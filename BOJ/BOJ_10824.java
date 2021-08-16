package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10824 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        String num1 = st.nextToken();
        num1 = num1+st.nextToken();
        String num2 = st.nextToken();
        num2 = num2+st.nextToken();

        System.out.println(Long.parseLong(num1)+Long.parseLong(num2));
    }
}
