package com.Dequeue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Given a binary matrix of size N x M. The task is to find the distance of nearest 1 in the matrix for each cell. The distance is calculated as |i1 – i2| + |j1 – j2|, where i1, j1 are the row number and column number of the current cell and i2, j2 are the row number and column number of the nearest cell having value 1.
Input
The first line contains two integers N and M, denoting the number of rows and columns of the matrix. Next N lines contain M integers either 0 or 1.

1 <= T <= 20
1 <= N, M <= 500
Each element of matrix is either 0 or 1
It is guaranteed that there is at least one 1 present in the input.
Output
Print N lines. Each line containing M integers denoting the distance from nearest 1.
Sample Input:
3 3
1 0 0
0 1 0
0 0 0

Sample Output:
0 1 2
1 0 1
2 1 2
 */

class Pair{
    int i;
    int j;
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}

public class shortestPathIn2dMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        findShortestPath(arr, n, m);
    }

    static void findShortestPath(int[][] arr, int n, int m){
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 0)
                    dist[i][j] = 1000000;
                else
                    dist[i][j] = -1;
            }
        }
        dist[0][0] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));

        while (!q.isEmpty()){
            Pair front = q.peek();
            int i = front.i;
            int j = front.j;
            checkAdj(q, i, j+1, arr, dist, n , m, i, j); // Right
            checkAdj(q, i+1, j, arr, dist, n , m, i, j); // Down
            q.remove();
            if(i == n-1 && j == n-1){
                break;
            }
        }
        System.out.println(dist[n-1][m-1]);
    }
    static void checkAdj(Queue<Pair> q, int x, int y, int[][] arr, int[][] dist, int n, int m, int i, int j){
        if(x<n && x>=0 && y>=0 && y<m && dist[x][y] == -1 && arr[x][y] != 0){
            dist[x][y] = dist[i][j] + 1;
            q.add(new Pair(x,y));
        }
    }
}
