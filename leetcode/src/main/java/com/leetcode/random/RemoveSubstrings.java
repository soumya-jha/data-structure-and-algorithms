package com.leetcode.random;

public class RemoveSubstrings {

    public int minLength(String s) {
        int idx = 0;
        StringBuilder sb = new StringBuilder(s);
        while (idx < sb.length() - 1) {
            if ((sb.charAt(idx) == 'A' && sb.charAt(idx + 1) == 'B') || sb.charAt(idx) == 'C' && sb.charAt(idx + 1) == 'D') {
                sb.replace(idx, idx + 2, "");
                if (idx != 0) {
                    idx--;
                }
            } else {
                idx++;
            }
        }
        return sb.length();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveSubstrings().minLength("ABFCACDB"));
        System.out.println(new RemoveSubstrings().minLength("ACBBD"));
    }

}
