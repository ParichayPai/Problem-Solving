package com.Contests;

import java.util.Scanner;

public class RandomSequences {
    public static void main (String[] args) {

        int [] series = new int[10002];
        series[3] = 1;
        series[4] = 1;
        series[5] = 1;
        for(int i = 5 ; i < 10001 ; i++){
            series[i+1] = (series[i] + series[i-2])%1000000007;
        }

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n < 3){
            System.out.println("0");
        }
        else{
            System.out.println(series[n]%1000000007);
        }
    }
}
