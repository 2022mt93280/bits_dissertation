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
}
