package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780_divideAndConquer {
    static int[][] paper;
    static final int[] answer = {0,0,0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            int j = 0;
            while(st.hasMoreTokens()){
                paper[i][j++] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0,0,n);
        for(int i:answer) System.out.println(i);

    }
    static void solve(int x,int y,int n){
        int check = paper[x][y];
        for(int i = x;i< x+n;i++){
            for(int j = y;j< y+n;j++){
                if(check != paper[i][j]){
                    solve(x,y,n/3);
                    solve(x,y+n/3,n/3);
                    solve(x,y+2*(n/3),n/3);
                    solve(x+n/3,y,n/3);
                    solve(x+n/3,y+n/3,n/3);
                    solve(x+n/3,y+2*(n/3),n/3);
                    solve(x+2*(n/3),y,n/3);
                    solve(x+2*(n/3),y+n/3,n/3);
                    solve(x+2*(n/3),y+2*(n/3),n/3);
                    return ;
                }
            }
        }
        answer[check+1] += 1;
    }
}
