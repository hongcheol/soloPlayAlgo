package com.algo.java.practice.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class KuruskalTest {

    static class Edge implements Comparable<Edge> {
        int start, end, weight;
        public Edge(int start,int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.weight,o.weight);
        }
    }
    static int V;
    static int E;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Edge[] edgeList;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine()," ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edgeList = new Edge[E];
        for(int i = 0;i<E;i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(start,end,weight);
        }
        Arrays.sort(edgeList);//오름차
        make();// 모든 정점을 각각 집합으로 만들고 출발한다.
        //간선 하나씩 시도하며 트리를 만든다.
        int cnt = 0,result = 0;
        for(Edge edge : edgeList){
            if(merge(edge.start,edge.end)){
                result += edge.weight;
                if(++cnt == V-1) break;// 신장트리 완성.
            }
        }
        System.out.println(result);

    }
    static int[] parents;
    static void make(){
        parents = new int[V];
        for(int i = 0;i<V;i++){
            parents[i] = i;
        }
    }
    //u가 속한 트리의 루트 번호를 반환한다.
    static int find(int u){
        if(u == parents[u]) return u;
        //return find(parent[u]); --- 기울어진 트리의 경우 비효율적
        //최적화(Path Compression)
        return parents[u] = find(parents[u]);
    }
    //u가 속한 트리와 v가 속한 트리를 합친다..
    static boolean merge(int u, int v){
        u = find(u);
        v = find(v);
        //u와 v가 이미 같은 트리에 속하는 경우는 걸러낸다.
        if(u ==v) return false;
        parents[u] = v;
        return true;
    }
}
