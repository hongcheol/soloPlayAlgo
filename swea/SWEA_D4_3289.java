package com.algo.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_3289 {
    static int[] parent;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int testcase = Integer.parseInt(br.readLine());
        for(int t = 1;t<=testcase;t++) {
            sb.append("#"+t+" ");
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            parent = new int[n+1];
            make(n);
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                if (cmd == 0) {
                    union(n1, n2);
                } else if (cmd == 1) {
                    int a = find(n1);
                    int b = find(n2);
                    if (a!=b) sb.append(0);
                    else sb.append(1);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void make(int n){

        for(int i = 0;i<n+1;i++){
            parent[i] = -1;
        }
    }
    static int find(int x){
        if(parent[x]<0) return x;
        return parent[x] = find(parent[x]);
    }
    static void union(int x, int y){
        int v = find(x);
        int u = find(y);
        if(v==u) return ;
        parent[u] = v;
    }
}
