package com.Contests;

import java.math.BigInteger;
import java.util.Scanner;

/*
Given an integer A, find the value of A + A2 + A3 +. . .+ A1000. As the answer can be large, output answer modulo 109+7.
Input
The first and the only line of input contains a single integer A.

Constraints
1 <= A <= 109
Output
Output a single integer, value of sum modulo 10^9+7.
 */

public class WeirdSum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigInteger no = sc.nextBigInteger();
        BigInteger nocopy = no;
        BigInteger sum = BigInteger.valueOf(0);
        for(int i=0;i<1000;i++){
            sum = sum.add(no);
            no = no.multiply(nocopy);
        }
        System.out.println(sum.mod(BigInteger.valueOf((int)Math.pow(10,9) + 7)) );
    }
}
