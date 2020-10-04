package com.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class distinctValues {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(line[i]);
        }
        distinctValues(arr);
    }

    public static void distinctValues(long[] arr){
        Set<Long> set = new HashSet<>();
        for (Long ele : arr) {
            set.add(ele);
        }
        System.out.println(arr.length - set.size());
    }
}
