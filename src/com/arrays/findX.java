package com.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class findX {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i = 1; i <= num; i++){
            int currSum = 0;
            for(int j = i; j <= num; j++){
                currSum = currSum + j;
                if(currSum == num){
                    System.out.print(j - i + 1);
                    break;
                }
                if(currSum > num)
                    break;
            }
            if(currSum == num)
                break;
        }
    }
}
