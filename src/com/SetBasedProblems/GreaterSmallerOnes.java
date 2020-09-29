package com.SetBasedProblems;

/*
Given an unsorted array A of size N and value K. The elements of the array A
contains positive integers. You have to print all the elements which are
greater than K in the array in sorted order (including K as well if present
in the array A), and print all the elements which are smaller than K in sorted
order both of them in separate lines. If the elements greater than or equal to
K are not present in the array then print "-1". Similarly, in the case of smaller
elements print -1 if elements smaller than K doesn’t exist. If a number appears
more than once print number more than once.
Input
First line of input contains number of testcases T. For each testcase, there are
two lines, first of which contains N and K separated by space, next line contains
N space separated integers.


Constraints:
1 <= T <= 100
1 <= N <= 100000
1 <= K <= 1000000
1 <= A[i] <= 1000000
Sum of N over all test cases do not exceed 100000
Output
For each testcase, print the required elements(if any), else print "-1" (without quotes)
Example

Input:
1
5 1
2 1 5 7 6

Output:
1 2 5 6 7
-1

Explanation:
Testcase 1 : Since, 1, 2, 5, 6, 7 are greater or equal to given K.
Also, no element less than K is present in the array.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GreaterSmallerOnes {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        while(testcases-- > 0){
            int size = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[size];
            for(int i = 0; i < size; i++){
                arr[i] = sc.nextInt();
            }
            List<Integer> smallerList = new ArrayList<>();
            List<Integer> biggerList = new ArrayList<>();
            for(int i = 0; i < size; i++){
                if(arr[i] < k){
                    smallerList.add(arr[i]);
                }
                else{
                    biggerList.add(arr[i]);
                }
            }
            Collections.sort(biggerList);
            Collections.sort(smallerList);
            if(biggerList.isEmpty()){
                System.out.print("-1");
            }
            else{
                for(Integer i:biggerList){
                    System.out.print(i+" ");
                }
            }
            System.out.println();
            if(smallerList.isEmpty()){
                System.out.print("-1");
            }
            else{
                for(Integer i:smallerList){
                    System.out.print(i+" ");
                }
            }
            System.out.println();
        }
    }
}
