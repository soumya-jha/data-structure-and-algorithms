package com.leetcode.top50;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        if (s.equals(p))
            return true;
        if (s.isEmpty() || p.isEmpty())
            return false;
        int p1 = 0, p2 = 0;
        char prev = p.charAt(0);
        while (p1 < s.length() && p2 < p.length()) {
            if ((s.charAt(p1) == p.charAt(p2)) || p.charAt(p2) == '.') {
                prev = p.charAt(p2);
                p1++;
                p2++;
            } else if (p.charAt(p2) == '*') {
                if (prev == '.') {
                    p1++;
                } else if (prev == s.charAt(p1)) {
                    p1++;
                } else {
                    p2++;
                }
            } else if (p2 < p.length() - 1 && p.charAt(p2 + 1) == '*') {
                prev = p.charAt(p2);
                p2 = p2 + 2;
            } else {
                return false;
            }
        }
        if (p1 == s.length()) {
            if (p2 == p.length()) {
                return true;
            } else {
                while (p2 < p.length()) {
                    if (p.charAt(p2) != '*' && p.charAt(p2)!=s.charAt(p1-1)) {
                        return false;
                    }
                    p2++;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        RegularExpressionMatching rem = new RegularExpressionMatching();
        System.out.println(rem.isMatch("abb", "a*b*"));
        System.out.println(rem.isMatch("aa", "a"));
        System.out.println(rem.isMatch("aa", "a*"));
        System.out.println(rem.isMatch("ab", ".*"));
        System.out.println(rem.isMatch("aab", "c*a*b"));
        System.out.println(rem.isMatch("ab", ".*c"));
        System.out.println(rem.isMatch("aaa", "a*a"));
        System.out.println(rem.isMatch("aaa", "a*aaaa"));  //Not Working
        System.out.println(rem.isMatch("aaa", "aaaa")); //Not Working
    }
}
