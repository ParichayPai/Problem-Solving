package com.sortProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class frequencySort {
    private static void sortArrayElementsByFrequency(int[] inputArray)
    {
        Map<Integer, Integer> elementCountMap = new LinkedHashMap<>();
        for (int j : inputArray) {
            elementCountMap.put(j, elementCountMap.getOrDefault(j,0) + 1);
        }
        ArrayList<Map.Entry<Integer, Integer>> listOfEntry = new ArrayList<>(elementCountMap.entrySet());

        listOfEntry.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> op1, Map.Entry<Integer, Integer> op2) {
                if(op1.getValue().compareTo(op2.getValue()) == 0)
                    return op2.getKey().compareTo(op1.getKey());
                else
                    return op1.getValue().compareTo(op2.getValue());
            }
        });
        List<Integer> arrl = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : listOfEntry)
        {
            int frequency = entry.getValue();

            while (frequency >= 1)
            {
                arrl.add(entry.getKey());
                frequency--;
            }
        }
        for (int i = arrl.size()-1; i >= 0; i--)
                System.out.print(arrl.get(i)+" ");
        System.out.println();

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            int n = Integer.parseInt(br.readLine());
            String[] inp = br.readLine().split(" ");
            int[] inputArray = new int[inp.length];
            for(int i = 0; i < inp.length; i++)
                inputArray[i] = Integer.parseInt(inp[i]);
            sortArrayElementsByFrequency(inputArray);
        }
    }
}
/*
private static void sortArrayElementsByFrequency(int[] inputArray)
    {
        Map<Integer, Integer> elementCountMap = new LinkedHashMap<>();
        for (int i = 0; i < inputArray.length; i++)
        {
            if (elementCountMap.containsKey(inputArray[i])){
                elementCountMap.put(inputArray[i], elementCountMap.get(inputArray[i])+1);
            }
            else{
                elementCountMap.put(inputArray[i], 1);
            }
        }
        ArrayList<Entry<Integer, Integer>> listOfEntry = new ArrayList<>(elementCountMap.entrySet());

        Collections.sort(listOfEntry, new Comparator<Entry<Integer, Integer>>()
        {
            @Override
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2)
            {
                return o2.getValue().compareTo(o1.getValue());
            }
        }
        );

        //Print sorted array elements in descending order of their frequency

        System.out.println("Input Array : "+Arrays.toString(inputArray));

        System.out.println("Sorted Array Elements In Descending Order Of Their Frequency :");

        System.out.print("[ ");

        for (Entry<Integer, Integer> entry : listOfEntry)
        {
            int frequency = entry.getValue();

            while (frequency >= 1)
            {
                System.out.print(entry.getKey()+" ");

                frequency--;
            }
        }

        System.out.print("]");
    }
 */