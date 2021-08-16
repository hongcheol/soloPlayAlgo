package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 쭉 읽어들이면서
 * < , ' ' 이 니오면 지금까지의 문자열 뒤집어서 sb에 넣는다
 * < 이 나왔다면 >이 나올 때까지 문자열에 넣고 sb 에 넣는다.
 * subString을 사용할 수 있지만 배열을 다루고 생각한 논리를 직접 구현해보고싶어서 사용하지않았다.
 */
public class BOJ_17413 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static char[] inputString;
    public static void main(String[] args) throws IOException {
        inputString = br.readLine().toCharArray();
        int start = 0;
        boolean isTag = false;
        for(int i = 0;i<inputString.length;i++){
            if(inputString[i] == '>'){
                isTag = false;
                sb.append(inputString[i]);
                start = i+1;
                continue;
            }
            if(isTag){
                sb.append(inputString[i]);
                continue;
            }

            if(inputString[i] != '<' && inputString[i] != ' ') continue;
            else{
                for(int j = i-1;j>=start;j--){
                    sb.append(inputString[j]);
                }
                start = i+1;
                if(inputString[i] == '<') isTag = true;
                sb.append(inputString[i]);
            }
        }
        if(start != inputString.length){
            for(int i = inputString.length-1;i>=start;i--){
                sb.append(inputString[i]);
            }
        }
        System.out.println(sb.toString());

    }
}
