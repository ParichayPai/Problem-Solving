package com.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _chessBoard {
    static int checkMinimum(int[][] arr , int n){
        int count = 0;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-1; j++){
                if(arr[i][j]==1){
                    if(arr[i][j+1] != 0){
                        arr[i][j+1] = 0;
                        count++;
                    }
                    if(arr[i+1][j] != 0){
                        arr[i+1][j] = 0;
                        count++;
                    }
                }
                else{
                    if(arr[i][j+1] != 1){
                        arr[i][j+1] = 1;
                        count++;
                    }
                    if(arr[i+1][j] != 1){
                        arr[i+1][j] = 1;
                        count++;
                    }
                }
            }
        }
        if(arr[n-1][n-1] == arr[n-1][n-2]){
            count++;
        }

        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][] brr = new int[n][n];
        for(int i = 0; i < n; i++){
            String[] a = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(a[j]);
                brr[i][j] = arr[i][j];
            }
        }
        if(n == 1 || n == 0){
            System.out.println("0");
        }
        else{
            int count1=0, count=0;
            if (arr[0][0]==1)
                count1++;
            else
                count++;
            arr[0][0] = 1;
            count += checkMinimum(arr , n);
            brr[0][0] = 0;
            count1 += checkMinimum(brr , n);
            System.out.println(Math.min(count, count1));
        }
    }
}
