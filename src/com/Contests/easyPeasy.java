package com.Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class easyPeasy {
    public static void easypeasy(int[] arr){
        boolean even = false, odd = false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%2==0){
                even = true;
            }else{
                odd = true;
            }

            if(odd && even){
                Arrays.sort(arr);
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
//        int temp;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i; j < arr.length; j++) {
//                if((arr[i]+arr[j])%2==1 && (arr[i] > arr[j]) && i!=j){
//                    temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        easypeasy(arr);
    }
}
