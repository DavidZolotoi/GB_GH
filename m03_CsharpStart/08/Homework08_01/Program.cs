// Задача 1: Задайте двумерный массив. Напишите программу, которая упорядочит по убыванию элементы каждой строки двумерного массива.
System.Console.WriteLine("Задача 1: Задайте двумерный массив. Напишите программу, которая упорядочит по убыванию элементы каждой строки двумерного массива.");
(int m, int n) sizeArray = (new Random().Next(5, 10), new Random().Next(5, 10)); // Размеры массива
int[,] array = GetRandomIntArray2(sizeArray.m, sizeArray.n);
PrintArray2(array);
System.Console.WriteLine("После сортировки:");
PrintArray2(GetSort2(array));

// Метод сортировки 2мерного массива
int[,] GetSort2(int[,] array)
{
    for (int i = 0; i < array.GetLongLength(0); i++)
    {   
        int[] rowArraySort = GetSort1(GetRow(array, i));
        for (int j = 0; j < array.GetLongLength(1); j++) array[i, j] = rowArraySort[j];
    }
    return array;
}

// Метод сортировки 1мерного массива
int[] GetSort1(int[] rowArray)
{
    for (int i = 0; i < rowArray.Length; i++)
        for (int j = rowArray.Length - 1; j > i; j--)
            if (rowArray[j]>rowArray[j-1]) (rowArray[j], rowArray[j-1]) = (rowArray[j-1], rowArray[j]);
    return rowArray;
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