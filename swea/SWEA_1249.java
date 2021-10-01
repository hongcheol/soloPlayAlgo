package com.algo.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 복구작업에 걸리는 시간이 최단인 경로를 찾으면 된다.0을 우선순위로 둔다.
 * 입력받고 다익스트라
 */
public class SWEA_1249 {
    static class Node implements Comparable<Node>{
        int r,c;
        int dist;

        public Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist,o.dist);
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static final int MAX = 100000;
    static PriorityQueue<Node> pq;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int t = 1;t<=T;t++){
            sb.append("#"+t+" ");
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            for(int i = 0;i<n;i++){
                char[] input = br.readLine().toCharArray();
                for(int j = 0;j<n;j++){
                    map[i][j] = input[j]-'0';
                }
            }//입력처리
            dijkstra(0,0);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void dijkstra(int r,int c){
        boolean[][] visited = new boolean[n][n];
        int[][] dist = new int[n][n];

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                dist[i][j] = MAX;
            }
        }
        dist[r][c] = 0;
        visited[r][c] = true;
        pq = new PriorityQueue<>();
        pq.offer(new Node(r,c,0));
        Node cur = null;
//        for(int i = 0;i<4;i++){
//            int nr = r + dr[i];
//            int nc = c + dc[i];
//            if(boundCheck(nr,nc) && !visited[nr][nc]){
//                dist[nr][nc] = map[nr][nc];
//                pq.offer(new Node(nr,nc,dist[nr][nc]));
//            }
//        }
        for(int j = 0;j<n;j++){
            for(int k = 0;k<n;k++) {
                cur = pq.poll();
                visited[cur.r][cur.c] = true;
                for (int i = 0; i < 4; i++) {
                    int nr = cur.r + dr[i];
                    int nc = cur.c + dc[i];
                    if (boundCheck(nr, nc) && !visited[nr][nc]) {
                        if (dist[nr][nc] > dist[cur.r][cur.c] + map[nr][nc]) {
                            dist[nr][nc] = dist[cur.r][cur.c] + map[nr][nc];
                            pq.offer(new Node(nr, nc, dist[nr][nc]));
                        }
                    }
                }
            }
        }
        sb.append(dist[n-1][n-1]);

    }
    public static boolean boundCheck(int r,int c){
        if(r>=0 && r<n && c>= 0 && c<n) return true;
        else return false;
    }
    public static void printArr(int[][] arr){
        for(int[] row : arr){
            for(int data : row){
                System.out.print(data +"\t");
            }
            System.out.println();
        }
        sb.append("\n");
    }
}
