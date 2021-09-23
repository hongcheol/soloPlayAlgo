package com.algo.java.BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_9663_NQueen {
    static int N;
    static int col[];
    static boolean isFind = false;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        col = new int[N+1];
        setQueens(1);

        for(int i = 1;i<=N;i++){
            sb.append(col[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
    private static void setQueens(int rowNo){
        //답이 될 수 있는지 확인
        if(!validCheck(rowNo-1)) {
            return ;
        }//계속 되돌리는 작업을 할거라서 여기서 따로 처리할 필요는 없다.

        if(rowNo>N){
            isFind = true;
            return ;
        }
        //1열부터 N열까지 놓아보기
        for(int i = 1;i<=N;i++){
            col[rowNo] = i;
            //정답이 될 수 있는지 확인.
            setQueens(rowNo+1);//될 수 있으면 다음 단계를 살펴본다.
            if(isFind) return;
       }
    }
    private static boolean validCheck(int rowNo){//rowNo : 현재 검사하려는 퀸
        for(int k = 1;k<rowNo;k++){//k는 이전 퀸
            //이전 퀸 이전의 퀸과의 관계는 이전 퀸에서 해결했기때문에 여기서는 이전 퀸이랑만 비교한다.
            if(col[rowNo] == col[k] || Math.abs(col[rowNo] -col[k])==(rowNo-k)) return false;
        }
        return true;
    }
}
