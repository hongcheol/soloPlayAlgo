package com.algo.java.practice;

public class LinkedListStackTest {
    public static void main(String[] args) {


        StackByLinkedList stack = new StackByLinkedList();

        stack.push("춘식이");
        stack.printStack();

        stack.push("어피치");
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.printStack();
    }
}
