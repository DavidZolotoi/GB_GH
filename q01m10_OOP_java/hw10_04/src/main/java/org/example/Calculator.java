package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

/**
 * Калькулятор, рабоающий с коллекциями и Обобщениями (Generics)
 */
@Data
@NoArgsConstructor
//@AllArgsConstructor
public class Calculator {
    /**
     * Рассчитывает сумму коллекции
     * @param list коллекция
     * @return результат подсчета суммы
     */
    public Double sum(List<? extends Number> list){
        Double sum = 0.0;
        for (Number num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }

    /**
     * Рассчитывает произведение коллекции
     * @param list коллекция
     * @return результат подсчета произведения
     */
    public Double multiplication(List<? extends Number> list){
        Double multiplication = 1.0;
        for (Number num : list) {
            multiplication *= num.doubleValue();
        }
        return multiplication;
    }

    /**
     * Рассчитывает частное коллекция (игнорирует делители, равные нулю)
     * @param list коллекция
     * @return результат подсчета частного
     */
    public Double division(List<? extends Number> list){
        Double division = list.get(0).doubleValue();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).doubleValue() != 0.0) division /= list.get(i).doubleValue();
            else {
                System.out.printf(
                        "Для расчета частного, исключен элемент №%d, в связи с тем, что он равен нулю, а на ноль делить нельзя.\n", i);
            }
        }
        return division;
    }

    /**
     * Переводит все элементы коллекции в двоичную систему счисления
     * @param listDecimals исходная коллекция, записанная в десятичной системе счисления
     * @return коллекция-результат, записанная в двоичной системе счисления
     */
    public LinkedList<String> toBinary(List<? extends Number> listDecimals){
        LinkedList<String> listBinary = new LinkedList<>();
        for (var decimalValue : listDecimals) {
            Integer decimalInteger = Integer.parseInt(String.format("%.0f", decimalValue.doubleValue()));
            StringBuilder binaryValue = new StringBuilder("");
            while (decimalInteger > 0){
                binaryValue.append(decimalInteger % 2);
                decimalInteger /= 2;
            }
            listBinary.add(binaryValue.reverse().toString());
        }
        return listBinary;
    }
}










