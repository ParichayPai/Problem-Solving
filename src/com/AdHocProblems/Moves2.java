package com.AdHocProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Ram is on a boat which is parked on another infinitely big boat's swimming pool. Infinitely big boat is on the infinite ocean. The infinitely big boat moves on it's own schedule. It's Schedule is given in the form of character array s of length n.
If the i-th minute (starting from 1st minute, i=1),
char c=s[(i-1)%n]
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
Input
First line contains two integers x1, x2 (Starting position)
Second line contains two integers y1, y2 (Final position)
Next line contains integer n (length of s array)
Next line contains n characters which are array S.

Constraints:
0 <= x1, x2, y1, y2 <= 10^9
1 <= n <= 100000
Output
Print the minimum minutes taken to reach at final position from starting position. If it is not possible print -1.

Sample Input
0 0
0 1
1
B

Sample Output
-1

Sample Input
0 0
0 4
3
AAA

Sample Output
2

0 0
20 20
3
EEE
*/


public class Moves2 {

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
        double[] arr1 = new double[8];
        long[][] shipMovements = shipMoves(s);
        int i = 1, minutes = 0;
        long currentX = xOrigin, currentY = yOrigin, xship = xOrigin, yship = yOrigin;
        boolean flag = true;
        while(true){
//            System.out.println(minutes);
            xship += shipMovements[0][(i-1)%size];
            yship += shipMovements[1][(i-1)%size];
//            System.out.println(xship+" "+yship+" "+currentX+" "+currentY);
            double dist = distance(currentX,currentY,x2,y2) - distance(xship,yship,x2,y2);
//            System.out.println(dist);
            if(dist == -1){
                flag = false;
                break;
            }
            currentX += shipMovements[0][(i-1)%size];
            currentY += shipMovements[1][(i-1)%size];

//            double maxDist = Long.MAX_VALUE;
//            long[][] temp = new long[8][2];
//            temp[0] = new long[]{currentX + 1, currentY};
//            temp[1] = new long[]{currentX, currentY + 1};
//            temp[2] = new long[]{currentX - 1, currentY};
//            temp[3] = new long[]{currentX, currentY - 1};
//            temp[4] = new long[]{currentX + 1, currentY - 1};
//            temp[5] = new long[]{currentX - 1, currentY + 1};
//            temp[6] = new long[]{currentX + 1, currentY + 1};
//            temp[7] = new long[]{currentX - 1, currentY - 1};
//
//            long[][] newC = new long[1][2];
//            for (int j = 0; j < 8; j++) {
//                double d = distance(temp[j][0], temp[j][1], x2, y2);
//                if(maxDist > d) {
//                    maxDist = d;
//                    newC[0] = new long[]{temp[j][0], temp[j][1]};
//                }
//            }
//            currentX = newC[0][0];
//            currentY = newC[0][1];

            arr1[0] = distance(currentX+1,currentY,x2,y2);
            arr1[1] = distance(currentX,currentY+1,x2,y2);
            arr1[2] = distance(currentX-1,currentY,x2,y2);
            arr1[3] = distance(currentX,currentY-1,x2,y2);
            arr1[4] = distance(currentX+1,currentY-1,x2,y2);
            arr1[5] = distance(currentX-1,currentY+1,x2,y2);
            arr1[6] = distance(currentX+1,currentY+1,x2,y2);
            arr1[7] = distance(currentX-1,currentY-1,x2,y2);

            double m = Double.MAX_VALUE;
            for (int j = 0; j < 8; j++) {
                m = Math.min(m, arr1[j]);
            }
            int index = 0;
            for (int k = 0; k < 8; k++) {
                if(arr1[k]==m){
                    index = k;
                }
            }
            switch (index){
                case 0:
                    currentX++;
                    break;
                case 1:
                    currentY++;
                    break;
                case 2:
                    currentX--;
                    break;
                case 3:
                    currentY--;
                    break;
                case 4:
                    currentX++;
                    currentY--;
                    break;
                case 5:
                    currentX--;
                    currentY++;
                    break;
                case 6:
                    currentX++;
                    currentY++;
                    break;
                case 7:
                    currentX--;
                    currentY--;
                    break;
            }
//            56678063
//            Took 31942863700 ns
            i++;
            minutes++;
            if((xship==x2 && yship==y2)||(currentX==x2 && currentY==y2))
                break;
            // minutes++;
        }
        if(!flag){
            System.out.println("-1");
            return;
        }
        System.out.println(minutes);
    }

    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        String[] line2 = br.readLine().split(" ");
        long x1 = Long.parseLong(line1[0]);
        long y1 = Long.parseLong(line1[1]);
        long x2 = Long.parseLong(line2[0]);
        long y2 = Long.parseLong(line2[1]);
        int size = Integer.parseInt(br.readLine());
        String s = br.readLine();
        moves(x1, y1, x2, y2, size, s);

        long endTime = System.nanoTime();
        System.out.println("Took "+(endTime - startTime) + " ns");
    }
}
/*
precalc ship movement -> Resultant movement
xmov = []
ymov = []

xbmov = []
ybmov = []
 */
