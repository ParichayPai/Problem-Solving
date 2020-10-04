package com.stringProblems;

import java.math.BigInteger;
import java.util.Scanner;

public class NumberOfStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();
        BigInteger answer = ((BigInteger.valueOf(26).pow(n.intValue())).subtract(BigInteger.valueOf(25).pow(n.intValue())).mod(BigInteger.valueOf(1000000007)));
        System.out.println(answer);
    }
}
