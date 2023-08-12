/*
 Урок 2. Исключения и их обработка.
 Задание 4. Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
 Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */

package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        inputTxtNotEmpty();
    }

    private static void inputTxtNotEmpty(){
        Scanner in = new Scanner(System.in);
        String txtNotEmpty = "";
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            try {
                System.out.print("Введите не пустую строку: ");
                txtNotEmpty = in.nextLine();
                if (txtNotEmpty.replace(" ", "").replace("\t", "").isEmpty())
                    throw new StringEmptyException("Строка пуста.");
                isInputCorrect = true;
            }catch (StringEmptyException ex) {
                System.out.println("Введено некорректное значение.\n" +
                        ex.getMessage() + "\n" +
                        "Попробуйте еще раз.");
                isInputCorrect = false;
            }
        }
        System.out.printf("Вы ввели:\n%s", txtNotEmpty);
        in.close();
    }
}

class StringEmptyException extends Exception{
    public StringEmptyException(String message){
        super(message);
    }
}