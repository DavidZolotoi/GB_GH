Console.WriteLine("Задача 2: Напишите программу, которая принимает на вход число и выдаёт сумму цифр в числе. Реализовать через функции.");

int number = InputInteger($"Введите число в промежутке от {int.MinValue} по {int.MaxValue}");
System.Console.WriteLine(SummNumbers(number));

int SummNumbers(int number)
{
    if (number < 0) number = -number;
    int s = 0;
    while (number > 0)
    {
        s += number % 10;
        number /= 10;
    }
    return s;
}

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