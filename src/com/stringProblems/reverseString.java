package com.stringProblems;

import java.util.Scanner;

public class reverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] charArray = s.toCharArray();
        getReversedString(charArray);
    }
    public static void getReversedString(char[] arr){
        int l = 0, r = arr.length-1;
        while(l < r){
            while((!Character.isLetter(arr[l]) && arr[l]!='{' && arr[l]!='[')&& l<r){
                l++;
            }
            while((!Character.isLetter(arr[r]) && arr[r]!='{' && arr[r]!='[')&& l<r){
                r--;
            }
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        for (char c : arr) {
            System.out.print(c);
        }
    }
}
