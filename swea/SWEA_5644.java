package com.algo.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5644 {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][][] field, chargerNum;
    static final int[] dr = {0,-1,0,1,0};
    static final int[] dc = {0,0,1,0,-1};
    static int[] moveA,moveB;
    static int[] nowA = new int[2], nowB = new int[2];
    static int[][] charger;
    static int chargeA = 0, chargeB = 0;
    public static void main(String[] args) throws IOException {
        int testcase = Integer.parseInt(br.readLine());
        for(int t = 1;t<=testcase;t++){
            field = new int[10][10][2];
            chargerNum = new int[10][10][2];
            st = new StringTokenizer(br.readLine()," ");
            int M = Integer.parseInt(st.nextToken()),A = Integer.parseInt(st.nextToken());
            moveA = new int[M];
            moveB = new int[M];
            charger = new int[A][4];
            chargeA = 0;
            chargeB = 0;
            st = new StringTokenizer(br.readLine()," ");
            for(int i = 0;i<M;i++){
                moveA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine()," ");
            for(int i = 0;i<M;i++){
                moveB[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 0;i<A;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j = 0;j<4;j++){
                    charger[i][j] = Integer.parseInt(st.nextToken());
                }
                makeChargeField(charger[i][1]-1,charger[i][0]-1,charger[i][2],charger[i][3],i+1);
            }
            nowA[0] = 0; nowA[1] = 0;
            nowB[0] = 9; nowB[1] = 9;
            simulation(nowA,nowB);
            for(int i = 0;i<M;i++){
                nowA[0] += dr[moveA[i]];
                nowA[1] += dc[moveA[i]];
                nowB[0] += dr[moveB[i]];
                nowB[1] += dc[moveB[i]];
                if(boundCheck(nowA[0],nowA[1])&& boundCheck(nowB[0],nowB[1])) simulation(nowA, nowB);
            }
            sb.append("#"+t+" "+(chargeA+chargeB)).append("\n");
        }
        System.out.println(sb.toString());
    }
    static void simulation(int[] A, int[] B){
        int rA = A[0],rB=B[0],cA=A[1],cB=B[1];
        if(chargerNum[rA][cA][0]==chargerNum[rB][cB][0]) {
            //일단 같으면 [0]/2이랑 [0]+[1]이랑 비교해서 큰 애로 더해준다.
            int num1 = field[rA][cA][0];
            int num2 = field[rA][cA][0]+field[rB][cB][1];
            int num3 = field[rB][cB][0]+field[rA][cA][1];
            if(num1 >= num2){
                if(num1>=num3) {
                    chargeA += num1/2;
                    chargeB += num1/2;
                    return ;
                }
            }//2개를 선택한 경우보다 1개로 반절씩 충전하는게 더 큰 경우.
            if(num2 > num1){
                if(num2 >= num3){
                    chargeA += field[rA][cA][0];
                    chargeB += field[rB][cB][1];
                    return ;
                }
            }
            if(num3 > num1){
                if(num3 > num2){
                    chargeA += field[rA][cA][1];
                    chargeB += field[rB][cB][0];
                }
            }
        }else{
            chargeA += field[rA][cA][0];
            chargeB += field[rB][cB][0];
        }
    }

    static void makeChargeField(int r,int c, int d, int num,int id){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[10][10];
        int[] nextR = {-1,1,0,0},nextC = {0,0,-1,1};
        int nr = 0,nc = 0;
        int nowR = 0, nowC = 0,nowD = 0;
        queue.offer(new int[]{r,c,0});
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            nowR = now[0];
            nowC = now[1];
            nowD = now[2];
            if(nowD>d) break;
            isVisited[nowR][nowC] = true;
            //지금 설치하는 애가 충전되는 영역에서 제일 크면 전부 갱신
            if(chargerNum[nowR][nowC][0] != id && chargerNum[nowR][nowC][1] != id)
            if(field[nowR][nowC][0] < num){
                field[nowR][nowC][1] = field[nowR][nowC][0];
                field[nowR][nowC][0] = num;
                chargerNum[nowR][nowC][1] = chargerNum[nowR][nowC][0];
                chargerNum[nowR][nowC][0] = id;
            }else{
                //2번째로 크면 2번째애만 갱신
                if(field[nowR][nowC][1]<num){
                    field[nowR][nowC][1] = num;
                    chargerNum[nowR][nowC][1] = id;
                }
            }
            for (int j = 0; j < 4; j++) {
                nr = nowR + nextR[j];
                nc = nowC + nextC[j];
                if (boundCheck(nr, nc)&& !isVisited[nr][nc]) {
                    queue.offer(new int[]{nr,nc,nowD+1});
                }
            }
        }
    }
    static boolean boundCheck(int r,int c){
        if(r>=0 && r<10&&c>=0&&c<10) return true;
        return false;
    }
}
