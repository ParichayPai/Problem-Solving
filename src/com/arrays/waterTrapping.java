package com.arrays;

/*
Given n non-negative integers representing an elevation map where the width
of each bar is 1, compute volume of water it is able to trap after raining.
Please refer to Sample test case for more details.

Input
The first line of input contains the size of the array, n
The following line of input contains n space-separated integers

Constraints:-
1 <= n <= 50000
0<=A[i]<=1010
Output
The first and only line of output contains integer, in accordance to the task.
Example

Sample Input:
6
3 0 0 2 0 4
Sample Output:
10
 */

import java.util.Scanner;

public class waterTrapping {
    public static void printWaterTrapped(long[] heights, int n){
        long[] leftMax = new long[n];
        leftMax[0] = heights[0];
        for(int i=1;i<n;i++)
            leftMax[i] = Math.max(leftMax[i-1],heights[i]);

        long[] rightMax = new long[n];
        rightMax[n-1] = heights[n-1];
        for(int i=n-2;i>=0;i--)
            rightMax[i] = Math.max(rightMax[i+1],heights[i]);

        long totalWater = 0, currentWater=0, volume=0;
        for(int i=1;i<n;i++){
            volume = Math.min(leftMax[i], rightMax[i]);
            currentWater = volume - heights[i];
            totalWater += currentWater;
        }
        System.out.print(totalWater);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] heights = new long[n];
        for(int i=0;i<n;i++)
            heights[i] = sc.nextLong();
        printWaterTrapped(heights, n);
    }
}
