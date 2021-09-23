package com.algo.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D3_6808_np {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static final int cardNum = 9;
    static int inScore = 0, qScore = 0;
    static int inWin = 0,draw = 0,qWin = 0;
    static final int total = 362880;
    static int[] qCard,inCard,inPerm;
    public static void main(String[] args) throws IOException {
        int testcase = Integer.parseInt(br.readLine());

        for(int t = 1;t<=testcase;t++){
            qCard = new int[cardNum];
            inCard = new int[cardNum];
            inPerm = new int[cardNum];
            st = new StringTokenizer(br.readLine());
            for(int i = 0;i<9;i++){
                qCard[i]=Integer.parseInt(st.nextToken());
            }
            LP:for(int i = 1,j=0;i<=18;i++){
                for(int k = 0;k<9;k++){
                    if(i == qCard[k]){
                        continue LP;
                    }
                }
                inCard[j++] = i;
            }
            //조합을 만든다.
            inWin = 0;
            qWin = 0;
            do {
                inScore = 0;
                qScore = 0;
                for(int i = 0;i<cardNum;i++){
                    int temp = inCard[i]+qCard[i];
                    if(inCard[i]>qCard[i]) inScore += temp;
                    else qScore += temp;
                }
                if(inScore>qScore)inWin++;
                else if(inScore==qScore) draw++;
                else qWin++;
            }while(nextPerm(inCard));
            System.out.println("#" + t + " " + qWin +" "+ inWin);
        }
    }
    static boolean nextPerm(int[] numbers){
        //일단 뒤에서부터 찾는다.
        int N = numbers.length;
        //1. 꼭대기 찾기
        int i = N-1;
        while(i>0 && numbers[i-1]>=numbers[i])i--;
        if(i==0) return false;

        //2. 꼭대기를 찾았으면 다시 맨 뒤부터찾으면서
        int j = N-1;
        while(numbers[i-1]>=numbers[j])j--;

        //3. 찾았으면 둘이 위치 바꾸기
        swap(numbers,i-1,j);
        //4. 그 다음 뒤에 정렬
        int k = N-1;
        while(i<k){
            swap(numbers,i++,k--);
        }
        return true;
    }
    private static void swap(int[] numbers,int i,int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

}
