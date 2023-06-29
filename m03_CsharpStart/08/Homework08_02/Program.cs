// Задача 2: Задайте прямоугольный двумерный массив. Напишите программу, которая будет находить строку с наименьшей суммой элементов.
System.Console.WriteLine("Задача 2: Задайте прямоугольный двумерный массив. Напишите программу, которая будет находить строку с наименьшей суммой элементов.");
(int m, int n) sizeArray = (new Random().Next(5, 10), new Random().Next(5, 10)); // Размеры массива
int[,] array = GetRandomIntArray2(sizeArray.m, sizeArray.n);
System.Console.WriteLine("Исходный массив:");
PrintArray2(array);
System.Console.WriteLine($"Номер строки с наименьшей суммой элементов: {GetNumberRowMinSumm(array)+1} строка.");

// Метод поиска строки с наименьшей суммой элементов
int GetNumberRowMinSumm(int[,] array)
{
    int numberRowMinSumm = 0;
    long minSumm = GetSummArray1(GetRow(array, 0));
    for (int i = 0; i < array.GetLongLength(0); i++)
    {
        long rowSumm = GetSummArray1(GetRow(array, i));
        if (rowSumm < minSumm)
        {
            minSumm = rowSumm;
            numberRowMinSumm = i;
        }
    }
    return numberRowMinSumm;
}

// Метод расчета суммы элементов в 1мерном массиве
long GetSummArray1(int[] array)
{
    long summ = 0;
    foreach (var item in array) summ += item;
    return summ;
}

// Возврат i-й строки двумерного массива array
int[] GetRow(int[,] array, int i)
{
    int[] rowArray = new int[array.GetLongLength(1)];
    for (int j = 0; j < array.GetLongLength(1); j++) rowArray[j] = array[i, j];
    return rowArray;
}

// Генерация массива с интами
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
    for (int i = 0; i < array.GetLength(0); i++)                 // движение по строкам (вниз)
    {
        for (int j = 0; j < array.GetLength(1); j++) System.Console.Write($"{array[i, j]}\t");  // движение по колонкам (вправо) + вывод
        System.Console.WriteLine();
    }
}