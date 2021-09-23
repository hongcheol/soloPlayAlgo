package com.algo.java.BOJ;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ_9663_NQueen_ver2 {
    static int N;
    static int col[];
    static int count = 0;
    static StringBuilder sb = new StringBuilder();
    static boolean isFind = false;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        col = new int[N+1];
        setQueens(1);
        bw.write(sb.toString());
        bw.flush();
        long end = System.currentTimeMillis();
        System.out.println("수행시간: " + (end - start) + " ms");
        System.out.println(count);
    }
    static void setQueens(int rowNo){
        System.out.println("here?");
        if(rowNo>N){
            isFind = true;
            System.out.println(rowNo);
            for(int i = 1;i<rowNo;i++){
                System.out.println(i+" "+col[i]);
                sb.append(col[i]).append('\n');
            }
            return ;
        }
        System.out.println("ssibal");
        //1열부터 N열까지 놓아보기
        for(int i = 1;i<=N;i++){
            System.out.println("yogiyo");
            col[rowNo] = i;
            //정답이 될 수 있는지 확인.
            //답이 될 수 있는지 확인
            if(!validCheck(rowNo)) {
                System.out.println(">>>");
                System.out.println(rowNo);
                setQueens(rowNo+1);//될 수 있으면 다음 단계를 살펴본다.
                if(isFind) return;
            }//계속 되돌리는 작업을 할거라서 여기서 따로 처리할 필요는 없다.
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
