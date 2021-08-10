package com.algo.java.practice;

public class CompleteBinaryTree {
    private char[] nodes;
    private final int SIZE;
    private int lastIndex;

    public CompleteBinaryTree(int size){
        this.SIZE = size;
        nodes = new char[size+1];
    }

    public void add(char c){
        if(lastIndex==SIZE) return;
        nodes[++lastIndex] = c;
    }
    public void bfs(){

    }
}
