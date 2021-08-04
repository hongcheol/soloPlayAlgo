package com.algo.java.practice;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Hanoi {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println((int)Math.pow(2,n)-1);
        hanoi(n,1,2,3);
        System.out.println(sb);
    }
    static void move(int start,int end) throws IOException {
        sb.append(start+" "+end+"\n");

    }
    static void hanoi(int n,int start,int by,int end) throws IOException {
        if(n == 1) move(start,end);
        else{
            hanoi(n-1,start,end,by);
            move(start,end);
            hanoi(n-1,by,start,end);
        }
    }
}
