package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15686 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] city;
    static List<int[]> chicken = new ArrayList<>(),homes = new ArrayList<>();
    static int n,m,chickenCount = 0;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        //필드 정보 읽어옴
        city = new int[n][n];
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            city[i] = new int[n];
            for(int j = 0;j<n;j++){
                city[i][j] = Integer.parseInt(st.nextToken());
                if(city[i][j]==2) {
                    chicken.add(new int[]{i, j});
                    chickenCount++;
                }
                if(city[i][j]==1) homes.add(new int[]{i,j});
            }
        }
        int minDist = 100000;
        int[] p = new int[chickenCount];
        int cnt = 0;
        while(++cnt<=m) p[chickenCount-cnt] = 1;
        do{
            int dist = 0;
            dist = getChicken(p,homes);
            if(minDist>dist) minDist = dist;
        }while(np(p));
        System.out.println(minDist);
    }
    public static int getChicken(int[] p,List homes){
        int d = 0;
        for(int i = 0;i<homes.size();i++){
            int[] now = (int[])homes.get(i);
            int temp = 1000000;

            for(int j = 0;j<chickenCount;j++){
                if(p[j]==1){
                    temp = Math.min(temp,Math.abs(now[0]-chicken.get(j)[0])+Math.abs(now[1]-chicken.get(j)[1]));
                }
            }
            d += temp;
        }
        return d;
    }
    public static boolean np(int[] numbers){
        int N = numbers.length;
        int i = N-1;
        while(i>0&&numbers[i-1]>=numbers[i]) --i;
        if(i == 0) return false;

        int j = N-1;
        while(numbers[i-1]>=numbers[j])--j;

        swap(numbers,i-1,j);
        int k = N-1;
        while(i<k){
            swap(numbers,i++,k--);
        }
        return true;
    }
    public static void swap(int[] numbers,int i,int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
    public static boolean boundCheck(int r,int c){
        if(r>=0&&r<n&&c>=0&&c<m)return true;
        return false;
    }
}
