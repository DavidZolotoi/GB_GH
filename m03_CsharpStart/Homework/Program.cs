﻿// Текст приветствия для выбора задачи
string messageText = "*****************************************************************************************************************************\n" +
        "Выберите программу для запуска:\n" +
        "Тема №1. Знакомство с языком программирования С#\n" +
        " 1. Программа, которая на вход принимает два числа и выдаёт, какое число большее, а какое меньшее.\n" +
        " 2. Программа, которая принимает на вход три числа и выдаёт максимальное из этих чисел.\n" +
        " 3. Программа, которая на вход принимает число и выдаёт, является ли число чётным (делится ли оно на два без остатка).\n" +
        " 4. Программа, которая на вход принимает число (N), а на выходе показывает все чётные числа от 1 до N.\n" +
        "Тема №2. Базовые алгоритмы\n" +
        " 5. Программа, которая принимает на вход трёхзначное число и на выходе показывает вторую цифру этого числа. Не использовать строки.\n" +
        " 6. Программа, которая выводит случайное трёхзначное число и удаляет вторую цифру этого числа. Не использовать строки для расчета.\n" +
        " 7. Программа, которая выводит третью цифру заданного числа или сообщает, что третьей цифры нет. . Не использовать строки.\n" +
        " 8. Программа, которая принимает на вход цифру, обозначающую день недели, и проверяет, является ли этот день выходным. Не использовать строки.\n" +
        "Тема №3. Базовые алгоритмы. Продолжение\n" +
        " 9. Программа, которая принимает на вход пятизначное число и проверяет, является ли оно палиндромом. Не использовать строки.\n" +
        "10. Программа, которая принимает на вход координаты двух точек и находит расстояние между ними в 3D пространстве.\n" +
        "11. Программа, которая принимает на вход число (N) и выдаёт таблицу кубов чисел от 1 до N.\n" +
        "Введите номер задачи (одна цифра от 1 по 11):";
bool isWork = true;
while (isWork)
{
    // Выбор номера задачи
    int number = InputInteger(messageText);
    // Разветвление программы, в зависимости от выбранной задачи
    switch (number)
    {
        case 1:
            SolutionTask1();
            break;
        case 2:
            SolutionTask2();
            break;
        case 3:
            SolutionTask3();
            break;
        case 4:
            SolutionTask4();
            break;
        case 5:
            SolutionTask5();
            break;
        case 6:
            SolutionTask6();
            break;
        case 7:
            SolutionTask7();
            break;
        case 8:
            SolutionTask8();
            break;
        case 9:
            SolutionTask9();
            break;
        case 10:
            SolutionTask10();
            break;
        case 11:
            SolutionTask11();
            break;
        default:
            System.Console.WriteLine("Что-то пошло не так! Перезапустите программу.");
            break;
    }
    // Узнать продолжаем или нет
    System.Console.Write("Желаете продолжить решение задач? (enter - ДА, любой другой символ - НЕТ)");
    if (Console.ReadLine() == "")
    {
        System.Console.WriteLine("Продолжаем решать.");
    }
    else
    {
        System.Console.WriteLine("Работа программы завершена.");
        isWork = false;
    }
}

/**********ТЕМА1**********/
// Метод решения задачи № 1
void SolutionTask1()
{
    System.Console.WriteLine($"Выбрана задача № 1.");
    int number1 = InputInteger("Для решения задачи необходимо ввести два числа.\nВведите первое число: ");
    int number2 = InputInteger("Введите второе чило:");
    if (number1 == number2) System.Console.WriteLine("Числа равны");
    else if (number1 > number2)
        System.Console.WriteLine($"max = {number1}, min = {number2}");
    else
        System.Console.WriteLine($"max = {number2}, min = {number1}");
};

// Метод решения задачи № 2
void SolutionTask2()
{
    System.Console.WriteLine($"Выбрана задача № 2.");
    int number1 = InputInteger("Для решения задачи необходимо ввести три числа.\nВведите первое число: ");
    int number2 = InputInteger("Введите второе чило:");
    int number3 = InputInteger("Введите третье чило:");
    if (number1 == number2 && number1 == number3)
        System.Console.WriteLine("Числа равны");
    else
    {
        int max = number1;
        if (max < number2) max = number2;
        if (max < number3) max = number3;
        System.Console.WriteLine($"max = {max}");
    }
};

// Метод решения задачи № 3
void SolutionTask3()
{
    System.Console.WriteLine($"Выбрана задача № 3.");
    int number = InputInteger("Для решения задачи необходимо ввести число.\nВведите число: ");
    if (number % 2 == 0)
        System.Console.WriteLine($"Число {number} четное.");
    else
        System.Console.WriteLine($"Число {number} нечетное.");
};

// Метод решения задачи № 4
void SolutionTask4()
{
    System.Console.WriteLine($"Выбрана задача № 4.");
    int number = InputInteger("Для решения задачи необходимо ввести число.\nВведите число: ");
    if (number == 1)                    // случай, когда ввели 1
    {
        System.Console.WriteLine("Необходимо число, отличное от 1");
    }
    else if (number > 1)                // случай, когда ввели четное правее от 1 - начинаем с двойки и движемся вправо
    {
        System.Console.WriteLine($"Четные числа в промежутке с {1} по {number}:");
        for (int i = 2; i <= number; i += 2)
        {
            System.Console.Write($"{i} ");
        }
    }
    else                                // случай, когда ввели четное левее от 1 - начинаем с нуля и движемся влево
    {
        System.Console.WriteLine($"Четные числа в промежутке с {1} по {number}:");
        for (int i = 0; i >= number; i -= 2)
        {
            System.Console.Write($"{i} ");
        }
    }
    System.Console.WriteLine();         // дополнительный перевод на следующую строку
};

