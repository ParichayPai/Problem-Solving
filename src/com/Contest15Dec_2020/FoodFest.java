package com.Contest15Dec_2020;

import java.util.Scanner;

public class FoodFest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long P = sc.nextLong();

        int[] arr = new int[N];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
            if(arr[i] < min) {
                min = arr[i];
            }
        }

        long minTime = 1;
        long maxTime = min * P;
        long ans = 0;
        while (minTime <= maxTime){
            long midTime = minTime + (maxTime - minTime)/2;
            long countDishesT = 0;
            for (int i = 0; i < N; i++){
                countDishesT +=  midTime/arr[i];
            }
            if(countDishesT >= P){
                ans = midTime;
                maxTime = midTime - 1;
            } else {
                minTime = midTime + 1;
            }
        }
        System.out.print(ans);
    }
}
