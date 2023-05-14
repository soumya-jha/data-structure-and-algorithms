package com.leetcode.random;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        //cbacdcbc
        int[] lastIdx = new int[26]; // array to maintain the last occurrence of character in the input string
        for (int i = 0; i < s.length(); i++) {
            lastIdx[s.charAt(i) - 'a'] = i;
        }
        boolean[] visited = new boolean[26]; // array to store whether curr char is visited
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int currChar = s.charAt(i) - 'a';
            if (!visited[currChar]) {
                while (!stack.isEmpty() && stack.peek() > currChar && lastIdx[stack.peek()] > i) {
                    visited[stack.pop()] = false;
                }
                stack.push(currChar);
                visited[currChar] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append((char) (stack.pop() + 'a'));
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters rdl = new RemoveDuplicateLetters();
        System.out.println(rdl.removeDuplicateLetters("cbacdcbc"));
        System.out.println(rdl.removeDuplicateLetters("bcabc"));
    }
}
