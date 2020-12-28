package com.contest_27_12_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;

class Coordinates implements Comparable<Coordinates>{
    long x, y;
    Coordinates(long x, long y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Coordinates student2) {
        return (int) (Math.abs(this.x - student2.x) - Math.abs(this.y - student2.y));
    }
}

public class campSetup {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Coordinates[] arr = new Coordinates[n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            arr[i] = new Coordinates(Long.parseLong(line[0]), Long.parseLong(line[1]));
        }
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i].x+" "+arr[i].y);
        }
    }
}
