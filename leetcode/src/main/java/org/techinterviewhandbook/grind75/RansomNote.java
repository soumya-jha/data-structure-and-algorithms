package org.techinterviewhandbook.grind75;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length()<ransomNote.length())
            return false;
        int[] chars = new int[26];
        for(int i=0; i<magazine.length();i++){
            chars[magazine.charAt(i) - 'a']++;
        }
        for(int i=0; i<ransomNote.length();i++){
            chars[ransomNote.charAt(i) - 'a']--;
            if(chars[ransomNote.charAt(i) - 'a']<0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new RansomNote().canConstruct("aa", "aab"));
    }
}
