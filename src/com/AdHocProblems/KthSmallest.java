package com.AdHocProblems;

/*
You are given Q queries and an integer K. Queries will be of two types :-
Query of type one gives you coordinates on a 2-D plane.
For Query of type two you have to give the square of distance of the kth
closest coordinate of those given so far (in query of type 1) from origin.
Note:-K is fixed for all queries
Input
First line of input contains Q i.e. Total no. of queries and K.
Then Q lines follow
for query of first type : 1 x y
for query of second type : 2
It is gauranted that there will be atleast k queries of type 1 before first
query of type 2.

Constraints:-
1 < = k < = Q < = 100000
-1000000 < = x , y < = 1000000
Output
For each query of type 2 output the square of distance of Kth nearest coordinate
from Origin in a new line.

Sample input
9 3
1 10 10
1 9 9
1 -8 -8
2
1 7 7
2
1 6 6
1 5 5
2

Sample output
200
162
98

Explanation:-
3rd closest coordinate will be 10,10 for first query of type 2 then after inserting 7,7
9,9 will become the 3rd closest then after 5 5 and 6 6 7,7 will become the 3rd closest coordinate
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KthSmallest {
    public static long sqDistance(long x, long y){
        return x*x + y*y;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] qnk = br.readLine().split(" ");
        int q = Integer.parseInt(qnk[0]);
        int k = Integer.parseInt(qnk[1]);
        List<Long> arrl = new ArrayList<>();
        while (q-- > 0){
            String[] query = br.readLine().split(" ");
            if (query[0].equals("1")){
                long x = Long.parseLong(query[1]);
                long y = Long.parseLong(query[2]);
                arrl.add(sqDistance(x,y));
            }else{
                Collections.sort(arrl);
				System.out.println(arrl.get(k-1));
            }
        }
    }
}
