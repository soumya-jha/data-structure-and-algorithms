package com.udemy.masterthecodinginterview.dataStructures.arrays;

import java.util.Hashtable;

/*
//Google Question
Given an array = [2,5,1,2,3,5,1,2,4]
It should return 2

Given an array = [2,1,1,2,3,5,1,2,4]
It should return 1

Given an array = [2,3,4,5]
It should return Undefined

 */
public class FirstRecurringNumberInArray {

    public static void main(String[] args) {
        int[] array = {2, 5, 1, 2, 3, 5, 1, 2, 4};
        System.out.println(findFirstRecurringNumber(array));
    }

    private static String findFirstRecurringNumber(int[] array) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        for (int i = 0; i < array.length; i++) {
            if (hashtable.containsKey(array[i])) {
                return String.valueOf(array[i]);
            }
            hashtable.put(array[i], 1);
        }
        return "Undefined";
    }
}
