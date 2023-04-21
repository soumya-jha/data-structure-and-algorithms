package com.leetcode.top50;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int longest = 0;
        int start = 0;
        Map<Character, Integer> idxMap = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (!idxMap.containsKey(ch)) {
                longest = Math.max(longest, end - start + 1);
            } else {
                int idx = start;
                start = idxMap.get(ch) + 1;
                while(idx<idxMap.get(ch)){
                    idxMap.remove(s.charAt(idx++));
                }
            }
            idxMap.put(ch, end);
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println("abcabcbb : " + l.lengthOfLongestSubstring("abcabcbb"));
        System.out.println("bbbbb : " + l.lengthOfLongestSubstring("bbbbb"));
        System.out.println("pwwkew : " + l.lengthOfLongestSubstring("pwwkew"));
        System.out.println("tmmzuxt : " + l.lengthOfLongestSubstring("tmmzuxt"));

    }
}
