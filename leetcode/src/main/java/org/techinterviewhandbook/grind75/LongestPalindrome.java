package org.techinterviewhandbook.grind75;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s.length() == 1)
            return 1;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int longest = 0;
        boolean foundOdd = false;
        for (int value : map.values()) {
            if (value % 2 == 0) {
                longest += value;
            } else {
                longest += value - 1;
                foundOdd = true;
            }
        }
        return foundOdd ? longest + 1 : longest;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("adam"));
    }
}
