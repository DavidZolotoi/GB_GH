/*
 Урок 2. Исключения и их обработка.
 Задание 1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
 и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
 вместо этого, необходимо повторно запросить у пользователя ввод данных.
 */

package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        inputFloat();
    }

    private static void inputFloat() {
        Scanner in = new Scanner(System.in);
        Float number = 0.0f;
        Boolean isParsingSuccessful = false;
        while (!isParsingSuccessful) {
            System.out.print("Введите число формата float: ");
            String numberString = in.nextLine();
            try{
                number = Float.parseFloat(numberString);
                isParsingSuccessful = true;
            }
            catch (NumberFormatException ex){
                System.out.println("Введено некорректное значение, попробуйте еще раз.");
                isParsingSuccessful = false;
            }
        }
        System.out.printf("Введенное число: %f \n", number);
        in.close();
    }
}