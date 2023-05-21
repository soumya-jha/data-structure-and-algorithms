package org.techinterviewhandbook.grind75;

public class PhrasePalindrome {
    public boolean isPalindrome2(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        int start = 0, end = sb.length() - 1;
        while (start < end) {
            if (sb.charAt(start++) != sb.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else {
                if (Character.toLowerCase(s.charAt(start++)) != Character.toLowerCase(s.charAt(end--))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PhrasePalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new PhrasePalindrome().isPalindrome("race a car"));
        System.out.println(new PhrasePalindrome().isPalindrome(" "));
    }
}
