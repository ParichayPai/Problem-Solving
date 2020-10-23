package com.recursion;

/*
Find number of ways an integer N can be represented as a sum of unique natural numbers.
Input
First line contain an integer T denoting number of test cases. Each test case contains a single integer N.

Constraint:-
1 <= T <= 100
0 <= N <= 120
Output
Print a single integer containing number of ways.
Sample input
4
6
1
4
2

Sample output:-
4
1
2
1

Explanation:-
TestCase1:-
6 can be represented as (1, 2, 3), (1, 5), (2, 4), (6)
 */

import java.util.Scanner;

public class numberOfWays {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            System.out.println(getNumberOfWays(n , 1));
        }
    }
    public static int getNumberOfWays(int num, int i){
        int remaining = num - i;
        if (remaining == 0 ) {
            return 1;
        }
        if (remaining < 0) {
            return 0;
        }
        else{
            return (getNumberOfWays(remaining,i+1)+getNumberOfWays(num,i+1));
        }
    }
}
