package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2999 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        char[] input = br.readLine().toCharArray();
        int l = input.length;
        int r = (int)Math.sqrt(l);
        while(l%r != 0)r--;
        int c = l/r;
        int idx = 0;
        char[][] encoding = new char[r][c];

        for(int i = 0;i<c;i++){
            for(int j = 0;j<r;j++){
                encoding[j][i] = input[idx++];
            }
        }
        for(int j = 0;j<r;j++){
            for(int i = 0;i<c;i++){
                sb.append(encoding[j][i]);
            }
        }
        System.out.println(sb.toString());
    }
}
