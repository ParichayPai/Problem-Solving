package com.Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class kMostOccurringElements {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            int k = Integer.parseInt(br.readLine());

            int[] frequencies = new int[1000001];

            for(int i = 0; i < n; i++){
                frequencies[Integer.parseInt(line[i])]++;
            }

            Arrays.sort(frequencies);
            int sum = 0;
            for(int i = frequencies.length-1; i >= 0 && k>0; i--){
                if(frequencies[i]>0){
                    sum += frequencies[i];
                    k--;
                }
            }
            System.out.println(sum);
        }
    }
}
