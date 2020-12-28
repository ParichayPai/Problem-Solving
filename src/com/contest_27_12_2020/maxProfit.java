package com.contest_27_12_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Sample Input:-
5
3 5 2 8 3

Sample Output:-
8

Explanation:-
Buy at index 1, sell at index 2, Buy at index 3, sell at index 8.

Sample Input:-
4
1 2 4 5

Sample Output:-
4
 */

public class maxProfit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(line[i]);
        }
//        long singleProfit = 0, min = 1000000000, max = 0;
//        int maxIndex = 0, minIndex = 0;
//        for (int i = 0; i < n; i++) {
//            if(arr[i] > max) {
//                max = arr[i];
//                maxIndex = i;
//            }
//        }
//        for (int i = 0; i < maxIndex; i++) {
//            if(arr[i] < min){
//                min = arr[i];
//                minIndex = i;
//            }
//        }
//
//        singleProfit = max - min;
//
//        long min1 = 1000000000, max1 = 0, secondProfit = 0;
//        int maxIndex1 = 0, minIndex1 = 0;
//        for (int i = 0; i < minIndex; i++) {
//            if(arr[i] > max1){
//                max1 = arr[i];
//                maxIndex1 = i;
//            }
//        }
//        for (int i = 0; i < maxIndex1; i++) {
//            if(arr[i] < min1){
//                min1 = arr[i];
//            }
//        }
//        secondProfit = max1 - min1;
//
//        System.out.println(singleProfit+" "+secondProfit);
//        System.out.println(Math.max(singleProfit, (secondProfit + singleProfit)));
        findMaxProfit(arr, arr.length);
    }

    public static void findMaxProfit(long[] priceList, int n) {
        long[] profit = new long[n];
        for (int i = 0; i < n; i++)            //initialize profit list with 0
            profit[i] = 0;

        long maxPrice = priceList[n-1];        //initialize with last element of price list

        for (int i = n-2; i >= 0; i--) {
            if (priceList[i] > maxPrice)
                maxPrice = priceList[i];

            profit[i] = Math.max(profit[i+1], maxPrice - priceList[i]);     //find the profit for selling in maxPrice
        }

        long minPrice = priceList[0];            //first item of priceList as minimum

        for (int i = 1; i < n; i++) {
            if (priceList[i] < minPrice)
                minPrice = priceList[i];

            profit[i] = Math.max(profit[i-1], profit[i] + (priceList[i]- minPrice) );
        }

        long result = profit[n-1];
        System.out.println(result);
    }
}
