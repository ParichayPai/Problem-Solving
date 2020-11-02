package com.Sorts;

import java.util.Scanner;

public class QuickSortRandomized {

    public static long[] quickSortRandomized(long[] arr, int start, int end){
        if(start>=end)
            return arr;
         int partitionIndex = randomizedPartition(arr, start, end);
         quickSortRandomized(arr, start, partitionIndex - 1);
         quickSortRandomized(arr, partitionIndex + 1, end);
         return arr;
    }

    static int randomizedPartition(long[] arr, int start, int end) {
       int length = end-start + 1;
       int pivotIndex = start + (int)Math.floor(Math.random()*length);

       long temp = arr[end];
       arr[end] = arr[pivotIndex];
       arr[pivotIndex] = temp;

       return Partition(arr, start, end);
    }

    static int Partition(long[] arr, int start, int end){
         long pivot = arr[end];
         int length = end - start+1;
         int partitionIndex = start;
         for(int i=0;i<length-1;++i){
               if(arr[start+i] < pivot){
                     long temp = arr[start + i];
                     arr[start+i] = arr[partitionIndex];
                     arr[partitionIndex] = temp;
                     partitionIndex++;
               }
         }
         long temp = arr[end];
         arr[end] = arr[partitionIndex];
         arr[partitionIndex] = temp;
         return partitionIndex;
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
            long[] ans = quickSortRandomized(arr, 0, n);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i]+" ");
            }
            System.out.println();
        }
    }
}
