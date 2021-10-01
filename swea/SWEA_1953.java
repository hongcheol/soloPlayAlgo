package com.algo.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953 {
    static final int[][] dr = new int[][]{
            {},
            {-1,1,0,0},
            {-1,1},
            {0,0},
            {-1,0},
            {1,0},
            {1,0},
            {-1,0}
    };
    static final int[][] dc = {
            {},
            {0,0,-1,1},
            {0,0},
            {-1,1},
            {0,1},
            {0,1},
            {0,-1},
            {0,-1}
    };
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] underworld;
    static int R,C,enterR,enterC,L;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int t = 1;t<=T;t++){
            sb.append("#"+t+" ");
            int cnt = 0;
            st = new StringTokenizer(br.readLine().trim()," ");
            //세팅값 입력
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            enterR = Integer.parseInt(st.nextToken());
            enterC = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            //공간 정보 입력
            underworld = new int[R][C];
            for(int r = 0;r<R;r++){
                st = new StringTokenizer(br.readLine());
                for(int c = 0;c<C;c++){
                    underworld[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            cnt = BFS(enterR,enterC);
            sb.append((cnt+1)+"\n");
        }
        System.out.println(sb.toString());
    }

    public static int BFS(int r,int c){
        int count = 0;
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{r,c,0});
        visited[r][c] = true;
        int[] cur = null;
        while(!queue.isEmpty()){
            cur = queue.poll();
            int pipeNum = underworld[cur[0]][cur[1]];
            for(int i = 0;i<dr[pipeNum].length;i++){
                int nr = cur[0]+dr[pipeNum][i];
                int nc = cur[1]+dc[pipeNum][i];
                if(boundCheck(nr,nc) && !visited[nr][nc] && underworld[nr][nc] != 0){
                    if(backCheck(dr[pipeNum][i],dr[underworld[nr][nc]]) && backCheck(dc[pipeNum][i],dc[underworld[nr][nc]])){
                        visited[nr][nc] = true;
                        if(cur[2]+1==L) return count;
                        queue.offer(new int[]{nr,nc,cur[2]+1});
                        count++;
                    }//돌아갈 수 있으면 집어넣는다.
                }
            }
        }
        return count;
    }

    /**
     * 돌아갈 수 있는지 체크
     * @param d 들어온 방향
     * @param arr 들어온 파이프의 방향벡터
     * @return
     */
    public static boolean backCheck(int d,int[] arr){
        int temp = d*(-1);
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == temp) return true;
        }
        return false;
    }
    public static boolean boundCheck(int r,int c){
        if(r>=0 && r<R && c>=0 && c<C) return true;
        else return false;
    }
}
