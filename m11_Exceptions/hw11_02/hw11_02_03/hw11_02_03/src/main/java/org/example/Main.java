/*
 Урок 2. Исключения и их обработка.
 Задание 3. Дан следующий код, исправьте его там, где требуется
 (задание 3 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
 */

package org.example;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {    // этот блок должен быть последним, потому что он включает в себя остальные
            System.out.println("Что-то пошло не так...");
        }
    }

    // В данном методе объявление о возможном выпадении исключения FileNotFoundException кажется излишним,
    // но удалять не стал, т.к. это не ломает работу программы, просто нет логичного объяснения этому объявлению
    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }

}