package com.algo.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SWEA_D3_0802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for(int t = 1;t<=testcase;t++){
            char[] inputString = br.readLine().toCharArray();
            int count = inputString[0]== '0' ? 0 : 1;
            for(int i = 1;i<inputString.length;i++){
                if(inputString[i] != inputString[i-1]) count++;
            }
            System.out.println("#"+t+" "+count);
        }
    }
}
