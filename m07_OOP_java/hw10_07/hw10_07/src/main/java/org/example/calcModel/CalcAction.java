package org.example.calcModel;

import org.example.CalcView;

/**
 * Класс статических методов работы с комплексными числами
 */
public class CalcAction {
    /**
     * Вычисляет сумму двух комплексных числа
     * @param n1 первое слогаемое
     * @param n2 второе слогаемое
     * @return сумма
     */
    public static ComplexNumber sum (ComplexNumber n1, ComplexNumber n2){
        ComplexNumber sum = new ComplexNumber(n1.getA()+n2.getA(), n1.getB()+n2.getB());
        CalcView view = new CalcView();
        String report = "(" + n1 + ") + (" + n2 + ") = " + sum + ";";
        view.sendInfo("Сумма комплексных чисел:\n" + report);
        Logs.logger.info("Вызван метод суммы: " + report);
        return sum;
    }

    /**
     * Вычисляет разность двух комплексных числа
     * @param n1 уменьшаемое
     * @param n2 вычитаемое
     * @return разность
     */
    public static ComplexNumber diff (ComplexNumber n1, ComplexNumber n2){
        ComplexNumber diff =  new ComplexNumber(n1.getA()-n2.getA(), n1.getB()-n2.getB());
        CalcView view = new CalcView();
        String report = "(" + n1 + ") - (" + n2 + ") = " + diff + ";";
        view.sendInfo("Разность комплексных чисел:\n" + report);
        Logs.logger.info("Вызван метод разности: " + report);
        return diff;
    }

    /**
     * Вычисляет произведение двух комплексных числа
     * @param n1 первый множитель
     * @param n2 второй множитель
     * @return произведение
     */
    public static ComplexNumber mult (ComplexNumber n1, ComplexNumber n2){
        ComplexNumber mult = new ComplexNumber(n1.getA()*n2.getA() - n1.getB()*n2.getB(), n1.getA()*n2.getB() - n1.getB()*n2.getA());
        CalcView view = new CalcView();
        String report = "(" + n1 + ") * (" + n2 + ") = " + mult + ";";
        view.sendInfo("Произведение комплексных чисел:\n" + report);
        Logs.logger.info("Вызван метод произведения: " + report);
        return mult;
    }
}
