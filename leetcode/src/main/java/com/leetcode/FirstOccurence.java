package com.leetcode;

public class FirstOccurence {
    public static void main(String[] args) {
        FirstOccurence fo = new FirstOccurence();
        System.out.println(fo.strStr("fadbutsad", "mad"));

        System.out.println(fo.strStr2("fadbutsad", "mad"));

    }

    public int strStr(String haystack, String needle) {
        int nedLength = needle.length();
        char[] arr = haystack.toCharArray();
        String match = "";
        int first = 0;
        for (int second = 0; second < arr.length; second++) {
            match += arr[second];
            if (second >= nedLength - 1) {
                if (match.equals(needle)) {
                    return first;
                } else {
                    match = match.substring(1);
                    first++;
                }
            }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        int nedLength = needle.length();
        for(int i=0,j=nedLength; j<=haystack.length();j++,i++){
            if(haystack.substring(i,j).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
