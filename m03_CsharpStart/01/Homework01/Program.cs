﻿// Текст приветствия для выбора задачи
string messageText = "*****************************************************************************************************************************\n" +
        "Выберите задачу для решения:\n" +
        "1. Напишите программу, которая на вход принимает два числа и выдаёт, какое число большее, а какое меньшее.\n" +
        "2. Напишите программу, которая принимает на вход три числа и выдаёт максимальное из этих чисел.\n" + 
        "3. Напишите программу, которая на вход принимает число и выдаёт, является ли число чётным (делится ли оно на два без остатка).\n" +
        "4. Напишите программу, которая на вход принимает число (N), а на выходе показывает все чётные числа от 1 до N.\n" +
        "Введите номер задачи (одна цифра от 1 по 4):";
bool isWork = true;
while(isWork)
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


// Метод решения задачи № 1
void SolutionTask1()
{
    System.Console.WriteLine($"Выбрана задача № 1.");
    int number1 = InputInteger("Для решения задачи необходимо ввести два числа.\nВведите первое число: ");
    int number2 = InputInteger("Введите второе чило:");
    if (number1==number2) System.Console.WriteLine("Числа равны");
    else if (number1>number2)
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
    if (number1==number2 && number1==number3) System.Console.WriteLine("Числа равны");
    else if (number1>=number2 && number1>=number3)  // Вариант, что все равны исключен строкой выше! Может быть такое, что два из трех равны, поэтому тут знак равно
        System.Console.WriteLine($"max = {number1}");
    else if (number2>=number1 && number2>=number3)
        System.Console.WriteLine($"max = {number2}");
    else
        System.Console.WriteLine($"max = {number3}");
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
        for (int i = 2; i <= number; i+=2)
        {
            System.Console.Write($"{i} ");
        }
    }
    else                                // случай, когда ввели четное левее от 1 - начинаем с нуля и движемся влево
    {
        System.Console.WriteLine($"Четные числа в промежутке с {1} по {number}:");
        for (int i = 0; i >= number; i-=2)
        {
            System.Console.Write($"{i} ");
        }
    }
    System.Console.WriteLine();         // дополнительный перевод на следующую строку
};

// Метод ввода int
int InputInteger(string messageText)
{
    bool isNumber = false; int number = -1;
    while(!isNumber)
    {
        System.Console.WriteLine(messageText);
        isNumber = int.TryParse(Console.ReadLine(), out number);
    }
    return number;
}