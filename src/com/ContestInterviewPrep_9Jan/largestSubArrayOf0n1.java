package com.ContestInterviewPrep_9Jan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Given an array of N elements containing only 0 and 1. Find the length of the largest subarray with an equal number of 0's and 1's.

This problem was asked in Amazon.
Input
Each test case contains two lines. The first line of each test case is a number N denoting the size of the array and in the next line are N space-separated values of A [].

Constraints:-
1 < = N < = 100000
Output
Print the max length of the subarray.
Sample input
4
0 1 0 1

Sample Output
4

Sample Input
5
0 0 1 0 0

Sample Output
2
 */

public class largestSubArrayOf0n1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int maxSize = -1, currentSize = -1;
        map.put(0,-1);
        for(int i = 0; i < n; i++){
            int number = sc.nextInt();
            sum += (number == 0 ? -1 : 1);
            if(map.containsKey(sum)){
                currentSize = i - map.get(sum);
                if(currentSize > maxSize)
                    maxSize = currentSize;
            } else {
                map.put(sum, i);
            }
        }
        System.out.println(maxSize);
    }
}
