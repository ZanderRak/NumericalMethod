package com.numeric.Method.Lab2.Combination;

public class Combination {
    private double function(double x) {
        return Math.pow(x, 3) + Math.pow(x, 2) + 3;
    }

    private double dxFunction(double x) {
        return 3 * Math.pow(x, 2) + 2 * x;
    }

    public double solution(double a, double b, double eps) {
        double x0 = a;
        double x11;
        double x12;
        double tmpEps;
        if (function(a) * function(b) > 0) {
            return Double.POSITIVE_INFINITY;
        } else {
            x11 = x0 - function(x0) / dxFunction(x0);
            x12 = a - (((b - a) * function(a)) / (function(b) - function(a)));
        do {
                a = x11;
                b = x12;
                x11 = a - function(a) / dxFunction(a);
                x12 = a - ((b - a) * function(a) / function(b) - function(a));
                tmpEps = (x11 + x12) / 2;
            }
            while (Math.abs(tmpEps - x11) > eps);
        }
        return x11;
    }
}

