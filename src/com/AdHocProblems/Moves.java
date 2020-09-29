package com.AdHocProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Moves {

//    public static void isBeneficial()

    public static double distance(long x1, long y1, long x2, long y2){
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }

    public static long[][] shipMoves(String s){
        long[] xMoves = new long[s.length()];
        long[] yMoves = new long[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c){
                case 'A':
                    xMoves[i] = 0;
                    yMoves[i] = 1;
                    break;
                case 'B':
                    xMoves[i] = 0;
                    yMoves[i] = -1;
                    break;
                case 'C':
                    xMoves[i] = -1;
                    yMoves[i] = 0;
                    break;
                case 'D':
                    xMoves[i] = 1;
                    yMoves[i] = 0;
                    break;
                case 'E':
                    xMoves[i] = 1;
                    yMoves[i] = 1;
                    break;
                case 'F':
                    xMoves[i] = -1;
                    yMoves[i] = -1;
                    break;
                case 'G':
                    xMoves[i] = -1;
                    yMoves[i] = 1;
                    break;
                case 'H':
                    xMoves[i] = 1;
                    yMoves[i] = -1;
                    break;
            }
        }
        return new long[][]{xMoves, yMoves};
    }

    public static void moves(long xOrigin, long yOrigin, long x2, long y2, int size, String s){
        long[][] shipMovements = shipMoves(s);
//        System.out.println(distance(xOrigin, yOrigin, x2, y2));
//        System.out.println(distance(xResultant, yResultant, x2, y2));
        int i = 0;
        long xMinutes = 0, yMinutes = 0, xCurrent = 0, yCurrent = 0, xShip = xOrigin, yShip = yOrigin;
        List<Integer> xm = new ArrayList<>();
        List<Integer> ym = new ArrayList<>();
        while (true){
            if(xCurrent < x2){
                if(Math.abs(x2 - (xCurrent + shipMovements[0][i%s.length()])) < Math.abs(x2-xCurrent)){
                    xm.add(2);
                    xCurrent += 2;
                }else if (Math.abs(x2 - (xCurrent + shipMovements[0][i%s.length()])) == Math.abs(x2-xCurrent)){
                    xm.add(1);
                    xCurrent++;
                }else{
                    xm.add(0);
                }
                xMinutes++;
            }

//            if (xCurrent >= x2)
//                xm.add(0);

            if(yCurrent < y2){
                if(Math.abs(y2 - (yCurrent + shipMovements[1][i%s.length()])) < Math.abs(y2-yCurrent)){
                    ym.add(2);
                    yCurrent += 2;
                }else if (Math.abs(y2 - (yCurrent + shipMovements[1][i%s.length()])) == Math.abs(y2-yCurrent)){
                    ym.add(1);
                    yCurrent++;
                }else{
                    ym.add(0);
                }
                yMinutes++;
            }



            if(xCurrent >= x2 && yCurrent >= y2)
                break;
            xShip += shipMovements[0][i++%s.length()];
            yShip += shipMovements[1][i++%s.length()];
            if(xShip==x2 && yShip==y2)
                break;
        }
//        System.out.println(xm);
//        System.out.println(ym);
        System.out.println(Math.max(xMinutes, yMinutes));
        System.out.println(xMinutes+" "+yMinutes);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        String[] line2 = br.readLine().split(" ");
        long x1 = Long.parseLong(line1[0]);
        long y1 = Long.parseLong(line1[1]);
        long x2 = Long.parseLong(line2[0]);
        long y2 = Long.parseLong(line2[1]);
        int size = Integer.parseInt(br.readLine());
        String s = br.readLine();
        if(check(x1,y1,x2,y2,s))
            moves(x1, y1, x2, y2, size, s);
        else
            System.out.println("-1");
    }

    public static boolean check(long x1, long y1, long x2, long y2, String s){
        long[] x = new long[s.length()];
        long[] y = new long[s.length()];
        long[][] shipMovements = shipMoves(s);
        for (int i = 0; i < s.length(); i++) {
            if(x1 < x2){
                if((x2 - (x1 + shipMovements[0][i%s.length()])) < (x2-x1)){
                    x[i] = 2;
                    x1 += 2;
                }else if ((x2 - (x1 + shipMovements[0][i%s.length()])) == (x2-x1)){
                    x[i] = 1;
                    x1++;
                }else{
                    x[i] = 0;
                }
            }
            if(y1 < y2){
                if((y2 - (y1 + shipMovements[1][i%s.length()])) < (y2-y1)){
                    y[i] = 2;
                    y1 += 2;
                }else if ((y2 - (y1 + shipMovements[1][i%s.length()])) == (y2-y1)){
                    y[i] = 1;
                    y1++;
                }else{
                    y[i] = 0;
                }
            }
        i++;
        }
        long c1 = 0, c2 = 0;
        for (long l : x) {
            if (l != 0) {
                c1++;
            }
        }
        for (long l : y) {
            if (l != 0) {
                c2++;
            }
        }
        return c1 != 0 || c2 != 0;
    }
    // 846127
    // 730068
}
/*
if c == A, then the infinite boat moves from (x, y) to (x, y+1);
if c == B, then the infinite boat moves from (x, y) to (x, y−1);
if c == C, then the infinite boat moves from (x, y) to (x−1, y);
if c == D, then the infinite boat moves from (x, y) to (x+1, y);
if c == E, then the infinite boat moves from (x, y) to (x+1, y+1);
if c == F, then the infinite boat moves from (x, y) to (x-1, y−1);
if c == G, then the infinite boat moves from (x, y) to (x−1, y+1);
if c== H, then the infinite boat moves from (x, y) to (x+1, y-1);

Ram can move your small boat in any of directions in pool but in one minute you can move only one step in either of 8 directions shown above. Your resultant movement will be sum of movements of smaller and bigger boat.
Given starting positions (x1, x2) and final position (y1, y2) calculate minimum minutes to reach at final position.

0 0
0 1
1
B

-1
----------------------------
0 0
0 4
3
AAA

2
 */
