package com.udemy.masterthecodinginterview.algorithms.sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        SelectionSort ss = new SelectionSort();
        ss.selectionSort(arr);
        System.out.println("Done!");
    }

    public void selectionSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length-1; i++) {
            int idx = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[idx] > arr[j]) {
                    idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
    }
}