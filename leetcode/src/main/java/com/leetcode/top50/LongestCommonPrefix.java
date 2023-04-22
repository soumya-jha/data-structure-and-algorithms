package com.leetcode.top50;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String str1 = strs[0];
        String str2 = strs[strs.length - 1];
        int i = 0;
        for (; i < str1.length() && i < str2.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
        }
        return str1.substring(0, i);
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[] {"flower","flow","flight"}));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[] { "dog","racecar","car"}));
    }
}
