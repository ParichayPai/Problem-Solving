package com.arrays;

import java.util.Scanner;

public class rgbTuples {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long count = 0;
        for (int r = 1; r < n; r++) {
            for (int g = 1; r*g <= n; g++) {
                if(r*g < n){
                    count += n - (r*g);
                }
            }
        }
        System.out.println(count);
    }
}
