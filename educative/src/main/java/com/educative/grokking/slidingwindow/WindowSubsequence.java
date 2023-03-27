package com.educative.grokking.slidingwindow;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Not fully implemented
public class WindowSubsequence {
    public static void main(String[] args) {
        Set<Integer> s = new HashSet();
        System.out.println(s.add("abc".hashCode()));
        System.out.println(s.add("abc".hashCode()));
        new ArrayList<>(s);
        s.clear();
        int[] arr = new int[5];
        Arrays.stream(arr).sorted();


    }

    public static String minWindow(String str1, String str2) {
        // Write your code here
        int sizeStr1 = str1.length();
        int sizeStr2 = str2.length();

        int sizeMinSubSeq = Integer.MAX_VALUE;
        String minSubSeq = "";

        int idxStr1 = 0;
        int idxStr2 = 0;

        int start = 0;
        int end = 0;

        while (idxStr1 < sizeStr1) {
            if (str1.charAt(idxStr1) == str2.charAt(idxStr2)) {
                idxStr2++;
                if (idxStr2 == sizeStr2) {
                    start = idxStr1;
                    end = idxStr1 + 1;
                    idxStr2--;
                    while (idxStr2 >= 0) {
                        if (str1.charAt(start) == str2.charAt(idxStr2)) {
                            idxStr2--;
                        }
                        start--;
                    }
                    start++;
                }

            }
            if (sizeMinSubSeq > (end - start)) {
                sizeMinSubSeq = end - start;
                minSubSeq = str1.substring(start, end);
            }
            idxStr1++;
        }

        return minSubSeq;
    }
}
