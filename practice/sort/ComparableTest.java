package com.algo.java.practice.sort;

import java.util.Arrays;

public class ComparableTest {
    public static void main(String[] args) {
        Student[] students = {
                new Student(1,10),
                new Student(3,50),
                new Student(2,80),
                new Student(4,10),

        };
        System.out.println("정렬 전 : " + Arrays.toString(students));
        Arrays.sort(students);
        System.out.println("정렬 후 : " + Arrays.toString(students));
    }
}
