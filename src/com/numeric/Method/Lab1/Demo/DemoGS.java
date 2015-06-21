package com.numeric.Method.Lab1.Demo;

import com.numeric.Method.Lab1.Jacobi.GaussSeidel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class DemoGS {
    public static void main(String[] args) throws IOException
    {
        int n;
        double[][] M;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out, true);

        System.out.println("Enter the number of variables in the equation:");
        n = Integer.parseInt(reader.readLine());
        M = new double[n][n+1];
        System.out.println("Enter the augmented matrix:");

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n + 1; j++)
                M[i][j] = scanner.nextDouble();
        }


        GaussSeidel gausSeidel = new GaussSeidel(M);

        if (!gausSeidel.makeDominant())
        {
            writer.println("The system isn't diagonally dominant: " +
                    "The method cannot guarantee convergence.");
        }

        writer.println();
        gausSeidel.print();
        gausSeidel.solve();
    }
}
