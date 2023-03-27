package com.udemy.masterthecodinginterview.algorithms.recursion;

//Reverse a string using recursion
public class ReverseString {
    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        System.out.println(rs.reverseString("hello"));
        System.out.println(rs.reverseString("yoyo mastery"));
    }

    public String reverseString(String s) {
        int length = s.length();
        if (length == 1) {
            return s;
        } else {
            //return s.substring(length - 1) + reverseString(s.substring(0, length - 1));
            //or
            return reverseString(s.substring(1)) + s.charAt(0);
        }
    }
}
