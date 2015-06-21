package com.numeric.Method.Lab2.SimpleIteration;

public class SimpleIteration {
    public double[] solution(double[] previousVariableValues, double[][] matrix, double eps) {
        while (true) {
            // Введем вектор значений неизвестных на текущем шаге
            double[] currentVariableValues = new double[previousVariableValues.length];

            // Посчитаем значения неизвестных на текущей итерации
            // в соответствии с теоретическими формулами
            for (int i = 0; i < previousVariableValues.length; i++) {
                // Инициализируем i-ую неизвестную значением
                // свободного члена i-ой строки матрицы
                currentVariableValues[i] = matrix[i][previousVariableValues.length];

                // Вычитаем сумму по всем отличным от i-ой неизвестным
                for (int j = 0; j < previousVariableValues.length; j++) {
                    if (i != j) {
                        currentVariableValues[i] -= matrix[i][j] * previousVariableValues[j];
                    }
                }

                // Делим на коэффициент при i-ой неизвестной
                currentVariableValues[i] /= matrix[i][i];
            }

            // Посчитаем текущую погрешность относительно предыдущей итерации
            double error = 0.0;

            for (int i = 0; i < previousVariableValues.length; i++) {
                error += Math.abs(currentVariableValues[i] - previousVariableValues[i]);
            }

            // Если необходимая точность достигнута, то завершаем процесс
            if (error < eps) {
                break;
            }

            // Переходим к следующей итерации, так
            // что текущие значения неизвестных
            // становятся значениями на предыдущей итерации
            previousVariableValues = currentVariableValues;
        }
        return previousVariableValues;
    }
}

