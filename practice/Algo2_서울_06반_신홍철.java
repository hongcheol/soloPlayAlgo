package com.algo.java.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 접근 전략
 * 모음을 적을 때에는 그 뒤에 p를 붙이고 그 모음을 붙여서 암호화를 진행하기 때문에
 * 이를 해독할 때에는 모음을 만났을 때, p와 추가로 붙은 해당 모음을 무시하면 됩니다.
 * 그렇기 때문에, 주어진 String을 처음부터 순회하면서 모음이 만났을 때, 2칸을 건너뛰어서 불필요한 문자를 무시하면
 * 김싸피가 작성한 원래의 문장을 구할 수 있습니다.
 * @author shinhongcheol
 *
 */
public class Algo2_서울_06반_신홍철 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//input을 받아오기위한 bufferedReader.
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        String inputString = br.readLine();//김싸피가 암호화한 문자열.
        int l = inputString.length();//김싸피가 암호화한 문자열의 길이.
        char[] decodeString = new char[l];//김싸피가 적은 원래의 문장을 저장할 배열(몇개의 모음이 있을지 모르기 때문에 암호화 문자열과 같은 길이로 만든 후 암호 해독이 끝난 후에 필요한 길이만큼만 사용)
        int decodeLength = 0;//김싸피가 적은 원래의 문장의 길이.
        int i = 0;//while문을 제어할 반복문 제어자

        while(i<l){
            char now = inputString.charAt(i);//i번째 문자가 모음인지 아닌지 확인.
            decodeString[decodeLength++] = now;//불필요한 문자는 아래의 조건문에서 건너뛰기 때문에 확인하지않는다. 따라서 현재 확인하는 문자는 김싸피가 적은 원래의 문장이기 때문에 값을 저장한다.
            if(vowelCheck(now)) {
                i += 3;//현재 확인하는 i번째 문자가 모음이면 i+1,i+2번째 문자는 불필요한 문자고 i+3번째 문자부터 다시 확인하면 된다.
            }//if - 현재 확인하는 문자가 모음이라면 그 뒤에 오는 p와 같은 모음은 원래 문장과는 무관하므로 별도의 처리를 한다.
            else {
                i++;
            }//else - 모음이 아니면 다음 문자로 넘어간다.
        }
        System.out.println(decodeToString(decodeString, decodeLength));
        br.close();//buffered reader close
    }
    /**
     * 주어진 문자가 모음인지 자음인지 확인하는 메서드.
     * @param c 모음인지 확인할 문자.
     * @return 모음이면 true, 자음이면 false
     */
    public static boolean vowelCheck(char c) {
        char[] vowel = {'a','e','i','o','u'};//모음
        for(int i = 0;i<vowel.length;i++) {
            if(c == vowel[i]) return true;//if - 주어진 문자가 모음이면 true 리턴.
        }//for - 모음을 저장한 배열을 순회하면서 같은게 있는지 확인하는 반복문 - 같은게 발견되면 true를 리턴한다.
        return false;//모음을 저장한 배열에 현재 확인하는 문자가 없다면 자음이기 때문에 false를 리턴.
    }

    /**
     * decode한 문자배열을 String으로 만들어준다.
     * @param decodingString 김싸피가 작성한 원래의 문장의 문자들을 담은 배열.
     * @param decodeLength 넘어온 배열 중에서 decodeLength까지만 유효한 데이터이고 나머지는 불필요한 데이터.
     * @return 배열을 String으로 만들어서 리턴한다.
     */
    public static String decodeToString(char[] decodingString,int decodeLength) {
        for(int i = 0;i<decodeLength;i++) {
            sb.append(decodingString[i]);
        }//for - 문자열 배열을 stringBuilder에 저장. 이때 유효한 길이(decodeLength)만큼만 저장한다.
        return sb.toString();
    }

}
