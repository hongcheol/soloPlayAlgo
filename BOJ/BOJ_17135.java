package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17135 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] staticField;
    static int n,m,d;
    static int[] dr = {0,-1,0};
    static int[] dc = {-1,0,1};
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        //필드 정보 읽어옴
        staticField = new int[n+1][];
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            staticField[i] = new int[m];
            for(int j = 0;j<m;j++){
                staticField[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        staticField[n] = new int[m];

        int max = 0;
        int[] p = new int[m];
        int cnt = 0;
        while(++cnt<=3) p[m-cnt] = 1;
        do{
            int[][] field = new int[n+1][m];
            init(field);
            //조합을 찾아서 하나씩 해보고 count
            int temp = shot(p,field);
            if(temp>max) max = temp;
        }while(np(p));
        System.out.println(max);
    }
    public static void init(int[][] field){
        for(int i = 0;i<=n;i++){
            for(int j = 0;j<m;j++){
                field[i][j] = staticField[i][j];
            }
        }
    }
    public static int shot(int[] p,int[][] field){
        int max = 0;
        //위치마다 다 쏴보기(r= n-1부터 0까지로 반복)
        for(int i = n;i>=0;i--){
            //맨 밑의 라인에서 bfs로 찾기
            int[][] target = new int[3][];
            int idx = 0;
            for(int j = 0;j<m;j++){
                if(p[j]==1) {
                    target[idx++] = bfs(i,j,field);
                }
            }
            //찾은 위치의 애들 전부 다 0으로 줄이기
            for(int j = 0;j<3;j++){
                int r = target[j][0];
                int c = target[j][1];
                if(field[r][c]==1){
                    max++;
                    field[r][c] = 0;
                }
            }
        }
        return max;
    }
    public static int[] bfs(int r,int c,int[][] field){

        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] isVisited = new boolean[n+1][m];
        int[] curNode = {r,c};
        int depth = 0;
        int nr = r, nc = c;

        nr = r + dr[1];
        nc = c + dc[1];
        if(boundCheck(nr,nc)){
            int[] nextNode = {nr,nc};
            queue.offer(nextNode);
        }

        //없으면 지금 들어온 애
        while(!queue.isEmpty()){
            //확인하고
            curNode = queue.poll();
            if(isVisited[curNode[0]][curNode[1]]) continue;
            isVisited[curNode[0]][curNode[1]] = true;
            depth = Math.abs(curNode[0]-r)+Math.abs(curNode[1] - c);
            //거리가 d를 넘어가면 나가기.
            if(d<depth){
                curNode[0] = n;
                curNode[1] = c;
                break;
            }
            if(field[curNode[0]][curNode[1]]==1) return curNode;
            for(int i = 0;i<3;i++){
                nr = curNode[0]+dr[i];
                nc = curNode[1]+dc[i];
                if(boundCheck(nr,nc)){
                    if(!isVisited[nr][nc]) {
                        int[] nextNode = {nr, nc};
                        queue.offer(nextNode);
                    }
                }
            }
        }
        return curNode;
    }
    public static boolean np(int[] numbers){
        int N = numbers.length;
        int i = N-1;
        while(i>0&&numbers[i-1]>=numbers[i]) --i;
        if(i == 0) return false;

        int j = N-1;
        while(numbers[i-1]>=numbers[j])--j;

        swap(numbers,i-1,j);
        int k = N-1;
        while(i<k){
            swap(numbers,i++,k--);
        }
        return true;
    }
    public static void swap(int[] numbers,int i,int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
    public static boolean boundCheck(int r,int c){
        if(r>=0&&r<n&&c>=0&&c<m)return true;
        return false;
    }
}
