package com.leetcode.random;

public class Atoi {

    /*
     * Implement atoi which converts a string to an integer.
     *
     * The function first discards as many whitespace characters as necessary until
     * the first non-whitespace character is found. Then, starting from this
     * character, takes an optional initial plus or minus sign followed by as many
     * numerical digits as possible, and interprets them as a numerical value.
     *
     * The string can contain additional characters after those that form the
     * integral number, which are ignored and have no effect on the behavior of this
     * function.
     *
     * If the first sequence of non-whitespace characters in str is not a valid
     * integral number, or if no such sequence exists because either str is empty or
     * it contains only whitespace characters, no conversion is performed.
     *
     * If no valid conversion could be performed, a zero value is returned.
     *
     * Note:
     *
     * Only the space character ' ' is considered as whitespace character. Assume we
     * are dealing with an environment which could only store integers within the
     * 32-bit signed integer range . If the numerical value is out
     * of the range of representable values, INT_MAX  or INT_MIN  is
     * returned.
     */

    /*
     * Example 1:
     *
     * Input: "42" Output: 42 Example 2:
     *
     * Input: "   -42" Output: -42 Explanation: The first non-whitespace character
     * is '-', which is the minus sign. Then take as many numerical digits as
     * possible, which gets 42. Example 3:
     *
     * Input: "4193 with words" Output: 4193 Explanation: Conversion stops at digit
     * '3' as the next character is not a numerical digit. Example 4:
     *
     * Input: "words and 987" Output: 0 Explanation: The first non-whitespace
     * character is 'w', which is not a numerical digit or a +/- sign. Therefore no
     * valid conversion could be performed. Example 5:
     *
     * Input: "-91283472332" Output: -2147483648 Explanation: The number
     * "-91283472332" is out of the range of a 32-bit signed integer. Thefore
     * INT_MIN
     */

    public static void main(String[] args) {
        Atoi solution = new Atoi();
        int integerConversion = solution.myAtoi("2147483647 ");
        System.out.println(integerConversion);
    }

    public int myAtoi(String str) {
        if (str == null)
            return 0;
        str = str.trim();
        if (str.equals(""))
            return 0;
        int integerConversion = 0;
        boolean sign = true; // positive sign
        int firstElement = str.charAt(0);
        try {
            if (firstElement == 43 || firstElement == 45 || (firstElement >= 48 && firstElement <= 57)) {
                if (firstElement == 43 || firstElement == 45) {
                    int secondElement = str.charAt(1);
                    if (secondElement < 48 || secondElement > 57) {
                        return 0;
                    }
                    if (firstElement == 45)
                        sign = false;
                    str = str.substring(1);
                }
                char[] charArray = str.toCharArray();
                for (char charElement : charArray) {
                    int element = charElement;
                    if (element < 48 || element > 57)
                        break;
                    integerConversion = Math.addExact(Math.multiplyExact(integerConversion, 10),
                            Integer.parseInt(String.valueOf(charElement)));
                }
                if (!sign)
                    integerConversion = integerConversion * -1;
            } else
                return 0;
        } catch (StringIndexOutOfBoundsException sIOBEx) {
            System.out.println("No second character found after sign");
            return 0;
        } catch (ArithmeticException aEx) {
            System.out.println("32-bit overflow");
            if (sign)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }
        return integerConversion;
    }
}
