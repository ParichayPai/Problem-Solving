package com.Contest15Dec_2020;

import java.util.Scanner;

public class CoolestHottest {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextLong();
        }
        long currentMin = 0;
        long currentMax = 0;
        long minVal = 1000000000;
        long maxVal = -1000000000;
        for(int  i = 0; i < n; i++){
            currentMin += arr[i];
            currentMax += arr[i];
            maxVal = Math.max(maxVal, currentMax);
            minVal = Math.min(minVal, currentMin);
            if(currentMin > 0)
                currentMin = 0;
            if(currentMax < 0)
                currentMax = 0;
        }
        System.out.println((long)Math.abs(maxVal - minVal));
    }
}
