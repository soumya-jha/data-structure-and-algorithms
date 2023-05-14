package com.leetcode.random;

public class DivideTwoIntegers {

    public static void main(String[] args) {

        int quotient = new DivideTwoIntegers().divide(-2147483648, 1);
        System.out.println("Quotient : " + quotient);
    }

    public int divide(int dividend, int divisor) {
        int sign;
        if (dividend > 0 && divisor > 0) {
            sign = 1;
        } else if (dividend < 0 && divisor < 0) {
            sign = 1;
        } else {
            sign = -1;
        }
        if (dividend == Integer.MIN_VALUE) {
            if (sign == 1)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }
        int quotient = 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend >= divisor) {
            dividend = dividend - divisor;
            quotient++;
        }
        if (sign == 1)
            return quotient;
        else
            return -quotient;
    }
}
