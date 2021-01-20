package com.Contests;

/*
Given a sorted array of size N and an integer K. You have to divide the given array into K non- empty subarrays such that each index of the array is in exactly one of the subarray.
Divide the array such that following value is minimised:
summation (max(i) - min(i)) for i from 1 to K
where max(i) is maximum value in the subarray i.
and min(i) is minimum value in the subarray i.
For example if we have array [1, 2, 3, 4, 5, 6] and we split it as [1, 2] [3, 4, 5] [6] then value we get will be
(2-1) + (5-3) + (6-6) = 3.
Input
The first line of the input contains two integers N and K.
The next line contain N integers.

Constraints
1 <= K <= N <= 100000
1 <= Arr[i] <= 10^9
Output
Print the minimum value you can obtain after dividing the array.
Sample Input
6 3
4 8 15 16 23 42

Sample Output
12

Explanation: we split the array as [4, 8, 15, 16], [23], [42]

Sample Input:-
6 3
1 2 3 4 5 6

Sample Output:-
3

Sample Input:-
5 5
1 2 3 4 5

Sample Output:-
0
 */

import java.util.Arrays;
import java.util.Scanner;

public class divideArray {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int result = getMinValue(arr, k);
        System.out.println(result);
    }

    static int getMinValue(int[] arr, int k){

        int[] tempArr = new int[arr.length-1];

        for(int i = 1; i < arr.length; i++){
            tempArr[i-1] = arr[i-1] - arr[i];
        }
        Arrays.sort(tempArr);

        int result = arr[arr.length-1] - arr[0];

        for(int i = 0; i < k-1; i++){
            result += tempArr[i];
        }

        return result;
    }
}
