package com.educative.grokking.topKelements;

import java.util.PriorityQueue;

public class KthLargestInArray {
    public static void main(String[] args) {

    }

    public static int findKthLargest(int[] arr, int k) {
        //Create a minHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int count = 0;
        for (int i : arr) {
            //Add k integers to minHeap
            if (count < k) {
                minHeap.add(i);
            } else {
                //after minHeap has k integers, compare remaining integer to top value in minHeap
                //Swap if the current integer in the array is greater than the top integer value in minHeap
                if (i > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(i);
                }
            }
            count++;
        }
        //By the end of this iteration, the topmost integer in minHeap will be the kth largest
        return !minHeap.isEmpty() ? minHeap.peek() : -1;
    }
}
