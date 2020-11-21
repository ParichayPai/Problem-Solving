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
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        while(n-- > 0){
//            long no = sc.nextLong();
//            getTrickyNumber(no);
//        }
//    }
//    public static void getTrickyNumber(long no){
        // Approach failed for a huge test case
//        while ((no & no * 2) != 0) {
//            no++;
//        }
//        System.out.println(no);
//    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            long number = sc.nextLong();
            String binaryOfNumber = Long.toBinaryString(number);
            System.out.println(findTrickyNumber(binaryOfNumber));
        }
    }

    public static long findTrickyNumber(String binaryNumber){
        if(!binaryNumber.contains("11")){
            return Long.parseLong(binaryNumber,2);
        }
        int index = binaryNumber.indexOf("11");
        StringBuilder nextNumber = new StringBuilder();
        for(int i = 0; i < index-1; i++){
            nextNumber.append(binaryNumber.charAt(i));
        }
        nextNumber.append("1");
        for(int i = index; i < binaryNumber.length(); i++){
            nextNumber.append("0");
        }
        return findTrickyNumber(nextNumber.toString());
    }
}
