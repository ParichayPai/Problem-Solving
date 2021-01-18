package com.Dequeue;

import java.util.Collections;
import java.util.PriorityQueue;

public class medianInStream {
    static PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> min = new PriorityQueue<>();

    // Function to getMedian
    public static double getMedian(int X){
        double median = 0.0;
        insertIntoHeap(X);
        if(max.size() == min.size()){
            median = (max.peek() + min.peek()); ///2;
            median /= 2;
        } else {
            if(min.isEmpty() || min.size() < max.size()){
                median = max.peek();
            } else {
                median = min.peek();
            }
        }
        return median;
    }

    public static void insertIntoHeap(int x){
        if(max.isEmpty())
            max.add(x);
        else if(x > max.peek())
            min.add(x);
        else if(min.isEmpty()){
            min.add(max.remove());
            max.add(x);
        }else {
            max.add(x);
        }
        setHeaps();
    }

    public static void setHeaps(){
        if(Math.abs(max.size()-min.size()) > 1){
            if(max.size() > min.size()){
                min.add(max.remove());
            }else{
                max.add(min.remove());
            }
        }
    }
}
