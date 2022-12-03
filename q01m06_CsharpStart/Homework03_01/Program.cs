Console.WriteLine("Тема №3. Базовые алгоритмы. Продолжение.\nЗадача 1. Программа, которая принимает на вход пятизначное число и проверяет, является ли оно палиндромом. Не использовать строки");
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
    return sign?valueRserve:-valueRserve;
}