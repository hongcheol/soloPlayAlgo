package com.algo.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D3_6808 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static final int cardNum = 9;
    static int inScore = 0, qScore = 0;
    static int inWin = 0,draw = 0,qWin = 0;
    static final int total = 362880;
    static int[] qCard,inCard,inPerm;
    public static void main(String[] args) throws IOException {
        int testcase = Integer.parseInt(br.readLine());

        for(int t = 1;t<=testcase;t++){
            qCard = new int[cardNum];
            inCard = new int[cardNum];
            inPerm = new int[cardNum];
            st = new StringTokenizer(br.readLine());
            for(int i = 0;i<9;i++){
                qCard[i]=Integer.parseInt(st.nextToken());
            }
            LP:for(int i = 1,j=0;i<=18;i++){
                for(int k = 0;k<9;k++){
                    if(i == qCard[k]){
                        continue LP;
                    }
                }
                inCard[j++] = i;
            }
            //조합을 만든다.
            int flag = 0;
            inScore = 0;
            qScore = 0;
            inWin = 0;
            qWin = 0;
            perm(0,flag);
            System.out.println("#" + t + " " + qWin +" "+ inWin);
        }
    }
    static void perm(int n,int flag){
        //System.out.println("n>>>>>>"+n+"flag>>>>>"+flag);
        if(n == cardNum){
            inScore = 0;
            qScore = 0;
            for(int i = 0;i<cardNum;i++){
                int temp = inCard[inPerm[i]]+qCard[i];
                //System.out.println("inCard = "+inCard[inPerm[i]]+"qCard = " + qCard[i]);
                if(inCard[inPerm[i]]>qCard[i]) inScore += temp;
                else qScore += temp;
            }
            if(inScore>qScore)inWin++;
            else if(inScore==qScore) draw++;
            else qWin++;
        }else {
            for (int i = 0; i < cardNum; i++) {
                //System.out.println("(1<<i) = " + (1<<i));
                if ((flag & (1 << i)) != 0) continue;
                //ystem.out.println("flag = " + (flag|1<<i));
                inPerm[n] = i;
                //System.out.println(inScore);
                perm(n + 1, flag | (1 << i));
            }
        }
    }
}
