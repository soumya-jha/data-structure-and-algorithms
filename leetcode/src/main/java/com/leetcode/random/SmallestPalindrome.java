package com.leetcode.random;

public class SmallestPalindrome {
    public String makeSmallestPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);

        while (start < end) {
            char firstChar = s.charAt(start);
            char lastChar = s.charAt(end);
            if (firstChar != lastChar) {
                if (firstChar > lastChar) {
                    sb.replace(start, start + 1, String.valueOf(lastChar));
                } else {
                    sb.replace(end, end + 1, String.valueOf(firstChar));
                }
            }
            start++; end--;
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(new SmallestPalindrome().makeSmallestPalindrome("egcfe"));
        System.out.println(new SmallestPalindrome().makeSmallestPalindrome("abcd"));
        System.out.println(new SmallestPalindrome().makeSmallestPalindrome("seven"));

    }
}
