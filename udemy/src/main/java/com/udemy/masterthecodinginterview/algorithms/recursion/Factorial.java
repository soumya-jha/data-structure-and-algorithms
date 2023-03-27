package com.udemy.masterthecodinginterview.algorithms.recursion;

public class Factorial {
    public static void main(String[] args) {
        Factorial f = new Factorial();
        System.out.println(f.findFactorialIterative(5));
        System.out.println(f.findFactorialRecursive(5));
    }

    public int findFactorialIterative(int n) {
        int fact = 1;
        while (n > 1) {
            fact = fact * n;
            n--;
        }
        return fact;
    }

    public int findFactorialRecursive(int n) {
        if (n > 1) {
            return n * findFactorialRecursive(n - 1);
        }
        return 1;
    }
}
