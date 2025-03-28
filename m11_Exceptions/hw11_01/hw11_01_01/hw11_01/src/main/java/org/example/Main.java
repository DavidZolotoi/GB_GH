package org.example;

import java.util.Random;

class Answer {
    public static void arrayOutOfBoundsException() {
        // Напишите свое решение ниже
        int[] arrayForTest = new int[new Random().nextInt(10)];
        arrayForTest[arrayForTest.length] = 1;
    }

    public static void divisionByZero() {
        // Напишите свое решение ниже
        int a = 5/0;
    }

    public static void numberFormatException() {
        // Напишите свое решение ниже
        int a = Integer.parseInt("2?3");
    }
}


public class Main {
    public static void main(String[] args) {
        Answer ans = new Answer();
        try {
            ans.arrayOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        }

        try {
            ans.divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }

        try {
            ans.numberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        }
        System.out.println("Hello world!");
    }
}