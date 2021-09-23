package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2798 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int i = 0,j = 0, k = 0;
        int[] card = new int[n];
        //int sum[111111] = {0,};
        int temp = 0;
        int ans = -1;
        st = new StringTokenizer(br.readLine());
        for(i = 0;i<n;i++){
            card[i] = Integer.parseInt(st.nextToken());
        }
        for(i = 0;i<n;i++){
            for(j = i+1;j<n;j++){
                for(k = j+1;k<n;k++){
                    temp = card[i]+card[j]+card[k];
                    if(temp > m) continue;
                    else if(m-ans > m -temp) ans = temp;
                }
            }
        }

        System.out.println(ans);

    }
}
