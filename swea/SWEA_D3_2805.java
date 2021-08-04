package com.algo.java.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_D3_2805 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] farm;
    static final int[] dr = {-1,1,1,-1};
    static final int[] dc = {1,1,-1,-1};
    public static void main(String[] args) throws Exception{
        int testcase = Integer.parseInt(br.readLine());
        for(int t = 1;t<=testcase;t++){
            int N = Integer.parseInt(br.readLine());
            int squareLength = N/2+1;
            farm = new char[N][N];
            for(int i = 0;i<N;i++){
                farm[i] = br.readLine().toCharArray();
            }
            System.out.println("#"+t+" "+harvest(squareLength,squareLength,-1));
        }
    }
    static int harvest(int l,int r, int c){
        int nr = r+dr[0],nc = c+dc[0];
        if(l == 1){
            return (int)farm[nr][nc]-(int)'0';
        }

        int sum = 0;
        for(int i = 0;i<4;i++){
            for(int j = 0;j<l-1;j++){
                sum += (int)farm[nr][nc]-(int)'0';
                nr += dr[i];
                nc += dc[i];
            }
        }
        sum += harvest(l-1,nr+1,nc);
        return sum;
    }
}
