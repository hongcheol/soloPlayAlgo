package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10989_sort {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] num;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        num = new int[10001];
        for(int i = 0;i<n;i++){
            num[Integer.parseInt(br.readLine())]++;
        }
        for(int i = 0;i<10001;i++){
            while(num[i]>0) {
                sb.append(i+"\n");
                num[i]--;
            }
        }
        System.out.println(sb.toString());
    }
}
