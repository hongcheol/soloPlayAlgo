package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2810 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int lCount = 0;
        for(int i = 0;i<input.length();i++){
            if(input.charAt(i) == 'L') lCount++;
        }
        if(lCount == 0) System.out.println(n);
        else System.out.println((n+1)-lCount/2);
    }
}
