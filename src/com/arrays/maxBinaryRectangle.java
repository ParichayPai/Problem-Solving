package com.arrays;
    /*
Given a binary matrix, your task is to calculate the maximum area of rectangle formed by only 1's in it.
Input
First line contains two integers number of rows N and number of columns M.
Next N lines contain M integers with each integer being either 0 or 1

Constraints:-
1 <= N, M <=1000
Output
Print the maximum area of rectangle.
Example
Sample Input 1:4 4 0 1 1 0 1 1 1 1 1 1 1 1 1 1 0 0 Sample Output 1:8*/
// Observations
// use area under a histogram concept for every row(maintain a 1d array of column size)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class maxBinaryRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] l = br.readLine().split(" ");
        int n = Integer.parseInt(l[0]);
        int m = Integer.parseInt(l[1]);
        int[][] matrix = new int[n][m];
        int area = 0;

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(i == 0) {
                    area = max_area(matrix[0], m);
                    break;
                }
                else if(matrix[i][j]==1)
                    matrix[i][j] += matrix[i-1][j]; // takes the sum
            }
            // call max area for the array
            area = Math.max(area,max_area(matrix[i] , m));
        }
        System.out.println(area);
    }
    // this function calculates max area of matrix
    static int max_area(int[] arr , int m){
        int top;
        int area, max_area = 0;
        int i = 0;
        Stack<Integer> st = new Stack<>();
        while(i < m){
            //push if element of array is greater than equals stack top
            if (st.empty() || arr[st.peek()] <= arr[i]) {
                st.push(i++);
            } else {
                top = arr[st.pop()];
                // calculate area for the two cases
                // 1. if stack is empty than area will be current(height) * (i)
                // 2. if stack is not empty than area will be current(height) * (i-stackTop-1)width
                if(st.isEmpty())
                    area = top * i;
                else
                    area = top * (i - st.peek() - 1);
                // update max_area
                max_area = Math.max(area, max_area);
            }
        }
        while (!st.empty()) {
            top = arr[st.pop()];
            area = top * i;
            if (!st.empty())
                area = top * (i - st.peek() - 1);

            max_area = Math.max(area, max_area);
        }
        return max_area;
    }
}

