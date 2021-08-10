package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_10825_comparator {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];
        String[] s;
        for(int i = 0;i<N;i++){
            s = br.readLine().split(" ");
            Student input = new Student();
            input.setName(s[0]);
            input.setKoreanScore(Integer.parseInt(s[1]));
            input.setEnglishScore(Integer.parseInt(s[2]));
            input.setMathScore(Integer.parseInt(s[3]));
            students[i] = input;
        }
        Arrays.sort(students,new Comparator<Student>(){

            public int compare(Student s1,Student s2) {
                if (s1.getKoreanScore() == s2.getKoreanScore()) {
                    if (s1.getEnglishScore() == s2.getEnglishScore()) {
                        if (s1.getMathScore() == s2.getMathScore()) {
                            return s1.getName().compareTo(s2.getName());
                        } else {
                            return Integer.compare(s2.getMathScore(),s1.getMathScore());
                        }
                    } else {
                        return Integer.compare(s1.getEnglishScore(),s2.getEnglishScore());
                    }
                } else {
                    return Integer.compare(s2.getKoreanScore(),s1.getKoreanScore());
                }

            }
        });
        for(int i = 0;i<N;i++){
            System.out.println(students[i].getName());
        }


    }
    static class Student implements Comparable<Student>{
        private String name;
        private int koreanScore;
        private int englishScore;
        private int mathScore;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getKoreanScore() {
            return koreanScore;
        }

        public void setKoreanScore(int koreanScore) {
            this.koreanScore = koreanScore;
        }

        public int getEnglishScore() {
            return englishScore;
        }

        public void setEnglishScore(int englishScore) {
            this.englishScore = englishScore;
        }

        public int getMathScore() {
            return mathScore;
        }

        public void setMathScore(int mathScore) {
            this.mathScore = mathScore;
        }

        @Override
        public int compareTo(Student o) {
            return Integer.compare(o.getKoreanScore(),koreanScore);
        }
    }
}

