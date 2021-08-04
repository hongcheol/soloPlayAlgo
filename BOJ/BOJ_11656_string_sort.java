package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_11656_string_sort {
    //일단 접미사 배열 만들고
    //sorting 메서드 만들기.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputString = br.readLine();
        List<String> suffix = new ArrayList<>();
        for(int i = 0;i<inputString.length();i++){
            suffix.add(inputString.substring(i,inputString.length()));
        }
        suffix.sort(String::compareTo);
        for(String s : suffix){
            System.out.println(s);
        }
    }

}
