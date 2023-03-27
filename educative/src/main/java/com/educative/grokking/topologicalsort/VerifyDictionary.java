package com.educative.grokking.topologicalsort;

import java.util.HashMap;
import java.util.Map;

public class VerifyDictionary {
    public static void main(String[] args) {
        String[] words = new String[] {"jupyter", "ascending"};
        System.out.println(verifyDictionary(words, "jabcdefghiklmnopqrstuvwxyz"));
    }

    public static boolean verifyDictionary(String[] words, String order){
        //Declare a map for maintaining list of characters, Map contains char as key, its index in order[] as value
        Map<Character, Integer> graph = new HashMap<>();
        char[] orderArr = order.toCharArray();
        for(int idx=0; idx< orderArr.length;idx++){
            graph.put(orderArr[idx], idx);
        }

        outerLoop:
        for(int idx=0; idx<words.length-1;idx++){
            String word1 = words[idx], word2 = words[idx+1];
            for(int k=0;k<word1.length() || k<word2.length();k++){
                //length of word1 is less than word2, valid scenario, hence skip to continue checking the next two words
                if(k>=word1.length()) {
                    continue outerLoop;
                }
                //length of word1 is more than word2,invalid scenario, return false
                if(k>=word2.length()) {
                    return false;
                }
                //if current idx character in word1 and word2 are same, continue to check for next character
                if(word1.charAt(k)==word2.charAt(k)){
                    continue;
                }
                if(graph.get(word1.charAt(k))>graph.get(word2.charAt(k))){
                    return false;
                }else{
                    continue outerLoop;
                }
            }
        }
        return true;
    }
}
