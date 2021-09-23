package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_DP {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int[][] minPrice = new int[1001][3];
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<3;i++){
            minPrice[0][i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1;i<n;i++){
            int[] color = new int[3];
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<3;j++){
                color[j] = Integer.parseInt(st.nextToken());
            }
            minPrice[i][0] += color[0] + Math.min(minPrice[i-1][1],minPrice[i-1][2]);
            minPrice[i][1] += color[1] + Math.min(minPrice[i-1][0],minPrice[i-1][2]);
            minPrice[i][2] += color[2] + Math.min(minPrice[i-1][0],minPrice[i-1][1]);
        }
        System.out.println(Math.min(Math.min(minPrice[n-1][0],minPrice[n-1][1]),minPrice[n-1][2]));
    }
}
