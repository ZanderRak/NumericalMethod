package com.numeric.Method.Lab3.Demo;

import com.numeric.Method.Lab3.InterpolationPolynomialNewton.InterpolationPolynomialNewton;

import java.util.Scanner;

public class DemoNewton {
    public static void main(String[] arg){
        InterpolationPolynomialNewton ipn = new InterpolationPolynomialNewton();
        Scanner sc = new Scanner(System.in);
        double[] xPoints = new double[5];
        double[] yPoints = new double[5];
        System.out.println("Ведите полином");
        for(int i =0; i < 5; i++){
            System.out.print("Ведите x" + i+1 + "=");
            xPoints[i] = sc.nextDouble();
            System.out.print("Ведите y"+ i+1 + "=");
            yPoints[i] = sc.nextDouble();
            System.out.println();
        }
        System.out.print("Введите контрольный X для проверки полинома: x=");
        double x = sc.nextDouble();
        System.out.print(ipn.newton(xPoints, yPoints, x));
    }
}
