/*
Реализуйте метод subArrays, принимающий в качестве аргументов два целочисленных массива a и b,
и возвращающий новый массив c, каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
Если длины массивов не равны - верните нулевой массив длины 1.
*/

package org.example;

import java.util.Arrays;

class Answer {
    public int[] subArrays(int[] a, int[] b){
        // Введите свое решение ниже
        //if (a.length != b.length) return new int[]{0};    // с этой строкой try можно не использовать
        int cLength = Math.max(a.length, b.length);
        int[] c = new int[cLength];
        try {
            for (int i = 0; i < c.length; i++)
                c[i] = a[i] - b[i];
        }
        catch (Exception arrayOutOfBoundsException){
            System.out.println("Исходные массивы имеют не одинаковые размеры.");
            c = new int[]{0};
        }
        return c;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a = {};
        int[] b = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = new int[]{4, 5, 6};
            b = new int[]{1, 2, 3};
        }
        else{
            a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
            b = Arrays.stream(args[1].split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        Answer ans = new Answer();
        String itresume_res = Arrays.toString(ans.subArrays(a, b));
        System.out.println("Результат: " + itresume_res);
    }
}