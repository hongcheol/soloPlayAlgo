package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1963_prime_search {
    static boolean[] m = new boolean[10001];
    static List<Integer> tempList = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for(int t = 0;t<testcase;t++)
        {
            initMArray();
            String[] inputString = br.readLine().split(" ");

            int[] input = new int[2];
            input[0] = Integer.parseInt(inputString[0]);
            input[1] = Integer.parseInt(inputString[1]);
            if(input[0]==input[1]) {
                System.out.println(0);
                continue;
            }
            List<Integer> queue = new LinkedList<Integer>();
            queue.add(input[0]);
            int now = input[0];
            int count = 1;
            boolean isFind = false;
            tempList.clear();
            while(!queue.isEmpty()){
                now = queue.get(0);
                //System.out.println(now);
                queue.remove(0);
                m[now] = true;
                //현재 꺼낸 것에서 가능한 애들 다 집어넣
                for(int i = 0;i<4;i++){
                    for(int j = 0;j<10;j++){
                        if(i == 0 && j == 0) continue;//첫자리 0되는거 막음
                        int next = numChange(now,i,j);
                        if(next == input[1]) {
                            isFind = true;
                            break;
                        } else if(m[next]) continue;
                        else tempList.add(next);
                    }
                    if(isFind) break;
                }
                if(isFind) break;
                if(queue.isEmpty() && !tempList.isEmpty()) {
                    for(int i = 0;i<tempList.size();i++){
                        queue.add(tempList.get(i));
                    }
                    tempList.clear();
                    count++;
                }

            }
            System.out.println(count);
        }
    }
    static void initMArray() {
        Arrays.fill(m,false);
        m[0] = true;//true -> not prime
        m[1] = true;
        for (int i = 2; i < 10001; i++) {
            if (!m[i]) {
                for (int j = 2 * i; j < 10001; j += i) {
                    m[j] = true;
                }
            }
        }
    }
    static int numChange(int n,int digit, int change){
        String temp = Integer.toString(n);
        String result = temp.substring(0,digit) + change + temp.substring(digit+1);
        //System.out.println("result = " + result);
        return Integer.parseInt(result);
    }
}
