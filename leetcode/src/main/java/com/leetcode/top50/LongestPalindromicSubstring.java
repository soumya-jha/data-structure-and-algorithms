package com.leetcode.top50;

public class LongestPalindromicSubstring {

    public String longestPalindrome1(String s) {
        String longestSubstring = "";
        for (int i = 0; i < s.length(); i++) {
            String odd = isPalindrome1(s, i, i);
            String even = isPalindrome1(s, i, i + 1);
            String currLongest = odd.length() > even.length() ? odd : even;
            longestSubstring = longestSubstring.length() >= currLongest.length() ? longestSubstring : currLongest;
        }
        return longestSubstring;
    }

    private String isPalindrome1(String s, int start, int end) {
        while (start >= 0 && end < s.length() && (s.charAt(start) == s.charAt(end))) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }

    public String longestPalindrome2(String s) {
        String longestSubstring = "";
        for (int i = 0; i < s.length(); i++) {
            int odd = isPalindrome2(s, i, i);
            int even = isPalindrome2(s, i, i + 1);
            int start, end;
            if (odd > even) {
                start = i - odd / 2;
                end = i + odd / 2;
            } else {
                start = i - even / 2 + 1;
                end = i + even / 2;
            }
            String currLongest = s.substring(start, end + 1);
            longestSubstring = longestSubstring.length() >= currLongest.length() ? longestSubstring : currLongest;
        }
        return longestSubstring;
    }

    private int isPalindrome2(String s, int start, int end) {
        while (start >= 0 && end < s.length() && (s.charAt(start) == s.charAt(end))) {
            start--;
            end++;
        }
        return end - start - 1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println(lps.longestPalindrome1("babad"));
        System.out.println(lps.longestPalindrome2("babad"));
    }
}
