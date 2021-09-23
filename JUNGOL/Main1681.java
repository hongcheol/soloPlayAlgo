package com.algo.java.JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1681 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] dist;
    static int n;
    static int min = 100000;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine().trim());
        dist = new int[n][n];
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<n;j++){
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[] visited = new boolean[n];
        hamilton(visited, 0, 0, n, 0);
        System.out.println(min);
    }

    public static void hamilton(boolean[] visited,int cost,int depth,int n,int from){
        if(cost>=min) return ;
        if(depth == n-1){
            if(dist[from][0]!= 0) {
                cost += dist[from][0];
                min = min > cost ? cost : min;
            }
            return ;
        }
        for(int i = 1;i<n;i++){
            if(!visited[i] && dist[from][i] != 0){
                visited[i] = true;
                hamilton(visited,cost+dist[from][i],depth+1,n,i);
                visited[i] = false;
            }
        }
    }
}
