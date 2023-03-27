package com.educative.grokking.twopointers;

import java.util.HashSet;
import java.util.Set;

public class ValidPalindromeII {

    public static int skipCount = 0;

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.contains(5);
        System.out.println(ValidPalindromeII.isPalindrome("madame"));
    }
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left) == s.charAt(right)){
                left++;right--;
            }else if(skipCount == 0){
                skipCount++;
                if(right-left == 1){
                    return true;
                }else if(right-left>1){
                    boolean check = isPalindrome(s.substring(left, right));
                    if(check){
                        return check;
                    }else{
                        return isPalindrome(s.substring(left+1, right+1));
                    }
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
