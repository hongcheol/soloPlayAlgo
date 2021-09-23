package com.algo.java.practice.prim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrimTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] adjMatrix = new int[N][N];
        boolean[] visited = new boolean[N];
        int[] minEdge = new int[N];

        StringTokenizer st = null;
        for(int i = 0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0;j<N;j++){
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
            minEdge[i] = Integer.MAX_VALUE;
        }

        int result = 0;//최소 신장 트리 비용
        minEdge[0] = 0;//임의의 시작점 0의 간선 비용을 0으로 세팅 index는 아무거나 상관없다.
        for(int i = 0;i<N;i++){
            // 1. 신장 트리에 포함되지않은 정점 중 최소간선비용의 정점 찾기
            int min = Integer.MAX_VALUE;
            int minVertex = -1;//최소간선비용의 정점번호
            for(int j = 0;j<N;j++){
                if(!visited[j] && min>minEdge[j]){
                    min = minEdge[j];
                    minVertex = j;
                }
            }
            visited[minVertex] = true;//신장트리에 포함시킴.
            result += min;//간선비용 누적.

            //2. 선택된 정점 기준으로 신장트리에 연결되지않은 타 정점과의 간선 비용 최소로 업데이트
            for (int j = 0; j < N; j++) {
                //인접 안해있으면 인풋이 0이므로 걔가 최소가 되어버림.
                if(!visited[j] && adjMatrix[minVertex][j]!=0 && minEdge[j] > adjMatrix[minVertex][j]){
                    minEdge[j] = adjMatrix[minVertex][j];
                }
            }
        }
        System.out.println(result);
    }
}
