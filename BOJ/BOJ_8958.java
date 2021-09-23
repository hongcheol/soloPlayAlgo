package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8958 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int relay = 0;
        int score = 0;
        String input;
        for(int i = 0;i<n;i++){
            relay = 0;
            score = 0;
            input = br.readLine();
            for(int idx = 0;idx<input.length();idx++){
                if(input.charAt(idx) == 'O'){
                    score += ++relay;
                } else relay = 0;
            }
            sb.append(score+"\n");
        }
        System.out.println(sb);
    }
}
