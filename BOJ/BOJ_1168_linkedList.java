package com.algo.java.BOJ;

import com.algo.java.practice.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1168_linkedList {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    //static List<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        LinkedList list = new LinkedList();
        sb.append('<');
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()),k = Integer.parseInt(st.nextToken());

        for(int i = 2;i<=n;i++){
           list.push(i);
        }
        Node curNode = list.head.left;
        while(list.length>1){
            for(int i = 0;i<k;i++){
                curNode = curNode.right;
            }
            sb.append(curNode.data);
            sb.append(", ");
            list.pop(curNode);
        }
        curNode = curNode.right;
        sb.append(curNode.data);
        sb.append('>');
        System.out.println(sb.toString());
//        int idx = k-1;
//        while(list.size()!=1) {
//            int now = list.remove(idx);
//            sb.append(now);
//            sb.append(", ");
//            idx = (idx+k-1)%(--n);
//        }
//        sb.append(list.get(0));
        sb.append('>');
        System.out.println(sb.toString());
        long end = System.currentTimeMillis();

        System.out.println( "실행 시간 : " + ( end - start )/1000.0 );

    }
    static class Node{
        int data;
        Node left,right;
        public Node(){
            this.left = null;
            this.data = 1;
            this.right = null;
        }

        public Node(int data){
            this.data = data;
        }

        public Node(Node left, int data, Node right) {
            super();
            this.left = left;
            this.data = data;
            this.right = right;
        }

        public int getData(){
            return this.data;
        }
    }
    static class LinkedList{
        int length = 0;
        private Node head;
        private Node tail;
        LinkedList(){
            this.head = null;
            this.tail = null;
            tail.left = head;
            tail.right = head;
            head.left = tail;
            head.right = tail;
        }
        void push(int i){
            Node node = new Node();
            node.data = i;
            node.left = tail.left;
            node.right = tail;
            tail.left.right = node;
            tail.left = node;
            length++;
        }
        void pop(Node node){
            node.left.right = node.right;
            node.right.left = node.left;
            length--;
        }
    }
}
