package com.algo.java.practice.sort;

import java.util.Arrays;
import java.util.Comparator;

public class ReverseTest {
    public static void main(String[] args) {
        String[] arr2 = {"line","samsung","naver","kakao","toss"};
        System.out.println("정렬 전 : "+ Arrays.toString(arr2));
        //String에 comparator을 적용하는 방
        Arrays.sort(arr2,(s1,s2)->s2.compareTo(s1));
        Arrays.sort(arr2, Comparator.reverseOrder());
        System.out.println("정렬 후 : "+ Arrays.toString(arr2));
    }
}
