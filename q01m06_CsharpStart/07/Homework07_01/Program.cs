// Задача 1. Задайте двумерный массив размером m x n, заполненный случайными вещественными числами.
Console.WriteLine("Задача 1. Задайте двумерный массив размером m x n, заполненный случайными вещественными числами.");
(int m, int n) size = (new Random().Next(5, 10), new Random().Next(5, 10)); // Размеры массива
double[,] array = GetRandomDoubleArray2(size.m, size.n);
PrintArray2(array);

// Генерация массива с даблами
double[,] GetRandomDoubleArray2(int m=5, int n=5)   // в теории передавать и возвращать необязательно, но так удобнее
{
    double[,] array = new double[size.m, size.n];
    for (int i = 0; i < array.GetLength(0); i++)
        for (int j = 0; j < array.GetLength(1); j++)
            array[i, j] = new Random().NextDouble()*10;
    return array;
}

// Метод вывода 2хмерного массива
void PrintArray2(double[,] array)
{
    System.Console.WriteLine($"Размеры массива: {array.GetLength(0)} х {array.GetLength(1)}.");
    for (int i = 0; i < array.GetLength(0); i++)                 // движение по строкам
    {
        for (int j = 0; j < array.GetLength(1); j++) System.Console.Write($"{array[i, j]:f3}\t");  // движение по колонкам + вывод
        System.Console.WriteLine();
    }
}