package com.google.techdevguide;

import java.util.Stack;

public class Decompression {
    public static void main(String[] args) {
        System.out.println(deCompressString("3[abc]4[ab]c"));
        System.out.println(deCompressString("2[3[a]b]"));
        System.out.println(deCompressString("b10[a]b"));

    }

    public static String deCompressString(String str) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int open = 0, num = 0;
        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = (num*10) + Character.getNumericValue(ch);
            } else if (ch !='[' &&ch !=']'){
                if (open > 0) {
                    sb.append(ch);
                } else {
                    result.append(ch);
                }
            }else if (ch =='['){
                open++;
                stack.push(num);
                num=0;
            }else if (ch ==']'){
                open--;
                int n = stack.pop();
                String temp = sb.toString();
                while (n > 1) {
                    sb.append(temp);
                    n--;
                }
                if (open == 0) {
                    result.append(sb);
                    sb.delete(0, sb.length());
                }
            }
        }
        return result.toString();
    }

}
