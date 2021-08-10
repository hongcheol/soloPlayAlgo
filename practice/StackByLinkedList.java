package com.algo.java.practice;

public class StackByLinkedList {

    private Node head;
    static long length;
    public Node peek(){
        for(Node curNode =head;curNode != null;curNode = curNode.link){
            if(curNode.link == null){
                return curNode;
            }
        }
        return null;
    }
    public void push(String data){
        if(head == null){
            Node newNode = new Node(data,head);
            head = newNode;
        }
        Node lastNode = peek();
        Node newNode = new Node(data);

        lastNode.link = newNode;
        length++;
    }
    public Node pop(){
        if(head == null){
            System.out.println("stack is empty");
            return null;
        }
        if(head.link == null){
            Node returnNode = head;
            head = null;
        }
        for(Node curNode =head;curNode != null;curNode = curNode.link){
            if(curNode.link.link == null){
                Node returnNode = curNode.link;
                curNode.link = null;
                length--;
                return returnNode;
            }
        }
        return null;
    }
    public boolean isEmpty(){
        if(head == null){
            return true;
        }
        return false;
    }
    public Node getIndex(int i){
        int j = 1;
        for(Node curNode =head;curNode != null;curNode = curNode.link){
            if(j++ == i) return curNode;
        }
        return null;
    }
    @Override
    public String toString(){
        String returnString = new String();
        if(isEmpty()) return "empty stack";
        for(int i = 1;i<=length;i++) {
            if(getIndex(i)==null) break;
            returnString += i+"번째 원소 = "+ getIndex(i).data+" ";
        }
        return returnString;
    }
    public void printStack(){
        System.out.println(this.toString());
    }
}
