package com.test.interview;

public class WoodenSticks {
    public static void main(String[] args) {
        System.out.println(findLargestSide(10, 21));
        System.out.println(findLargestSide(13, 11));
        System.out.println(findLargestSide(2, 1));
        System.out.println(findLargestSide(1, 8));
    }

    public static int findLargestSide(int A, int B) {
        // Implement your solution here
        //If length of both sticks are same, take @ parts from each stick and return
        if (A == B) {
            return A / 2;
        }
        int min = Math.min(A, B);
        int max = Math.max(A, B);
        //If 1/4th of length of max stick is greater than length of min stick, return max/4
        if (max / 4 >= min) {
            return max / 4;
        }
        int largest = 0; //store the length of the largest side of square
        //Case when three parts from max stick, and one part from min stick is taken
        if (max / 3 <= min) {
            largest = max / 3;
        } else if (max / 3 > min) {
            largest = min;
        }
        //Case when two parts from each stick is taken
        largest = Math.max(largest, min / 2);

        return largest;
    }
}
