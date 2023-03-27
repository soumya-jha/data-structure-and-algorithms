package com.educative.grokking.topKelements;

import java.util.PriorityQueue;

public class KthLargestInAStream {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    int k;

    // constructor to initialize topKHeap and add values in it
    public KthLargestInAStream(int k, int[] nums) {
        this.k = k;
        for (int n : nums) {
            minHeap.add(n);
        }
    }

    // adds element in the topKHeap
    public int add(int val) {
        minHeap.add(val);
        return returnKthLargest();
    }

    // returns kth largest element from topKHeap
    public int returnKthLargest() {
        while (!minHeap.isEmpty() && minHeap.size() > k) {
            minHeap.poll();
        }
        return !minHeap.isEmpty() ? minHeap.peek() : -1;
    }
}
