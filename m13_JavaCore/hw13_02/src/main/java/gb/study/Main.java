/*
Урок 2. Данные и функции
        1. Написать метод, возвращающий количество чётных элементов массива.
        countEvens([2, 1, 2, 3, 4]) → 3 countEvens([2, 2, 0]) → 3 countEvens([1, 3, 5]) → 0
        2. Написать функцию, возвращающую разницу между самым большим и самым маленьким элементами переданного не пустого массива.
        3. Написать функцию, возвращающую истину, если в переданном массиве есть два соседних элемента, с нулевым значением.
*/
package gb.study;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Решение первой задачи
        var array1 = generateRandomArray(10,1, 10);
        System.out.println(
                "Задача №1.\n" +
                "В массиве\n" +
                getArrayListString(array1, "\t") +
                "\nКоличество четных элементов равно " + countEvens(array1)
        );

        // Решение второй задачи
        var array2 = generateRandomArray(10,1, 10);
        System.out.println(
                "Задача №2.\n" +
                "В массиве\n" +
                getArrayListString(array2, "\t") +
                "\nразница между наибольшим и наименьшим элементами равна " + deltaMaxMin(array2)
        );

        // Решение третьей задачи
        var array3 = generateRandomArray(10,0, 3);
        System.out.println(
                "Задача №3.\n" +
                "Утверждение о том, что в массиве\n" +
                getArrayListString(array3, "\t") +
                "\nесть два соседних элемента, с нулевым значением является " +
                ((areNeighborsEqualZero(array3))? "истиной." : "ложью." )
        );
    }


    /**
     * Метод, возвращающий количество четных элементов массива
     * @param array заданный массив
     * @return количество четных элементов массива
     */
    private static int countEvens(ArrayList<Integer> array) {
        int count = 0;
        for (int i = 0; i < array.size(); i++)
            if (array.get(i) % 2 == 0) count++;
        return count;
    }

    /**
     * Метод, возвращающий разницу между наибольшим и наименьшим элементами массива
     * @param array заданный массив
     * @return разница между наибольшим и наименьшим элементами массива
     */
    private static Integer deltaMaxMin(ArrayList<Integer> array) {
        Integer max = array.get(0), min = array.get(0);
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max) max = array.get(i);
            if (array.get(i) < min) min = array.get(i);
        }
        return max - min;
    }

    /**
     * Метод, возвращающий истину, если в переданном массиве есть два соседних элемента, с нулевым значением
     * @param array заданный массив
     * @return истина, если есть два соседних элемента, с нулевым значением
     */
    private static Boolean areNeighborsEqualZero(ArrayList<Integer> array) {
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i-1) == 0 && array.get(i) == 0) return true;
        }
        return false;
    }

    /**
     * Метод, генерирующий массив случайных чисел
     * @param size размер массива
     * @param min минимальное значение элемента в массиве
     * @param max максимальное значение элемента в массиве
     * @return массив случайных чисел
     */
    private static ArrayList<Integer> generateRandomArray(int size, Integer min, Integer max) {
        ArrayList<Integer> array = new ArrayList<>(size);
        for (int i = 0; i < size; i++)
            array.add((int) (Math.random() * (max - min + 1)) + min);
        return array;
    }

    /**
     * Метод, возвращающий массив в виде строки
     * @param array массив для вывода
     * @return строку с массивом
     */
    private static String getArrayListString(ArrayList<Integer> array, String sepor) {
        StringBuilder result = new StringBuilder("");
        for (Integer item : array) result.append(item + sepor);
        return result.toString();
    }

}