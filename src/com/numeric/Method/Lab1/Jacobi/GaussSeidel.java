package com.numeric.Method.Lab1.Jacobi;

import java.util.Arrays;

public class GaussSeidel {
    public static final int MAX_ITERATIONS = 1000;
    private double[][] matrix;
    public GaussSeidel(double[][] matrix) {
        this.matrix = matrix;
    }

    public void print() {
        for (double[] matrixElement : matrix) {
            for (int j = 0; j < matrix.length + 1; j++)
                System.out.print(matrixElement[j] + " ");
            System.out.println();
        }
    }

    public boolean transformToDominant(int r, boolean[] V, int[] R) {
        if (r == matrix.length) {
            double[][] matrixTransposable = new double[matrix.length][matrix.length + 1];
            for (int i = 0; i < R.length; i++) {
                System.arraycopy(matrix[R[i]], 0, matrixTransposable[i], 0, matrix.length + 1);
            }
            matrix = matrixTransposable;
            return true;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (V[i]) continue;
            double sum = 0;
            for (int j = 0; j < matrix.length; j++)
                sum += Math.abs(matrix[i][j]);

            if (2 * Math.abs(matrix[i][r]) > sum) { // diagonally dominant?
                V[i] = true;
                R[r] = i;

                if (transformToDominant(r + 1, V, R))
                    return true;
                V[i] = false;
            }
        }
        return false;
    }

    public boolean makeDominant() {
        boolean[] visited = new boolean[matrix.length];
        int[] rows = new int[matrix.length];

        Arrays.fill(visited, false);

        return transformToDominant(0, visited, rows);
    }

    public void solve() {
        int iterations = 0;
        int n = matrix.length;
        double epsilon = 0.1;
        double[] approximations = new double[n]; // Approximations
        double[] prev = new double[n]; // Prev
        Arrays.fill(approximations, 0);

        while (true) {
            for (int i = 0; i < n; i++) {
                double sum = matrix[i][n]; // b_n

                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum -= matrix[i][j] * approximations[j];
                    }
                }
                // Update x_i to use in the next row calculation
                approximations[i] = 1 / matrix[i][i] * sum;
            }

            System.out.print("X_" + iterations + " = {");

            for (int i = 0; i < n; i++) {
                System.out.print(approximations[i] + " ");
            }

            System.out.println("}");

            iterations++;
            if (iterations == 1) {
                continue;
            }

            boolean stop = true;
            for (int i = 0; i < n && stop; i++) {
                if (Math.abs(approximations[i] - prev[i]) > epsilon) {
                    stop = false;
                }
            }

            if (stop || iterations == MAX_ITERATIONS) {
                break;
            }
            prev = approximations.clone();
        }
    }
}
