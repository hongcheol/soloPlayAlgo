package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9655 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws IOException {
        int n = Integer.parseInt(br.readLine());
        if(n%4 == 1 || n%4 == 3) System.out.print("SK");
        else System.out.print("CY");
    }
}
