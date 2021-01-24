package com.ContestInterviewPrep12Jan;

/*
Given an undirected graph of N nodes and E edges. Edges are given in the form of x y if there is an edge between x and y. Print 1 if graph is connected else print 0.
Input
Two integers denoting N and E.
Then E lines follow, in each line two integers u, v denoting there is an edge between them.

Constraints
1<= N <=100000
0<= M <=100000
1<= u, v <=N
Output
Print 1 if graph is connected else print 0.
Input :
4 6
1 2
2 3
3 4
4 2
1 3
2 4

Output:
1
*/

import java.util.*;

public class IsItConnected {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int[] edges = new int[e+1];
        int n = sc.nextInt();
        while(n-->0){
            int u = sc.nextInt();
            int v = sc.nextInt();
            edges[u] = edges[u]+1;
            edges[v] = edges[v]+1;
        }
        boolean f = false;
        for(int i = 1; i <= e; i++){
            if(edges[i] < 1){
                f = true;
                break;
            }
        }
        int ans = f ? 0 : 1;
        System.out.println(ans);
    }
}
