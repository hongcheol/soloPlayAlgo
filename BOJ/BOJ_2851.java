package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BOJ_2851 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int before = 0;
        int answer = 0;
        int now = 0;
        for(int i=0;i<10;i++){
            now = Integer.parseInt(br.readLine());

            if(before+now==100){
                before += now;
                break;
            }else if(before+now > 100){
                //100-before이 크면 지금 더한게 더 가까움
                before = 100-before >= (now+before)-100 ? before+now : before;
                break;
            }
            before += now;
        }
        System.out.println(before);
    }
}
