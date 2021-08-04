package com.algo.java.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_D2_2001 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] flyField;
    public static void main(String[] args) throws Exception{
        int testcase = Integer.parseInt(br.readLine());
        for(int t = 1;t<=testcase;t++){
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]),M = Integer.parseInt(input[1]);
            flyField = new int[N][N];
            for(int i = 0;i<N;i++){
                input = br.readLine().split(" ");
                for(int j = 0;j<N;j++) {
                    flyField[i][j] = Integer.parseInt(input[j]);
                }
            }
            int areaSum = 0;
            int temp = 0,leftColSum = 0,rightColSum = 0;
            for(int r = 0;r<N-M+1;r++){
                for(int c = 0;c<N-M+1;c++){
                    leftColSum = 0;
                    rightColSum = 0;
                    if(c == 0){
                        temp = 0;
                        for(int i = 0;i<M;i++){
                            for(int j = 0;j<M;j++){
                                temp += flyField[r+i][c+j];
                            }
                        }
                    }else {
                        for (int i = 0; i < M; i++) {
                            leftColSum += flyField[r+i][c-1];
                        }
                        for (int i = 0; i < M; i++) {
                            rightColSum += flyField[r+i][c + M - 1];
                        }
                        temp -= leftColSum;
                        temp += rightColSum;
                    }
                    if(areaSum<temp) areaSum = temp;
                }//판 움직이면서 계산
            }//for
            System.out.println("#"+t+" "+areaSum);
        }
    }
}
