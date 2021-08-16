package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3052 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] array = new int[42];
        int answer = 0;
        for(int i = 0;i<10;i++){
            array[Integer.parseInt(br.readLine())%42]++;
        }
        for(int i = 0;i<42;i++){
            if(array[i] != 0)
                answer++;
        }
        System.out.println(answer);
    }
}
