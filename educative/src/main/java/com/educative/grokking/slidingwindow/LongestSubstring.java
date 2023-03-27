package com.educative.grokking.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(LongestSubstring.findLongestSubstring("abcdbea"));
    }
    public static int findLongestSubstring(String inputString) {
        if(inputString == null || inputString ==""){
            return 0;
        }
        int longest = 0;
        int currentLength = 0;
        int length = inputString.length();
        int left =0, right =0;
        Set<Character> set = new HashSet<>();
        while(right<length){
            char ch = inputString.charAt(right);
            boolean addToSet = set.add(ch);
            if(!addToSet){
                while(inputString.charAt(left)!=ch){
                    set.remove(inputString.charAt(left));
                    left++;
                    currentLength--;
                }
                left++;
            }else{
                currentLength++;
            }
            longest = Math.max(longest,currentLength);
            right++;
        }
        return longest;
    }
}
