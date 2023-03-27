package com.udemy.masterthecodinginterview.dataStructures.arrays;

public class ReverseAString {

    public static void main(String[] args) {
        String revStr;
        revStr = reverse("hey1234");
        //revStr=reverse(null);
        //revStr=reverse("");
        //revStr=reverse("A");
        System.out.println(revStr);
    }

    public static String reverse(String s) {
        if (s == null || "".equals(s) || s.length() < 2) {
            return s;
        }
        char[] strArr;
        strArr = s.toCharArray();
        int idx = strArr.length - 1;
        int i = 0;
        while (i < idx) {
            char temp = strArr[i];
            strArr[i] = strArr[idx];
            strArr[idx] = temp;
            i++;
            idx--;
        }
        return String.valueOf(strArr);
    }
}
