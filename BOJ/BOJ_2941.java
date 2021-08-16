package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2941 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        char[] input = br.readLine().toCharArray();
        int cnt = 0;
        for(int i = 0;i<input.length;i++){
            if(input[i]=='='){
                if(input[i-1]=='c' || input[i-1] == 's' || input[i-1] == 'z'){
                    continue;
                }
            }else if(input[i] == '-'){
                if(input[i-1] == 'c' || input[i-1] == 'd'){
                    continue;
                }
            }else if(input[i] == 'j'){
                if(i == 0) cnt++;
                else if(input[i-1] == 'l' || input[i-1] == 'n'){
                    continue;
                }else{
                    cnt++;
                }
            }else if(input[i] == 'z'){
                if(i== 0) cnt++;
                else if(input[i-1]=='d'){
                    if(i != input.length-1){
                        if(input[i+1]=='='){
                            continue;
                        }else cnt++;
                    }else cnt++;
                }else cnt++;
            }else cnt++;
        }
        System.out.println(cnt);
    }
}
