package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8320 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int upperBound = (int)Math.sqrt(n);
        for (int i = 1; i <= upperBound; i++) {
            int temp = n;
            while (i <= temp / i) {
                if (temp % i == 0) answer++;
                temp--;
            }
        }
        System.out.print(answer);
    }
}


