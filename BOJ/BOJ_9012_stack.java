package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_9012_stack{
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());

        for(int t = 0;t<testcase;t++){
            Stack leftStack = new Stack();
            boolean isYes = true;
            String input = br.readLine();
            for(int i = 0;i<input.length();i++){
                if(input.charAt(i)=='('){
                    leftStack.push(input.charAt(i));
                }else if(input.charAt(i) == ')'){
                    try {
                        leftStack.pop();
                    } catch (EmptyStackException ese) {
                        isYes = false;
                        break;
                    }
                }
            }
            if(leftStack.isEmpty() && isYes) System.out.println("YES");
            else System.out.println("NO");
        }
        br.close();
    }
}
