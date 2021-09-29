package com.algo.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_5607 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static final long MOD = 1234567891;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int t = 1;t<=T;t++){
            sb.append("#"+t+" ");
            long bunja = 1, bunmo = 1;
            st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken()),R = Long.parseLong(st.nextToken());
            for(long i = 1;i<=N;i++){
                bunja *= i;
                bunja %= MOD;
                if(i<=R){
                    bunmo *= i;
                    bunmo %= MOD;
                }
                if(i<=N-R){
                    bunmo *= i;
                    bunmo %= MOD;
                }
            }
            long B = 1;
            long mod = MOD-2;
            while(mod > 0){
                if(mod%2 == 1){
                    B *= bunmo;
                    mod -= 1;
                    B %= MOD;
                }
                bunmo *= bunmo;
                bunmo %= MOD;
                mod /= 2;
            }
            long result = bunja*B;
            result %= MOD;
            sb.append(result+"\n");
        }
        System.out.println(sb.toString());
    }
}
