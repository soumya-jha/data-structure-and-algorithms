package com.educative.grokking.stacks;

import java.util.Stack;

class Pair {
    char ch;
    int idx;

    public Pair(char ch, int idx) {
        this.ch = ch;
        this.idx = idx;
    }
}

public class RemoveParentheses {
    public static void main(String[] args) {
        System.out.println(removeMinParentheses("ar)ab(abc)abd("));
    }

    public static String removeMinParentheses(String s) {
        StringBuilder output = new StringBuilder(s);
        Stack<Pair> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(new Pair('(', i));
            } else if (chars[i] == ')') {
                if (stack.isEmpty() || stack.peek().ch != '(') {
                    stack.push(new Pair(')', i));
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop().idx;
            output.replace(idx, idx + 1, "");
        }
        return output.toString();
    }
}
