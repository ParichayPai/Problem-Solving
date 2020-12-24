package com.InterviewPrep;

import java.util.Arrays;
import java.util.Scanner;

public class minimumSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if(i % 2 == 0){
                first.append(arr[i]);
            }else{
                second.append(arr[i]);
            }
        }
        System.out.println(Long.parseLong(String.valueOf(first)) + Long.parseLong(String.valueOf(second)));
    }
}
 /*
 Sample Input:-
5
5 3 0 7 4      0 3 4 5 7 

Sample Output:-
82

Explanation:-
047 + 35
  */