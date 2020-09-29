package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class contestTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        String[] line2 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        long k = Long.parseLong(line1[1]);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line2[i]);
        }
        jumpJump(arr,k);
    }
    public static void jumpJump(int[] arr, long k){
        int ptr = 0;
        long countTillOne = 0;
        while(k-- > 0){
            ptr = arr[ptr]-1;
            countTillOne++;
            if(ptr==0){
                k = k % (countTillOne);
            }
        }
        System.out.println(countTillOne);
    }
}