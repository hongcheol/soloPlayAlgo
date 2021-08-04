package com.algo.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_D3_0803_1 {
    static int[][] boxes;
    static int[] dumpArr;

    public static void main(String[] args) throws IOException {
        boxes = new int[10][100];//가로길이는 100으로 고정
        dumpArr = new int[10];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 0; t < 10; t++) {
            try {
                dumpArr[t] = Integer.parseInt(br.readLine());
            }catch (NumberFormatException e){
                System.out.println("empty string");
            }
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < 100; i++) {
                boxes[t][i] = Integer.parseInt(input[i]);
            }
        }
        br.close();
        for (int t = 0; t < 10; t++) {
            int[] box = boxes[t];
            int dump = dumpArr[t];
            box = moveBox(box,dump,0);
            System.out.println("#"+t+" "+(findMaxValue(box)-findMinValue(box)));
        }
    }
    static int[] moveBox(int[] box,int dump,int count){
        if(dump != count){
            int minIdx = findMinValueIdx(box);
            int maxIdx = findMaxValueIdx(box);
            if (box[maxIdx] == box[minIdx]) return box;
            box[maxIdx]--;
            box[minIdx]++;
            moveBox(box,dump,count+1);
        }
        return box;
    }
    static int findMinValueIdx(int[] arr){
        int min = 1000;
        int idx = 0;
        for(int i = 0;i<100;i++){
            if(arr[i]<min) {
                min = arr[i];
                idx = i;
            }
        }
        return idx;
    }
    static int findMaxValueIdx(int[] arr){
        int max = -1;
        int idx = 0;
        for(int i = 0;i<100;i++){
            if(arr[i]>max) {
                max = arr[i];
                idx = i;
            }
        }
        return idx;
    }
    static int findMaxValue(int[] arr){
        int max = -1;
        for(int i = 0;i<100;i++){
            if(arr[i]>max) {
                max = arr[i];
            }
        }
        return max;
    }
    static int findMinValue(int[] arr){
        int min = 1000;
        for(int i = 0;i<100;i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }
}
