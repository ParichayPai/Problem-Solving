package com.sortProblems;

import java.util.Arrays;
import java.util.Scanner;

public class countInversionsMergeSort {

    public static int merge(int[] arr, int l, int m, int r){
        int[] left = Arrays.copyOfRange(arr, l, m + 1);
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, swaps = 0;
        while (i < left.length && j < right.length)
        {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }
        return swaps;
    }

    public static int countInversions(int[] arr, int l, int r){
        int count = 0;

        if (l < r) {
            int m = (l + r) / 2;
            count += countInversions(arr, l, m);
            count += countInversions(arr, m + 1, r);
            count += merge(arr, l, m, r);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int count = countInversions(arr,0, n-1);
        System.out.println(count);
    }
}
