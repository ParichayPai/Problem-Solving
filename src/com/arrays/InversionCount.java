package com.arrays;

/*
Calculate inversion count of array of integers.
Inversion count of an array is quantisation of how much unsorted
an array is. A sorted array has inversion count 0, while an unsorted
array has maximum inversion count.
Formally speaking inversion count = number of pairs i, j such that
i < j and a[i] > a[j].
Input
The first line contain integers N.
The second line of the input contains N singly spaces integers.

1 <= N <= 100000
1 <= A[i] <= 1000000000
Output
Output one integer the inversion count.

Sample Input
5
1 1 3 2 2

Sample Output
2

Sample Input
5
5 4 3 2 1

Sample Output
10
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InversionCount {
    public static long inversionCount(long[] arr, int start, int end){
        if(start > end)
            return 0;
        long count=0;
        if(start < end){
            int mid = (start+end)/2;
            count += inversionCount(arr, start, mid);
            count += inversionCount(arr, mid+1, end);
            count += Merge(arr, start, mid, end);
        }
        return count;
    }
    static long Merge(long[] arr, int start, int mid, int end){
        long[] left = Arrays.copyOfRange(arr, start, mid+1);
        long[] right = Arrays.copyOfRange(arr, mid+1, end+1);
        int i = 0, j = 0, k = start;
        long count=0;
        while(i<left.length && j<right.length){
            if(left[i]<=right[j])
                arr[k++] = left[i++];
            else{
                arr[k++] = right[j++];
                count += (mid+1) - (start+i);
            }
        }
        while(i<left.length)
            arr[k++] = left[i++];
        while(j<right.length)
            arr[k++] = right[j++];
        return count;
    }
    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        String[] str = br.readLine().split(" ");
        for(int i = 0; i < n; ++i)
            arr[i] = Long.parseLong(str[i]);
        System.out.println(inversionCount(arr,0,n-1));
    }
}
