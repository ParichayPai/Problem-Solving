package com.Sorts;

import java.util.Scanner;

class InsertionSort{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int k = 0; k < n; k++){
            int m = sc.nextInt();
            int[] arr = new int[m];
            for(int i = 0; i < m; i++)
                arr[i] = sc.nextInt();
            for(int i = 0; i < m; i++){
                int pivot = arr[i];
                int j= i-1;
                while(j>=0 && arr[j] > pivot){
                    arr[j+1] = arr[j];
                    j--;
                }
                arr[j+1] = pivot;
            }
            for(int i=0;i<m;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.print("\n");
        }
    }
}