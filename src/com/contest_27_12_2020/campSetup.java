package com.contest_27_12_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;

/*
Given N points on 2D plane, you have to setup a camp at a point such that sum of Manhattan distance all the points from that point is minimum. If there are many such points you have to find the point with minimum X coordinate and if there are many points with same X coordinate, you have to minimize Y coordinate.
Manhattan distance between points (x1, y1) and (x2, y2) = |x1 - x2| + |y1 - y2|.
Input
First line of input contains N.
Next N lines contains two space separated integers denoting the ith coordinate.

Constraints:
1 <= N <= 100000
1 <= X[i], Y[i] <= 1000000000
Note:- the camp can overlap with the given points and the given points can also overlap(you have to consider overlapping points separately).
Output
Print two space separated integers, denoting the X and Y coordinate of the camp.
Sample Input
3
3 3
1 1
3 2

Sample Output
3 2

Explanation:
Sum of distances = 1 + 3 + 0 = 4
This is the minimum distance possible.
 */

class Coordinates implements Comparable<Coordinates>{
    long x, y;
    Coordinates(long x, long y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Coordinates student2) {
        return (int) (Math.abs(this.x - student2.x) - Math.abs(this.y - student2.y));
    }
}

public class campSetup {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Coordinates[] arr = new Coordinates[n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            arr[i] = new Coordinates(Long.parseLong(line[0]), Long.parseLong(line[1]));
        }
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i].x+" "+arr[i].y);
        }

    }
}
