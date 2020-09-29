package com.arrays;

/*
Given two arrays of size N which have the same values but in
different orders, we need to make a second array the same as a
first array using a minimum number of swaps.

Note:- It is guaranteed that the elements of the array are unique
Input
First line of input contains the size of array N, second line of
input contains N space separated integers depicting values of
first array, third line of input contains N space separated integers
depicting values of second array.

Constraints:-
1 < = N < = 10000
1 < = Arr[i] < = 1000000000
Output
Print the minimum number of swaps required to make the second array equal to first.
Example

Sample Input:-
5
1 2 3 4 5
3 1 2 5 4

Sample Output:-
3

Sample Input:-
4
3 6 4 8
4 6 8 3

Sample Output:-
2
 */

import java.util.Scanner;

public class minSwaps {
    public static void printMinSwaps(long[] arr1, long[] arr2, int n){
        int swapCount = 0;
        for (int i = 0; i<arr1.length; i++){
            if (arr1[i]!=arr2[i]){
                int j = i;
                while(arr2[j] != arr1[i])
                    j++;
                long temp = arr2[i];
                arr2[i] = arr2[j];
                arr2[j] = temp;
                swapCount++;
            }
        }
        System.out.println(swapCount);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr1 = new long[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextLong();
        long[] arr2 = new long[n];
        for(int i=0;i<n;i++)
            arr2[i]= sc.nextLong();
        printMinSwaps(arr1, arr2, n);
    }
}
