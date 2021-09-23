package com.algo.java.practice;

import java.util.Arrays;

public class radixSort {

    public static void main(String[] args) {
        int[] data = new int[]{170, 45, 75, 90, 2, 24, 802, 66};
        data = radixSort(data,3,10);
        System.out.println(Arrays.toString(data));
;    }

    /**
     *
     * @param data 정수 배열
     * @param numLen 숫자의 최대 자리수
     * @param radix 기수(10진법인 경우 10)
     */

    public static int[] radixSort(int[] data, int numLen,int radix){

        int[] count = new int[radix];//특정 자리에서 숫자들을 카운트하는 배열
        int[] temp = new int[data.length];//정렬된 배열을 담을 임시 공간
        int idx, nowRadix;//idx : index, nowRadix : 현재 확인하는 자리수에 해당하는 숫자
        for(int i = 0;i<numLen;i++){
            for(int j = 0;j<radix;j++){
                count[j] = 0;
            }//자리수별로 정렬하기 때문에 초기화를 진행해야한다.
            System.out.println(Arrays.toString(count));
            nowRadix = (int)Math.pow((double)radix,(double)i);
            for(int j = 0;j<data.length;j++){
                idx = (int)(data[j]/nowRadix)%radix;
                count[idx] = count[idx]+1;
            }//각 숫자가 몇 번 나오는지 count
            for(int j = 1;j<radix;j++){
                count[j] = count[j] + count[j-1];
            }//계수 정렬을 위한 카운트의 누적합을 구한다.
            for(int j = data.length-1;j>=0;j--){
                idx = (int)(data[j]/nowRadix)%radix;
                temp[count[idx]-1] = data[j];
                count[idx] = count[idx]-1;
            }//count 배열을 통해서 각 항목의 위치를 결정
            data = Arrays.copyOf(temp,temp.length);
        }
        return data;

    }

}
