package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class temp1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        String[] line2 = br.readLine().split(" ");
        String[] line3 = br.readLine().split(" ");
        int x1 = Integer.parseInt(line1[0]);
        int y1 = Integer.parseInt(line1[1]);
        int x2 = Integer.parseInt(line2[0]);
        int y2 = Integer.parseInt(line2[1]);
        int len = Integer.parseInt(line3[0]);
        String direction = br.readLine();
        //  System.out.println(direction);
        isposibletoreach(x1, y1, x2, y2, len, direction);


    }

    static void isposibletoreach(int x1, int y1, int x2, int y2, int len, String direction) {
        int[] xfac, yfac, c;
        int xtime, ytime, xin = x1, yin = y1, cover1 = 0 , cover2 = 0;
        int xtimetaken , ytimetaken , xfinaltime, yfinaltime ;
        xfac = xtraversal(x1, x2, y1, len, direction);      // Time & position after first traverssal of
        yfac = ytraversal(x1, y1, y2, len, direction);      // string in X & Y direction diection
        x1 = xfac[0]; y1 = yfac[0];
        xtime = xfac[1];  ytime = yfac[1];

        // Check if boat reached final position in first traversal
        // Also check if possible or not.
        boolean executed =  jhamela(x1, x2, y1, y2, xin, yin, xtime, ytime);
        if(executed)
            return;
        else {
            int xprofit = (x1  - xin);           // Gain after a traversal in X & Y direction
            int yprofit = (y1  - yin);
            int xtravneed = Math.abs((xin - x2)/xprofit);       // Calc. no. of traversal required
            int ytravneed = Math.abs((yin - y2)/yprofit);
            xtimetaken = xtravneed * direction.length();         // Time taken in traversal
            ytimetaken = ytravneed * direction.length();
            int xval = xin + xtravneed*xprofit;                  // X1 & Y1 position after traversal
            int yval = yin + ytravneed*yprofit;
            int xrem = Math.abs(x2 - x1)%xprofit;               //Remaining part left which will be covered in 1 traversal
            int yrem = Math.abs(y2 - y1)%yprofit;
            //    System.out.println(x1+" "+x2+" "+y1+" "+y2+" "+xprofit+" "+yprofit+" "+xtravneed+" "+ytravneed+" "+xtimetaken+" "+ytimetaken+" "+xrem+" "+yrem+" "+xval+" "+yval);
            if(xrem == 0){
                xfinaltime = xtimetaken;
            }
            else {
                c = xtraversal((Math.abs(xval)), x2, y1, len, direction);
                cover1 = c[1];
                xfinaltime = xtimetaken + cover1;
            }
            if(yrem == 0){
                yfinaltime = ytimetaken;
            }
            else {
                c = ytraversal(x1,(Math.abs(yval)), y2, len, direction);
                cover2 = c[1];
                yfinaltime = ytimetaken + cover2;
            }
            /// System.out.println(xtimetaken+" "+ytimetaken+" "+xfinaltime+" "+yfinaltime+" " +cover1+" "+cover2);
            System.out.print(Math.max(xfinaltime, yfinaltime));
        }


    }

    // Check if boat reaches final postion in first traversal.
    // Also Check if it is possible to reach or not

    static boolean jhamela(int x1, int x2, int y1, int y2, int xin, int yin, int xtime , int ytime){
        int xtimetaken = 0, ytimetaken = 0;
        //System.out.println(x1+" "+x2+" "+y1+" "+y2+" "+xtime+" "+ytime);
        if(x1 == xin){
            if(x1 == x2){

            }
            else {
                System.out.print(-1);
                return true;
            }
        }
        if(y1 == yin){
            if(y1 == y2){
            }
            else {
                System.out.print(-1);
                return true;
            }
        }
        if(x1 == x2 && y1 == y2) {
            System.out.println(Math.max(xtime, ytime));
            return true;
        }
        return false;
    }

    //move the boat  in X direction
    //Move only if movement is beneficial, if not ignore the movement
    // If bigger boat is not moving , Ram will move his boat beneficially.

    static int[] xtraversal(int x1, int x2, int y1, int len, String direction){
        int xtime = 0 ,xco,xin = x1 ; int[] a; int[] b = new int[2];

        int reduce;
        for(int i = 0 ; i < len; i = i+1){
            if(xin <= x2) {
                if (x1 >= x2)
                    break;
            }
            if(xin > x2) {
                if (x1 <= x2)
                    break;
            }
            char c = direction.charAt(i);
            a = movetheboat(x1, y1, c);
            xco = x1 + a[0];
            reduce = increordecrement(xco, x1, x2);
            if(reduce == 1){
                x1 = xco + a[0];
            }
            else if(reduce == 0){
                if(x1 < x2) {
                    x1++;
                } else if(x2 < x1)
                    x1--;
            }
            xtime++;
        }
        b[0] = x1; b[1] = xtime;
        return b;
    }

    //move the boat  in Y direction
    //Move only if movement is beneficial, if not ignore the movement
    // Ifbigger  boat is not moving , Ram will move his boat beneficially.

    static int[] ytraversal(int x1, int y1, int y2, int len, String direction){
        int ytime = 0 , yco , yin = y1; int[] a; int[] b = new int[2];
        int reduce;
        for(int i = 0 ; i < len; i = i+1){
            if(yin <= y2) {
                if (y1 >= y2)
                    break;
            }
            if(yin > y2) {
                if (y1 <= y2)
                    break;
            }
            char c = direction.charAt(i);
            a = movetheboat(x1, y1, c);
            yco = y1 + a[1];
            reduce = increordecrement(yco, y1, y2);
            if(reduce == 1){
                y1 = yco + a[1];
            }
            else if(reduce == 0){
                if(y1 < y2)
                    y1++;
                else if(y2 < y1)
                    y1--;
            }
            ytime++;
        }
        b[0] = y1; b[1] = ytime;
        return b;
    }

    //Check that gap is reduced between intial & final postion.
    static int increordecrement(int move, int intial, int finl){
        int gap1 = Math.abs(move - finl);
        int gap2 = Math.abs(intial - finl);
        return (gap2 - gap1);

    }

    //Function to move the boat as per the string given.
    static int[] movetheboat(int x1, int y1, char c){
        int[] a = new int[2];
        if(c == 'A'){
            a[0] = + 0;
            a[1] = + 1;
        }
        else if(c == 'B'){
            a[0] = + 0;
            a[1] = - 1;
        }
        else if(c == 'C'){
            a[0] = - 1;
            a[1] = + 0;
        }
        else if(c == 'D'){
            a[0] = + 1;
            a[1] = + 0;
        }
        else if(c == 'E'){
            a[0] = + 1;
            a[1] = + 1;
        }
        else if(c == 'F'){
            a[0] = - 1;
            a[1] = - 1;
        }
        else if(c == 'G'){
            a[0] = - 1;
            a[1] = + 1;
        }
        else if(c == 'H'){
            a[0] = + 1;
            a[1] = - 1;
        }
        return a;
    }
}
