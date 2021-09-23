package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10817 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        int[] arr = new int[3];
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());

        if (isBig(a, b)) {
            arr[0] = a;
            arr[1] = b;
        } else {
            arr[0] = b;
            arr[1] = a;
        }
        if (isBig(arr[0], c)) {
            if (isBig(arr[1], c)) {
                System.out.println(arr[1]);
            } else {
                System.out.println(c);
            }
        } else {
            System.out.println(arr[0]);
        }
    }
    static boolean isBig(int a,int b){
        if(a<b)return true;
        else return false;
    }
}
