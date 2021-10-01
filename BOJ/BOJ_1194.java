package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * key 6개라서 비트마스킹으로 처리.
 * bfs 탐색.
 */
public class BOJ_1194 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[][] world;
    static boolean[][][] visited;//키를 든 상태에 따라서 방문여부를 다르게 체크.
    static int R,C;
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};
    static Queue<int[]> queue = new LinkedList<>();//int[r,c,key 상태]
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        world = new char[R][C];
        visited = new boolean[R][C][64];
        for(int r = 0;r<R;r++){
            char[] input = br.readLine().toCharArray();
            for(int c = 0;c<C;c++){
                world[r][c] = input[c];
                if(world[r][c] == '0'){
                    queue.offer(new int[]{r,c,0});
                    world[r][c] = '.';
                }
            }
        }
        System.out.println(bfs());
    }
    public static int bfs(){
        int moving = 0;
        while(!queue.isEmpty()){
            moving++;
            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                int curR = cur[0];
                int curC = cur[1];
                int curKS = cur[2];
                for(int d = 0;d<4;d++){
                    int nr = curR + dr[d];
                    int nc = curC + dc[d];
                    int nextKS = curKS;
                    if(!boundCheck(nr,nc)) continue;
                    if(visited[nr][nc][curKS] || world[nr][nc] == '#')continue;
                    if(world[nr][nc] == '1') return moving;
                    else if(world[nr][nc] >= 'a' && world[nr][nc] <= 'f'){
                        int keyState = 1 << (world[nr][nc]-'a');
                        nextKS |= keyState;
                    }//key를 만난 경우.
                    else if(world[nr][nc] >= 'A' && world[nr][nc] <= 'F'){
                        int door = 1<<(world[nr][nc]-'A');
                        if((nextKS&door) != door) continue;
                    }
                    queue.offer(new int[]{nr,nc,nextKS});
                    visited[nr][nc][curKS] = true;
                }
            }
        }
        return -1;
    }
    public static boolean boundCheck(int r,int c){
        if(r>=0 && r<R && c>=0 && c<C) return true;
        return false;
    }

}
