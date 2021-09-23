package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] paper;
    static int[] answer = new int[2];
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<n;j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        paperCheck(0,0,n);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
    public static void paperCheck(int x,int y,int n){
        int check = paper[x][y];
        for(int i = x;i<x+n;i++){
            for(int j = y;j<y+n;j++){
                if(check != paper[i][j]){
                    paperCheck(x,y,n/2);
                    paperCheck(x,y+n/2,n/2);
                    paperCheck(x+n/2,y,n/2);
                    paperCheck(x+n/2,y+n/2,n/2);
                    return ;
                }
            }
        }
        answer[check]++;
    }
}
