package com.numeric.Method.Lab2.Combination;

public class Combination {
    private double function(double x) {
        return Math.exp(-x)-Math.log10(x);
    }

    private double dxFunction(double x) {
        return 3 * Math.pow(x, 2) + 2 * x;
    }

    public double solution(double a, double b, double eps) {
        double x0 = a;
        double tmpXfirst;
        double tmpXsecond;
        double tmpEps;
        if (function(a) * function(b) > 0) {
           // если нет решение
            return Double.POSITIVE_INFINITY;
        } else {
            tmpXfirst = x0 - function(x0) / dxFunction(x0);
            tmpXsecond = a - (((b - a) * function(a)) / (function(b) - function(a)));
        do {
                a = tmpXfirst;
                b = tmpXsecond;
                tmpXfirst = a - function(a) / dxFunction(a);
                tmpXsecond = a - ((b - a) * function(a) / function(b) - function(a));
                tmpEps = (tmpXfirst + tmpXsecond) / 2;
            }
            while (Math.abs(tmpEps - tmpXfirst) > eps);
        }
        return tmpXsecond;
    }
}

