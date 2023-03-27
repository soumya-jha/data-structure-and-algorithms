package com.educative.datastructures.hashtables;

import java.util.HashSet;
import java.util.Set;

public class SymmetricPairs {
    public static String findSymmetric(int[][] arr) {

        String result = "";
        Set<String> set = new HashSet<>();
        System.out.println(arr[0][0]);
        for(int i=0; i<arr.length;i++){
            set.add(arr[i][0]+","+arr[i][1]);
        }
        System.out.println(set);

        for(int i=0; i<arr.length;i++){
            if(set.contains(arr[i][1]+","+arr[i][0])){
                set.remove(arr[i][0]+","+arr[i][1]);
               result+= "{"+arr[i][0]+","+arr[i][1]+"}";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {3, 4}, {5, 9}, {4, 3}, {9, 5}};
        System.out.println(findSymmetric(arr));
    }
}
