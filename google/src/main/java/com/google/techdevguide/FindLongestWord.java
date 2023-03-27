package com.google.techdevguide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string S and a set of words D, find the longest word in D that is a subsequence of S.
 * <p>
 * Word W is a subsequence of S if some number of characters, possibly zero, can be deleted from S to form W, without reordering the remaining characters.
 * <p>
 * Note: D can appear in any format (list, hash table, prefix tree, etc.
 * <p>
 * For example, given the input of S = "abppplee" and D = {"able", "ale", "apple", "bale", "kangaroo"} the correct output would be "apple"
 * <p>
 * The words "able" and "ale" are both subsequences of S, but they are shorter than "apple".
 * The word "bale" is not a subsequence of S because even though S has all the right letters, they are not in the right order.
 * The word "kangaroo" is the longest word in D, but it isn't a subsequence of S.
 */
public class FindLongestWord {
    public String findLongest(String s, String[] words) {

        //Create a hashmap to store char and all of its index (from input string s)
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, new ArrayList<>());
            }
            map.get(ch).add(i);
        }
        /*
        abppplee
        Now, map will be :
        a - [0]
        b - [1]
        p - [2, 3, 4]
        l - [5]
        e - [6, 7]
         */
        String longest = "";
        boolean isSubsequence;
        for (String word : words) {
            int prevIdx = -1;
            isSubsequence = true;
            outerLoop:
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (map.containsKey(ch)) {
                    List<Integer> list = map.get(ch);
                    for (int idx : list) {
                        if (idx > prevIdx) {
                            prevIdx = idx;
                            continue outerLoop;
                        }
                    }
                    isSubsequence = false;
                    break;
                }
            }
            if (isSubsequence && longest.length() < word.length()) {
                longest = word;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        FindLongestWord fw = new FindLongestWord();
        System.out.println(fw.findLongest("abppplee", new String[]{"able", "ale", "apple", "bale", "kangaroo"}));
    }
}