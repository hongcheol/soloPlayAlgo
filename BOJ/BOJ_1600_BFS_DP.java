package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_BFS_DP {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};
    static final int[] hdr = {-2,-2,-1,-1,1,1,2,2};
    static final int[] hdc = {-1,1,-2,2,-2,2,-1,1};
    static int R = 0;
    static int C = 0;
    static int K = 0;
    public static void main(String[] args) throws IOException {
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int[][] field = new int[R][C];

        for(int r = 0;r<R;r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0;c<C;c++){
                field[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        if(!bfs(field)) System.out.println(-1);
    }
    static boolean bfs(int[][] field){
        boolean[][][] visited = new boolean[R][C][31];
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{0,0,0,0});
        visited[0][0][0] = true;
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            if(node[0] == R-1 && node[1] == C-1){
                System.out.println(node[3]);
                return true;
            }
            if(node[2]<K){
                for(int i = 0;i<8;i++){
                    int nr = node[0] + hdr[i];
                    int nc = node[1] + hdc[i];
                    if(boundCheck(nr,nc)){
                        if(field[nr][nc] == 0 && visited[nr][nc][node[2]+1]==false){
                            queue.offer(new int[]{nr,nc,node[2]+1,node[3]+1});
                            visited[nr][nc][node[2]+1] = true;
                        }
                    }
                }
            }//말처럼 이동이 가능하다면!
            for(int i = 0;i<4;i++){
                int nr = node[0] + dr[i];
                int nc = node[1] + dc[i];
                if(boundCheck(nr,nc)){
                    if(field[nr][nc]==0 && visited[nr][nc][node[2]]==false){
                        queue.offer(new int[]{nr,nc,node[2],node[3]+1});
                        visited[nr][nc][node[2]] = true;
                    }
                }
            }
        }
        return false;
    }
    static boolean boundCheck(int r,int c){
        if(r>=0 && r<R && c>= 0 && c<C) return true;
        else return false;
    }
}
