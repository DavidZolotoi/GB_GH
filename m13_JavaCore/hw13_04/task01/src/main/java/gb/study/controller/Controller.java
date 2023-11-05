package gb.study.controller;

import gb.study.View;
import gb.study.controller.exception.ConfirmPasswordException;
import gb.study.controller.exception.WrongLoginException;
import gb.study.controller.exception.WrongPasswordException;
import gb.study.model.Account;

import java.util.ArrayList;
import java.util.Scanner;

/*
1. Задача: Проверка логина и пароля
1 - Создать статический метод который принимает на вход три параметра: login, password и confirmPassword.
2 - Длина login должна быть меньше 20 символов. Если login не соответствует этим требованиям,
необходимо выбросить WrongLoginException.
3 -Длина password должна быть меньше 20 символов. Также password и confirmPassword должны быть равны.
Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.
4 - WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами:
один по умолчанию, второй принимает сообщение исключения и передает его в конструктор класса Exception.
5 - В основном классе программы необходимо по-разному обработать исключения.
6 - Метод возвращает true, если значения верны или false в другом случае.
*/

public class Controller {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account());
        int simbolCount = 20;

        var resultLogs = new StringBuilder("Возникшие проблемы:\n");
        try {
            // Это метод создания логина и пароля, вызванный со стороны клиента.
            // В него переданы те данные, которые известны на стороне клиента (аккаунт, длина логина/пароля и сканер).
            // Этот метод сам вызовет перегруженный метод внутри Account,
            // в параметры которого будут переданы результаты работ методов ввода логина и пароля (с подтверждением)
            Account.loginPasswordCreate(accounts.get(0), simbolCount, scanner);
        } catch (WrongLoginException loginEx) {
            resultLogs
                    .append("Программа кинула исключение WrongLoginException:\n")
                    .append(loginEx.getMessage())
                    .append("\n");
        } catch (WrongPasswordException passwordEx) {
            resultLogs
                    .append("Программа кинула исключение WrongPasswordException:\n")
                    .append(passwordEx.getMessage())
                    .append("\n");
        } catch (ConfirmPasswordException confirmPasswordEx) {
            resultLogs
                    .append("Программа кинула исключение ConfirmPasswordException:\n")
                    .append(confirmPasswordEx.getMessage())
                    .append("\n");
        } finally {
            if (resultLogs.toString().length()>22)
                View.printMessage(resultLogs.toString());
        }

    }
}