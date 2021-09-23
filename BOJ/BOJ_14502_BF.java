package com.algo.java.BOJ;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14502_BF {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] originLab;//최초에 입력으로 주어진 연구소 모습.
    static int R,C;//연구소 사이즈.세로, 가로 순서.
    static final int[] dr = {-1,1,0,0};
    static final int[] dc = {0,0,-1,1};
    //연구소 내의 벽 세울 수 있는 위치를 다루기 위한 클래스
    static class Loc{
        int r;
        int c;
        Loc(int r,int c){
            this.r = r;
            this.c = c;
        }
    }
    static List<Loc> virusLoc = new ArrayList<>();
    static int wallCount = 0;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        originLab = new int[R][C];
        int emptyCount = 0;
        List<Loc> availBuild = new ArrayList<Loc>();
        for(int r = 0;r<R;r++){
            st = new StringTokenizer(br.readLine());
            for (int c = 0;c<C;c++){
                originLab[r][c] = Integer.parseInt(st.nextToken());
                if(originLab[r][c] == 0) {
                    emptyCount++;
                    availBuild.add(new Loc(r,c));
                }
                if(originLab[r][c] == 2){
                    virusLoc.add(new Loc(r,c));
                }
                if(originLab[r][c] == 1){
                    wallCount++;
                }
            }
        }
        int[][] arr = new int[R][C];

        int r = 3;
        int cnt = 0;
        int[] p = new int[emptyCount];
        while(++cnt<=r) p[emptyCount-cnt] = 1;

        do {
            cnt = 0;
            setLab(arr);//연구실 초기 세팅으로
            for(int i = 0;i<emptyCount;i++){
                if(p[i]==1) {
                    Loc node = availBuild.get(i);
                    wallBuilding(node.r, node.c, arr);//벽 세우기
                    cnt++;
                    if(cnt == 3) break;
                }
            }//이번 경우의 벽을 세워본다.
            spreadVirus(arr);
        }while(np(p));
        System.out.println(max);
        br.close();
    }
    /**
     * 시행 후에 원래 상태로 연구소 상태 되돌리기.
     */
    public static void setLab(int[][] arr){
        for(int r = 0;r<R;r++){
            for(int c = 0;c<C;c++){
                arr[r][c] = originLab[r][c];
            }
        }
    }
    public static void wallBuilding(int r, int c,int[][] arr){
        arr[r][c] = 1;
    }
    //바이러스 확산
    public static int spreadVirus(int[][] arr){
        int cnt = 0;
        for(int i = 0;i<virusLoc.size();i++){
            cnt += virusCount(virusLoc.get(i),arr);
        }
        int result = (R*C-(wallCount+3)-cnt);
        if(max<result) max = result;

        return cnt;
    }
    //bfs로 바이러스 퍼진 영역 파악하기
    public static int virusCount(Loc start,int[][] arr){
        int cnt = 0;
        boolean[][] visited = new boolean[R][C];
        Queue<Loc> needVisit = new LinkedList<Loc>();
        needVisit.offer(start);
        while(!needVisit.isEmpty()){
            Loc now = needVisit.poll();
            if(!visited[now.r][now.c]) {
                visited[now.r][now.c] = true;
                arr[now.r][now.c] = 2;
                cnt++;
            }
            for(int i = 0;i<4;i++){
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if(boundCheck(nr,nc)&&!visited[nr][nc]&&arr[nr][nc]==0){
                    needVisit.offer(new Loc(nr,nc));
                }
            }
        }
        return cnt;
    }
    public static boolean boundCheck(int r, int c){
        if(r >= 0 && r < R && c >= 0 && c < C) return true;
        else return false;
    }

    private static boolean np(int[] numbers){
        int N = numbers.length;
        //step1. 꼭대기(i)를 찾는다. 꼭대기를 통해 교환위치(i-1) 찾
        int i = N-1;
        while(i>0 && numbers[i-1]>=numbers[i]){
            i--;
        }
        if(i==0)return false;

        //step2. i-1 위치값과 교환할 큰 값 찾기기
        int j = N-1;
        while(numbers[i-1]>=numbers[j])--j;//반드시 존재 없다면 꺾이지 않기 때문

        //step3. i-1위치값과 j위치값 교환
        swap(numbers,i-1,j);

        //step4. 꼭대기부터 맨뒤까지 내림차순 형태의 순열을 오름차순으로 처리
        int k = N-1;
        while(i<k){//아직 둘이 만나지않았으면
            swap(numbers,i++,k--);
        }
        return true;
    }

    private static void swap(int[] numbers,int i,int j){
        if(i>=numbers.length-1 || j<0) return ;
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
