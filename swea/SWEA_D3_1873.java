package com.algo.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_D3_1873 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //상하좌우
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};
    static char[][] field;
    static int H,W;
    public static void main(String[] args) throws IOException {
        int testcase = Integer.parseInt(br.readLine());
        int dir = 0;
        for(int t = 1; t<testcase+1;t++){
            String[] inputHW = br.readLine().split(" ");
            H = Integer.parseInt(inputHW[0]);
            W = Integer.parseInt(inputHW[1]);
            field = new char[H][W];
            for(int h = 0;h<H;h++){
                field[h] = br.readLine().toCharArray();
            }
            int commandNum = Integer.parseInt(br.readLine());
            String command = br.readLine();
            int[] pos = findTank(H,W);
            dir = checkDir(field[pos[0]][pos[1]]);
            //command 하나씩 읽어가면서 처리하기
            for(int i = 0;i<commandNum;i++){
                switch (command.charAt(i)){
                    case 'U':
                        dir = 0;
                        field[pos[0]][pos[1]]='^';
                        break;
                    case 'D':
                        dir = 1;
                        field[pos[0]][pos[1]]='v';
                        break;
                    case 'L':
                        dir = 2;
                        field[pos[0]][pos[1]]='<';
                        break;
                    case 'R':
                        dir = 3;
                        field[pos[0]][pos[1]]='>';
                        break;
                    case 'S':
                        fire(pos[0],pos[1],dir);
                        break;
                }
                if(command.charAt(i)!='S'){
                    pos = move(pos[0],pos[1],dir);
                }
            }
            System.out.print("#"+t+" ");
            for(char[] chars : field){
                for(char c: chars){
                    System.out.print(c);
                }
                System.out.println();
            }
        }
    }
    static int[] findTank(int H, int W){
        int[] pos = new int[2];
        for(int h = 0;h<H;h++){
            for(int w = 0;w<W;w++){
                if(field[h][w]=='<'|| field[h][w]== '>'|| field[h][w]=='^'||field[h][w]=='v'){
                    pos[0] = h;
                    pos[1] = w;
                }
            }
        }
        return pos;
    }
    static int checkDir(char c){
        if(c=='<') return 2;
        if(c=='>') return 3;
        if(c=='^') return 0;
        if(c=='v') return 1;
        return 0;
    }
    static int[] move(int r,int c, int dir){
        int[] pos = new int[2];
        int nr = r+dr[dir];
        int nc = c+dc[dir];
        if(nr>=0 && nr<H && nc >=0 && nc <W){
            if(field[nr][nc] =='.'){
                field[nr][nc] = field[r][c];
                field[r][c] = '.';
                r = nr;
                c = nc;
            }
        }
        pos[0] = r;
        pos[1] = c;
        return pos;
    }
    static void fire(int r,int c,int dir){
        int nr = r+dr[dir];
        int nc = c+dc[dir];
        while(nr>=0 && nr<H && nc >=0 && nc <W){
            if(field[nr][nc]=='*'){
                field[nr][nc]='.';
                break;
            }
            if(field[nr][nc]=='#') break;
            nr += dr[dir];
            nc += dc[dir];
        }
    }
}
