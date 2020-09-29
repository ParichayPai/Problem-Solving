package com.SetBasedProblems;

/*
You are given an array A of size N, and you are also given a sum.
You need to find if two numbers in A exists such that their sum is
equal to the given sum. If yes, print 1, else print 0.
Input
The first line contains N denoting the size of the array A and target
sum. The second line contains N elements of the array. The third line
contains element sum.

Constraints:
1 <= N <= 100000
1 <= A[i] <= 1000000
Output
Print 1, if there is an occurrence of the sum, else print 0.

Sample Input
10 14
1 2 3 4 5 6 7 8 9 10

Sample Output
1

Explanation
10 + 4 = 14,  so pair exists

Sample Input
5 9
1 2 3 4 5

Sample Output
1

 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PairSumRevisited {
    public static void pairSumExists(int[] arr, int k){
        Set<Integer> set = new HashSet<>();
        for (int j : arr) {
            set.add(j);
            if (set.contains(k - j)) {
                System.out.println("1");
                return;
            }
        }
        System.out.println("0");
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;++i)
            arr[i] = sc.nextInt();
        pairSumExists(arr, k);
    }
}
