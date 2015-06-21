package com.numeric.Method.Lab2.Demo;

import com.numeric.Method.Lab2.SimpleIteration.SimpleIteration;

import java.io.PrintWriter;
import java.util.Scanner;

public class DemoSimpleIteration{

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);
        System.out.println("Введите размер матрицы");
        int size = scanner.nextInt();
        double[][] matrix = new double[size][size + 1];
        System.out.println("Введите матрицу");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size + 1; j++) {
                System.out.println("Введите " + i + "" + j + "элемент");
                matrix[i][j] = scanner.nextDouble();
            }
        }
        double eps;
        System.out.println("Введите точность");
        eps = scanner.nextDouble();
        double[] previousVariableValues = new double[size];
        for (int i = 0; i < size; i++) {
            previousVariableValues[i] = 0.0;
        }
        SimpleIteration simpleIteration = new SimpleIteration();
        simpleIteration.solution(previousVariableValues, matrix, eps);

        System.out.println("Решение");
        for (int i = 0; i < size; i++) {
            printWriter.print(previousVariableValues[i] + " ");
        }
        scanner.close();
        printWriter.close();
    }
}
