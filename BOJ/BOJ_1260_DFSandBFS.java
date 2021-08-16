//package com.algo.java.BOJ;
//import java.util.*;
//public class BOJ_1260_DFSandBFS {
//    public static void main(String args[]) throws Exception{
//        Map<Integer, ArrayList<Integer>> graph = new TreeMap<Integer, ArrayList<Integer>>();
//        int n = 0, m = 0, v= 0;
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        m = sc.nextInt();
//        v = sc.nextInt();//이렇게 하면 한 줄에 입력한거 다 받을 수 있다는거 까먹어서 구글링했음.
//
//        for(int i = 0;i<n;i++){
//            graph.put(i+1,new ArrayList<>());
//        }//초기화 해줘야지 아래의 반복문에서 nullPointException 발생하지않는다.
//        for(int i = 0;i<m;i++){
//            int n1 = 0, v1 = 0;
//            n1 = sc.nextInt();
//            v1 = sc.nextInt();
//            graph.get(n1).add(v1);
//            graph.get(v1).add(n1);//그냥 이렇게하면 되는데 추가한거 그래프에 다시 넣으려는 삽질함.
//        }
//        for(int i = 0;i<n;i++) {
//            if(graph.get(i+1).isEmpty()==false) {
//                Collections.sort(graph.get(i+1));
//                Collections.reverse(graph.get(i+1));
//            }
//        }
//        dfs(graph,v);
//        System.out.println();
//        for(int i = 0;i<n;i++) {
//            if(!graph.get(i+1).isEmpty()) {
//                Collections.reverse(graph.get(i+1));
//            }
//        }
//        bfs(graph,v);
//
//    }
//
//    static void bfs(Map graph,int start_node){
//        Queue<Integer> need_visit = new LinkedList<>();
//        Queue<Integer> visited = new LinkedList<>();
//        need_visit.add(start_node);
//
//        while(need_visit.isEmpty()==false){
//            int node = need_visit.poll();
//            if(!visited.contains(node)){
//                visited.add(node);
//                ArrayList<Integer> temp = (ArrayList<Integer>) graph.get(node);
//                for(int data : temp) need_visit.add(data);
//            }
//        }
//        for(int data : visited)System.out.print(data+" ");
//    }
//    public void dfs(int start) {
//        boolean[] isVisited = new boolean[adjVertices.size()];
//        dfsRecursive(start, isVisited);
//    }
//    void dfsRecursive(int current, boolean[] isVisited) {
//        isVisited[current] = true;
//        visit(current);
//        for (int dest : adjVertices.get(current)) {
//            if (!isVisited[dest])
//                dfsRecursive(dest, isVisited);
//        }public void dfs(int start) {
//            boolean[] isVisited = new boolean[adjVertices.size()];
//            dfsRecursive(start, isVisited);
//        }
//        void dfsRecursive(int current, boolean[] isVisited) {
//            isVisited[current] = true;
//            visit(current);
//            for (int dest : adjVertices.get(current)) {
//                if (!isVisited[dest])
//                    dfsRecursive(dest, isVisited);
//            }
//        }
//        public void dfsWithoutRecursion(int start) {
//            Stack<Integer> stack = new Stack<Integer>();
//            boolean[] isVisited = new boolean[adjVertices.size()];
//            stack.push(start);
//            while (!stack.isEmpty()) {
//                int current = stack.pop();
//                isVisited[current] = true;
//                visit(current);
//                for (int dest : adjVertices.get(current)) {
//                    if (!isVisited[dest])
//                        stack.push(dest);
//                }
//            }
//        }
//    }
//    public void dfsWithoutRecursion(int start) {
//        Stack<Integer> stack = new Stack<Integer>();
//        boolean[] isVisited = new boolean[adjVertices.size()];
//        stack.push(start);
//        while (!stack.isEmpty()) {
//            int current = stack.pop();
//            isVisited[current] = true;
//            visit(current);
//            for (int dest : adjVertices.get(current)) {
//                if (!isVisited[dest])
//                    stack.push(dest);
//            }
//        }
//    }
//    static void dfs(Map graph,int startNode,boolean[] visited){
//        visited[startNode] = true;
//        Stack<Integer> need_visit = new Stack<>();
//        need_visit.push(startNode);
//
//        while(need_visit.isEmpty()==false){
//            int node = need_visit.pop();
//            if(visited[node]==false){
//                visited[node]= true;
//                ArrayList<Integer> temp = (ArrayList<Integer>) graph.get(node);
//                for(int data : temp) need_visit.push(data);
//            }
//        }
//    }
//
//
//}
//
