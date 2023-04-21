package org.example;

import org.example.calcModel.CalcAction;
import org.example.calcModel.ComplexNumber;
import org.example.calcModel.Logs;

public class CalcController {
    public static void main(String[] args) {
        /**
         * Создать файл с логами рядом с классом, получить путь к нему и вернуть логгер
         */
        Logs.logger = Logs.GetLogger(Logs.GetPathForLogFile("Logs.log"));

        /**
         * Пользователь вводит два операнда
         */
        ComplexNumber n1 = new ComplexNumber();
        ComplexNumber n2 = new ComplexNumber();

        /**
         * Пользователь выбирает действие
         */
        CalcAction.sum(n1, n2);
        CalcAction.diff(n1, n2);
        CalcAction.mult(n1, n2);
    }
}