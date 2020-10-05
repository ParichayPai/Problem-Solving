package com.Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EnemyBase {
    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);

        long[] arr = new long[n];
        long[] pre = new long[n];
        long max = 0;
        input = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(input[i]);
            max = Math.max(max, arr[i]);
        }

        long low = 1, high = max+1; //(long)Math.pow(10,9) + 1;
        while(low < high) {
            long mid = (low + high)/2;
            if(check(mid, d, arr, pre, n))
                high = mid;
            else
                low = mid + 1;
        }

        System.out.println(low);
    }

    public static boolean check(long a, int d, long[] arr, long[] pre, int n) {
        int count = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] <= a)
                count++;
            pre[i] = count;
        }

        long ans;
        for(int i = 0; i < n; i++) {
            if(arr[i] > a){
                ans = pre[i];
                if(i > d)
                    ans -= pre[i-d-1];
                if(i+d < n)
                    ans += pre[i+d] - pre[i];
                else
                    ans += pre[n-1] - pre[i];
                if(ans*a < arr[i])
                    return false;
            }
        }
        return true;
    }
}
/*
The government has launched a missile to destroy the enemy bases which
are represented by a 1-indexed array of N integers.
At the time of launch, all the enemy bases which have defense lower than
or equal to A will be destroyed immediately. Then after, each destroyed
defense will act as government source and will lower the enemy base defense
by A when it attacks any particular base. If the current base is i (1 <= i < = N)
then on the first day it will attack i+1 and i-1 base the next day it will attack
the i+2 and i-2 base (the attack happens only if a base exists at the attack position).
The base will be destroyed if its defense goes below or equal to 0.
Since the missile is costly, the government wants to know the minimum A
requires so that the project can be ended within D days.
For more clarification see the example
Note:- Only the defenses which were destroyed at the time of launch will
act as a source
Input
First line of input contains two space separated integer N and D. Second
line of input contains N space separated integers denoting the value of the Array.

Constraints:-
1 < = N < = 100000
1 < = Arr[i] < = 100000000
1 < = D < = 10000
Output
Print the minimum attack power requires to complete the project within D days.

Sample Input:-
3 1
5 10 5

Sample Output:-
5

Explanation:-
1st and 3rd defense will be destroyed immediately then at first day
1st will attack 2nd defense and lowers its defense by 5 and on the
same day 3rd defense will also attack the second and destroys it.

Sample Input:-
6 3
2 15 4 2 6 9

Sample Output:-
5

Explanation:-
After launch :- 0 15 0 0 6 9 (1st 3rd and 4th will act as source)
Day 1:- 0 5 0 0 1 9
Day 2:- 0 0 0 0 0 4
Day 3:- 0 0 0 0 0 0
 */