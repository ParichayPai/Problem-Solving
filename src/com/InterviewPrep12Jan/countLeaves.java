package com.InterviewPrep12Jan;

import java.util.*;

public class countLeaves {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxChildren = 2;
        int currentLevel = 1, nodesTraversed = 0;
        while (n-- > 0){
            int u = sc.nextInt();
            int v = sc.nextInt();
            List<Integer> arrl = new ArrayList<>();
            arrl.add(u);
            arrl.add(v);
            map.put(currentLevel, arrl);
            map.put(currentLevel, arrl);
            nodesTraversed += 2;
            if(nodesTraversed == maxChildren){
                currentLevel++;
                nodesTraversed = 0;
            }
        }
        int count = 0;
        for (Map.Entry<Integer, List<Integer>> me : map.entrySet()) {
            System.out.print(me.getKey() + ":");
            System.out.println(me.getValue());
            for (int i = 0; i < me.getValue().size(); i++) {
                if(i % 2 == 0 && me.getValue().get(i) == -1 && i+1 < me.getValue().size() && me.getValue().get(i+1) == -1)
                    count++;
            }
        }
        System.out.println(count);
    }
}
