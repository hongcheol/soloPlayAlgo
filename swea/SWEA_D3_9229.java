package com.algo.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_9229 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int testcase = Integer.parseInt(br.readLine());
        for(int t = 1;t<=testcase;t++){
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]),limit = Integer.parseInt(input[1]);
            st = new StringTokenizer(br.readLine()," ");
            int[] snack = new int[n];
            int num = 0;
            while(st.hasMoreTokens()){
                snack[num++] = Integer.parseInt(st.nextToken());
            }
            int max = -1;
            for(int i = 0;i<n;i++){
                for(int j = i+1;j<n;j++){
                    int w = snack[i]+snack[j];
                    if(w<=limit&&max<w){
                        max = w;
                    }
                }
            }
            System.out.println("#"+t+" "+max);
        }
    }
}
