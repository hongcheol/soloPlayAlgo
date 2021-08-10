package com.algo.java.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_1158_linkedList {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        List list = new LinkedList();
        sb.append('<');
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]),k = Integer.parseInt(input[1]);
        List answer = new ArrayList();
        for(int i = 1;i<=n;i++){
           list.add(i);
        }
        int idx = 0;
        while(!list.isEmpty()) {
            int l = list.size();
            idx += (k-1);
            idx %= (l);
            answer.add(list.remove(idx));
        }
        if(!answer.isEmpty())sb.append(answer.remove(0));
        while(!answer.isEmpty()){
            sb.append(", ");
            sb.append(answer.remove(0));
        }
        sb.append('>');
        System.out.println(sb.toString());
    }


}
