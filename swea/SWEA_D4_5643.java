package com.algo.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_D4_5643 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] tall,little;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        tall = new ArrayList[N+1];
        little = new ArrayList[N+1];
        for(int i = 0;i<=N;i++){
            tall[i] = new ArrayList<>();
            little[i] = new ArrayList<>();
        }
        for(int i = 0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int ggoma = Integer.parseInt(st.nextToken());
            int giant = Integer.parseInt(st.nextToken());
            tall[ggoma].add(giant);
            little[giant].add(ggoma);
        }
        int result = 0;
        for(int i = 1;i<=N;i++){
            visited = new boolean[N+1];
            if(tallDfs(i)+littleDfs(i) == N-1) result++;
        }
        System.out.println(result);
    }
    public static int tallDfs(int start){
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;
        int cnt = 0;
        while(!stack.isEmpty()){
            int cur = stack.pop();
            for(int person : tall[cur]){
                if(!visited[person]){
                    visited[person] = true;
                    cnt++;
                    stack.push(person);
                }
            }
        }
        return cnt;
    }
    public static int littleDfs(int start){
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;
        int cnt = 0;
        while(!stack.isEmpty()){
            int cur = stack.pop();
            for(int person : little[cur]){
                if(!visited[person]){
                    visited[person] = true;
                    cnt++;
                    stack.push(person);
                }
            }
        }
        return cnt;
    }
}
