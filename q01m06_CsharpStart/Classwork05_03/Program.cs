// Задайте одномерный массив из 10 случайных чисел в диапазоне от 1 до 200. 
// Найдите количество элементов массива, значения которых лежат в отрезке [10,99]. 
// Пример для массива из 5, а не 123 элементов. В своём решении сделайте для 123
// [5, 18, 123, 6, 2] -> 1
// [1, 2, 3, 6, 2] -> 0
// [10, 11, 12, 13, 14] -> 5

int[] CreateArray(int Length, int minRange, int maxRange)
{

    int[] numbers = new int[Length];
    for (int i = 0; i < numbers.Length; i++)
    {
        numbers[i] = new Random().Next(minRange, maxRange + 1);
    }
    return numbers;
}

void PrintArray(int[] array)
{
    for (int j = 0; j < array.Length; j++)
    {
        Console.Write(array[j] + "\t");
    }
    Console.WriteLine();
}

int Promt(String message)
{
    System.Console.Write(message);
    return Convert.ToInt32(Console.ReadLine());
}

int Search(int[] array, int minLine, int maxLine)
{
    int counter = 0;
    foreach (int item in array)
    {
        if (item >= minLine && item <= maxLine)
        {
            counter++;
        }
    }
    return counter;
}

int Length = Promt("Input length of array ");
int minArray = Promt("Input min of array ");
int maxArray = Promt("Input max of array ");

int[] array = CreateArray(Length, minArray, maxArray);
PrintArray(array);

int minLine = Promt("Input start of line ");
int maxLine = Promt("Input finish of line ");

System.Console.WriteLine($"Count of numbers is {Search(array, minLine, maxLine)}");