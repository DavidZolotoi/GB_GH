/*
 Урок 2. Исключения и их обработка.
 Задание 2. Если необходимо, исправьте данный код
 (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
 */

package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        createAndPrintCatchedRes1();
    }

    private static void createAndPrintCatchedRes1() {
        try {
            int d = getValueD();  // будем считать, что в этой строке метод, возвращающий значение d и тут внезапно выпал 0
            // double catchedRes1 = intArray[8] / d;    // Эта строка вообще непонятна, надо общаться с автором...
            // Так как связи с автором нет, предполагаю, что автор хотел
            // создать массив catchedRes1, значения элементов которого
            // получаются путем деления значений элементов целочисленного массива intArray
            int[] intArray = getIntArray();  // будем считать, что в этой строке метод, возвращающий массив intArray (можно было и над try)
            if (intArray.length == 0){
                System.out.println("Невозможно создать массив catchedRes1, т.к. длина массива intArray = 0.");
                return;
            }
            double[] catchedRes1 = new double[intArray.length];
            for (int i = 0; i < intArray.length; i++) {
                if (d==0) catchedRes1[i] = intArray[i] / d;
                catchedRes1[i] = (double)intArray[i] / d;
                // Если убрать строку 30, то при делении на 0 в случае с double
                // не вылетает исключение деления на 0, частное = Infinity (и никаких исключений),
                // А судя по коду, раз мы ловим исключение деления на ноль, значит его надо выбросить.
                // Таким образом если d==0, то в 30 строке выброситься исключение деления на ноль.
                // (Мы могли его сами выбросить, но мне больше нравится, если система сама выбросит)
            }
            String catchedRes1ToString = Arrays.toString(catchedRes1);
            System.out.println("catchedRes1 = " + catchedRes1ToString);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }

    private static int[] getIntArray() {
        return new int[]{1,2,3,4,5,6,7};
    }

    private static int getValueD() {
        return 0;
    }
}