package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2004_math {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int twoCount,fiveCount;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long[] input = new long[2];
        int t = 0;
        twoCount = 0;
        fiveCount =  0;
        while(st.hasMoreTokens()){
            input[t++] = Long.parseLong(st.nextToken());
        }
        long n = input[0];
        for(long i = 2;i<=n;i *= 2){
            twoCount += n / i;
        }
        for(long i = 5;i<=n;i *= 5){
            fiveCount += n / i;
        }
        n = input[1];
        for(long i = 2;i<=n;i *= 2){
            twoCount -= n / i;
        }
        for(long i = 5;i<=n;i *= 5){
            fiveCount -= n / i;
        }
        n = input[0]-input[1];
        for(long i = 2;i<=n;i *= 2){
            twoCount -= n / i;
        }
        for(long i = 5;i<=n;i *= 5){
            fiveCount -= n / i;
        }
        System.out.println(twoCount>fiveCount ? fiveCount : twoCount);
    }
}

