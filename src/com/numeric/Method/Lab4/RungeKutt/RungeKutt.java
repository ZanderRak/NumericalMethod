package com.numeric.Method.Lab4.RungeKutt;


public class RungeKutt {
    //шаг
    private static  final double STEP = 0.1;

    private  double y0;
    //начало интевала
    private double startInterval;
    //конец интервала
    private double endInterval;

    public RungeKutt(double startInterval, double endInterval, double y0){

        this.startInterval = startInterval;
        this.endInterval = endInterval;
        this.y0 = y0;

    }

    // Производная
    private static double derivative(double x, double y)
    {
        return 0.218*(Math.pow(x,2) + Math.sin(1.6*x))+0.718*y;
    }

    //высчитываем k1 - нужна ниже
    double k1(double x, double y){
        return derivative(x, y);
    }

    //высчитываем k2 - нужна ниже
    double k2(double x, double y){
        return derivative(x+(STEP/2), y + (STEP/2)*k1(x, y));
    }

    //высчитываем k3 - нужна ниже
    double k3(double x, double y){
        return derivative(x+(STEP/2), y + (STEP/2)*k2(x, y));
    }

    //высчитываем k4 - нужна ниже
    double k4(double x, double y){
        return derivative(x+STEP, y + STEP*k3(x, y));
    }

    public double[] solution(){
        // значение y0 = f(x0)
        double []newY = new double[11]; //когда будет время сделать нормально
        int i = 0;
        //первое приближение мы знаем ложим оно равно y0
        newY[0] = y0;

        // по формуле высчитываем приближение
        for(double start = startInterval; start < endInterval; start+=STEP) {
           newY[i+1] = newY[i] + (STEP/6) * (k1(start, newY[i]) + 2 * k2(start, newY[i])  +
                    2 * k3(start, newY[i]) + k4(start, newY[i]));
            i++;
        }
        return  newY;// приближенные значение y на интевали [а;b] с шагом STEP
   }
}
