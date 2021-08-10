package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476_math {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int year = 1;
        st = new StringTokenizer(br.readLine());
        int[] esm = new int[3];
        int i = 0;
        while(st.hasMoreTokens()){
            esm[i++] = Integer.parseInt(st.nextToken());

        }
        while(true){
           if(year%15 == esm[0]%15 && year%28 == esm[1]%28 && year%19 == esm[2]%19) break;
           year++;
        }
        System.out.println(year);
    }
}
