// Задайте массив. Напишите программу, которая определяет, присутствует ли заданное число в массиве.
// 4; массив [6, 7, 19, 345, 3] -> нет
// 3; массив [6, 7, 19, 345, 3] -> да

int[] numbers = GenerateArray(20, -10, 10);
System.Console.WriteLine("Сгенерированный массив");
PrintArray(numbers);
int value = Promt("Какое значение будем искать?");

if (IsFound(numbers, value))
    System.Console.WriteLine($"Значения есть");
else
    System.Console.WriteLine($"Значения нет");

bool IsFound(int[] numbers, int value)
{
    foreach (var item in numbers)
    {
        if (item == value) return true;
    }
    return false;
}

int[] GenerateArray(int Length, int minRange, int maxRange)
{

    int[] array = new int[Length];
    for (int i = 0; i < array.Length; i++)
    {
        array[i] = new Random().Next(minRange, maxRange + 1);
    }
    return array;
}

void PrintArray(int[] array)
{
    for (int j = 0; j < array.Length; j++)
    {
        Console.Write(array[j] + "\t");
    }
}

int Promt(String message)
{
    System.Console.Write(message);
    return Convert.ToInt32(Console.ReadLine());
}