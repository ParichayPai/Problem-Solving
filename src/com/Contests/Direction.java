package com.Contests;

import java.util.Scanner;

/*
Alice wants to go to Bob's house. The location of their houses is given on a 2-D coordinate system. There are a total of 8 directions:
North - Directly above
South - Directly below
East - To the right
West - To the left
North East - In between north and east
North West - In between north and west
South East - In between south and east
South West - In between south and west
Find the direction in which Alice must go to reach Bob's house.
Input
There are two lines of input. The first line contains the x and y coordinate of Alice's house. The second line contains x and y coordinate of Bob's house. It is given that these two locations are different.

-100 <= Coordinates <= 100
Output
Print a single string denoting the direction in which Alice must move to reach Bob's house.
 */

public class Direction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        if(x1 < x2 && y1 < y2)
            System.out.println("North East");
        if(x1 > x2 && y1 > y2)
            System.out.println("South West");
        if(x1 > x2 && y1==y2)
            System.out.println("West");
        if(x1 < x2 && y1==y2)
            System.out.println("East");
        if(x1==x2 && y1 < y2)
            System.out.println("North");
        if(x1==x2 && y1 > y2)
            System.out.println("South");
        if(x1 > x2 && y1 < y2)
            System.out.println("North West");
        if(x1 < x2 && y1 > y2)
            System.out.println("South East");
    }
}
