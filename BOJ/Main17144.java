package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17144 {
    static int[][] room = new int[50][50];//먼지쌓인 방
    static int[][] afterSpread = new int[50][50];//바람이 지나간 곳을 처리하기위한 배열
    static int R = 0,C = 0;
    static int airR0 = 0;//0번 에어컨 위치
    static int airR1 = 0;//1번 에어컨 위치(둘은 항상 왼쪽에 붙어있고 위아래로 놓여있다.
    static int cleanDust = 0;
    static boolean[] avail = new boolean[4];// 0:우 1:상 2: 3:하 반시계
    static final int[] dr = {0,-1,0,1};
    static final int[] dc = {1,0,-1,0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int airConNum = 0;
        int totalDust = 0;
        for(int r = 0;r<R;r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0;c<C;c++){
                int now = Integer.parseInt(st.nextToken());
                room[r][c] = now;
                if(now != -1) totalDust += now;
                else{
                    if(airConNum == 0){
                        airR0 = r;
                        airR1 = r+1;
                        airConNum++;
                    }
                }
            }
        }
        for(int t = 0;t<T;t++){
            for(int r = 0;r<R;r++){
                for(int c = 0;c<C;c++){
                    if(room[r][c] > 0)spread(r,c);//먼지가 퍼짐
                }
            }
            for(int r = 0;r<R;r++){
                for(int c = 0;c<C;c++){
                    if(room[r][c] == -1)continue;//공기청정기면 스킵
                    room[r][c] += afterSpread[r][c];//퍼지는 것은 동시에 일어나는 현상이라 다른 칸의 확산은 이번 칸에 영향을 주면 안된다.
                    afterSpread[r][c] = 0;
                }
            }//바람이 쓸고 지나감.
            upperWind();//위쪽 처리
            lowerWind();//아래쪽 처리
        }
        System.out.println(totalDust-cleanDust);
    }
    //퍼질 수 있는 곳을 체크
    public static void availCheck(int r, int c){
        if(r == 0){
            avail[1] = false;
            avail[3] = true;
        }else if(r == R-1){
            avail[1] = true;
            avail[3] = false;
        }else{
            avail[1] = true;
            avail[3] = true;
        }
        if(c == 0){
            avail[0] = true;
            avail[2] = false;
        }else if(c == C-1){
            avail[0] = false;
            avail[2] = true;
        }else{
            avail[0] = true;
            avail[2] = true;
        }
    }
    public static void spread(int r,int c){
        availCheck(r,c);
        int spreadDust = 0;
        for(int i = 0;i<4;i++){
            if(avail[i]==true){
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(room[nr][nc]==-1) continue;
                afterSpread[nr][nc] += room[r][c]/5;
                spreadDust += room[r][c]/5;
            }
        }
        room[r][c] -= spreadDust;
    }
    public static void upperWind(){
        for(int r = airR0-1;r>-1;r--){
            if(r == airR0-1) cleanDust += room[r][0];
            else room[r+1][0] = room[r][0];
        }
        for(int c = 1;c<C;c++) room[0][c-1] = room[0][c];
        for(int r = 0; r<airR0;r++) room[r][C-1] = room[r+1][C-1];
        for(int c = C-1;c>1;c--) room[airR0][c] = room[airR0][c-1];
        room[airR0][1] = 0;
    }
    public static void lowerWind(){
        for(int r = airR1+1;r<R;r++){
            if(r == airR1+1) cleanDust += room[r][0];
            else room[r-1][0] = room[r][0];
        }
        for(int c = 0;c<C-1;c++) room[R-1][c] = room[R-1][c+1];
        for(int r = R-1; r>airR1;r--) room[r][C-1] = room[r-1][C-1];
        for(int c = C-1;c>1;c--) room[airR1][c] = room[airR1][c-1];
        room[airR1][1] = 0;
    }
}
