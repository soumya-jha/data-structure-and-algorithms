package com.leetcode.random;

import java.util.ArrayList;

public class BuddyStrings {

    public boolean buddyStrings(String A, String B) {
        if (A == null || B == null || "".equals(A) || "".equals(B) || A.length() != B.length())
            return false;
        boolean sameChar = true;
        char[] arrayA = A.toCharArray();
        char[] arrayB = B.toCharArray();
        ArrayList<Integer> diff = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (i != 0 && arrayA[0] != arrayA[i])
                sameChar = false;
            if (arrayA[i] != arrayB[i]) {
                diff.add(i);
                if (diff.size() > 2)
                    return false;
            }
        }
        if ((diff.size() == 2
                && (arrayA[diff.get(0)] == arrayB[diff.get(1)] && arrayA[diff.get(1)] == arrayB[diff.get(0)]))
                || (diff.size() == 0 && sameChar) || (diff.size() == 0 && !sameChar && A.equals(B) && A.length() > 2))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        BuddyStrings bS = new BuddyStrings();
        boolean result = bS.buddyStrings("abcd", "abcd");
        System.out.println(result);
    }
}
