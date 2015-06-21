package com.numeric.Method.Lab3.InterpolationPolynomNuton;

public class InterpolationPolynomNuton {
    public double nuton(double[] xPoint, double[] yPoint, double x) {
        double res = yPoint[0], F, den;
        int i, j, k;
        for (i = 1; i < xPoint.length; i++) {
            F = 0;
            for (j = 0; j <= i; j++) {
            //следующее слагаемое полинома
                den = 1;
                //считаем знаменатель разделенной разности
                for (k = 0; k <= i; k++) {
                    if (k != j) den *= (xPoint[j] - xPoint[k]);
                }
                //считаем разделенную разность
                F += yPoint[j] / den;
            }
                //домножаем разделенную разность на скобки (x-x[0])...(x-x[i-1])
                for (k = 0; k < i; k++) F *= (x - xPoint[k]);
                 res += F;//полином
        }
        return res;
    }
}
