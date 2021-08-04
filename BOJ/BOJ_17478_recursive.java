package com.algo.java.BOJ;

import java.io.*;

public class BOJ_17478_recursive {
    static final String START_STORY = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
    static final String QUESTION = "\"재귀함수가 뭔가요?\"\n";
    static final String FIRST_ANSWER = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
    static final String SECOND_ANSWER = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
    static final String THIRD_ANSWER = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
    static final String RETURN_ANSWER = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
    static final String END_STORY = "라고 답변하였지.\n";
    static final String TAB_STRING = "____";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(START_STORY);
        recursiveStroy(0,n,bw);
        bw.close();
    }
    static void recursiveStroy(int depth, int n,BufferedWriter bw) throws IOException {
        StringBuilder tab = new StringBuilder();
        for(int i = 0;i<depth;i++){
            tab.append(TAB_STRING);
        }
        bw.write(tab.toString());
        bw.write(QUESTION);
        if(depth == n){
            bw.write(tab.toString());
            bw.write(RETURN_ANSWER);
            bw.write(tab.toString());
            bw.write(END_STORY);
        }
        else{
            bw.write(tab.toString());
            bw.write(FIRST_ANSWER);
            bw.write(tab.toString());
            bw.write(SECOND_ANSWER);
            bw.write(tab.toString());
            bw.write(THIRD_ANSWER);
            recursiveStroy(depth+1,n,bw);
            bw.write(tab.toString());
            bw.write(END_STORY);
        }
    }
}

