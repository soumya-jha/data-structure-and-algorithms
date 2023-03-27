package com.educative.grokking.twopointers;

import java.util.Arrays;
import java.util.StringJoiner;

public class ReverseWordsInString {

    public static void main(String[] args) {
        //Original implementation
        System.out.println(ReverseWordsInString.reverseWords("We love      Java"));
        //OR
        //Implementation using StringBuilder
        System.out.println(ReverseWordsInString.reverseWords2("We love      Java"));
        //OR
        //Implementation using reverse iteration in String array of words
        System.out.println(ReverseWordsInString.newReverse("We love      Java"));
        //OR
        System.out.println(ReverseWordsInString.newReverse2("We love      Java"));
    }

    public static String reverseWords(String sentence) {
        sentence = sentence.trim().replaceAll("\\s+", " ");
        sentence = ReverseWordsInString.reverseString(sentence) + " ";
        int start = 0;
        int end = 0;
        while (end < sentence.length()) {
            if (sentence.charAt(end) == ' ') {
                String revWord = ReverseWordsInString.revWords(start, end, sentence);
                sentence = sentence.substring(0, start) + revWord + sentence.substring(end);
                end++;
                start = end;
            } else {
                end++;
            }
        }
        return sentence;
    }

    public static String revWords(int start, int end, String sentence) {
        return ReverseWordsInString.reverseString(sentence.substring(start, end));
    }

    public static String reverseString(String sentence) {
        int i = 0;
        int j = sentence.length() - 1;
        char[] arr = sentence.toCharArray();
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(arr);
    }

    //Implementation using reverse iteration in String array of words
    public static String newReverse(String sentence) {
        sentence = sentence.trim().replaceAll("\\s+", " ");
        String[] arr = sentence.split("\\s+");
        System.out.println(Arrays.toString(arr));
        StringJoiner joiner = new StringJoiner(" ");
        for (int i = arr.length - 1; i >= 0; i--) {
            joiner.add(arr[i]);
        }
        return joiner.toString();
    }


    //Implementation using StringBuilder
    public static String reverseWords2(String sentence) {
        //Trim start and end whitespace and replace multiple space in between sentence with single space
        sentence = sentence.trim().replaceAll("\\s+", " ");
        StringBuilder str = new StringBuilder(" " + sentence);
        str = str.reverse();
        int start = 0;
        int end = 0;
        while (end < str.length()) {
            if (str.charAt(end) == ' ') {
                //Reverse every word
                String revWord = ReverseWordsInString.reverse(start, end, str);
                str = str.replace(start, end, revWord); //Replace current word with its reversed word
                start = end + 1;
            }
            end++;
        }
        return str.substring(0, str.length() - 1); // Remove last space in the end and return result
    }

    public static String reverse(int start, int end, StringBuilder str) {
        return new StringBuilder(str.substring(start, end)).reverse().toString();
    }

    public static String newReverse2(String s){
        s = s.trim().replaceAll("\\s+", " ");
        String[] arr = s.split("\\s+");
        int start =0, end = arr.length-1;
        while(start<end){
            String temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++; end--;
        }
        return Arrays.toString(arr);
    }

}
