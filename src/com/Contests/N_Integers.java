package com.Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_Integers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String[] line1 = br.readLine().split(" ");
        long[] arr = new long[size + 1];
        int noOfQuery = Integer.parseInt(br.readLine());

        for (int i = 1; i <= size; i++)
            arr[i] = Long.parseLong(line1[i - 1]);

        long[] prefixSum = preSum(arr, size);

        StringBuilder sb = new StringBuilder();
        while (noOfQuery-- > 0) {
            String[] query = br.readLine().split(" ");
            int low = Integer.parseInt(query[0]);
            int high = Integer.parseInt(query[1]);
            sb.append(sumForQuery(prefixSum, low, high, size)).append("\n");
        }
        System.out.println(sb);

    }

    static long[] preSum(long[] arr, int size) {
        long[] prefixSum = new long[size + 1];
        prefixSum[1] = arr[1];
        for (int i = 2; i <= size; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        return prefixSum;
    }

    static long sumForQuery(long[] prefixSum, int low, int high, int size){
        return (prefixSum[size] - (prefixSum[high] - prefixSum[low-1]))%1000000007;
    }
}
