package com.Contests;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCircle {
    /*
    Basic idea is that when we put an ele in the circle
    we look left n right n choose min. In order to maximize
    we choose positions such that on both the sides there are
    great elements i.e. sort the array, choose initial happiness
    as greatest ele, then choose the next elements each twice
    until count(n) is over.
     */
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long size = sc.nextLong();
        long[] smartness = new long[(int)size];
        for(int i = 0 ; i < size ; i++ )
            smartness[i] = sc.nextLong();
        Arrays.sort(smartness);
        long happiness = smartness[(int)size-1];
        int j = 0,temp = 1;
        for(int i = 0; i < size-2; i++){
            if(temp==2){
                temp = 0;
                j++;
            }
            happiness += smartness[(int)size-2-j];
            // System.out.println(happiness);
            temp++;
        }
        System.out.print(happiness);
    }
}
