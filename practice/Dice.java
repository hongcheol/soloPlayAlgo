package com.algo.java.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Dice {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N = 6,R = 3
            ;
    static int[] dice = new int[]{1,2,3,4,5,6};
    static boolean[] isSelected;
    static int[] numbers;
    static int count = 0;
    public static void main(String[] args) throws Exception{

        while(true){
            System.out.println("주사위 던지기\n1.모든 경우의 수\n2.3개 다 다른 경우\n3.중복되는 경우 제외\n4.모두 다른 수가 나오는 경우에 중복 제거.");
            int diceCase = Integer.parseInt(br.readLine());
            switch (diceCase){
                case 0: break;
                case 1: caseOne();break;
                case 2: caseTwo();break;
                case 3: caseThree();break;
                case 4: caseFour();break;
                default:
                    System.out.println("0~4를 입력하세요");
            }
        }
    }
    private static void caseOne(){
        count = 0;
        numbers = new int[R];
        isSelected = new boolean[6];
        perm(0);
        System.out.println(count);
    }
    private static void caseTwo(){
        numbers = new int[R];
        combi(0,0);
    }
    private static void caseThree(){
        numbers = new int[R];
        removeSamePerm(0,0);
    }
    private static void caseFour(){
        numbers = new int[R];
        removeSameCombi(0,0);
    }

    private static void perm(int cnt){
        if(cnt == R){
            count++;
            System.out.println(Arrays.toString(numbers));
        }else{
            for(int i = 0;i<6;i++){
                if(isSelected[i]) continue;
                numbers[cnt] = dice[i];
                isSelected[i] = true;
                perm(cnt+1);
                isSelected[i] = false;
            }
        }
    }
    private static void combi(int cnt,int start){
        if(cnt == R){
            System.out.println(Arrays.toString(numbers));
        }else{
            for(int i = start;i<6;i++){
                numbers[cnt] = dice[i];
                combi(cnt+1,i+1);
            }
        }
    }
    private static void removeSamePerm(int cnt,int start){
        if(cnt == R){
            System.out.println(Arrays.toString(numbers));
        }else{
            for(int i = start;i<6;i++){
                numbers[cnt] = dice[i];
                removeSamePerm(cnt + 1,i);
            }
        }
    }
    private static void removeSameCombi(int cnt,int start){
        if(cnt == R){
            System.out.println(Arrays.toString(numbers));
        }else{
            for(int i = start;i<6;i++){
                numbers[cnt] = dice[i];
                removeSameCombi(cnt+1,i+1);
            }
        }
    }
    private static boolean checkHaving(int[] num,int d){
        for(int n : num){
            if(n==d){
                return true;
            }
        }
        return false;
    }
}
