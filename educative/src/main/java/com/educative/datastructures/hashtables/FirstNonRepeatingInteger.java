package com.educative.datastructures.hashtables;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingInteger {

    public static void main(String[] args) {
        System.out.println(findFirstUnique(new int[]{4,4,4,3}));
        System.out.println(findFirstUnique(new int[]{4,5,1,2,0,4}));
    }

    public static int findFirstUnique(int[] arr)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0) +1);
        }
        for(int i=0; i<arr.length;i++){
            if(map.get(arr[i])==1){
                return arr[i];
            }
        }
        return -1;
    }
}
