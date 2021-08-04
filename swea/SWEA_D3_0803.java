package com.algo.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_D3_0803 {
    static int[] boxes;
    public static void main(String[] args) throws IOException {
        for(int t = 0;t<1;t++) {
            boxes = new int[100];//가로길이는 100으로 고정
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int dump = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < 100; i++) {
                boxes[i] = Integer.parseInt(input[i]);
            }
            for(int dumpCount = 0;dumpCount<dump;dumpCount++){
                int[] idxes = findMinValueIdxes(boxes);
                int max = 0;
                int minIdx = 0;
                int maxIdx = 0;
                for(int idx : idxes){
                    int lMax = findMaxNearMin(boxes,idx,-1);
                    int rMax = findMaxNearMin(boxes,idx,1);
                    if(lMax == -1 || rMax == -1) break;
                    int nearMax = boxes[lMax]>boxes[rMax]?lMax:rMax;
                    if(max<boxes[nearMax]) {
                        max = boxes[nearMax];
                        maxIdx = nearMax;
                        minIdx = idx;
                    }
                }
                if(boxes[minIdx]==boxes[maxIdx]) break;
                boxes[minIdx]++;
                boxes[maxIdx]--;
                System.out.println("boxes[minIdx] = " + boxes[minIdx]);
                for(int i :boxes){
                    System.out.print(i+"\t");
                }
            }
            System.out.println(findMinValue(boxes));
            System.out.println(findMaxValue(boxes));


        }
    }
    static int[] findMinValueIdxes(int[] arr){
        int min = 1000;
        int count = 0;
        for(int i = 0;i<100;i++){
            if(arr[i]<min) {
                min = arr[i];
            }
        }
        for(int i = 0;i<100;i++){
            if(arr[i]==min) {
                count++;
            }
        }
        int[] result = new int[count];
        int n = 0;
        for(int i = 0;i<100;i++){
            if(arr[i]==min) {
                result[n++] = i;
            }
        }
        return result;
    }
    static int findMaxNearMin(int[] arr,int idx,int dir){
        //dir -1이면 left, 1이면 right
        while(idx+dir>=0 && idx+dir<100){
            if(arr[idx+dir]<=arr[idx]) return idx;
            idx += dir;
        }
        return -1;
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
        int idx = 0;
        for(int i = 0;i<100;i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }
}
