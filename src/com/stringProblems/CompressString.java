package com.stringProblems;

/*
We are given a string. Your task is to compress the consecutive letters
of the string

For example: given string is "AAACCCBBD", thus here
A's occurrence 3 times
C's occurrence 3 times
B's occurrence 2 times
D's occurrence 1 time
So after compressing string becomes "A3C3B2D1".
Input
The first line of input contains an integer T denoting the number of
test cases. Each test case will have a string provided in the new line.

Constraints:
1 <= T <= 10
1 <= sizeof(String) <= 10^6
All characters of String are upper case letters. (A-Z)

Sum of size of Strings over all testcases is <= 10^6
Output
For each testcase, in a new line, print the compressed string for each
test case in a new line.

Input:
2
AAACCCBBD
ABCD

Output:
A3C3B2D1
A1B1C1D1
 */

import java.util.Scanner;

public class CompressString {

    public static void compressString(String s){
        StringBuilder sb = new StringBuilder();
        char curr = s.charAt(0);
        int counter = 1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)==curr){
                counter++;
            }
            if(s.charAt(i) != curr){
                sb.append(curr).append(counter);
                curr = s.charAt(i);
                counter = 1;
            }
        }
        sb.append(curr).append(counter);
        System.out.println(sb);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- > 0){
            String s = sc.next();
            compressString(s);
        }
    }
}
