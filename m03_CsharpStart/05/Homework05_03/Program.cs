Console.WriteLine("Задача 3: Задайте массив вещественных чисел. Найдите разницу между максимальным и минимальным элементов массива.");

double[] array = CreateArrayDouble(5);
System.Console.WriteLine("Имеющийся массив:");
PrintArrayDouble(array);
double delta = getMaxArray(array) - getMinArray(array);
System.Console.WriteLine($"Разница между наибольшим и наименьшим равна: {delta:E} (~{delta:f0})");

// вычисление max в массиве
double getMaxArray(double[] array)
{
    double max = array[0];
    foreach (var item in array) 
        if (item > max) max = item;
    return max;
}

// вычисление min в массиве
double getMinArray(double[] array)
{
    double min = array[0];
    foreach (var item in array) 
        if (item < min) min = item;
    return min;
}

// генерация массива
double[] CreateArrayDouble(int Length, int minRange = int.MinValue, int maxRange = int.MaxValue)
{
    double[] numbers = new double[Length];
    for (int i = 0; i < numbers.Length; i++)
    {
        numbers[i] = (new Random().Next(minRange, maxRange))/(Math.Pow(10, new Random().Next(1, 8)));
    }
    return numbers;
}

// вывод массива
void PrintArrayDouble(double[] array)
{
    for (int j = 0; j < array.Length; j++)
    {
        Console.Write($"{array[j]:E}(~{array[j]:f0})\t");
    }
    Console.WriteLine();
}