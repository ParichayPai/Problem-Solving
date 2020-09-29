package com.arrays;

/*
Given an array A of positive integers. Your task is to sort
them in such a way that the first part of the array contains
odd numbers sorted in descending order, rest portion contains
even numbers sorted in ascending order.
Input
First line of each test case contains an integer N denoting
the size of the array. The next line contains N space separated
values of the array.

1 <= N <= 100000
0 <= A[i] <= 100000
Output
Print the space separated values of the modified array.

Sample Input
7
1 2 3 5 4 7 10

Sample Output
7 5 3 1 2 4 10


Sample Input
7
0 4 5 3 7 2 1

Sample Output
7 5 3 1 0 2 4
 */

import java.util.*;

public class EvenOddSeparateSorting {

    public static List<Integer> sortEvenOdd(int[] arr, int n){
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();


        for(int i = 0; i < n; i++){
            if(arr[i]%2==0)
                even.add(arr[i]);
            else
                odd.add(arr[i]);
        }
        Collections.sort(even);
        Collections.sort(odd);

        for(int i = odd.size()-1; i >= 0; i--){
            answer.add(odd.get(i));
        }
        for(int i = odd.size()-1; i >= 0; i--){
            answer.add(even.get(i));
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        List<Integer> ans = sortEvenOdd(arr, n);
        for (Integer ele : ans) {
            System.out.print(ele);
        }
    }
}
