package com.algo.java.practice.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/**
 * @author THKim
 */
public class DijkstraTest {
	static class Vertex implements Comparable<Vertex>{
		int no, distance;

		public Vertex(int no, int distance) {
			this.no = no;
			this.distance = distance;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.distance,o.distance);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		int V = Integer.parseInt(st.nextToken()); //정점 갯수
		int start = 0;
		int end =  V-1; //도착점 인덱스
		final int INFINITY = Integer.MAX_VALUE;
		
		int[][] matrix = new int[V][V];
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		
		for(int i=0; i<V; ++i){
			st = new StringTokenizer(in.readLine().trim(), " ");
			for(int j=0; j<V; ++j){
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.fill(distance, INFINITY);
		distance[start] = 0;
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		pq.offer(new Vertex(start,distance[start]));//출발지만 넣으면 이후에는 다 들어간다.
		int min=0;
		Vertex current=null;
		while(!pq.isEmpty()){
//			//a단계 : 방문하지 않은 정점들 중 최소가중치의 정점 선택
//			min = INFINITY;
//			for(int j=0; j<V; ++j){
//				if(!visited[j] && distance[j] < min){
//					min = distance[j];
//					current = j;
//				}
//			}
			current = pq.poll();

			//기존에 있던 흔적들을 지우고 집어넣은게 아니니까 업데이트 됐던 것들을 pq에서 빼줘야한다.
			if(visited[current.no])continue;

			visited[current.no] = true; // 선택 정점 방문 처리
			if(current.no == end){ // 선택 정점이 도착정점이면 탈출.
				break;
			}//출발지에서 도착지까지 구할 때만 쓴다.
			
			//b단계: current정점을 경유지로 하여 갈수 있는 다른 방문하지 않은 정점들에 대한 처리
			for(int c=0; c<V; ++c){
				if(!visited[c] && matrix[current.no][c] != 0
						&&  distance[c] > current.distance+matrix[current.no][c]){
					distance[c] = current.distance+matrix[current.no][c];
					pq.offer(new Vertex(c,distance[c]));
				}
			}
		}
		System.out.println(distance[end]);
		
	}

}
