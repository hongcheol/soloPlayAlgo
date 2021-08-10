package com.algo.java.swea;

import com.algo.java.practice.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_1233 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String[][] tree;
    static boolean opToggle = false;
    static int answer;
    public static void main(String[] args) throws IOException {
        for(int t = 1;t<=10;t++) {
            int num = Integer.parseInt(br.readLine());
            answer = 1;
            opToggle = false;
            tree = new String[num + 1][];
            //make tree
            for (int i = 0; i < num; i++) {
                st = new StringTokenizer(br.readLine()," ");
                int idx = Integer.parseInt(st.nextToken());
                tree[idx] = new String[3];//data, left, right
                int index = 0;
                while (st.hasMoreTokens()) {
                    tree[idx][index++] = st.nextToken();
                }
            }
            inorder(tree[1],num);
            System.out.println(answer);
        }
    }
    public static void inorder(String[] node,int num){
        if(answer == 0) return ;
        if(node[1] == null) {
            opCheck(node[0]);
            return ;
        }
        if(node[2] == null){
            opCheck(node[0]);
            return ;
        }
        int left = Integer.parseInt(node[1]);
        int right = Integer.parseInt(node[2]);

        if(left<=num) {
            inorder(tree[left],num);
            opCheck(node[0]);
            inorder(tree[right],num);
        }
    }
    public static boolean opCheck(String s){
        try{
            Integer.parseInt(s);
            //숫자면 통과하는데 숫자가 나올 때가 아니면 불가능 선언
            if(opToggle) {
                answer = 0;
                return false;
            }
        }catch (NumberFormatException nfe){
            //문자로 걸렸는데 문자가 나올 때가 아니면 불가능 선언
            if(!opToggle) {
                answer = 0;
                return false;
            }
        }
        opToggle = !opToggle;
        return true;
    }
}
