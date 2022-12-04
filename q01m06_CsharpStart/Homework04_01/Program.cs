Console.WriteLine("Задача 1: Напишите цикл, который принимает на вход два числа (A и B) и возводит число A в натуральную степень B. Реализовать через функции.");

int A = InputInteger("Введите число A");
int B = InputInteger("Введите число B");
long result = PowerAtoB(A, B);
string resultMess = (result == -1) ?
        $"Вы ввели не натуральную степень: {B}"
        :
        $"{A} в степени {B} равно {result}";
System.Console.WriteLine(resultMess);

// Метод возведения числа A в число B
long PowerAtoB(int A, int B)
{
    if (B <= 0) return -1;
    long result = A;
    for (int i = 1; i < B; i++) result *= A;
    return result;
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