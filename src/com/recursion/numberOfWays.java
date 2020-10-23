package com.recursion;

import java.util.Scanner;

public class numberOfWays {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            System.out.println(getNumberOfWays(n , 1));
        }
    }
    public static int getNumberOfWays(int num, int i){
        int remaining = num - i;
        if (remaining == 0 ) {
            return 1;
        }
        if (remaining < 0) {
            return 0;
        }
        else{
            return (getNumberOfWays(remaining,i+1)+getNumberOfWays(num,i+1));
        }
    }
}
