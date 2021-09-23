package com.algo.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
public class SWEA_D4_3124 {
    static class Node implements Comparable<Node>{
        int id;
        long w;
        public Node(int id, long w) {
            this.id = id;
            this.w = w;
        }
        @Override
        public int compareTo(Node o) {
            return Long.compare(this.w, o.w);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for(int t = 1;t<=testcase;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            List<Node> adjMatrix[] = new List[V + 1];
            boolean[] visited = new boolean[V + 1];
            for (int i = 1; i <= V; i++) {
                adjMatrix[i] = new ArrayList<>();
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                long n3 = Integer.parseInt(st.nextToken());
                adjMatrix[n1].add(new Node(n2, n3));
                adjMatrix[n2].add(new Node(n1, n3));
            }

            long result = 0;//최소 스패닝 트리 비용
            PriorityQueue<Node> pq = new PriorityQueue<>();
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(1);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                visited[cur] = true;
                for (int i = 0; i < adjMatrix[cur].size(); i++) {
                    int next = adjMatrix[cur].get(i).id;
                    long nextW = adjMatrix[cur].get(i).w;
                    if (!visited[(int) next]) {
                        pq.offer(new Node(next, nextW));
                    }
                }
                while (!pq.isEmpty()) {
                    Node nextNode = pq.poll();
                    int next = nextNode.id;
                    long nextW = nextNode.w;
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                        result += nextW;
                        break;
                    }
                }
            }
            System.out.println("#"+t+" "+result);
        }
    }
}

