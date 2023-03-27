package com.udemy.masterthecodinginterview.dataStructures.arrays;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "[]";
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid(s));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else {
                if (!stack.empty()) {
                    if (ch == '}' && stack.pop() != '{') {
                        return false;
                    } else if (ch == ']' && stack.pop() != '[') {
                        return false;
                    } else if (ch == ')' && stack.pop() != '(') {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }
}