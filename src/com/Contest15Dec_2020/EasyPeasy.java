package com.Contest15Dec_2020;

import java.util.Arrays;
import java.util.Scanner;

public class EasyPeasy {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int even = 0, odd = 0;
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            if(arr[i] % 2 == 0)
                even++;
            else
                odd++;
        }
        if(odd > 0 && even > 0)
            Arrays.sort(arr);
        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
