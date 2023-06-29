Console.WriteLine("Задача 1: Задайте массив заполненный случайными положительными трёхзначными числами. Напишите программу, которая покажет количество чётных чисел в массиве.");

int[] array = CreateArray(new Random().Next(10, 16), 100, 999);
System.Console.WriteLine("Имеющийся массив:");
PrintArray(array);
int number = getEvenNumber(array);
System.Console.WriteLine((number == 0) ? "В массиве четных чисел нет" : $"Кол-во четных чисел в массиве равно {number}");

// определение количества четных чисел в массиве (сделал не применяя if(){}else{})
int getEvenNumber(int[] array)
{
    int number = 0;
    foreach (var item in array) number += item % 2;
    return array.Length - number;
}

// генерация массива
int[] CreateArray(int Length, int minRange, int maxRange)
{

    int[] numbers = new int[Length];
    for (int i = 0; i < numbers.Length; i++)
    {
        numbers[i] = new Random().Next(minRange, maxRange + 1);
    }
    return numbers;
}

// вывод массива
void PrintArray(int[] array)
{
    for (int j = 0; j < array.Length; j++)
    {
        Console.Write(array[j] + "\t");
    }
    Console.WriteLine();
}