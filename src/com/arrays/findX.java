package com.arrays;

/*
Given an integer N, your task is to find the maximum value of X such that sum of some X consecutive natural numbers is N.
Input
Input contains a single integer N.

Constraints:-
1 <= N <= 1000000000
Output
Print the maximum value of X such that sum of some X consecutive natural numbers is N.
Sample Input:-
5

Sample Output:-
2

Explanation:-
2 + 3 = 5

Sample Input:-
50

Sample Output:-
5

Explanation:-
8 + 9 + 10 + 11 + 12 = 50
 */

import java.util.Scanner;

public class findX {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i = 1; i <= num; i++){
            int currSum = 0;
            for(int j = i; j <= num; j++){
                currSum = currSum + j;
                if(currSum == num){
                    System.out.print(j - i + 1);
                    break;
                }
                if(currSum > num)
                    break;
            }
            if(currSum == num)
                break;
        }
    }
}
