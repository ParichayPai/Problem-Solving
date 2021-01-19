package com.HeapPriorityQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class kthSmallestNumber {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
//        while(t-- > 0) {
//            String[] line1 = br.readLine().split(" ");
//            int n = Integer.parseInt(line1[0]);
//            int k = Integer.parseInt(line1[1]);
//            String[] line2 = br.readLine().split(" ");
//            System.out.println(getKthSmallestNumber(line2, n, k));
//        }
//    }
//
//    private static long getKthSmallestNumber(String[] arr, int n, int k) {
//        PriorityQueue<Long> pq = new PriorityQueue<>();
//        for (int i = 0; i < n; i++) {
//            long no = Long.parseLong(arr[i]);
//            if(!pq.contains(no))
//                pq.add(no);
//        }
//        for (int i = 0; i < k-1; i++) {
//            pq.remove();
//        }
//        if(!(pq.size() >= 1))
//            return pq.remove();
//        else
//            return -1;
//    }
    public static int findKthSmallest(List<Integer> A, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(A.subList(0, k));

        for (int i = k; i < A.size(); i++) {
            if (A.get(i) < pq.peek()) {
                pq.poll();
                pq.add(A.get(i));
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String[] line1 = br.readLine().split(" ");
            int n = Integer.parseInt(line1[0]);
            int k = Integer.parseInt(line1[1]);
            String[] line2 = br.readLine().split(" ");
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(Integer.parseInt(line2[i]));
            }
            System.out.println(findKthSmallest(arr, k));
        }
    }
}
