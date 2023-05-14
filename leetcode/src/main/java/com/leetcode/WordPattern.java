package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split("\\s+");
        if (arr.length != pattern.length()) {
            return false;
        }
        Map<String, Character> patternMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!patternMap.containsKey(arr[i])) {
                if (patternMap.containsValue(pattern.charAt(i))) {
                    return false;
                }
                patternMap.put(arr[i], pattern.charAt(i));
            } else {
                if (patternMap.get(arr[i]) != pattern.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern wp = new WordPattern();
        System.out.println(wp.wordPattern("abba", "dog cat cat dog"));
        System.out.println(wp.wordPattern("abba", "dog cat cat fish"));
        System.out.println(wp.wordPattern("aaaa", "dog cat cat dog"));
    }
}
