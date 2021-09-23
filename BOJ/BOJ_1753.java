package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
public class BOJ_1753 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static final int INF = Integer.MAX_VALUE;
    static class Edge implements Comparable<Edge>{
        int no,weight;

        public Edge(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight-o.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[V+1];
        for(int i = 1;i<=V;i++){
            graph[i] = new ArrayList<Edge>();
        }
        int u,v,w;
        for(int i = 0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v,w));
        }
        int[] distance = new int[V+1];
        boolean[] visited = new boolean[V+1];
        Arrays.fill(distance,INF);
        distance[startNode] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        pq.offer(new Edge(startNode,distance[startNode]));
        Edge cur;

        while(!pq.isEmpty()){
            cur = pq.poll();
            if(cur.weight > distance[cur.no])continue;

            for(int c = 0;c<graph[cur.no].size();c++){
                Edge next = (Edge) graph[cur.no].get(c);
                if(distance[next.no] > cur.weight+ next.weight){
                    distance[next.no] = cur.weight+next.weight;
                    pq.add(new Edge(next.no,distance[next.no]));
                }
            }
        }
        for(int i = 1;i<V+1;i++){
            if(distance[i] == Integer.MAX_VALUE)sb.append("INF");
            else sb.append(distance[i]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
