package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1592 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), l = Integer.parseInt(st.nextToken());
        int[] circle = new int[n];
        int now = 0;
        int count = 0;
        while(true){
            circle[now]++;
            if(circle[now]==m) break;
            if(circle[now]%2 == 0){
                now -= l;
                if(now<0)now += n;
                now %= n;
            }else{
                now = (now+l)%n;
            }
            count++;
        }
        System.out.println(count);
    }
}
