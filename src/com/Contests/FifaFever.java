package com.Contests;

/*
Ronaldo has challenged Messi to beat his team in the upcoming “Friendly” fixture.
But both these legends are tired of the original football rules, so they decided to
play Football with a twist. Each player is assigned an ID, from 1 to 10^6. Initially
Ronaldo has the ball in his posession. Given a sequence of N passes, help Messi Know
which ID player has the ball, after N passes.

Note: Passes are of two types :

i) P ID, which means the player currently having the ball passes it to Player with
identity ID.
ii) B, which means the player currently having the ball passes it back to the Player
he got the Pass From.

Also, It is guaranteed that the given order of passes will be a valid order.
Input
The first line of input contains number of testcases T. The 1st line of each testcase,
contains two integers, N and ID1, denoting the total number of passes and the ID of
Ronaldo. Respectively. Each of the next N lines, contains the information of a Pass
which can be either of the above two types, i.e:

1) P ID
2) B

Constraints
1 <= T <= 100
1 <= N <= 10^5
1 <= IDs <= 10^6
Sum of N for every test case is less than 10^6
Output
For each testcase you need to print the ID of the Player having the ball after N passes.

Input :
P 12
P 13
P 14
B
B

Output :
13
14
 */

import java.util.Scanner;

public class FifaFever {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int current_player = sc.nextInt();
            int previous_player = 0;
            for(int i = 0 ; i < n ; i++){
                char ch = sc.next().charAt(0);
                if(ch == 'P'){
                    previous_player = current_player;
                    current_player = sc.nextInt();
                }
                else{
                    int temp = current_player;
                    current_player = previous_player;
                    previous_player = temp;
                }
            }
            System.out.println(current_player);
        }
    }
}
//2
//3 1
//P 13
//P 14
//B
//5 1
