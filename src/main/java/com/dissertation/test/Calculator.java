package com.dissertation.test;

public class Calculator {
    public int add(int a, int b) {
        int c = a + b;
        return c;
    }

    public int subtract(int a, int b) {
        int c = a - b;
        return c;
    }

    public int multiply(int a, int b) {
        int c =  a * b;
        return c;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        double c = a / b;
        return c;
    }

    public double squareRoot(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }
        double result = Math.sqrt(a);
        return result;
    }
    public int power(int base, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    public int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Cannot calculate factorial of a negative number");
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public double absoluteValue(double a) {
        if (a < 0) {
            return -a;
        }
        return a;
    }
}
