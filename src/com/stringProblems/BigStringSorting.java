package com.stringProblems;

/*
Consider an array of numeric strings where each string is a positive number
(number of digits in the number can be from 1 to 1000000). Sort the array's
elements in non-decreasing, or ascending order of their integer values and
print each element of the sorted array on a new line.

Each string is guaranteed to represent a positive integer without leading zeros.
Input
The first line contains an integer n, denoting the number of strings in unsorted.
Each of the n subsequent lines contains a number string (unsorted[i]).

Constraints:-
1<=n<=2*10^4

The total number of digits across all strings is between 1 and 10^6 (inclusive).
Output
Print each element of the sorted array on a new line.

Input:
6
31415926535897932384626433832795
1
3
10
3
5

Output:
1
3
3
5
10
31415926535897932384626433832795
 */


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BigStringSorting {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] arr = new String[t];
        for(int i=0;i<t;++i){
            arr[i] = sc.next();
        }
        Arrays.sort(arr,new Comparator<String>(){ // Can be written with lambda (s1, s2) -> {}
            public int compare(String s1, String s2){
                if(s1.length()!=s2.length()){
                    return s1.length()-s2.length();
                }
                for(int i=0;i<s1.length();i++){
                    if(s1.charAt(i)!=s2.charAt(i))
                        return s1.charAt(i)-s2.charAt(i);
                }
                return 0;
            }
        });
        for(int i = 0; i < t; ++i){
            System.out.println(arr[i]);
        }
    }
}
