package com.educative.grokking.fastandslowpointers;

public class HappyNumber {
    public static void main(String[] args) {

        System.out.println(HappyNumber.isHappyNumber(2));
        System.out.println(HappyNumber.isHappyNumber(13));
    }

    public static boolean isHappyNumber(int n) {
        if (n == 1) {
            return true;
        }
        int slow = n;
        int fast = sumOfSquares(n);
        while (fast != 1 && fast != slow) {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        }
        return fast == 1;
    }

    public static int sumOfSquares(int n) {
        if (n < 10) {
            return n * n;
        } else {
            int sum = 0;
            while (n > 0) {
                int rem = n % 10;
                sum += rem * rem;
                n = n / 10;
            }
            return sum;
        }
    }
}
