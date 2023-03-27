package com.educative.datastructures.heaps;

import java.util.Arrays;

public class MaxToMinHeap {

    public static void convertMax(int[] maxHeap) {
        int size = maxHeap.length;
        for (int i = (size - 1) / 2; i >= 0; i--) {
            minHeap(maxHeap, size, i);
        }
    }

    public static void minHeap(int[] maxHeap, int size, int index) {
        int smallest = index;

        while (index <= (size - 1) / 2) {
            int left = (index * 2) + 1;
            int right = (index * 2) + 2;
            if (left < size && maxHeap[left] < maxHeap[smallest]) {
                smallest = left;
            }
            if (right < size && maxHeap[right] < maxHeap[smallest]) {
                smallest = right;
            }
            if (index != smallest) {
                //swap values
                int temp = maxHeap[index];
                maxHeap[index] = maxHeap[smallest];
                maxHeap[smallest] = temp;
                index = smallest;
            } else {
                break; // no need to swap
            }
        }
    }

    public static void main(String[] args) {
        int[] maxHeap = {16,15,14,12,4,7,9,2,3,1};
        convertMax(maxHeap);
        System.out.println(Arrays.toString(maxHeap));
    }
}
