package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R,C;
    static int[][] field;
    static boolean[] isUsed = new boolean[26];
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};
    static int cnt;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        field = new int[R][C];
        for(int i = 0;i<R;i++){
            String input = br.readLine();
            for(int j = 0;j<C;j++){
                field[i][j] = input.charAt(j)-'A';
            }
        }
        isUsed[field[0][0]] = true;
        dfs(0,0,1);
        System.out.println(cnt);
    }
    public static void dfs(int r,int c,int l){
        if(cnt == 26) return ;
        for(int i = 0;i<4;i++){
            int nr = r+dr[i];
            int nc = c+dc[i];

            if(!boundCheck(nr,nc)) continue;
            if(isUsed[field[nr][nc]]) continue;
            isUsed[field[nr][nc]] = true;
            dfs(nr,nc,l+1);
            isUsed[field[nr][nc]] = false;
        }
        cnt = Math.max(cnt,l);
    }
    public static boolean boundCheck(int r,int c){
        if(r>=0&&r<R&&c>=0&&c<C) return true;
        return false;
    }
}
