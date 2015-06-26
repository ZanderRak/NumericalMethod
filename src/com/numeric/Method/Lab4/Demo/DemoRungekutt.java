package com.numeric.Method.Lab4.Demo;


import com.numeric.Method.Lab4.RungeKutt.*;

import java.util.Scanner;

public class DemoRungekutt {
    public static void  main(String []args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите начало интервала:");
        double startInter = sc.nextDouble();
        System.out.println("Введите конец интервала:");
        double endIntervval = sc.nextDouble();
        System.out.println("Введите значение y в начальной точке:");
        double y0 = sc.nextDouble();
        RungeKutt rungeKutt = new RungeKutt(startInter, endIntervval, y0);
        for(double element : rungeKutt.solution()) {
            System.out.println(element);
        }
    }

}
