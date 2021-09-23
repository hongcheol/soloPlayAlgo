package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_18870 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        Map<Integer,Integer> input = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        int[] inputArr = new int[n];
        st = new StringTokenizer(br.readLine());
        int now;
        for(int i = 0;i<n;i++){
            now = Integer.parseInt(st.nextToken());
            inputArr[i] = now;
            input.put(now,i);
        }
        Arrays.sort(inputArr);
        for(int i = 0;i<n;i++){
            sb.append(input.get(inputArr[i])+" ");
        }
        System.out.println(sb.toString());
    }
}
