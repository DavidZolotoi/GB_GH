//Задача 3: Задайте две матрицы. Напишите программу, которая будет находить произведение двух матриц.
Console.WriteLine("Задача 3: Задайте две матрицы. Напишите программу, которая будет находить произведение двух матриц.");
// Генерация двух случайных и совместимых для перемножения массивов.
// (int m, int n) sizeArray1 = (new Random().Next(5, 10), new Random().Next(5, 10)); // Размеры массива
// (int m, int n) sizeArray2 = (sizeArray1.n, new Random().Next(5, 10)); // Размеры массива
// int[,] array1 = GetRandomIntArray2(sizeArray1.m, sizeArray1.n);
// int[,] array2 = GetRandomIntArray2(sizeArray2.m, sizeArray2.n);

// Конкретный пример из условия для проверки. (Можно раскоментировать то, что выше и каждый раз будет новая генерация матриц)
int[,] array1 = new int[2, 3]
                    {
                        {2, 4, 1},
                        {3, 2, 1}
                    };
int[,] array2 = new int[3, 2]
                    {
                        {3, 4},
                        {3, 3},
                        {1, 1}
                    };

PrintArray2(array1, "Матрица А:");
PrintArray2(array2, "Матрица B:");
if(TryGetMultiplResult(array1, array2, out int[,] multiplResult))
            PrintArray2(multiplResult, "Результат переменожения матриц АxB:");

// Метод перемножения двух матриц
bool TryGetMultiplResult(int[,] array1, int[,] array2, out int[,] multiplResult)
{
    bool isMultipl = array1.GetLength(1) == array2.GetLength(0); 
    if (!isMultipl)
    {
        System.Console.WriteLine("Матрицы несовметимы для перемножения.");
        //Обработку null не делал. Для избежания null можно было бы вместо default написать new[,]{{0}}, но это больше на бред похоже
        multiplResult = default;
        return false;
    }

    (int m, int n) sizeResult = (array1.GetLength(0), array2.GetLength(1)); // Размеры массива
    multiplResult = new int[sizeResult.m, sizeResult.n];
    for (int i = 0; i < sizeResult.m; i++)
        for (int j = 0; j < sizeResult.n; j++)
            multiplResult[i, j] = GetSumMultiplElements(GetRow(array1, i), GetColumn(array2, j));
    return isMultipl;
}

// Метод подсчета суммы произведений соответствующих элементов 1мерных массивов одинаковой длины
int GetSumMultiplElements (int[] array1, int[] array2)
{
    if (array1.Length != array2.Length) System.Console.WriteLine("Что-то пошло не так. Размеры массивов разные.");
    int sum = 0;
    for (int i = 0; i < array1.Length; i++)
            sum += array1[i] * array2[i];
    return sum;
}

// Возврат i-й строки двумерного массива array
int[] GetRow(int[,] array, int i)
{
    int[] rowArray = new int[array.GetLongLength(1)];
    for (int j = 0; j < array.GetLongLength(1); j++) rowArray[j] = array[i, j];
    return rowArray;
}

// Возврат j-й строки двумерного массива array
int[] GetColumn(int[,] array, int j)
{
    int[] columnArray = new int[array.GetLongLength(0)];
    for (int i = 0; i < array.GetLongLength(0); i++) columnArray[i] = array[i, j];
    return columnArray;
}

// Генерация массива с интами
int[,] GetRandomIntArray2(int m = 5, int n = 5)   // в теории передавать и возвращать необязательно, но так удобнее
{
    int[,] array = new int[m, n];
    for (int i = 0; i < array.GetLength(0); i++)        // номера строк (движение вниз)
        for (int j = 0; j < array.GetLength(1); j++)    // номера колонок (движение вправо)
            array[i, j] = new Random().Next(0, 10);
    return array;
}

// Метод вывода 2хмерного массива
void PrintArray2(int[,] array, string message="")
{
    System.Console.WriteLine(message);
    System.Console.WriteLine($"Размеры: {array.GetLength(0)} х {array.GetLength(1)}.");
    for (int i = 0; i < array.GetLength(0); i++)                 // движение по строкам (вниз)
    {
        for (int j = 0; j < array.GetLength(1); j++) System.Console.Write($"{array[i, j]}\t");  // движение по колонкам (вправо) + вывод
        System.Console.WriteLine();
    }
}