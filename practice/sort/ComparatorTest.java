package com.algo.java.practice.sort;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
    static class StudentComparator implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return 0;
        }
    }
    public static void main(String[] args) {
        Student[] students = {
                new Student(1, 10),
                new Student(3, 50),
                new Student(2, 80),
                new Student(4, 10)
        };
        System.out.println("정렬 전 : " + Arrays.toString(students));
        Arrays.sort(students,new StudentComparator());
        System.out.println("점수기준 오름차정렬 후 : " + Arrays.toString(students));
//        Arrays.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o2.score-o1.score;
//            }
//        });
//        Arrays.sort(students,
//            //타입 유추가 가능하면 타입 생략 가능.
////            (Student o1, Student o2)-> {
////
////            ( o1,  o2)-> {
////                return o2.score-o1.score;
////            }
//            (o1,  o2)-> o2.score-o1.score
//        );
        //다중 조건 정렬
        //block을 줘도 좋지만 삼항연산자로 잡고 가도 좋다.
        Arrays.sort(students,(o1,o2)->o2.score != o1.score? o2.score-o1.score:o2.no-o1.score);
        System.out.println("점수 기준 내림차순 정렬 후 :"+Arrays.toString(students));

        int[][] studentsArray = {
                {1,10},
                {3,50},
                {2,80},
                {4,10}
        };
//        Arrays.sort(studentsArray, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0]-o2[0];
//            }
//        });
        Arrays.sort(studentsArray,(o1, o2)->o1[0]-o2[0]);

    }
}
