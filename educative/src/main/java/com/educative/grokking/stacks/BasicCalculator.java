package com.educative.grokking.stacks;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        System.out.println("8 - 5 + (19 - 11) + 6 + (10 + 3) : " + calculator("8-5+(19-11)+6+(10+3)"));
        System.out.println("40 - 25 - 5 : " + calculator("40-25-5"));

    }

    public static int calculator(String expression) {
        int result = 0;
        int num = 0;
        int sign = 1; //1 for positive, -1 for negative
        Stack<Integer> stack = new Stack<>();
        for (char ch : expression.toCharArray()) {
            //if digit, build the number, store in num
            if (Character.isDigit(ch)) {
                num = num * 10 + Character.getNumericValue(ch);
            }
            //if sign, evaluate left side of expression, store in result, update sign value for next number
            else if (ch == '+' || ch == '-') {
                result += num * sign;
                num = 0;
                if (ch == '-') {
                    sign = -1;
                } else {
                    sign = 1;
                }
            }
            //if '(', push the current value to stack, then push the sign value to stack
            else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }
            //if ')', pop the sign value, multiply to current value, pop the integer value, add to current value
            else if (ch == ')') {
                result += num * sign;
                num = 0;
                sign = 1;
                result = result * stack.pop() + stack.pop();
            }
        }
        return result + (sign * num);
    }
}
