package com.contest_27_12_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class playPlay {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(line[i]);
        }
        int index = 0, count = 0;
        while(arr[index] > 0){
            if(arr[index] < count) break;
            arr[index] -= count;
            count++;
            index = (index + 1) % n;
        }
        System.out.println(index+1);
    }
}
