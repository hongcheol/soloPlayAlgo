package com.algo.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_D4_1210 {
    static String[][] ladder;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        int row,testcaseNum,col,dir;
        for(int t = 0;t<10;t++){
            row = 99;
            testcaseNum = Integer.parseInt(br.readLine());
            col = getLadder();
            while(row>0){
                row--;
                dir = leftRightCheck(row,col);
                if(dir != 0) col = move(row,col,dir);
                //row--;
            }
            System.out.println("#"+testcaseNum+" "+col);
        }
    }
    static int getLadder() throws IOException {
        //x 표시된 곳을 return
        ladder = new String[100][100];
        int endPoint = 0;
        for(int i = 0;i<100;i++){
            ladder[i] = br.readLine().split(" ");
        }
        for(int i = 0;i<100;i++){
            if(ladder[99][i].equals("2")){
                endPoint = i;
            }
        }
        return endPoint;
    }
    static int leftRightCheck(int r,int c){
        if(c == 0){
            if(ladder[r][c+1].equals("1")) return 1;
            else return 0;
        }
        else if(c == 99){
            if(ladder[r][c-1].equals("1")) return -1;
            else return 0;
        }
        else{
            if(ladder[r][c-1].equals("1")) return -1;
            if(ladder[r][c+1].equals("1")) return 1;
        }
        return 0;
    }
    static int move(int r, int c, int dir){
        //이동 후의 c를 return
        c += dir;
        while(ladder[r][c].equals("1")){
            c += dir;
            if(c==-1 || c == 100)break;
        }
        return c-dir;
    }
}
