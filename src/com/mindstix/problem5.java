package com.mindstix;

import java.util.Scanner;

public class problem5 {
    public static void closestTriplet(int[] arr, int arr_len, int X){
        int left = 0, right = 0, index = 0;
        for (int i = arr_len - 1; i >= 0; i--) {
            left = 0;
            right = i-1;
            index = i;
            if(right < 0)
                break;
            if(left == arr_len-1)
                break;
            while(left < right){
                if(arr[i] + arr[left] + arr[right] > X){
                        right--;
                }
                if(arr[i] + arr[left] + arr[right] < X){
                        left++;
                }
                if(arr[i] + arr[left] + arr[right] == X){
                    break;
                }
            }
//            System.out.println(left+" "+right+" "+i);
            if(arr[i] + arr[left] + arr[right] == X && left != right) {
                System.out.println(arr[left]+" "+arr[i]+" "+arr[right]);
                break;
            }
        }
//       System.out.println(left+" "+right+" "+index);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        closestTriplet(arr, n, x);
    }
}
