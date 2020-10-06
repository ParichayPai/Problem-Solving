package com.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sumOfOddSubArrays {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        System.out.println(sumOddLengthSubArrays(arr));
    }

    public static int sumOddLengthSubArrays(int[] arr) {

        int sum = 0;
        // n3 approach
//        for(int subArrSize = 1; subArrSize <= arr.length; subArrSize+=2){
//
//            for(int j = subArrSize-1; j < arr.length; j++){
//
//                for(int k = j; k > j - subArrSize; k--){
//                    sum += arr[k];
//                }
//            }
//        }
        int[] preSum = new int[arr.length];
        preSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            preSum[i] = arr[i] + preSum[i-1];
        }

         for(int i = 0; i < arr.length; i++){
             for(int j = i; j < i+j; j++){
                 System.out.println(sum+" "+i+" "+j);
                 sum += preSum[j] - preSum[i-1];
             }
         }

        return sum;
    }
//
// [1,5,7,12,15]

// for(int i = 1; i < arr.length; i++){
    // for(int j = i; j < i+j; j++){
    //     sum += returnSum(i,j,prefixArray)
    // }
// }


    // |

    // sum = prefix[j] - prefix[i-1];

}
