package com.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class missingInteger {
    //Approach 1 fails for huge nos
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        String[] line = br.readLine().split(" ");
//        int[] arr = new int[n];
//        long[] preSum = new long[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(line[i]);
//        }
//        for (int i = 1; i < n; i++) {
//            preSum[i] = (i*(i+1)/2);
//        }
//        System.out.println(Arrays.toString(preSum));
//        getMissingInteger(arr, preSum, n);
//    }
//    public static void getMissingInteger(int[] arr, long[] preSum, int n){
//        for (int i = 1; i <= n; i++) {
//            long currentSum = 0;
//            for (int j = 0; j < i; j++) {
//                currentSum += arr[j];
//            }
//            if(currentSum > preSum[i-1]){
//                System.out.println(0);
//            }else{
//                System.out.println(preSum[i-1]-preSum[i-2]);
//            }
//        }
//    }
    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] a = new int[size];
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        String[] line = br.readLine().split(" ");

        for(int i = 0 ; i < size ; i++)
            a[i] = Integer.parseInt(line[i]);

        for(int i = 0 ; i < size ; i++){
            if(ans == a[i]){
                set.add(a[i]);
                ans = missing(set, ans);
            }
            else{
                set.add(a[i]);
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }

    static int missing(Set<Integer> set, int j){
        for(int i = j ; i <= 200001 ; i++){
            if(!set.contains(i))
                return i;
        }
        return 0;
    }
}
