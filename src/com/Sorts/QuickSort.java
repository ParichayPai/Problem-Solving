package com.Sorts;

import java.util.Scanner;

public class QuickSort {

    public static long[] quickSort(long[] arr, int start, int end){
        if(start >= end)
            return arr;

        int partitionIndex = Partition(arr, start, end);
        quickSort(arr, start, partitionIndex);
        quickSort(arr, partitionIndex+1, end);
        return arr;
    }

    static int Partition(long[] arr, int start, int end){
        int i = start-1, j = end+1;
        long pivot = arr[start];
        // while(i<=j){
        // 	while(arr[i]<pivot)// && i<end)
        // 		i++;
        // 	while(arr[j]>pivot)// && j>=start)
        // 		j--;
        // 	int temp = arr[i];
        // 	arr[i] = arr[j];
        // 	arr[j] = temp;
        // }
        while(true){
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i >= j)
                break;
            long temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        long temp = arr[start];
        arr[start] = arr[j];
        arr[j] = temp;

        return j;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }
            long[] ans = quickSort(arr, 0, n);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i]+" ");
            }
            System.out.println();
        }
    }
}
