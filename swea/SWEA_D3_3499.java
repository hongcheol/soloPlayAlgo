package com.algo.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_3499 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int testcase = Integer.parseInt(br.readLine());
        for(int t = 1;t<=testcase;t++){
            StringBuilder sb = new StringBuilder();
            int i = 0;
            int n = Integer.parseInt(br.readLine());
            int leftStart = 0, rightStart = 0;
            if(n%2 == 0) rightStart = n/2;
            else rightStart = (n/2)+1;
            String[] cards = new String[n];
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                cards[i++] = st.nextToken();
            }
            for(i = 0;i<n/2;i++){
                sb.append(cards[leftStart+i]+" ");
                sb.append(cards[rightStart+i]+" ");
            }
            if(n%2 == 1){
                sb.append(cards[n/2]);
            }
            System.out.println(sb.toString());
        }
    }
}
