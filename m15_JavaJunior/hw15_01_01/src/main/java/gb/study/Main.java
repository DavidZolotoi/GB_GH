package gb.study;

import java.util.Random;
import java.util.stream.IntStream;

/*
Напишите программу, которая использует Stream API для обработки списка чисел.
Программа должна вывести на экран среднее значение всех четных чисел в списке.
*/
public class Main {
    public static void main(String[] args) {
        final int ELEM_COUNT = 20;
        final int ELEM_MIN = 10;
        final int ELEM_MAX = 99;

        var myList =
                IntStream.range(0, ELEM_COUNT)
                .map(ignored -> (new Random()).nextInt(ELEM_MAX - ELEM_MIN + 1) + ELEM_MIN)
                .boxed()
                .toList();
        System.out.println("Сгенерированный список: " + myList);

        double avgOfEvenNumbers =
                myList.stream()
                .filter((element) -> element%2==0)
                .mapToInt(Integer::intValue)
                .average().orElse(0.0);
        System.out.println("Среднее арифметическое: " + avgOfEvenNumbers);

        var myEventList =
                myList.stream()
                .filter((element) -> element%2==0)
                .toList();
        System.out.println("Полученное из четных чисел данной коллекции: " + myEventList);
    }
}