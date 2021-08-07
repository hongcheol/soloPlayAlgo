package com.algo.java.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_stack {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Stack<int[]> memo;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int now = 0;
        memo = new Stack<>();
        st = new StringTokenizer(br.readLine()," ");
        sb = new StringBuilder();
        int inputIdx = 0;

        while(st.hasMoreTokens()){
            int[] t = new int[2];
            inputIdx++;
            now = Integer.parseInt(st.nextToken());
            if(memo.isEmpty()){
                sb.append(0+" ");
                t[0] = inputIdx;
                t[1] = now;
                memo.push(t);
                continue;
            }
            while(!memo.isEmpty() && memo.peek()[1] <= now){
                memo.pop();
            }
            if(!memo.isEmpty()){
                sb.append(memo.peek()[0]+" ");
            }else {
                sb.append(0+" ");
            }
            t[0]=inputIdx;
            t[1]=now;
            memo.push(t);
        }
        System.out.println(sb.toString());
    }
}
