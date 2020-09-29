package com.arrays;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LCSofArray {

    public static void LCS(int[] arr, int[] arrCopy, int n){
        int[] table = new int[n];
        for (int j = 0; j < n; j++)
            table[j] = 0;
        for (int i = 0; i < n; i++) {
            int current = 0;
            for (int j = 0; j < n; j++) {
                // If both the array have same
                // elements. Note that we don't
                // break the loop here.
                if (arr[i] == arrCopy[j] && (current + 1) > table[j])
                    table[j] = current + 1;

                /* Now seek for previous smaller
                common element for current
                element of arr1 */
                if (arr[i] > arrCopy[j] && table[j] > current)
                    current = table[j];
            }
        }

        // The maximum value in table[] is out
        // result
        int result = 0;
        for (int i=0; i<n; i++)
            if (table[i] > result)
                result = table[i];

        System.out.println(result);
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] arrCopy = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            arrCopy[i] = arr[i];
        }
        LCS(arr, arrCopy, n);
    }
}
