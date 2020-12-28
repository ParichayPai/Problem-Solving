package com.Contest_XV;

import java.util.Scanner;

public class zeroWindow {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        char[] arr = new char[n];
        String s = sc.next();
        for (int i = 0; i < n; i++) {
            arr[i] = s.charAt(i);
        }
        int zero = 0, one = 0, totalCount = 0;
        for(int i = 0; i < k; i++){
            if(arr[i] == '0')
                zero++;
            else
                one++;
        }
        if(zero >= one)
            totalCount++;
        for(int i = k; i < n; i++){
            if(arr[i-k] == '0')
                zero--;
            else
                one--;
            if(arr[i] == '0')
                zero++;
            else
                one++;
            if(zero >= one)
                totalCount++;
        }
        System.out.println(totalCount);
    }
}
