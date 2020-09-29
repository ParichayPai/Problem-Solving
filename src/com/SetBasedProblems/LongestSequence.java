package com.SetBasedProblems;

/*
Given an unsorted array of integers, find the length of the longest
consecutive elements sequence.

A consecutive set of integers is a consecutive elements sequence.

See sample for better understanding
Input
First line contains integer N number of elements of the array. Next
line contains N space separated integers which are elements of array.
Constraints
1<= N <=100000
1<= A[i] <=100000
Output
Output the longest consecutive sequence in the array.
Example

Sample Input
7
100 4 200 1 3 2 2

Sample Output
4

Explanation
The longest consecutive elements sequence is [1, 2, 3, 4].
Therefore its length is 4.
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestSequence {

    public static void longestSequence(int[] arr, int n){
        Set<Integer> set = new HashSet<>();
        int ans = 0;

        for (int i = 0; i < n; ++i)
            set.add(arr[i]);

        for (int i = 0; i < n; ++i) {
            if (!set.contains(arr[i] - 1)) {
                int j = arr[i];
                while (set.contains(j))
                    j++;
                if (ans < j - arr[i])
                    ans = j - arr[i];
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        longestSequence(arr, n);
    }
}
