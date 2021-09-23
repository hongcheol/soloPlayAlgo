package com.algo.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] foodTable;
    public static void main(String[] args) throws IOException {
        int testcase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testcase; t++) {
            int n = Integer.parseInt(br.readLine());
            int min = 200000;
            int now = 0;
            int cnt = 0;
            int b = 0;
            foodTable = new int[n][n];
            for(int i = 0;i<n;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j = 0;j<n;j++){
                    foodTable[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[] p = new int[n];
            while (++cnt <= n/2) p[n - cnt] = 1;

            do {
                now = 0;
                b = 0;
                for (int i = 0; i < n; i++) {
                    if (p[i] == 1){
                        for(int j = 0;j<n;j++){
                            if(p[j]==1){
                                now += foodTable[i][j];
                            }
                        }
                    }
                    if (p[i] == 0) {
                        for(int j = 0;j<n;j++){
                            if(p[j] == 0){
                                b += foodTable[i][j];
                            }
                        }
                    }
                }
                if(min>Math.abs(now-b))min = Math.abs(now-b);
            } while (nextPerm(p));
            sb.append("#"+t+" "+min).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
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
