package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        List<Double> doubleList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        for (int i = 10; i > 0; i--) {
            doubleList.add((double)i);
            integerList.add(i);
        }

        System.out.printf("doubleSum=%.2f\n", calc.sum(doubleList));
        System.out.printf("integerSum=%.0f\n", calc.sum(integerList));

        System.out.printf("doubleMultiplication=%.2f\n", calc.multiplication(doubleList));
        System.out.printf("integerMultiplication=%.0f\n", calc.multiplication(integerList));

        System.out.printf("doubleDivision=%.9f\n", calc.division(doubleList));
        System.out.printf("integerDivision=%.9f\n", calc.division(integerList));

        System.out.println("doubleToBinary: " + calc.toBinary(doubleList));
        System.out.println("integerToBinary: " + calc.toBinary(integerList));
    }
}