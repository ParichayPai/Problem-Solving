package com.queueProblems;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class maxOfAllSubArrayOfSizeK {
    public static void printMaxElement(int[] arr, int n, int size){
//        for(int i=0;i<n-size+1;i++){
//            Queue<Integer> q = new LinkedList<>();
//            q.add(arr[i]);
//            for(int j=i+1;j<i+size;j++){
//                if(arr[j]>q.peek()){
//                    q.add(arr[j]);
//                    q.remove();
//                }
//            }
//            System.out.print(q.remove()+" ");
//        }
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0;i<size;i++){
//            if(deque.isEmpty() || arr[deque.getLast()] > arr[i]){
//                deque.offer(i); //add
//                continue;
//            }  // Le Code Optimization
            while(!deque.isEmpty() && arr[deque.getLast()] < arr[i]){
                deque.pollLast(); // remove
            }
            deque.offer(i);
        }
        System.out.print(arr[deque.peek()] + " ");
        for(int i=size; i<n; i++) {
            if(i-deque.peek() >= size) {
                deque.pollFirst();
            }
            while(!deque.isEmpty() && arr[deque.getLast()] < arr[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            System.out.print(arr[deque.peek()] + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int subArraySize = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        printMaxElement(arr,n,subArraySize);
    }
}
