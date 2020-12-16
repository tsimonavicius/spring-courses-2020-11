package com.codeacademy.eshop;

public class Factorial {
    public static int factorial(int param) {

        if (param < 0) {
            throw new IllegalArgumentException();
        }

        if (param == 0) {
            return 1;
        }

        int x = param;

        for (int i = 1; i < param; i++) {
            x *= i;
        }

        return x;
    }
}
