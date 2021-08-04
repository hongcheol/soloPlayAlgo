package com.algo.java.swea;

import java.util.Scanner;

public class SWEA_D2_1954 {
    static final int[] dr = {0,1,0,-1};
    static final int[] dc = {1,0,-1,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int t = 0;t<testCase;t++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            int n = 1;
            int startR = -1, startC = -1;
            arr[N / 2][N / 2] = N * N;
            for (int l = N - 1; l > 0; l -= 2) {
                startR += 1;
                startC += 1;
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < l; j++) {
                        arr[startR][startC] = n++;
                        startR += dr[i];
                        startC += dc[i];
                    }
                }
            }
            System.out.println("#" +(t+1));
            for (int[] ar : arr) {
                for (int a : ar) {
                    System.out.print(a + "\t");
                }
                System.out.println();
            }
        }
    }
}
