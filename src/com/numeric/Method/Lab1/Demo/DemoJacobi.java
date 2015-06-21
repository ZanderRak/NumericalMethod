package com.numeric.Method.Lab1.Demo;

import com.numeric.Method.Lab1.GaussSeidel.Jacobi;

import java.util.Scanner;

public class DemoJacobi {

    public static void main(String[] args) {
        Jacobi jacobi = new Jacobi();
        double matrix[][] = inputMatrix();
        double freeColumn[] = inputFreeColumn();
        double startApprox[] = inputStartApprox();
        double eps = inputEps();
        System.out.println("Исходное уравнение:");
        for(int i = 0; i < 4; i++){
            for (int j = 0; j <4; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.printf(" = "+freeColumn[i]);
            System.out.println();
        }
        System.out.println("Начальное приближение:");
        for (int i = 0; i < 4; i++){
            System.out.println(startApprox[i]);
        }
        System.out.println("Точность = " + eps);
        System.out.println("Начальное приближение:");
        for (int i = 0; i < 4; i++){
            System.out.println(jacobi.solution(matrix, freeColumn, startApprox, eps)[i]);
        }
    }
    private static double inputEps() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите eps:");
        return scanner.nextDouble();
    }
    private static double[] inputStartApprox() {
        Scanner scanner = new Scanner(System.in);
        double[] startApprox= new double[4];
        for (int i = 0; i < 4; i++){
            System.out.println("Введите "+ i+1 + " элемент уровнение:");
            startApprox[i] = scanner.nextDouble();
        }
        return startApprox;
    }
    private static double[] inputFreeColumn() {
        Scanner scanner = new Scanner(System.in);
        double[] freeColumn = new double[4];
        for (int i = 0; i < 4; i++){
            System.out.println("Введите "+ i+1 + " элемент столбца свободных чисел:");
            freeColumn[i] = scanner.nextDouble();
        }
        return freeColumn;
    }
    private static double[][] inputMatrix() {
        Scanner scanner = new Scanner(System.in);
        double matrix[][] = new double[4][4];
        for (int i = 0; i < 4; i++){
            for(int j =0; j < 4; j++){
                System.out.println("Введите элемент уровнение a" + (i+1) + "" + (j+1));
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return  matrix;
    }
}
