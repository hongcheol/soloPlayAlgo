package com.algo.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D5_1247 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] homes;
    static boolean[] isVisited;
    static int[] now = new int[2];
    static int[] myHome = new int[2];
    static int[] distance;
    static StringBuilder sb = new StringBuilder();
    static int min;

    public static void main(String[] args) throws IOException {
        int testcase = Integer.parseInt(br.readLine());
        for(int t = 1;t<=testcase;t++) {
            int n = Integer.parseInt(br.readLine());
            int tempMin = Integer.MAX_VALUE,temp = 0,tempMinIdx = 0;
            min = Integer.MAX_VALUE;
            homes = new int[n][2];
            isVisited = new boolean[n];
            distance = new int[n+1];

            st = new StringTokenizer(br.readLine());
            now[0] = Integer.parseInt(st.nextToken());
            now[1] = Integer.parseInt(st.nextToken());
            myHome[0] = Integer.parseInt(st.nextToken());
            myHome[1] = Integer.parseInt(st.nextToken());
            for(int i = 0;i<n;i++){
                homes[i] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            }
            //다익스트라용 세팅
            for(int i = 0;i<n;i++){
                distance[i] = getDistance(now,homes[i]);
            }
            distance[n] = getDistance(now,myHome);
            for(int i = 0;i<n;i++) {
                //방문 안한 지점이 없는지 확인
                temp = 0;
                for(int j = 0;j<n;j++){
                    //temp = getDistance(now,homes[j]);
                    if(!isVisited[j]){
                        if(tempMin > distance[j]){
                            tempMin = distance[j];
                            tempMinIdx = j;
                        }
                    }
                }
                for(int j = 0;j<n;j++){
                    if(!isVisited[j]&&j!=tempMinIdx){
                        distance[j] = Math.min(distance[j],distance[tempMinIdx]+getDistance(homes[j],homes[tempMinIdx]));
                    }
                }
                isVisited[tempMinIdx] = true;
            }
            for(int i = 0;i<n;i++){
                min = Math.min(min,distance[i]+getDistance(myHome,homes[i]));
            }
            sb.append("#"+t+" "+min+"\n");
        }
        System.out.println(sb.toString());
    }
    public static void goHome(int[] pre,int dist){}
    public static int getDistance(int[] a,int[] b){
        return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
    }
}
