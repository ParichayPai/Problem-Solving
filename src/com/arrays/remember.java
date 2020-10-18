package com.arrays;

import java.util.Scanner;

public class remember {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long count = 2;
        for (long i=1; i<=Math.sqrt(n); i++) {
            if (n%i==0) {
                if (n/i == i)
                    count++;
                else
                    count+=2;
            }
        }
        System.out.println(count);
    }
}
