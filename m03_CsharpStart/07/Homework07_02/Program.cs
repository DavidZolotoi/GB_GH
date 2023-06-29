// Задача 2. Напишите программу, которая на вход принимает позиции элемента в двумерном массиве,
// и возвращает значение этого элемента или же указание, что такого элемента нет.

Console.WriteLine("Задача 2. Напишите программу, которая на вход принимает позиции элемента в двумерном массиве, и возвращает значение этого элемента или же указание, что такого элемента нет.");
(int m, int n) sizeArray = (new Random().Next(5, 10), new Random().Next(5, 10)); // Размеры массива
int[,] array = GetRandomIntArray2(sizeArray.m, sizeArray.n);
PrintArray2(array);
int y = InputInteger("Введите № запрашиваемой строки: ");
int x = InputInteger("Введите № запрашиваемой колонки: ");
TrySearchValueElement(array, y, x, out string message);
System.Console.WriteLine(message);

// Проверка позиций
bool TrySearchValueElement(int[,] array, int y, int x, out string message)
{
    bool isSearch = (y < array.GetLength(0) + 1) && (x < array.GetLength(1) + 1);
    message = (isSearch)?
            $"Значение элемента [{y}, {x}] равно {array[y-1, x-1]}.":
            $"Элемента с позициями {y}, {x} в массиве нет.";
    return isSearch;
}

// Генерация массива с итами
int[,] GetRandomIntArray2(int m = 5, int n = 5)   // в теории передавать и возвращать необязательно, но так удобнее
{
    int[,] array = new int[m, n];
    for (int i = 0; i < array.GetLength(0); i++)
        for (int j = 0; j < array.GetLength(1); j++)
            array[i, j] = new Random().Next(0, 10);
    return array;
}

// Метод вывода 2хмерного массива
void PrintArray2(int[,] array)
{
    System.Console.WriteLine($"Размеры массива: {array.GetLength(0)} х {array.GetLength(1)}.");
    for (int i = 0; i < array.GetLength(0); i++)                 // движение по строкам
    {
        for (int j = 0; j < array.GetLength(1); j++) System.Console.Write($"{array[i, j]}\t");  // движение по колонкам + вывод
        System.Console.WriteLine();
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