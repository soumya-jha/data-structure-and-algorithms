package com.test;

import java.util.HashMap;

/**
 * You are given a dictionary of words and a large input string. You have to find out whether the input string can be completely
 * segmented into the words of a given dictionary. The following two examples elaborate on the problem further.
 */

class TrieNode{
    HashMap<Character, TrieNode> node;
    boolean isWord;

    TrieNode(){
        node = new HashMap<>();
        isWord = false;
    }
}

public class StringSegmentation {

    public static void main(String[] args) {
        String[] words = {"apple", "pen"};
        System.out.println(solve("applepenapple", words));

        System.out.println(solve("applepenaaapple", words));
    }

    public static boolean solve(String s, String[] words){

        TrieNode node = new TrieNode();
        TrieNode currentNode;

        for(String word : words){
            currentNode = node;
            for(int i=0; i< word.length(); i++){
                char ch = word.charAt(i);
                if(!currentNode.node.containsKey(ch)){
                    currentNode.node.put(ch, new TrieNode());
                }
                currentNode = currentNode.node.get(ch);
            }
            currentNode.isWord = true;
        }

        currentNode = node;
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(!currentNode.node.containsKey(ch)){
                return false;
            }
            currentNode=currentNode.node.get(ch);
            if(currentNode.isWord){
                currentNode=node;
            }
        }
        return true;
    }


}
