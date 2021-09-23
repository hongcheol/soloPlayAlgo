package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_1786 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] S,P;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        S = br.readLine().toCharArray();
        P = br.readLine().toCharArray();
        int sLength = S.length,pLength = P.length;
        if(pLength>sLength) {
            System.out.println(0);
            return ;
        }
        //부분 일치 테이블
        int[] pi = new int[pLength];
        int start = 1, partialMatched = 0;
        while(start+partialMatched<pLength){
            if(P[start+partialMatched]==P[partialMatched]){
                ++partialMatched;
                pi[start+partialMatched-1] = partialMatched;
            }else{
                if(partialMatched == 0){
                    start++;
                }else{
                    start += partialMatched-pi[partialMatched-1];
                    partialMatched = pi[partialMatched-1];
                }
            }
        }
        int matched = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<sLength;i++){
            while(matched > 0 && S[i]!=P[matched]) matched = pi[matched-1];
            if(S[i] == P[matched]){
                ++matched;
                if(matched==pLength){
                    list.add(i-pLength+1);
                    matched = pi[matched-1];
                }
            }
        }
        sb.append(list.size()).append('\n');
        for(int data : list){
            sb.append(data+1).append('\n');
        }
        System.out.println(sb.toString());
    }
}
