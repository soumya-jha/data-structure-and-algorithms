package com.udemy.masterthecodinginterview.algorithms.sorting;

public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        int[] arr = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        bs.sort(arr);
        System.out.println("Done!");
    }

    public void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i <= len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
