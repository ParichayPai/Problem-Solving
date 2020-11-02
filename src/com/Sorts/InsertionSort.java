package com.Sorts;

import java.util.Arrays;
import java.util.Scanner;

class InsertionSort{
    public static void insertionSort(int[] arr, int n){
        for(int i = 0; i < n; i++){
            int pivot = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > pivot){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = pivot;
        }
        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            insertionSort(arr, n);
        }
    }
}