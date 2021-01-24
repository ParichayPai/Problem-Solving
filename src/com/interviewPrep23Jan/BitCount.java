package com.interviewPrep23Jan;

import java.util.Scanner;

public class BitCount {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long count = 0, j = 1;
        for(int i = 0; i < 63; i++){
            if((n & (j<<i)) > 0)
                count++;
        }
        System.out.println(count);
    }
}
