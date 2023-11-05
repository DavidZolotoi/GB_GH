package gb.study.model;

import gb.study.View;
import gb.study.controller.exception.ConfirmPasswordException;
import gb.study.controller.exception.WrongLoginException;
import gb.study.controller.exception.WrongPasswordException;

import java.util.Scanner;

public class Account {
    private String login;
    private String password;

    public Account() {}

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /**
     * Ввод логина с заданной максимальной длиной
     * @param account аккаунт, для которого проводяться действия
     * @param simbolCount максимальная длина логина
     * @param scanner полученный сканер для ввода данных
     * @return true, если ввод данных прошел успешно
     */
    public static Boolean inputLogin(Account account, int simbolCount, Scanner scanner) throws WrongLoginException {
        Boolean isInputCorrect = false;
        View.printMessage("Введите логин:\n");
        String login = scanner.nextLine();
        if (login.length() >= simbolCount) {
            throw new WrongLoginException("Логин слишком длинный");
        }
        View.printMessage("У логина корректная длина (менее " + simbolCount +" символов).\n");
        account.login = login;
        isInputCorrect = true;
        return isInputCorrect;
    }

    /**
     * Ввод пароля с заданной максимальной длиной
     * @param simbolCount максимальная длина пароля
     * @param scanner полученный сканер для ввода данных
     * @return true, если ввод данных прошел успешно
     */
    public static String inputPssword(int simbolCount, Scanner scanner) throws WrongPasswordException {
        View.printMessage("Введите пароль:\n");
        String password = scanner.nextLine();
        if (password.length() >= simbolCount) {
            throw new WrongPasswordException("Пароль слишком длинный.\n");
        }
        View.printMessage("У пароля корректная длина (менее " + simbolCount +" символов).\n");
        return password;
    }

    /**
     * Подтверждение пароля
     * @param account аккаунт, для которого проводяться действия
     * @param inputPssword введенный пароль
     * @param scanner полученный сканер для ввода данных
     * @return true, если ввод данных прошел успешно
     */
    public static Boolean inputConfirmPssword(Account account, String inputPssword, Scanner scanner) throws ConfirmPasswordException {
        Boolean isInputCorrect = false;
        View.printMessage("Повторите пароль:\n");
        String confirmPassword = scanner.nextLine();
        if (!confirmPassword.equals(inputPssword)) {
            throw new ConfirmPasswordException("Пароли не совпадают.\n");
        }
        View.printMessage("Пароли совпадают.\n");
        account.password = confirmPassword;
        isInputCorrect = true;
        return isInputCorrect;
    }

    /**
     * Метод для создания логина и пароля для аккаунта, вызванный со стороны клиента
     * @param account аккаунт, для которого проводяться действия
     * @param simbolCount максимальная длина логина и пароля
     * @param scanner полученный сканер для ввода данных
     */
    public static void loginPasswordCreate(Account account, int simbolCount, Scanner scanner)
            throws WrongLoginException, WrongPasswordException, ConfirmPasswordException {
        // вызов перегруженного метода, в аргументах которого вызываются методы для ввода логина и пароля
        loginPasswordCreate(
                inputLogin(account, simbolCount, scanner),
                inputConfirmPssword(
                        account,
                        inputPssword(simbolCount, scanner),
                        scanner
                )
        );
    }

    /**
     * Метод для создания логина и пароля (с повторным вводом для подтверждения) для аккаунта,
     * который в качестве параметров принимает результаты работы методов их ввода
     * @param inputLogin true, если ввод логина прошел успешно
     * @param inputConfirmPssword true, если ввод пароля прошел успешно
     * @return true, если ввод логина и пароля прошел успешно
     */
    public static Boolean loginPasswordCreate(Boolean inputLogin, Boolean inputConfirmPssword) {
        Boolean isLoginPasswordCreate = inputLogin && inputConfirmPssword;
        if (!isLoginPasswordCreate) {
            View.printMessage("Не удалось создать логин и пароль.\n");
            return inputLogin && inputConfirmPssword;
        }
        View.printMessage("Логин и пароль созданы.\n");
        return inputLogin && inputConfirmPssword;
    }
}
