package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926_ArrayRotate {
    static int[][] data;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static final int[] dr = {0,1,0,-1};
    static final int[] dc = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        int startR = 0,startC = 0;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()),m = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        data = new int[n][m];
        //input
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<m;j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //rotate

        for(int rotate = 0;rotate<R;rotate++){
            int rl = n, cl = m;
            startR = 0;
            startC = 0;
            while(rl-startR>0 && cl-startC>0) {
                int r = startR, c = startC;
                int temp = data[startR][startC];
                for (int i = 0; i < 4; i++) {
                    if(i == 0){
                        for(;c<cl-1;c++){
                            data[r][c] = data[r+dr[i]][c+dc[i]];
                        }
                    }
                    else if(i == 1){
                        for(;r<rl-1;r++){
                            data[r][c] = data[r+dr[i]][c+dc[i]];
                        }
                    }
                    else if(i == 2){
                        for(;c>m-cl;c--){
                            data[r][c] = data[r+dr[i]][c+dc[i]];
                        }
                    }
                    else if(i == 3){
                        for(;r>n-rl;r--){
                            data[r][c] = data[r+dr[i]][c+dc[i]];
                        }
                    }
                }
                data[r+1][c] = temp;
                rl -= 1;
                cl -= 1;
                startR += 1;
                startC += 1;
            }
        }
        for(int[] d : data){
            for(int num : d){
                sb.append(num + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
