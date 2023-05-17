package com.gayle.arraysandstrings;

public class StringCompression {
    private String getCompressedString(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        char currChar = str.charAt(0);
        StringBuilder result = new StringBuilder();
        int currCount = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == currChar) {
                currCount++;
                continue;
            }
            result.append(currChar).append(currCount);
            currChar = str.charAt(i);
            currCount = 1;
        }
        result.append(currChar).append(currCount);
        return result.length()<str.length() ? result.toString() : str;
    }

    public static void main(String[] args) {
        StringCompression strComp = new StringCompression();
        System.out.println("aabcccccaaa : " + strComp.getCompressedString("aabcccccaaa"));
        System.out.println("abcde : " + strComp.getCompressedString("abcde"));
        System.out.println("aabbccdd : " + strComp.getCompressedString("aabbccdd"));
    }
}
