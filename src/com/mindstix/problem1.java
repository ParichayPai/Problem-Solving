package com.mindstix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class problem1 {
    public static String encodeURL(char[] arr, int arr_len) {
        String ans = "";
        for (int i = 0; i < arr_len; i++) {
            if(arr[i] == '/') {
                ans += "%2F";
            }
            else if(arr[i] == ' ')
                ans += "%20";
            else
                ans += arr[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] arr = s.toCharArray();
//                new char[s.length()];
//        for (int i = 0; i < s.length(); i++) {
//            arr[i] = s.charAt(i);
//        }
        String ans = encodeURL(arr, arr.length);
        System.out.println(ans);
    }
}
