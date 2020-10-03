package com.Contests;

import java.util.Scanner;

public class WeirdProduct {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean ans = false;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i]=sc.nextInt();
        }
        for(int i = 0 ; i < n-2 ; i++){
            if(arr[i]==arr[i+1]){
                if(arr[i]==arr[i+2]){
                    ans =true;
                    break;
                }
            }
        }
        if(ans){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
