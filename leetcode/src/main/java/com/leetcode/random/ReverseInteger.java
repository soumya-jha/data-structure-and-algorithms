package com.leetcode.random;

/**
 * Given a 32-bit signed integer, reverse digits of an integer. Note : Assume we
 * are dealing with an environment which could only store integers within the
 * 32-bit signed integer range. For the purpose of this problem, assume that
 * your function returns 0 when the reversed integer overflows.
 */

public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int reverse = reverseInteger.reverse(-1236756767);
        System.out.println(reverse);
    }

    public int reverse(int x) {
        int xRev = 0;
        int temp;
        boolean sign = false;
        if (x % 10 == x) {
            xRev = x;
        } else {
            if (x < 0) {
                sign = true;
                x = x * (-1);
            }
            while (x > 0) {
                temp = x % 10;
                try {
                    xRev = Math.addExact(Math.multiplyExact(xRev, 10), temp);
                } catch (ArithmeticException aEx) {
                    System.out.println("Exception occurred");
                    return 0;
                }
                x = x / 10;
            }
            if (sign)
                xRev = xRev * (-1);
        }
        return xRev;
    }
}
