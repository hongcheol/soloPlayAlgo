package com.algo.java.JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 최고 온도 기준으로 정렬
 * -> 하나씩 최소 온도가 현재 기준인 애를 넘는지 확인
 * -> 넘는다면 그 애의 최고 온도를 기준으로 설정, 냉장고 개수 ++
 * -> 끝까지 검색
 */
public class Solution1828_신홍철 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] chem;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int maxTemp = 0;
        int ref = 0;
        chem = new int[n][2];
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            chem[i][0]=Integer.parseInt(st.nextToken());
            chem[i][1]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(chem,(o1,o2)->o1[1]-o2[1]);
        maxTemp = chem[0][1];
        ref++;
        for(int i = 0;i<n;i++){
            if(chem[i][0]>maxTemp){
                ref++;
                maxTemp = chem[i][1];
            }//지금 냉장고에 못넣으면 새로운 냉장고 설정
        }
        System.out.println(ref);
    }
}
