package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992 {
    static char[][] paper;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        paper = new char[n][];
        for(int i = 0;i<n;i++){
            paper[i] = br.readLine().toCharArray();
        }
        solve(0,0,n);
        System.out.println(sb.toString());
    }
    public static void solve(int x,int y, int n){
        char check = paper[x][y];
        for(int i= x;i<x+n;i++){
            for(int j = y;j<y+n;j++){
                if(check != paper[i][j]){
                    sb.append("(");
                    solve(x,y,n/2);
                    solve(x,y+n/2,n/2);
                    solve(x+n/2,y,n/2);
                    solve(x+n/2,y+n/2,n/2);
                    sb.append(")");
                    return ;
                }
            }
        }
        sb.append(check);
    }
}
