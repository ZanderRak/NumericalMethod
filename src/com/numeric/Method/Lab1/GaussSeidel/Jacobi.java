package com.numeric.Method.Lab1.GaussSeidel;

public class Jacobi {
    public double[] solution(double[][] matrix, double[] freeColumn, double[] startApprox, double EPS) {
        double[] tempX = new double[freeColumn.length];
        double norm;

        do {
            for (int i = 0; i < freeColumn.length; i++) {
                tempX[i] = freeColumn[i];
                for (int j = 0; j < freeColumn.length; j++) {
                    if (i != j) {
                        tempX[i] -= matrix[i][j] * startApprox[j];
                    }
                }
                tempX[i] /= matrix[i][i];
            }
            norm = Math.abs(startApprox[0] - tempX[0]);
            for (int i = 0; i < freeColumn.length; i++) {
                if (Math.abs(startApprox[i] - tempX[i]) > norm) {
                    norm = Math.abs(startApprox[i] - tempX[i]);
                }
                startApprox[i] = tempX[i];

            }
        } while (norm > EPS);
        return startApprox;
    }
}
