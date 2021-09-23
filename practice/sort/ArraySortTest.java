package com.algo.java.practice.sort;

import java.util.Arrays;

public class ArraySortTest {
    public static void main(String[] args){
        int[] arr = {50,30,10,23,45};
        System.out.println("정렬 전 : "+ Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("정렬 후 : "+ Arrays.toString(arr));

        String[] arr2 = {"line","samsung","naver","kakao","toss"};
        System.out.println("정렬 전 : "+ Arrays.toString(arr2));
        Arrays.sort(arr2);
        System.out.println("정렬 후 : "+ Arrays.toString(arr2));
    }
}
