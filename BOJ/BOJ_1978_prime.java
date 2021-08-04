package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1978_prime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] m = new boolean[1001];
        Arrays.fill(m,true);
        m[0]=false;
        m[1]=false;
        for(int i = 2;i<1001;i++){
            if(m[i]){
                for(int j = 2*i;j<1001;j += i){
                    m[j] = false;
                }
            }
        }
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        String[] input = br.readLine().split(" ");
        for(String s: input){
            if(m[Integer.parseInt(s)]) count++;
        }
        System.out.println(count);
    }
}
