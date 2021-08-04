package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_9613_gcd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for(int t = 0;t<testcase;t++){
            long ans = 0L;
            List numList = new ArrayList();
            String[] input = br.readLine().split(" ");
            for(String s: input){
                numList.add(Integer.parseInt(s));
            }
            for(int i = 1;i<numList.size();i++){
                for(int j = i+1;j<numList.size();j++){
                    ans += gcd((int)numList.get(i),(int)numList.get(j));
                }
            }
            if(numList.size()==2) ans += (int)numList.get(1);
            System.out.println(ans);
        }
    }
    static Long gcd(int a,int b){
        if(a<b){
            int temp = a;
            a = b;
            b = temp;
        }
        int result = 0;
        while(b!=0){
            result = a%b;
            a = b;
            b = result;
        }
        return (long)a;
    }
}
