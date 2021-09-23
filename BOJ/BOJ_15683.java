package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 0 0 # 0 0 0
 * 0 0 # 0 0 0
 * # # 1 # 6 0
 * 0 0 # 0 0 0
 * 1~5 CCTV
 * 6 벽
 * 일단 5번인 애들부터 다 감시시키고
 * 전체 면적에서 cctv의 개수를 뺀애들이 기본값
 * 5번으로 채운 후 4번 설정하고
 * 3들어가고
 * 할 때마다 이번 단계의 맵을 복사해서 넘겨준다.
 */
public class BOJ_15683 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R,C;
    static int[][] field;
    static int min = 100;
    //static final int[] cctvDi1 = {0,1,2,3};
    static final int[][][] cctvDir = {
            //0 상 1 하 2 좌 3 우
            null,//{{}},
            {{0},{1},{2},{3}},
            {{0,1},{2,3}},
            {{0,2},{0,3},{1,2},{1,3}},
            {{0,1,2},{0,1,3},{0,2,3},{1,2,3}},
            {{0,1,2,3}}
    };//[cctv번호][감시방향조합번호][이제 감시할 방향]
//    static final int[][] cctvDir3 = {{0,1},{1,2},{2,3},{0,3}};
//    static final int[][] cctvDir4 = {{0,1,2},{1,2,3},{2,3,0}};
//    static final int[][] cctvDir5 = {{0,1,2,3}};
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};
    static int[][][] cctvPos = new int[6][9][3];//cctv마다 할당(0번 cctv는 없다) 최대 8개 row,col,현재 번호의 cctv개수 int[x][8][2]에는 cctv갯수 카운터 값이 들어감.
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        field = new int[R][C];
        int area = R*C;
        int cctvCnt = 0;
        int cctv = 0;
        for(int i = 0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<C;j++){
                field[i][j] = Integer.parseInt(st.nextToken());
                if(field[i][j]!=0){
                    if(field[i][j] == 6) area--;//벽이면 감시가능 영역을 1 줄인다.
                    else{
                        int now = field[i][j];
                        cctv++;
                        cctvCnt = cctvPos[now][8][2];
                        cctvPos[now][cctvCnt][0] = i;
                        cctvPos[now][cctvCnt][1] = j;
                        cctvPos[now][8][2]++;
                    }//cctv면 정보 저장
                }
            }
        }//입력
        min = area;
        if(cctv==0) System.out.println(area);
        else {
            simul(field, 5, 0);
            System.out.println(min);
        }
    }
    public static void simul(int[][] arr,int i,int j){
        //5인 애부터 쭉 돌린다
        if(i == 0){
            return ;
        }
        if(cctvPos[i][8][2]==0) {
            if(i == 1) {

                return ;
            }
            simul(arr,i-1,j);
            return;
        }
        //for(int i = 5;i>0;i--){
            //반복문은  cctvPos[i][8][2]만큼만 돌린다.(cctv개수만큼만 돌린다.)
            //5번 애들 다 배
            //System.out.println("cctvPos["+i+"][8][2] = " + cctvPos[i][8][2]);
            //for(int j = 0;j<cctvPos[i][8][2];j++){
        for(int dir = 0;dir<cctvDir[i].length;dir++) {
            int[][] cpyArr = copyArr(arr);
            watch(cctvPos[i][j][0], cctvPos[i][j][1], i, dir, cpyArr);
//                    for (int[] fi : cpyArr) {
//                        System.out.println(Arrays.toString(fi));
//                    }
            int sagakJidae = sagak(cpyArr);
            if (min>sagakJidae)min = sagakJidae;
            //System.out.println("go!");
            if(j == cctvPos[i][8][2]-1)simul(cpyArr,i-1,0);
            else simul(cpyArr,i,j+1);
                    //System.out.println();
            //    }
        }
        //}
        //System.out.println("a");
    }
    public static int sagak(int[][] arr){
        int cnt = 0;
        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                if(arr[i][j] == 0)cnt++;
            }
        }
        return cnt;
    }
    public static void watch(int r,int c,int cctvNumber,int dir,int[][] arr){
        int nr , nc;
        //System.out.println(dir);
        for(int j = 0;j<cctvDir[cctvNumber][dir].length;j++) {
            nr = r;
            nc = c;
            //System.out.println("nr = " + nr+"nc = " + nc);
            while(boundCheck(nr,nc)){
                if(arr[nr][nc]==6)break;
                else if(arr[nr][nc]>0 && arr[nr][nc]<6);
                else {
//                    System.out.println("I see");
//                    System.out.println(nr+ " "+nc);
                    arr[nr][nc] = -1;//감시한 곳은 -1로.
                }
                nr += dr[cctvDir[cctvNumber][dir][j]];
                nc += dc[cctvDir[cctvNumber][dir][j]];
            }//갈 수 있는 방향 다 가본다.
//        for (int[] fi :arr){
//            System.out.println(Arrays.toString(fi));
//        }
//        System.out.println();
        }
    }
    public static int[][] copyArr(int[][] arr){
        int[][] copy = new int[R][C];
        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }
    public static boolean boundCheck(int r,int c){
        if(r>=0&&r<R&&c>=0&&c<C) return true;
        return false;
    }
}
