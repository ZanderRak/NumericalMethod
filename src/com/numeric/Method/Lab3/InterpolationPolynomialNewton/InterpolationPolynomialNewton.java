package com.numeric.Method.Lab3.InterpolationPolynomialNewton;

public class InterpolationPolynomialNewton {
    public double newton(double[] xPoint, double[] yPoint, double x) {
        double approximation = yPoint[0];
        double sharedDifference = 0;
        double den;
        for (int i = 1; i < xPoint.length; i++) {
            for (int j = 0; j <= i; j++) {
                //следующее слагаемое полинома
                den = 1;
                //считаем знаменатель разделенной разности
                for (int k = 0; k <= i; k++) {
                    if (k != j) den *= (xPoint[j] - xPoint[k]);
                }
                //считаем разделенную разность
                sharedDifference += yPoint[j] / den;
            }
            //домножаем разделенную разность на скобки (x-x[0])...(x-x[i-1])
            for (int k = 0; k < i; k++) {
                sharedDifference *= (x - xPoint[k]);
            }
            approximation += sharedDifference;//полином
        }
        return approximation;
    }
}
