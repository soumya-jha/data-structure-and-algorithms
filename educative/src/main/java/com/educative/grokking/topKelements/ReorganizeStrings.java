package com.educative.grokking.topKelements;

import java.util.*;

public class ReorganizeStrings {

    public static void main(String[] args) {
        System.out.println(reorganizeStrings("aaabc"));
    }

    public static String reorganizeStrings(String string1) {
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < string1.length(); i++) {
            char key = string1.charAt(i);
            freqMap.put(key, freqMap.getOrDefault(key, 0) + 1);
        }
        Comparator<Character> freqComparator = Comparator.comparing(ch -> freqMap.get(ch), Collections.reverseOrder());
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(freqComparator);
        for (char ch : freqMap.keySet()) {
            maxHeap.add(ch);
        }
        String previous = null;
        while (!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();
            freqMap.put(ch, freqMap.get(ch) - 1);
            if(previous!=null){
                result.append(previous);
                if (freqMap.get(previous.charAt(0))> 0) {
                    maxHeap.add(previous.charAt(0));
                }
            }
            previous = String.valueOf(ch);
        }
        if(freqMap.get(previous.charAt(0))==0){
            return result.append(previous.charAt(0)).toString();
        }else{
            return "";
        }
    }
}
