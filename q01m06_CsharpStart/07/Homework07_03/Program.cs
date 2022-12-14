// Задача 3. Задайте двумерный массив из целых чисел. Найдите среднее арифметическое элементов в каждом столбце.
Console.WriteLine("Задача 3. Задайте двумерный массив из целых чисел. Найдите среднее арифметическое элементов в каждом столбце.");
(int m, int n) sizeArray = (new Random().Next(5, 10), new Random().Next(5, 10)); // Размеры массива
int[,] array = GetRandomIntArray2(sizeArray.m, sizeArray.n);
PrintArray2(array);
GetColumnAvg(array);


// Метод, возвращающий массив средних арифм. по столбцам от двумерного массива
double[] GetColumnAvg(int[,] array)
{
    double[] avg = new double[array.GetLength(1)];              // кол-во колонок
    for (int i = 0; i < array.GetLength(1); i++)                 // движение по колонкам (вправо)
    {
        avg[i]=0;
        for (int j = 0; j < array.GetLength(0); j++)            // движение по строке (вниз)
        {
                avg[i] += array[j, i];
        }
        avg[i] = avg[i] / (double)array.GetLength(0);
        System.Console.Write($"{avg[i]:f2}\t");
    }
    return avg;
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
    for (int i = 0; i < array.GetLength(0); i++)                 // движение по строкам (вниз)
    {
        for (int j = 0; j < array.GetLength(1); j++) System.Console.Write($"{array[i, j]}\t");  // движение по колонкам (вправо) + вывод
        System.Console.WriteLine();
    }
}