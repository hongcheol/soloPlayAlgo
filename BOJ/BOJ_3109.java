package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 접근 전략 - visited 메모하면서 위부터 DFS로 달린다.
 * 입력을 받을 때, 맨 왼쪽부터 가장 먼저 나오는 애들 모아놓는다.
 * ..x.......
 * .....x....
 * .x....x...
 * ...x...xx.
 * ..........
 * ....x.....
 * 이동하면서 x로 마킹
 */
public class BOJ_3109 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[][] field;
    static boolean[][] isVisited;
    static int R,C;
    static int count = 0;
    static boolean isEnd = false;
    static final int[] dc = {-1,0,1};
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        field = new char[R][];
        int count = 0;
        for(int i = 0;i<R;i++){
            field[i] = br.readLine().toCharArray();
        }
        for(int i = 0;i<R;i++){
            isEnd = false;
            dfs(i,0);
            if(isEnd) count++;
        }
        System.out.println(count);
    }
    public static void dfs(int r,int c){
        if(c == C-1 && field[r][c]=='.') isEnd = true;

        field[r][c] = 'x';
        for(int i = 0;i<3;i++){
            int nr = r + dc[i];
            int nc = c + 1;
            if(boundCheck(nr,nc)){
                if(field[nr][nc]!='x'){
                    dfs(nr,nc);
                    if(isEnd) break;
                }
            }
        }
    }
    public static boolean boundCheck(int r,int c){
        if(r>=0&&r<R&&c>=0&&c<C) return true;
        return false;
    }
}
