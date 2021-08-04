package com.algo.java.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11655_string {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputString = br.readLine();
        char[] outputString = new char[inputString.length()];
        for(int i = 0;i<inputString.length();i++){
            char now = inputString.charAt(i);
            if(now>='a' && now<='z') outputString[i]=(char)(((int)now-(int)'a'+13)%26+(int)'a');
            else if(now>='A' && now<='Z') outputString[i]=(char)(((int)now-(int)'A'+13)%26+(int)'A');
            else outputString[i] = now;
        }
        for(char c:outputString) System.out.print(c);
    }
}
