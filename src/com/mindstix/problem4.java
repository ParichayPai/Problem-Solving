package com.mindstix;

import java.util.Scanner;

public class problem4 {

    public static boolean isPresent(int[] arr, int arr_len, int w, int k) {
        int left = 0, right = 0, count = 0;
        while(right < arr_len){
            if(arr[right] == k || arr[left] == k){
                count++;
                left = left + w;
                right = left;
            }
            if(right - left == w){
                left = right;
            }
            right++;
        }
        return count >= arr_len / w;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr_len = sc.nextInt();
        int[] arr = new int[arr_len];
        for (int i = 0; i < arr_len; i++) {
            arr[i] = sc.nextInt();
        }
        int w = sc.nextInt();
        int k = sc.nextInt();

       if(isPresent(arr, arr_len, w, k))
           System.out.println("Yes");
       else
           System.out.println("No");
    }
}
