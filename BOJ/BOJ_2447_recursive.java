package com.algo.java.BOJ;

import java.io.*;
import java.util.Arrays;

public class BOJ_2447_recursive {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        for(char[] ar: arr) {
            Arrays.fill(ar, ' ');
        }
        starPrint(0,0,n,arr);
        for(char[] a:arr){
            for(char s : a){
                sb.append(s);
            }
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static void starPrint(int r,int c,int n,char[][] stars){
        if(n==1){
            stars[r][c] = '*';
        }else{
            for(int i = 0;i<3;i++){
                for(int j = 0;j<3;j++){
                    if( i != 1 || j != 1){
                        starPrint(r+n/3*i,c+n/3*j,n/3,stars);
                    }
                }
            }
        }
    }

}
