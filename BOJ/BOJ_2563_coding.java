package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563_coding {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[][] field = new boolean[100][100];

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        for(int i = 0;i<num;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            fill(r,c);
        }
        System.out.println(area());
    }
    public static void fill(int r,int c){
        for(int i = 0;i<10;i++){
            for(int j = 0;j<10;j++){
                field[r+i][c+j] = true;
            }
        }
    }
    public static int area(){
        int count = 0;
        for(int i = 0;i<100;i++){
            for(int j = 0;j<100;j++){
                if(field[i][j]) count++;
            }
        }
        return count;
    }
}
