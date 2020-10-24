package com.idkIntuition;

/*
A number is called tricky if it does not contain two adjacent 1's in its
binary representation like 5 (101) 8 (100) etc. Given an integer X, your
task is to print the smallest tricky number which is greater than or equal to X.
Input
The first line of input contains a single integer T denoting the number of test cases.
Next T lines contain a single integer, the value of X.

Constraints:-
1 <= T <= 100000
1 <= X <= 1000000000
Output
For each test case print the smallest tricky number which is greater than or equal to X.
Example
Sample Input:-
2
6
12

Sample Output:-
8
16
 */

import java.util.Scanner;

public class trickyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- > 0){
            long no = sc.nextLong();
            getTrickyNumber(no);
        }
    }
    public static void getTrickyNumber(long no){
//        while ((no & no * 2) != 0) {
//            no++;
//        }
//        System.out.println(no);
        
    }
}
