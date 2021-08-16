package com.algo.java.practice.sort;

import java.util.Comparator;

public class Student //implements Comparable<Student>//이걸 막으면 compareTo를 만들어놔도 안된다.
{
    int no, score;

    public Student(int no, int score) {
        this.no = no;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", score=" + score +
                '}';
    }
    //  음수  내가 작다 --> 둘을 그대로
    //  0    둘이 같다 --> 둘을 그대로
    //  양수  내가 크다 --> 서로 바꿈
    //@Override
    public int compareTo(Student o) {
        if(this.score==o.score){
            if(this.no == no) return 0;
            return this.no>o.no?1:-1;
        }
        return this.score>o.score?-1:1;
    }
//    @Override
//    public int compareTo(Student o){
////        return this.no - o.no;
////        return o.no - this.no;
////        return Integer.compare(this.no,o.no);
//        return Integer.compare(o.no,this.no);
//    }
}
