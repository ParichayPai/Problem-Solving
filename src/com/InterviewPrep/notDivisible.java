package com.InterviewPrep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class notDivisible {
    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().trim().split(" ");
        int n = Integer.parseInt(line1[0]);
        int k = Integer.parseInt(line1[1]);
        String[] line2 = br.readLine().trim().split(" ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(line2[i]);
        }
        System.out.println(findSubArrayLength(arr,n,k));
    }

    private static int findSubArrayLength(int[] arr, int n, int k) {
        long sum = 0;
        int left = -1;
        int right = 0;
        for(int i=0;i<n;i++){
            if(arr[i]%k != 0 ){
                if(left == -1){
                    left = i;
                }
                right = i;
            }
            sum += arr[i];
        }
        if(sum % k != 0){
            return n;
        }
        else if(left == -1){
            return -1;
        }
        else{
            int length1 = left +1;
            int length2 = n - right;
            return n- Math.min(length1,length2);
        }
    }
}
