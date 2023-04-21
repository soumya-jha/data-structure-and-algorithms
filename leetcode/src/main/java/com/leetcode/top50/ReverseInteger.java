package com.leetcode.top50;

public class ReverseInteger {

    public int reverse(int x) {

        int reverse = 0;
        while(x!=0){
            int rem = x%10;
            if (reverse > 0 && reverse > (Integer.MAX_VALUE-rem)/10){
                return 0;
            }
            if (reverse < 0 && reverse < (Integer.MIN_VALUE - rem) / 10) {
                return 0;
            }
            reverse = reverse*10 + rem;
            x= x/10;
        }
        return reverse;
    }

    public static void main(String[] args) {
        ReverseInteger rev = new ReverseInteger();
        System.out.println(rev.reverse(321));
        System.out.println(rev.reverse(-321));
        System.out.println(rev.reverse(Integer.MIN_VALUE));
        System.out.println(rev.reverse(Integer.MAX_VALUE));
    }
}
