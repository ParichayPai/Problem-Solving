package com.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SubArrayMinimaUsingArray {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int size = Integer.parseInt(br.readLine());
//        String[] line = br.readLine().split(" ");
//        int[] a = new int[size];
//        int arraySum = 0;
//        for(int i = 0 ; i < size ; i++){
//            a[i] = Integer.parseInt(line[i]);
//            arraySum += a[i];
//        }
//        System.out.print(arraySum +" "+ subArrayMinima(a, arraySum, size));
//    }
//    static long subArrayMinima(int[] a, int arraySum, int size){
//        long min, sum = 0;
//        for(int i = 0 ; i < size ; i++){
//            min = a[i];
////            sum += min;
//            for(int j = i + 1; j < size ; j++){
//                min = Math.min(min, a[j]);
//                sum += min;
//            }
//        }
//        return sum + arraySum;
//    }
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }
        long sum=0;
        for(int i=0;i<size;i++){
            long left = leftHigh(arr,i);
            long right = rightHigh(arr,i,size);
            long valuation = left+right+(left*right)+1;
            sum += valuation * arr[i];
        }
        System.out.print(sum);
    }
    public static long leftHigh(int arr[],int i){
        long left=0;
        for(int k=i-1;k>=0;k--){
            if (arr[k]>arr[i])
                left++;
            else if(arr[k]<=arr[i])
                break;
        }
        return left;
    }
    public static long rightHigh(int arr[],int i,int size){
        long right=0;
        for(int k=i+1;k<size;k++){
            if (arr[k]>arr[i])
                right++;
            else if(arr[k]<=arr[i])
                break;
        }
        return right;
    }
}
