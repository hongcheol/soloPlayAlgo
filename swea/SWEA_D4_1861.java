package com.algo.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_1861 {
    static int[][] rooms;
    static boolean[][] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        int testcase = Integer.parseInt(br.readLine());
        for(int t = 1;t<=testcase;t++){
            int maxCount= -1;//이동할 수 있는 방의 최댓값.
            int count = 0;//현재 확인하는 방에서 이동할 수 있는 방의 수.
            int minStartNum = 10000;//최대로 이동할 수 있는 방의 시작지점 중 가장 작은 수.
            int n = Integer.parseInt(br.readLine());
            rooms = new int[n][n];
            visited = new boolean[n][n];
            //input
            for(int i = 0;i<n;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j = 0;j<n;j++){
                    if(st.hasMoreTokens()){
                        rooms[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
            }
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    //방문한 적이 없으면
                    if(!visited[i][j]){
                        //현 위치에서 이동할 수 있는 횟수 체크.
                        count = move(i,j);
                        if(count>maxCount){
                            maxCount = count;
                            minStartNum = rooms[i][j];
                        }
                        else if(count == maxCount){
                            if(minStartNum>rooms[i][j]){
                                minStartNum = rooms[i][j];
                            }
                        }
                    }
                    else continue;
                }
            }
            System.out.println("#"+t+" "+minStartNum+" "+maxCount);
        }
    }
    //6 2 3     t t t
    //8 1 4     f f t
    //9 10 11   f f f
    static int move(int r,int c){
        int cnt = 1;
        int nr = r,nc = c;
        int moveChecker = moveCheck(nr,nc);
        while(moveChecker!=-1){
            visited[nr][nc] = true;
            cnt++;
            nr += dr[moveChecker];
            nc += dc[moveChecker];
            moveChecker = moveCheck(nr,nc);
        }
        return cnt;
    }
    //u:0,d:1,l:2,r:3,x:-1
    static int moveCheck(int r,int c){
        int nr = 0;
        int nc = 0;
        for(int i = 0;i<4;i++){
            nr = r+dr[i];
            nc = c+dc[i];
            if(boundCheck(nr,nc)){
                if(rooms[nr][nc]-rooms[r][c] == 1) return i;
            }
        }
        return -1;
    }
    //out : false in: true
    static boolean boundCheck(int r,int c){
        if(r>=0 && r<rooms.length && c>=0 && c<rooms.length) return true;
        else return false;
    }
}
