package org.techinterviewhandbook.grind75;

import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return -1;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) { // to check positive integer
                stack.push(Integer.parseInt(token));
            } else if (token.length() > 1) { //to check negative integers
                stack.push(Integer.parseInt(token));
            } else { //must be an operator
                int one, two;
                if (!stack.isEmpty())
                    two = stack.pop();
                else
                    return -1; //Invalid expression
                if (!stack.isEmpty())
                    one = stack.pop();
                else
                    return -1; //Invalid expression
                int total = 0;
                switch (token.charAt(0)) {
                    case '+' -> total = one + two;
                    case '-' -> total = one - two;
                    case '/' -> {
                        if (two == 0) // Handle divide by zero cases
                            return -1;
                        total = one / two;
                    }
                    case '*' -> total = one * two;
                }
                stack.push(total);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(new ReversePolishNotation().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(new ReversePolishNotation().evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(new ReversePolishNotation().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
        //Error scenarios
        System.out.println(new ReversePolishNotation().evalRPN(null));
        System.out.println(new ReversePolishNotation().evalRPN(new String[]{"2", "1", "+", "*"}));
        System.out.println(new ReversePolishNotation().evalRPN(new String[]{"2", "1", "+", "3", "*", "0", "/"}));
    }
}
