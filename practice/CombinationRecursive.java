package com.algo.java.practice;

import java.util.Scanner;

public class CombinationRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),r = sc.nextInt();
        System.out.println(fact(n,r)/fact(n-r,1));
    }

    static long fact(int n,int r){
        if(n==r)return 1;
        return n*fact(n-1,r);
    }
}
