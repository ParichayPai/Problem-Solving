package com.Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class happyStrings {
    // public static char[] array = new char[26];
    // public static char c1 = 'a';
    // static{
    //     for(int i = 0; i < 26; i++){
    //         array[i] = (char)(c1+i);
    //     }
    //     // System.out.println(Arrays.toString(array));
    // }
    public static boolean checkValid(String s){
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if(s.charAt(i) < s.charAt(j)){
                    return true;
                }
            }
        }
        return false;
    // Set<Character> set = new LinkedHashSet<>();
    // for(int i = 0; i < s.length(); i++){
    //     // char c = ;
    //     set.add(s.charAt(i));
    // }
    // System.out.println(set);
    // Object[] arr = set.toArray();
    // for(int i = 0; i < arr.length; i++){
    //     for(int j = i+1; j < arr.length; j++){
    //         if((char)(arr[i]) < (char)(arr[j])){
    //             return true;
    //         }
    //     }
    // }

    // return false;
    }

    public static void HappyStrings(String[] arr){
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
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().trim();
        }
        HappyStrings(arr);
    }
}
