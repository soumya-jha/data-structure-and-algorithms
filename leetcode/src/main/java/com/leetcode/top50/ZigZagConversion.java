package com.leetcode.top50;

public class ZigZagConversion {

    //Incomplete
    public String convert(String s, int numRows) {
        if (numRows == 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        /*
        numRows - no of char to skip while reading
        1 - skip 0
        2 - skip 1
        3 - skip 3
        4 - skip 5
        5 - Skip 7
        6 - skip 9
        which becomes and odd number series (2n - 1).
        */
        StringBuilder result = new StringBuilder();
        boolean[] arr = new boolean[s.length()];
        int skip = 2 * (numRows - 1);
        int currSkip = skip;
        boolean vertical;

        for (int i = 0; i < skip; i++) {
            int pos = i;
            vertical = true;
            if (i == numRows - 1) {
                currSkip = skip;
            }
            while (pos < s.length() && !arr[pos]) {
                result.append(s.charAt(pos));
                arr[pos] = true;
                if (i == 0 || i == numRows - 1 || vertical) {
                    pos = pos + currSkip;
                    vertical = false;
                } else {
                    while (pos < s.length() && arr[pos]) {
                        pos = pos + 1;
                    }
                    vertical = true;
                }
            }
            currSkip = currSkip - 2;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion zigzag = new ZigZagConversion();
        System.out.println(zigzag.convert("PAYPALISHIRING", 3));
        System.out.println(zigzag.convert("PAYPALISHIRING", 4));
    }
}
