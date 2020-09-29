package com.Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsThisKadane {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        long[] arr = new long[size + 1];

        for(int i = 1 ; i <= size; i++)
            arr[i] = Long.parseLong(line[i - 1]);

        long value1 = maxOfSubArray(arr,size);
        long value2 = maxOfSubArrayBreakingAtNegativeValue(arr, size);

        System.out.print(Math.max(value1, value2));
    }

    static long maxOfSubArray(long[] a , int size){
        long currSum = 0 , maxSum = 0, maxEl = 0;
        for(int i = 1 ; i <= size ; i++){
            currSum += a[i];
            if(currSum < 0)
                currSum = 0;
            if(currSum > maxSum){
                maxSum = currSum;
                maxEl = Math.max(maxEl, a[i]);
            }
        }
        return (maxSum - maxEl);
    }

    static long maxOfSubArrayBreakingAtNegativeValue(long[] a , int size){
        long currsum = 0 , maxsum = 0, maxEl = 0, maxofall = 0;
        for(int i = 1 ; i <= size ; i++){
            maxEl = Math.max(maxEl, a[i]);
            currsum += a[i];

            if(currsum - maxEl < 0){
                currsum = 0;
                maxEl = 0;
            }
            if(currsum - maxEl > maxsum){
                maxofall = currsum - maxEl;
                maxsum = maxofall;
            }

        }
        return (maxofall);
    }
}
