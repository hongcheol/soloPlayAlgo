package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10845_queue {

    public static void main(String[] args) throws IOException {
        List<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for(int t = 0;t<testcase;t++){
            String[] input = br.readLine().split(" ");;
            switch (input[0]) {
                case "push":
                    push(queue, Integer.parseInt(input[1]));
                    break;
                case "pop":
                    System.out.println(pop(queue));
                    break;
                case "size":
                    System.out.println(size(queue));
                    break;
                case "empty":
                    System.out.println(empty(queue));
                    break;
                case "front":
                    System.out.println(front(queue));
                    break;
                case "back":
                    System.out.println(back(queue));
                    break;
                default:
            }
        }
    }
    static void push(List<Integer> q,int num){
        q.add(q.size(),num);
    }
    static int pop(List<Integer> q){
        try {
            int result = q.get(0);
            q.remove(0);
            return result;
        }catch (Exception e) {
            return -1;
        }
    }
    static int size(List<Integer> q){
        //if(empty(q)== 1) return 0;
        return q.size();
    }
    static int empty(List<Integer> q){
        if(q.size()==0) return 1;
        return 0;
    }
    static int front(List<Integer> q){
        if(empty(q)==1) return -1;
        return q.get(0);
    }
    static int back(List<Integer> q){
        if(empty(q)==1) return -1;
        return q.get(size(q)-1);
    }
}
