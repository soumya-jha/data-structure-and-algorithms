package com.leetcode.top50;

public class AtoiStringToInteger {
    public int myAtoi(String s) {
        if (s == null) {
            return 0;
        }
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        boolean sign = true;
        int num = 0;
        int i = 0;
        if (s.charAt(i) == '-') {
            sign = false;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        for (; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                if (num > (Integer.MAX_VALUE - Character.getNumericValue(ch)) / 10) {
                    return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                num = num * 10 + Character.getNumericValue(ch);
            } else {
                break;
            }
        }
        return sign ? num : -num;
    }

    public static void main(String[] args) {
        AtoiStringToInteger atoi = new AtoiStringToInteger();

        System.out.println(atoi.myAtoi("42"));
        System.out.println(atoi.myAtoi("+-12"));
        System.out.println(atoi.myAtoi("    -42"));
        System.out.println(atoi.myAtoi("    -4193- with words"));
        System.out.println(atoi.myAtoi("    +4193- with words"));
        System.out.println(atoi.myAtoi("    -4193534536346636565 with words"));
        System.out.println(atoi.myAtoi("   4193534536346636565 with words"));
        System.out.println(atoi.myAtoi("-000000000000001"));
    }
}
