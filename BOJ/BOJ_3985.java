package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3985 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int l = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] rollCake = new int[l+1];
        int maxWant = 0;
        int whoIsMax = 0;
        int start;
        int end;
        int want;
        int realTake;
        int takeMax = 0;
        int whoIsRealMax = 0;
        for(int i = 1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            want = end-start;
            realTake = 0;

            if(maxWant<want){
                maxWant = want;
                whoIsMax = i;
            }
            for(int j = start;j<=end;j++){
                if(rollCake[j]==0) {
                    rollCake[j] = i;
                    realTake++;
                }
            }
            if(takeMax<realTake){
                takeMax = realTake;
                whoIsRealMax = i;
            }
        }
        System.out.println(whoIsMax);
        System.out.println(whoIsRealMax);
    }
}
