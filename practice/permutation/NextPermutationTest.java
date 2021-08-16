package com.algo.java.practice.permutation;

import java.util.Arrays;

public class NextPermutationTest {

    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,7,8,9};
        Arrays.sort(input);
        while(np(input)){
            System.out.println(Arrays.toString(input));

        }
    }
    //다음 큰 순열이 있으면 true, 없으면 false
    private static boolean np(int[] numbers){
        int N = numbers.length;
        //step1. 꼭대기(i)를 찾는다. 꼭대기를 통해 교환위치(i-1) 찾
        int i = N-1;
        while(numbers[i-1]>=numbers[i])i--;
        System.out.println(i);
        if(i==0)return false;

        //step2. i-1 위치값과 교환할 큰 값 찾기기
        int j = N-1;
        while(numbers[i-1]>=numbers[j])--j;//반드시 존재 없다면 꺾이지 않기 때문

        //step3. i-1위치값과 j위치값 교환
        swap(numbers,i-1,j);

        //step4. 꼭대기부터 맨뒤까지 내림차순 형태의 순열을 오름차순으로 처리
        int k = N-1;
        while(i<k){//아직 둘이 만나지않았으면
            swap(numbers,i++,k--);
        }
        return true;
    }

    private static void swap(int[] numbers,int i,int j){
        if(i>=numbers.length-1 || j<0) return ;
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
