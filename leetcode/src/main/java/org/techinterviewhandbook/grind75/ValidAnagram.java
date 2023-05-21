package org.techinterviewhandbook.grind75;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }
        for(Character ch : t.toCharArray()){
            if(!map.containsKey(ch)){
                return false;
            }
            map.put(ch, map.get(ch) - 1);
            if(map.get(ch)==0){
                map.remove(ch);
            }
        }
        return map.isEmpty();
    }

    public boolean isAnagram2(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int[] charCount = new int[26];
        for(int i=0; i<s.length(); i++){
            charCount[s.charAt(i)-'a']++;
            charCount[t.charAt(i)-'a']--;
        }
        for (int count : charCount) {
            if(count!=0)
                return false;
        }
        return true;
    }

    public boolean isAnagram3(String s, String t) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        s.chars().forEach(ch -> freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1));
        t.chars().forEach(ch -> freqMap.put(ch, freqMap.getOrDefault(ch, 0) - 1));
        return freqMap.values().stream().allMatch(f ->  f== 0);
    }

    public static void main(String[] args) {
        System.out.println(new ValidAnagram().isAnagram("anagram", "nagaram"));
        System.out.println(new ValidAnagram().isAnagram("rat", "car"));
        System.out.println("*******************");
        System.out.println(new ValidAnagram().isAnagram2("anagram", "nagaram"));
        System.out.println(new ValidAnagram().isAnagram2("rat", "car"));
        System.out.println("*******************");
        System.out.println(new ValidAnagram().isAnagram3("anagram", "nagaram"));
        System.out.println(new ValidAnagram().isAnagram3("rat", "car"));
    }
}
