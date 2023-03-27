package com.educative.datastructures.heaps;

import java.util.Arrays;

public class KSmallestElementsInArray {

    public static int[] findKSmallest(int[] arr, int k) {
        int size = arr.length;
        for (int i = (size - 1) / 2; i >= 0; i--) {
            buildMinHeap(arr, size, i);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            deleteRoot(arr, i, result, size--);
        }
        return result;

    }

    public static void buildMinHeap(int[] arr, int size, int index) {
        int smallest = index;
        while (index <= (size - 1) / 2) {
            int left = (index * 2) + 1;
            int right = (index * 2) + 2;
            if (left < size && arr[left] < arr[smallest]) {
                smallest = left;
            }
            if (right < size && arr[right] < arr[smallest]) {
                smallest = right;
            }
            if (smallest != index) {
                //swap values
                int temp = arr[smallest];
                arr[smallest] = arr[index];
                arr[index] = temp;
                index = smallest;
            } else {
                break;
            }
        }
    }

    public static void deleteRoot(int[] arr, int index, int[] result, int size) {
        if (arr == null) {
            return;
        }
        result[index] = arr[0];
        arr[0] = arr[size - 1];
        buildMinHeap(arr, size - 1, 0);
    }

    public static void main(String args[]) {
        int[] input = {9, 4, 7, 1, -2, 6, 5};
        int[] output = findKSmallest(input, 3);
        System.out.println(Arrays.toString(output));
    }
}
