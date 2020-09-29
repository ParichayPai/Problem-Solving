package com.Contests;

/*
You have a house, which you model as an axis-aligned rectangle with corners at (x1, y1) and (x2, y2).
You also have a goat, which you want to tie to a fence post located at (x, y), with a rope of length
l. The goat can reach anywhere within a distance l from the fence post.
Find the largest value of l so that the goat cannot reach your house.
Input
Input consists of a single line with six space-separated integers x, y, x1, y1, x2, and y2. All the
values are guaranteed to be between −1000 and 1000 (inclusive).
It is guaranteed that x1 < y1 and x2 < y2, and that (x, y) lies strictly outside the axis-aligned
rectangle with corners at (x1, y1) and (x2, y2).
Output
Print, on one line, the maximum value of l, rounded and displayed to exactly three decimal places.
 */

import java.util.Scanner;

public class GoatTrouble {
    public static double dist(int a, int b, int c, int d){
        return Math.sqrt((a-c)*(a-c)+(b-d)*(b-d));
    }

    public static void goatTrouble(int x, int y, int x1, int y1, int x2, int y2){
        double answer, temp1, temp2;
        if(x1 <= x && x <= x2){
            answer = Math.min(Math.abs(y1 - y), Math.abs(y2 - y));
        }else if(y1 <= y && y <= y2){
            answer = Math.min(Math.abs(x1 - x), Math.abs(x2 - x));
        }else{
            temp1 = Math.min(dist(x, y, x1, y1), dist(x, y, x2, y2));
            temp2 = Math.min(dist(x, y, x1, y2), dist(x, y, x2, y1));
            answer = Math.min(temp1, temp2);
        }
        System.out.printf("%.3f\n",answer);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        goatTrouble(x, y, x1, y1, x2, y2);
    }
}
