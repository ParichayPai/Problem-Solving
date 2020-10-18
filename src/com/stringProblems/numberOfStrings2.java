package com.stringProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class numberOfStrings2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();
        //p26 - ((2 * (p25 - p24)) % mod) - p24
        BigInteger p26 = BigInteger.valueOf(26).pow(n.intValue()).mod(BigInteger.valueOf(1000000007));
        BigInteger p25 = BigInteger.valueOf(25).pow(n.intValue()).mod(BigInteger.valueOf(1000000007));
        BigInteger p24 = BigInteger.valueOf(24).pow(n.intValue()).mod(BigInteger.valueOf(1000000007));
        BigInteger answer = (p26.subtract((p25.subtract(p24)).multiply(BigInteger.valueOf(2)).mod(BigInteger.valueOf(1000000007))).subtract(p24)).mod(BigInteger.valueOf(1000000007));
        System.out.println(answer);
    }
}
