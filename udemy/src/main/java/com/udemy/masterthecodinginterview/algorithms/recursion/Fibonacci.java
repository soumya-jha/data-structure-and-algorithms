package com.udemy.masterthecodinginterview.algorithms.recursion;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.fibonacciIterative(8));
        System.out.println(f.fibonacciRecursive(8));
    }

    public int fibonacciIterative(int n) { //O(n)
        int fib = 0;
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            int a = 1, b = 1;
            int count = 3;
            while (count <= n) {
                fib = a + b;
                a = b;
                b = fib;
                count++;
            }
            return fib;
        }
    }

    public int fibonacciRecursive(int n) { //O(2^n) --- hence not an ideal solution
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }
    }
}
