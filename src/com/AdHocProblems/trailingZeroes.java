package com.AdHocProblems;

import java.math.BigInteger;
import java.util.Scanner;

public class trailingZeroes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger input = sc.nextBigInteger();
        BigInteger count = BigInteger.valueOf(0);
        while (input.compareTo(BigInteger.valueOf(5))>=0){
            input = input.divide(BigInteger.valueOf(5));
            count  = count.add(input);
        }
        System.out.println(count);
    }
}
