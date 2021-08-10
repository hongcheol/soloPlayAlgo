package com.algo.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class SWEA_D3_5215 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int testcase = Integer.parseInt(br.readLine());

        for(int t = 1;t<=testcase;t++){
            String[] input = br.readLine().split(" ");
            int numIngredient = Integer.parseInt(input[0]);
            int calLimit = Integer.parseInt(input[1]);
            int[] ingredient = new int[numIngredient];
            int[] cal = new int[numIngredient];
            int[][] dp = new int[numIngredient+1][calLimit+1];
            int max = 0;
            for(int i = 0;i<numIngredient;i++){
                input = br.readLine().split(" ");
                ingredient[i] = Integer.parseInt(input[0]);
                cal[i] = Integer.parseInt(input[1]);
            }
            for(int i = 1;i<=numIngredient;i++){
                for(int j = 1;j<=calLimit;j++){
                    if(cal[i-1]<=j)
                        dp[i][j] = Math.max(ingredient[i-1]+dp[i-1][j-cal[i-1]],dp[i-1][j]);
                    else
                        dp[i][j] = dp[i-1][j];
                    max = dp[i][j]>max?dp[i][j]:max;
                }
            }
            System.out.println("#"+t+" "+max);
        }
    }
}
