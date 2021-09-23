package com.algo.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D4_3234 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] mass;
    static int count = 0;
    static int left,right,n;
    public static void main(String[] args) throws IOException {
        int testcase = Integer.parseInt(br.readLine());
        for(int t = 1;t<=testcase;t++){
            n = Integer.parseInt(br.readLine());
            mass = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0;i<n;i++){
                mass[i] = Integer.parseInt(st.nextToken());
            }
            count = 0;
            Arrays.sort(mass);
            do{
                left = mass[0];
                right = 0;
                scale(1);
            }while(nextPerm(mass));
            sb.append("#"+t+" "+count+"\n");
        }
        System.out.println(sb.toString());
    }
    public static void scale(int i){

        if(left<right) return ;
        if(i==n){
            count++;
            return ;
        }
        left+=mass[i];
        scale(i+1);
        left-=mass[i];
        right+=mass[i];
        scale(i+1);
        right-=mass[i];
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
    static void swap(int[] numbers,int i,int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
