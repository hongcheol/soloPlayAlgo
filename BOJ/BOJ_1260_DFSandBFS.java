package com.algo.java.BOJ;
import java.util.*;
public class BOJ_1260_DFSandBFS {
    public static void main(String args[]) throws Exception{
        Map<Integer, ArrayList<Integer>> graph = new TreeMap<>();
        int n = 0, m = 0, v= 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        for(int i = 0;i<n;i++){
            graph.put(i+1,new ArrayList<>());
        }
        for(int i = 0;i<m;i++){
            int n1 = 0, v1 = 0;
            n1 = sc.nextInt();
            v1 = sc.nextInt();
            graph.get(n1).add(v1);
            graph.get(v1).add(n1);
        }
        for(int i = 0;i<n;i++) {
            if(graph.get(i+1).isEmpty()==false) {
                Collections.sort(graph.get(i+1),((o1, o2) -> o2-o1));
            }
        }
        dfs(graph,v);
        System.out.println();
        for(int i = 0;i<n;i++) {
            if(!graph.get(i+1).isEmpty()) {
                Collections.reverse(graph.get(i+1));
            }
        }
        bfs(graph,v);
    }

    static void bfs(Map graph,int start_node){
        Queue<Integer> need_visit = new LinkedList<>();
        Queue<Integer> visited = new LinkedList<>();
        need_visit.add(start_node);

        while(need_visit.isEmpty()==false){
            int node = need_visit.poll();
            if(!visited.contains(node)){
                visited.add(node);
                ArrayList<Integer> temp = (ArrayList<Integer>) graph.get(node);
                for(int data : temp) need_visit.add(data);
            }
        }
        for(int data : visited)System.out.print(data+" ");
    }

    static void dfs(Map graph,int start_node){
        Stack<Integer> visited = new Stack<>();
        Stack<Integer> need_visit = new Stack<>();
        need_visit.push(start_node);

        while(need_visit.isEmpty()==false){
            int node = need_visit.pop();
            if(visited.contains(node)==false){
                visited.add(node);
                ArrayList<Integer> temp = (ArrayList<Integer>) graph.get(node);
                for(int data : temp) need_visit.push(data);
            }
        }
        for(int data : visited)System.out.print(data+" ");
    }
}

