package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 익은 토마토들을 기준으로 하나
 */
public class Main7576 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int r,c;
    static int notYet = 0;
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        Queue<int[]> queue = new LinkedList<int[]>();//[r,c,익기까지 걸린 시간]
        int[][] box = new int[r][c];
        int min = 0;
        boolean[][] visited = new boolean[r][c];
        for(int i = 0;i<r;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<c;j++){
                int now = Integer.parseInt(st.nextToken());
                box[i][j] = now;
                if(now == 1){
                    queue.add(new int[]{i,j,0});//입력을 받으면서 토마토 위치 바로 저장
                    visited[i][j] = true;
                }else if(now == 0){
                    notYet++;
                }
            }
        }
        if(queue.isEmpty()){
            if(notYet>0) System.out.println(-1);
            else System.out.println(0);
            return ;
        }
        min = bfs(queue,visited,box);
        if(notYet>0){
            System.out.println(-1);
        }else{
            System.out.println(min);
        }
    }
    public static int bfs(Queue<int[]> queue,boolean[][] visited,int[][] box){
        int[] cur = null;
        while(!queue.isEmpty()){
            cur = queue.poll();
            for(int i = 0;i<4;i++){
                int nr = cur[0]+dr[i];
                int nc = cur[1]+dc[i];
                if(boundCheck(nr,nc) && !visited[nr][nc] && box[nr][nc]>=0){
                    visited[nr][nc] = true;
                    //ripe[nr][nc] = cur[2]+1;
                    queue.add(new int[]{nr,nc,cur[2]+1});
                    notYet--;
                }
            }
        }
        return cur[2];
    }
    public static boolean boundCheck(int i,int j){
        if(i<0 || i>=r || j<0 || j>=c) return false;
        return true;
    }
}
