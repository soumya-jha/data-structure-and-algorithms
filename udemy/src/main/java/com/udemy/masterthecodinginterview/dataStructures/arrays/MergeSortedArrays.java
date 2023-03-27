package com.udemy.masterthecodinginterview.dataStructures.arrays;

/*mergeSortedArrays([0,3,4,31], [4,6,30]);
Output - ([0,3,4,4,6,30,31])
*/

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] array1 = {0, 3, 4, 31};
        int[] array2 = {4, 6, 30};
        int[] mergedArray = mergeArrays(array1, array2);
        System.out.println(Arrays.toString(mergedArray));
    }

    public static int[] mergeArrays(int[] array1, int[] array2) {
        int arrLen1 = array1.length;
        int arrLen2 = array2.length;
        int[] mergedArray = new int[arrLen1 + arrLen2];
        if (arrLen1 == 0) {
            return array2;
        } else if (arrLen2 == 0) {
            return array1;
        } else {
            int i = 0, j = 0, idx = 0;
            while (i < arrLen1 || j < arrLen2) {
                if ((i != arrLen1 && j != arrLen2 && array1[i] <= array2[j]) || (i < arrLen1 && j == arrLen2)) {
                    mergedArray[idx] = array1[i];
                    i++;
                } else {
                    mergedArray[idx] = array2[j];
                    j++;
                }
                idx++;
            }
            return mergedArray;
        }
    }
}
