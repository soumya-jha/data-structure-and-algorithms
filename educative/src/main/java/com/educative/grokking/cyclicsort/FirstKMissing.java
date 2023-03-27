package com.educative.grokking.cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class FirstKMissing {
    public static void main(String[] args) {
        //3,-1,8,2,5
        //8,-1,3,2,5 -> 8,2,3,-1,5 -> 8,2,3,-1,5
        //1,4,6,7
        System.out.println(findMissingNumbers(new int[]{3, -1, 8, 2, 5}, 4));
    }

    public static List<Integer> findMissingNumbers(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        // declare an int[] array to store sorted numbers in correct positions
        int[] nums = new int[arr.length + k];
        int idx = 0;
        while (idx < arr.length) {
            //check if number is not in correct index, its value is less that arr.length and it is non negative
            if (arr[idx] != idx + 1 && arr[idx] <= arr.length && arr[idx] > 0) {
                //swap and add to nums[] in correct index
                int temp = arr[arr[idx] - 1];
                arr[arr[idx] - 1] = arr[idx];
                nums[arr[idx] - 1] = arr[idx]; //add swapped index to nums[]
                arr[idx] = temp;
                nums[idx] = arr[idx]; // add correct value in current idx to nums[]
            } else if (arr[idx] > arr.length) {
                //if current value is greater than arr.length, add it to correct position in nums[]
                nums[arr[idx] - 1] = arr[idx];
                idx++;
            } else {
                //add all other cases (correct positions) directly to nums[]
                nums[idx] = arr[idx];
                idx++;
            }
        }
        //iterate through nums[] and find all idx where numbers are in incorrect idx until k numbers are found
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1 && k>0) {
                result.add(i+1);
                k--;
            }
        }
        return result;
    }
}
