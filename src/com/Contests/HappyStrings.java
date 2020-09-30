package com.Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class HappyStrings {

    public static boolean checkValid(String s){
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if(s.charAt(i) < s.charAt(j)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void happyStrings(String[] arr){
        int count = 0;
        for (String s : arr) {
            for (String value : arr) {
                if (s.equals(value) && s.length() == 1) {
                    continue;
                }
                if (checkValid(s + value)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        int start = 0, end = n;
        long count = 0, unhappy = 0;
        for (int i = 0; i < n; i++) {
            String in = br.readLine();
            if(isHappyString(in)){
                arr[start++] = in;
                count++;
            }
            else{
                arr[--end] = in;
            }
        }
        int[] startLetter = new int[26];
        int[] endLetter = new int[26];
        unhappy = n - end;
        long track =  formPairsOfUnhappy(arr, startLetter, endLetter, end);
        System.out.println((count*(count + unhappy) + (unhappy * count)) + track);
    }

    static boolean isHappyString(String str){
        int least = (str.charAt(0) - 'a');
        for(int i = 1 ; i <str.length() ; i++){
            char ch = str.charAt(i);
            if((ch -'a') < least) {
                least = (ch -'a');
            }
            else if((ch -'a') > least)
                return true;
        }
        return false;
    }

    static long formPairsOfUnhappy(String[] arr, int[] startLetter, int[] endLetter, int end){
        long track = 0; int occur = 0;
        firstAndLastLetter(arr, startLetter, endLetter, end);
        for(int i = 0 ; i < 26 ; i++){
            occur = 0;
            for(int j = 0 ; j < i; j++){
                occur += endLetter[j];
            }
            track += startLetter[i]*occur;
        }
        return track;
    }


    static void firstAndLastLetter(String[] arr, int[] startLetter, int[] endLetter, int end){
        String temp; int len;
        for(int i = end ; i < arr.length ; i++){
            temp = arr[i]; len = arr[i].length();
            startLetter[temp.charAt(0) - 'a']++;
            endLetter[temp.charAt(len - 1) - 'a']++;
        }
    }
}
