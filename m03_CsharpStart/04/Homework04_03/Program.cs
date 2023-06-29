// Задача 3: Напишите программу, которая выводит массив из 8 элементов, заполненный случайными числами.
// Оформите заполнение массива и вывод в виде функции (пригодится в следующих задачах). Реализовать через функции.
// (* Доп сложность, “введите количество элементов массива”, “Введите минимальный порог случайных значений”, “Введите максимальный порог случайных значений”)

Console.WriteLine("Задача 3: Напишите программу, которая выводит массив из 8 элементов, заполненный случайными числами. Оформите заполнение массива и вывод в виде функции (пригодится в следующих задачах). Реализовать через функции. (* Доп сложность, “введите количество элементов массива”, “Введите минимальный порог случайных значений”, “Введите максимальный порог случайных значений”)");
int Length = InputInteger("Введите количество элементов массива");
int minRange = InputInteger("Введите минимальный порог массива");
int maxRange = InputInteger("Введите максимальный порог массива");
int[] numbers = CreateArray(Length, minRange, maxRange);
PrintArray(numbers, "Полученный массив:");

// Вариант с одним оператором
// PrintArray
// (
//     CreateArray
//     (
//         InputInteger("Введите количество элементов массива"),
//         InputInteger("Введите минимальный порог массива"),
//         InputInteger("Введите максимальный порог массива")
//     ),
//     "Полученный массив:"
// );


// Метод заполнения массива случайными
int[] CreateArray(int Length, int minRange, int maxRange)
{
    int[] array = new int[Length];
    for (int i = 0; i < array.Length; i++)
    {
        array[i] = new Random().Next(minRange, maxRange + 1);
    }
    return array;
}

// Метод вывода массива черз \t
void PrintArray(int[] array, string messageText)
{
    System.Console.WriteLine(messageText);
    for (int j = 0; j < array.Length; j++)
    {
        Console.Write(array[j] + "\t");
    }
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