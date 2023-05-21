package org.techinterviewhandbook.grind75;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '{', '(', '[' -> stack.push(ch);
                case '}' -> {
                    if (stack.isEmpty() || stack.pop() != '{')
                        return false;
                }
                case ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[')
                        return false;
                }
                default -> {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("()[]{}"));
        System.out.println(new ValidParentheses().isValid("(]"));
        System.out.println(new ValidParentheses().isValid("({["));
    }
}
