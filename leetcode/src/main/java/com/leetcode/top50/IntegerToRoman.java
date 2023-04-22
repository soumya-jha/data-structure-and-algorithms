package com.leetcode.top50;

public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        while (num > 0) {
            if (num >= 1000) {
                num = createRoman(num, 1000, roman);
            } else if (num >= 900) {
                num = createRoman(num, 900, roman);
            } else if (num >= 500) {
                num = createRoman(num, 500, roman);
            } else if (num >= 400) {
                num = createRoman(num, 400, roman);
            } else if (num >= 100) {
                num = createRoman(num, 100, roman);
            } else if (num >= 90) {
                num = createRoman(num, 90, roman);
            } else if (num >= 50) {
                num = createRoman(num, 50, roman);
            } else if (num >= 40) {
                num = createRoman(num, 40, roman);
            } else if (num >= 10) {
                num = createRoman(num, 10, roman);
            } else if (num == 9) {
                num = createRoman(num, 9, roman);
            } else if (num >= 5) {
                num = createRoman(num, 5, roman);
            } else if (num == 4) {
                num = createRoman(num, 4, roman);
            } else {
                num = createRoman(num, 1, roman);
            }
        }
        return roman.toString();
    }

    private int createRoman(int num, int divisor, StringBuilder roman) {
        int factor = num / divisor;
        num = num - (factor * divisor);
        String suffix = mapToRoman(divisor);
        while (factor > 0) {
            roman.append(suffix);
            factor--;
        }
        return num;
    }

    private String mapToRoman(int divisor) {
        if (divisor == 1000) {
            return "M";
        } else if (divisor == 900) {
            return "CM";
        } else if (divisor == 500) {
            return "D";
        } else if (divisor == 400) {
            return "CD";
        } else if (divisor == 100) {
            return "C";
        } else if (divisor == 90) {
            return "XC";
        } else if (divisor == 50) {
            return "L";
        } else if (divisor == 40) {
            return "XL";
        } else if (divisor == 10) {
            return "X";
        } else if (divisor == 9) {
            return "IX";
        } else if (divisor == 5) {
            return "V";
        } else if (divisor == 4) {
            return "IV";
        } else {
            return "I";
        }
    }

    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        System.out.println(integerToRoman.intToRoman(2500));
        System.out.println(integerToRoman.intToRoman(27));
        System.out.println(integerToRoman.intToRoman(3));
        System.out.println(integerToRoman.intToRoman(58));
        System.out.println(integerToRoman.intToRoman(1994));
    }
}
