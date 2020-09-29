package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class temp {
//    public static void main(String[] args)throws IOException
//    {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int testCases = Integer.parseInt(br.readLine());
//        StringBuilder sb = new StringBuilder();
//        while(testCases-->0)
//        {
//            String s1[] = br.readLine().split(" ");
//            int size = Integer.parseInt(s1[0]);
//            int K = Integer.parseInt(s1[1]);
//            long arr[] = new long[size];
//            String s2[] = br.readLine().split(" ");
//            for (int i = 0; i < size; i++)
//            {
//                arr[i] = Long.parseLong(s2[i]);
//            }
//            Arrays.sort(arr);
//            long first = 0, last =(arr[size-1]-arr[0]),mid=last;
//            while(first<last)
//            {
//                mid = first +((last-first)/2);
//                long count = pairCount(arr,mid,size,K);
//                if(count<K)
//                {
//                    first = mid+1;
//                }
//                else
//                {
//                    last = mid;
//                }
//
//            }
//
//            sb.append(first+"\n");
//        }
//        System.out.print(sb);
//    }
//    public static long pairCount(long arr[] , long mid,int size ,int K)
//    {
//        long count =0;
//        for(int i=1;i<size;i++)
//        {
//            if(arr[i]-arr[0]<=mid)
//            {
//                count = count+i;
//            }
//            else
//            {
//                int first1 = 1,last1 = i,mid1=last1;
//                while(first1<last1)
//                {
//                    mid1 = (first1+((last1-first1)/2));
//                    if(arr[i]-arr[mid1]<=mid)
//                    {
//                        last1 = mid1;
//                    }
//                    else
//                    {
//                        first1 = mid1+1;
//                    }
//
//                }
//                count = count+(i-first1);
//               /* for(int j=1;j<i;j++)
//                {
//                    if(arr[i]-arr[j]<=mid)
//                    {
//                        count = count + i-j;
//                        break;
//                    }
//                }*/
//            }
//        }
//        return count;
//    }
    public static double distance(int x1, int y1, int x2, int y2){
        return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 0, y = 0, xf = 123, yf = 321;
        DecimalFormat df = new DecimalFormat("#.###");
        System.out.println(df.format(distance(x+1,y,xf,yf)-distance(x,y,xf,yf)));
        System.out.println(df.format(distance(x+1,y+1,xf,yf)-distance(x,y,xf,yf)));
        System.out.println(df.format(distance(x,y+1,xf,yf)-distance(x,y,xf,yf)));
        System.out.println(df.format(distance(x-1,y+1,xf,yf)-distance(x,y,xf,yf)));
        System.out.println(df.format(distance(x-1,y,xf,yf)-distance(x,y,xf,yf)));
        System.out.println(df.format(distance(x-1,y-1,xf,yf)-distance(x,y,xf,yf)));
        System.out.println(df.format(distance(x,y-1,xf,yf)-distance(x,y,xf,yf)));
        System.out.println(df.format(distance(x+1,y-1,xf,yf)-distance(x,y,xf,yf)));

        /*
        case 1 : if dist > 1 : x++, y++;
        case 2 : if dist < -1: x--, y--;
        case 3 : if dist < 0.2 dist > 0 : x--, y++
        case 4 : if dist > -0.2 dist < 0
        case 5 :
        case 6 :
        case 7 :
        case 8 :
         */
    }
}
