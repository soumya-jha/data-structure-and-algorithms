package com.educative.grokking.topKelements;

import java.util.*;

public class FrequentElements {
    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
        System.out.println(topKFrequent(arr, 6));
    }

    public static List<Integer> topKFrequent(int[] arr, int k) {
        //Create frequency Map and add all elements from arr with frequency
        Map<Integer, Integer> freqMap = new HashMap();
        for (int i: arr) {
            freqMap.put(i, freqMap.getOrDefault(i,0)+1);
        }
        //Create a min Heap of distinct Integer values in arr based on their frequency
        Comparator<Integer> freqComparator = Comparator.comparingInt(key -> freqMap.get(key));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(freqComparator);

        int count = 0;
        for(int key : freqMap.keySet()){
            //Add k elements to min heap
            if(count<k){
                minHeap.add(key);
                count++;
            }else{
                //Compare next integer with top integer of minHeap.
                // If it is greater, remove top integer and add this integer to min heap, else do nothing
                if(freqMap.get(key)>freqMap.get(minHeap.peek())){
                    minHeap.poll();
                    minHeap.add(key);
                }
            }
        }
        //minHeap will only contain K elements, convert to arraylist and return
        return new ArrayList<>(minHeap);
    }
}
