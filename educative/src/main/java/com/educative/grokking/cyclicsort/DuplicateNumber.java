package com.educative.grokking.cyclicsort;

public class DuplicateNumber {
    public static void main(String[] args) {
        System.out.println("{1,3,3,4,2,5} : " + findDuplicate(new int[]{1, 3, 3, 4, 2, 5}));
        System.out.println("{3,4,4,4,2} : " + findDuplicate(new int[]{3, 4, 4, 4, 2}));
        System.out.println("{1,1} : " + findDuplicate(new int[]{1, 1}));
        System.out.println("{1,3,6,2,7,3,5,4} : " + findDuplicate(new int[]{1, 3, 6, 2, 7, 3, 5, 4}));
        System.out.println("{1,2,2} : " + findDuplicate(new int[]{1, 2, 2}));

    }

    public static int findDuplicate(int[] arr) {
        int idx = 0;
        while (idx < arr.length) {
            //check if num is not in correct idx
            if (arr[idx] != idx + 1) {
                int temp = arr[arr[idx] - 1];
                //check if the value to be swapped is not the same as current idx value
                //if it is same, then skip (case of duplicate)
                if (temp != arr[idx]) {
                    arr[arr[idx] - 1] = arr[idx];
                    arr[idx] = temp;
                } else {
                    //else if the value is same, then we have found the duplicate element
                    //since duplicate exists in arr for only one integer, return its value
                    return temp;
                    //idx++;
                }
            } else {
                //do nothing, increment idx
                idx++;
            }
        }
        /*for(int i=0;i<arr.length;i++){
            if(arr[i]!=i+1){
                return arr[i];
            }
        }*/
        //return arr[arr.length-1];
        return -1;
    }
}
