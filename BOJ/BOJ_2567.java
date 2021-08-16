package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2567 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] field = new int[102][102];
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        for(int i = 0;i<num;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            fill(r,c);
        }
        System.out.println(round());

    }
    public static void fill(int r,int c){
        for(int i = 0;i<10;i++){
            for(int j = 0;j<10;j++){
                field[r+i][c+j] = 1;
            }
        }
    }
    public static int round(){
        int count = 0;
        for(int i = 1;i<101;i++){
            for(int j = 1;j<101;j++){
                if(field[i][j] == 1){
                    for(int d = 0;d<4;d++){
                        if(field[i+dr[d]][j+dc[d]]==0) count++;
                    }
                }
            }
        }
        return count;
    }
}
