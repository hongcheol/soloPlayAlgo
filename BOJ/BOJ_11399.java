package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] human = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            human[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(human);
        for(int i = 0;i<n;i++){
            if(i == 0){
                continue;
            }else{
                human[i] += human[i-1];
            }
        }
        int answer = 0;
        for(int i = 0;i<n;i++){
            answer += human[i];
        }
        System.out.println(answer);
    }
}
