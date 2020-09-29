package com.MapProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinearProbing {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String[] l1 = br.readLine().split(" ");
            int hashTableSize = Integer.parseInt(l1[0]);
            int size = Integer.parseInt(l1[1]);
            long[] arr = new long[hashTableSize];
            for(int i=0;i<hashTableSize;i++)
                arr[i] = -1;
            String[] line = br.readLine().split(" ");
            int counter = 0;
            for (String s : line) {
                if (counter == hashTableSize)
                    break;
                long ele = Long.parseLong(s);
                int ptr = (int) (ele) % hashTableSize;
                while (arr[ptr] != -1 && counter < hashTableSize)
                    ptr = (ptr + 1) % hashTableSize;
                arr[ptr] = ele;
                counter++;
            }
            for(int i=0;i<hashTableSize;i++){
                System.out.print(arr[i] +" ");
            }
            System.out.println();
        }
    }
}
