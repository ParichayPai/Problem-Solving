package com.arrays;
import java.util.*;

public class simpleRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int realSize = size*2;
        long[] a = new long[realSize];
        long[] x = new long[size];
        long[] y = new long[size];
        for(int i = 0; i < realSize ;i++)
            a[i] = sc.nextLong();

        int k = 0;
        for(int i = 0; i < realSize; i = i+2)
            x[k++] = a[i];

        int z = 0;
        for(int i = 1; i < realSize; i = i+2)
            y[z++] = a[i];

        Arrays.sort(x);
        Arrays.sort(y);

        long xmin = x[0], xmax = x[size-1], ymin = y[0], ymax = y[size-1];
        long xvalue = Math.abs(xmax - xmin);
        long yvalue = Math.abs(ymax - ymin);

        System.out.print(xvalue*yvalue);

    }
}
