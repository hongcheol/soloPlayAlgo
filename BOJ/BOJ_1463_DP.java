package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463_DP {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] makeOne;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        makeOne = new int[n+1];
        makeOne[1] = 0;

        for(int i = 2;i<=n;i++){
            makeOne[i] = makeOne[i-1] + 1;
            if(i%2 == 0) makeOne[i] = Math.min(makeOne[i],makeOne[i/2]+1);
            if(i%3 == 0) makeOne[i] = Math.min(makeOne[i],makeOne[i/3]+1);

        }

        System.out.println(makeOne[n]);
    }
}
