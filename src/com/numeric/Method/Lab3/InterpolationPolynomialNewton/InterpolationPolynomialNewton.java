package com.numeric.Method.Lab3.InterpolationPolynomialNewton;

public class InterpolationPolynomialNewton {
    public double newton(double[] xPoint, double[] yPoint, double x) {
        double res = yPoint[0], polymomial, den;
        int i, j, k;
        for (i = 1; i < xPoint.length; i++) {
            polymomial = 0;
            for (j = 0; j <= i; j++) {
            //следующее слагаемое полинома
                den = 1;
                //считаем знаменатель разделенной разности
                for (k = 0; k <= i; k++) {
                    if (k != j) den *= (xPoint[j] - xPoint[k]);
                }
                //считаем разделенную разность
                polymomial += yPoint[j] / den;
            }
                //домножаем разделенную разность на скобки (x-x[0])...(x-x[i-1])
                for (k = 0; k < i; k++) polymomial *= (x - xPoint[k]);
                 res += polymomial;//полином
        }
        return res;
    }
}
