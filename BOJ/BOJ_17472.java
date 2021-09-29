package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17472 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] world;
    static boolean[][] visited;
    static int R,C;
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};
    static PriorityQueue<Edge> pq;
    static int[] parents;
    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int w;
        Edge(int start,int end,int w){
            this.start = start;
            this.end = end;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w,o.w);
        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        world = new int[R][C];
        visited = new boolean[R][C];

        for(int i = 0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<C;j++){
                world[i][j] = Integer.parseInt(st.nextToken());
            }
        }//입력.
        int number = 1;
        //섬구분을 위해 번호 부여
        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                if(!visited[i][j] && world[i][j] == 1){
                    numbering(i,j,number++);
                }
            }
        }
        for(int[] row: world){
            for(int data:row){
                System.out.print(data+"\t");
            }
            System.out.println();
        }
        //각 칸에서 다리를 놓을 수 있는지 확인해서 놓을 수 있으면 놓는다.
        pq = new PriorityQueue<>();
        for(int r = 0;r<R;r++){
            for(int c = 0;c<C;c++){
                if(world[r][c] != 0) {
                    for (int i = 0; i < 4; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];
                        if (boundCheck(nr, nc) && world[nr][nc] == 0) {
                            bridge(i, nr, nc, world[r][c]);//넘겨줄 때, 놓는 섬 번호를 넘겨줘야함.
                        }
                    }
                }
            }
        }
        parents = new int[number];
        for(int i = 1;i<number;i++){
            parents[i] = i;
        }
        //놓을 수 있는 다리 놓은 후에 크루스칼
        int edgeCount = 0;
        int ans = 0;
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            if(merge(cur.start-1,cur.end-1)){
                ans += cur.w;
                if(++edgeCount == number-2) break;
            }
        }
        if(edgeCount<number-2) System.out.println(-1);
        else System.out.println(ans);


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
        if(u == v) return false;
        parents[u] = v;
        return true;
    }
    public static void numbering(int r, int c,int number){
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{r,c});
        int[] cur = null;
        while(!stack.isEmpty()) {
            cur = stack.pop();
            world[cur[0]][cur[1]] = number;
            for (short i = 0; i < 4; i++) {
                int nr = (cur[0] + dr[i]);
                int nc = (cur[1] + dc[i]);
                if (!boundCheck(nr, nc)) continue;
                if (world[nr][nc] != 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    stack.push(new int[]{nr,nc});
                }
            }
        }
    }
    //다리 놓기.
    public static void bridge(int dir,int r,int c,int num){
        int len = 1;
        while(boundCheck(r,c)){
            if(world[r][c] != 0){
                if(len > 2){
                    pq.add(new Edge(num,world[r][c],len-1));
                }
                break;
            }
            r += dr[dir];
            c += dc[dir];
            len++;
        }
    }
    public static boolean boundCheck(int r,int c){
        if(r>=0 && r<R && c>=0 && c<C) return true;
        return false;
    }
    public static void init(boolean[][] arr){
        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                arr[i][j] = false;
            }
        }
    }
}
