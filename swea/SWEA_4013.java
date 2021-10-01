package com.algo.java.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_4013 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int jasukSu,nalSu = 8;
    static int[] dir = new int[]{-1,1};
    static boolean[] used;
    public static void main(String[] args) throws IOException {

        jasukSu = Integer.parseInt(br.readLine());
        LinkedList<Integer>[] jasuk = new LinkedList[jasukSu];
        for(int i = 0;i<jasukSu;i++) jasuk[i] = new LinkedList<>();
        int[] rotateDir = new int[jasukSu];//회전 방향 고려.
        int[] interlock = new int[jasukSu*2];//맞물린 애들만 따로 저장.
        boolean[] avail = new boolean[jasukSu];//회전 가능성 체크
        used = new boolean[jasukSu];
        int score = 0;
        for(int i = 0;i<jasukSu;i++){
            char[] input = br.readLine().toCharArray();
            for(int j = 0;j<nalSu;j++){
                jasuk[i].add(input[j]-'0');
            }
        }//입력
        int K = Integer.parseInt(br.readLine());
        for(int i = 0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());
            //회전 방향 설정
            setRotateDir(rotateDir,start,dir);
            //interlock setting
            setInterlock(jasuk,interlock);
            //회전 가능성 체크
            initAvail(avail);
            initUsed(used);
            setAvail(interlock,avail,start);
            //회전
            rotate(jasuk,avail,rotateDir);
        }
        //점수 체크
        score = getScore(jasuk);
        System.out.println(score);
    }

    private static void initUsed(boolean[] used) {
        for(int i = 0;i<jasukSu;i++){
            used[i] = false;
        }
    }

    private static void rotate(LinkedList[] jasuk, boolean[] avail, int[] rotateDir) {
        for(int i = 0;i<jasukSu;i++){
            if(avail[i]){
                if(rotateDir[i] == 1){
                    int temp = (int)jasuk[i].remove(nalSu-1);
                    jasuk[i].add(0,temp);
                }else{
                    int temp = (int)jasuk[i].remove(0);
                    jasuk[i].add(nalSu-1,temp);
                }
            }
        }
    }

    private static int getScore(LinkedList[] jasuk) {
        int score = 0;
        for(int i = 0;i<jasukSu;i++){
            if ((int)jasuk[i].get(0)==1) score++;
        }
        return score;
    }
    //이 부분은 DFS 로 구현 가능.
    private static void setAvail(int[] interlock, boolean[] avail,int start) {
        avail[start] = true;
        used[start] = true;
        for(int i = 0;i<2;i++){
            int next = start+dir[i];
            if(boundCheck(next)&&!used[next]){
                if(i==0){
                    if((interlock[next*2+1]^interlock[start*2])==1){
                        setAvail(interlock,avail,next);
                    }
                }//left
                else{
                    if((interlock[next*2]^interlock[start*2+1])==1){
                        setAvail(interlock,avail,next);
                    }
                }//right
            }
        }
    }
    private static void initAvail(boolean[] avail) {
        for(int i = 0;i<jasukSu;i++) avail[i] = false;
    }
    private static boolean boundCheck(int pos){ return (pos>=0 && pos<jasukSu);}

    private static void setInterlock(LinkedList[] jasuk, int[] interlock) {
        for(int i = 0;i<jasukSu;i++){
            interlock[i*2] = (int)jasuk[i].get((nalSu*3)/4);
            interlock[i*2+1] = (int)jasuk[i].get(nalSu/4);
        }
    }

    private static void setRotateDir(int[] rotateDir, int start, int dir) {
        for(int i = 0;i<jasukSu;i++){
            if(i%2 == start%2) rotateDir[i] = dir;
            else rotateDir[i] = -1*dir;
        }
    }
}
