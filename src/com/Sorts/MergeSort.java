package com.Sorts;

// Implement Merge Sort

import java.util.Scanner;

public class MergeSort {

    public static long[] implementMergeSort(long[] arr, int start, int end){
        if(start >= end)
            return arr;
        int mid = (start+end)/2;
        implementMergeSort(arr, start, mid);
        implementMergeSort(arr, mid+1, end);
        Merge(arr, start, mid, end);
        return arr;
    }

    static void Merge(long[] arr, int start, int mid, int end){
        int sorted1size = mid - start +1;
        int sorted2size = end - mid;
        long[] sorted1 = new long[sorted1size];
        long[] sorted2 = new long[sorted2size];
        for(int i=0;i<sorted1size;i++){
            sorted1[i] = arr[start + i];
        }
        for(int i=0;i<sorted2size;i++){
            sorted2[i] = arr[mid+1 + i];
        }
        int i=0, j=0, k=start;
        while(i<sorted1size && j<sorted2size){
            if(sorted1[i] < sorted2[j]){
                arr[k++] = sorted1[i++];
            }
            else{
                arr[k++] = sorted2[j++];
            }
        }
        while (i < sorted1size)
            arr[k++] = sorted1[i++];
        while (j < sorted2size)
            arr[k++] = sorted2[j++];
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
            long[] ans = implementMergeSort(arr, 0, n);
            for (int i = 0; i < n; i++) {
                System.out.print(ans[i]+" ");
            }
            System.out.println();
        }
    }
}