/**********ТЕМА2**********/
// Метод решения задачи № 5
void SolutionTask5()
{
    System.Console.WriteLine($"Выбрана задача № 5.");
    int number = InputInteger("Для решения задачи необходимо ввести трехзначное число.\nВведите трехзначное число: ");
    if (number >= 1000 || number <= 99) // случай, когда ввели не трехзначное]
    {
        System.Console.WriteLine("Число не трехзначное.");
    }
    number /= 10;
    number %= 10;
    System.Console.WriteLine($"Вторая цифра введенного числа {number}");
};

// Метод решения задачи № 6
void SolutionTask6()
{
    System.Console.WriteLine($"Выбрана задача № 6.");
    int number = new Random().Next(100, 1000);
    System.Console.WriteLine($"Выбранное случайное трехзначное число {number}");
    System.Console.WriteLine($"Число, полученное удалением 2-ой цифры {(number / 100) * 10 + number % 10}");
};

// Метод решения задачи № 7
void SolutionTask7()
{
    System.Console.WriteLine($"Выбрана задача № 7.");
    int number = InputInteger("Для решения задачи необходимо ввести число.\nВведите число: ");
    while (number > 0)
    {
        if (number / 100 == 0)
        {
            System.Console.WriteLine($"В числе {number} нет третьей цифры.");
            break;
        }
        else if (number / 1000 == 0)
        {
            System.Console.WriteLine($"Третья цифра введенного числа: {number % 10}.");
            break;
        }

        {/* // Способ решения через тернарные операторы. Не совсем подходит, потому что после вывода 3-ей цифры нужно остановить цикл через break
        // System.Console.WriteLine
        //     (
        //         (number / 100 == 0)?
        //             $"В числе {number} нет третьей цифры."
        //         :(
        //             (number / 1000 == 0)?
        //                 $"Третья цифра введенного числа: {number % 10}."
        //             :
        //                 ""
        //         )
        //     );
        */
        }

        number /= 10;
    }

};
// Метод решения задачи № 8
void SolutionTask8()
{
    System.Console.WriteLine($"Выбрана задача № 8.");
    int number = InputInteger("Для решения задачи необходимо ввести число в промежутке [1; 7].\nВведите число: ");
    if (number < 1 || number > 7)
        System.Console.WriteLine($"Число {number} не входит в промежуток [1; 7].");
    else if (number >= 6)
        System.Console.WriteLine($"День недели № {number} выходной.");
    else
        System.Console.WriteLine($"День недели № {number} не выходной.");
};

/**********ТЕМА3**********/
// Метод решения задачи № 9
void SolutionTask9()
{
    System.Console.WriteLine($"Выбрана задача № 9.");
    // Вводим
    int number = InputInteger("Для решения задачи необходимо ввести число.\nВведите число: ");
    // Переворачиваем
    int numberReverse = ReverseInteger(number);
    // Проверяем
    if (number == numberReverse)
        System.Console.WriteLine($"Число {number} является палиндромом.");
    else
        System.Console.WriteLine($"Число {number} не является палиндромом.");
    // // Способ решения через тернарные операторы
    // System.Console.WriteLine
    // (
    //     (number == numberReverse)?
    //         $"Число {number} является палиндромом."
    //     :
    //         $"Число {number} не является палиндромом."
    // );
};

// Метод решения задачи № 10
void SolutionTask10()
{
    System.Console.WriteLine($"Выбрана задача № 10.");
    // Вводим
    double x1 = InputDouble("Для решения задачи необходимо ввести координаты.\nВведите координату x 1-й точки: ");
    double y1 = InputDouble("Введите координату y 1-й точки: ");
    double x2 = InputDouble("Введите координату x 2-й точки: ");
    double y2 = InputDouble("Введите координату y 2-й точки: ");
    // Счиатем
    double len = Math.Sqrt(squareDif(x2, x1) + squareDif(y2, y1));
    // Выводим
    System.Console.WriteLine($"Расстояние между точками ({x1}, {y1}) и ({x2}, {y2}) равно {len:f}.");
};

// Метод решения задачи № 11
void SolutionTask11()
{
    System.Console.WriteLine($"Выбрана задача № 11.");
    // Вводим
    int N = InputInteger("Для решения задачи необходимо ввести конечное число N.\nВведите N: ");
    System.Console.WriteLine($"Таблица кубов чисел от 1 до {N}");
    TableCubePrint(1, N);
};

// Метод ввода int
int InputInteger(string messageText)
{
    bool isNumber = false; int number = -1;
    while (!isNumber)
    {
        System.Console.WriteLine(messageText);
        isNumber = int.TryParse(Console.ReadLine(), out number);
    }
    return number;
}

// Метод ввода double
double InputDouble(string messageText)
{
    bool isNumber = false; double number = -1;
    while (!isNumber)
    {
        System.Console.WriteLine(messageText);
        isNumber = double.TryParse(Console.ReadLine(), out number);
    }
    return number;
}

// Метод реверса int
int ReverseInteger(int value)
{
    bool sign = value >= 0;
    value = Math.Abs(value);
    int valueRserve = 0;
    while (value > 0)
    {
        valueRserve = (valueRserve * 10) + (value % 10);
        value /= 10;
    }
    return sign ? valueRserve : -valueRserve;
}

// Метод возведения разницы в квадрат
double squareDif(double a1, double a2)
{
    return (a2 - a1) * (a2 - a1);
}

// Метод вывода таблицы кубов
void TableCubePrint(int a1, int a2)
{
    for (int i = a1; i <= a2; i++) System.Console.Write($"{i * i * i} ");
}