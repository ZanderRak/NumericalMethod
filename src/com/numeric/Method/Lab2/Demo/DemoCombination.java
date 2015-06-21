package com.numeric.Method.Lab2.Demo;

import com.numeric.Method.Lab2.Combination.Combination;

import java.util.Scanner;

/**
 * Created by Alexander on 6/20/2015.
 */
public class DemoCombination {
    public static void main(String [] args) {
        Combination combination = new Combination();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите начало интервала");
        double a = sc.nextDouble();
        System.out.println("Введите конец интервала");
        double b = sc.nextDouble();
        System.out.println("Введите шаг");
        double eps = sc.nextDouble();
        System.out.print(combination.solution(a, b, eps));
    }
}
