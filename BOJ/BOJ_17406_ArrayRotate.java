package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17406_ArrayRotate {
    static int[][] data;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static final int[] dr = {1,0,-1,0};
    static final int[] dc = {0,1,0,-1};
    static final int[] reverseDc = {1,0,-1,0};
    static final int[] reverseDr = {0,1,0,-1};
    static int[] numbers;
    static int[] dice = new int[]{1,2,3,4,5,6};
    static boolean[] isSelected;
    static int[][] input;
    static int min = Integer.MAX_VALUE,n,m;
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        int startR = 0,startC = 0;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        data = new int[n][m];
        //input
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<m;j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        input = new int[R][3];
        for(int rotate = 0;rotate<R;rotate++){
            st = new StringTokenizer(br.readLine());
            for(int i = 0;i<3;i++)
            input[rotate][i] = Integer.parseInt(st.nextToken());
        }
        //rotate

        getAnswer(R);
        System.out.println(min);
    }
    private static void rotate(int rotate){
        int tempR = input[rotate][0]-1,tempC = input[rotate][1]-1;
        int tempS = input[rotate][2];
        int l = 2*tempS+1;
        int count = l/2;

        for(int i = 0;i<count;i++){
            int r = tempR-tempS+i;
            int c = tempC-tempS+i;
            int temp = data[r][c];
            for(int j = 0;j<4;){
                int nr = dr[j]+r;
                int nc = dc[j]+c;
                if(nr<tempR-tempS+i||nr>tempR+tempS-i||nc<tempC-tempS+i||nc>tempC+tempS-i) j++;
                else{
                    data[r][c] = data[nr][nc];
                    r = nr;
                    c = nc;
                }
            }
            data[tempR-tempS+i][tempC-tempS+i+1] = temp;

        }
    }
    private static void reverseRotate(int rotate){

        int tempR = input[rotate][0]-1,tempC = input[rotate][1]-1;
        int tempS = input[rotate][2];
        int l = 2*tempS+1;
        int count = l/2;

        for(int i = 0;i<count;i++){
            int r = tempR-tempS+i;
            int c = tempC-tempS+i;
            int temp = data[r][c];
            for(int j = 0;j<4;){
                int nr = reverseDr[j]+r;
                int nc = reverseDc[j]+c;
                if(nr<tempR-tempS+i||nr>tempR+tempS-i||nc<tempC-tempS+i||nc>tempC+tempS-i) j++;
                else{
                    data[r][c] = data[nr][nc];
                    r = nr;
                    c = nc;
                }
            }
            data[tempR-tempS+i+1][tempC-tempS+i] = temp;
        }
    }
    private static void getAnswer(int R){
        numbers = new int[R];
        isSelected = new boolean[R];
        perm(0,R);
    }
    private static void perm(int cnt,int R){
        if(cnt == R){
            //cal max
            int temp = 0;
            for(int i = 0;i<n;i++){
                for(int j = 0;j<m;j++){
                    temp+= data[i][j];
                }
                if(temp<min) min = temp;
                temp = 0;
            }
        }else{
            for(int i = 0;i<R;i++){
                if(isSelected[i]) continue;
                numbers[cnt] = dice[i];
                isSelected[i] = true;
                rotate(i);
                perm(cnt+1,R);
                reverseRotate(i);
                isSelected[i] = false;
            }
        }
    }

}
