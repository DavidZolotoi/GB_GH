// Задача 4. (*) Напишите программу, которая заполнит спирально массив 4 на 4. 
Console.WriteLine("Задача 4. (*) Напишите программу, которая заполнит спирально массив 4 на 4. ");
(int m, int n) sizeArray = (new Random().Next(3, 10), new Random().Next(3, 10)); // Размеры массива
PrintArray2(GetFillArray2(sizeArray));


// Метод заполнения 2мерного массива змейкой
int[,] GetFillArray2((int m, int n) sizeArray)
{
    int[,] result = new int[sizeArray.m, sizeArray.n];
    (int height, int width) rectangleSize = (result.GetLength(0), result.GetLength(1));
    int iStart = 0, jStart = 0;
    int valueCurrent = 1;
    while (true)   // в данной конкретной задаче valueCurrent совпадает с количеством
    {
        // Движение по верхней стороне прямоугольника - вправо
        FillTopSideRectangle(result, rectangleSize.width, iStart, jStart, valueCurrent);
        jStart = jStart + rectangleSize.width - 1;
        valueCurrent = valueCurrent + rectangleSize.width - 1;
        if (valueCurrent > result.Length) return result;
        // Движение по правой стороне прямоугольника - вниз
        FillRightSideRectangle(result, rectangleSize.height, iStart, jStart, valueCurrent);
         iStart = iStart + rectangleSize.height - 1;
        valueCurrent = valueCurrent + rectangleSize.height - 1;
        if (valueCurrent > result.Length) return result;
        // Движение по нижней стороне прямоугольника - влево
        FillBottomSideRectangle(result, rectangleSize.width, iStart, jStart, valueCurrent);
        jStart = jStart - rectangleSize.width + 1;
        valueCurrent = valueCurrent + rectangleSize.width - 1;
        if (valueCurrent > result.Length) return result;
        // Движение по левой стороне прямоугольника - вверх
        FillLeftSideRectangle(result, rectangleSize.height, iStart, jStart, valueCurrent);
        iStart = iStart - rectangleSize.height + 2;
        jStart += 1;
        valueCurrent = valueCurrent + rectangleSize.height - 1;
        if (valueCurrent > result.Length) return result;
        rectangleSize = (rectangleSize.height - 2, rectangleSize.width - 2);
    }
}

// Метод заполнения верхней стороны нового прямоугольника
void FillTopSideRectangle(int[,] array, int rectangleWidth, int iStart, int jStart, int valueCurrent)
{
    for (int j = jStart; j < jStart + rectangleWidth; j++)
    {
        array[iStart, j] = valueCurrent;
        valueCurrent += 1;
    }
}

// Метод заполнения правой стороны нового прямоугольника
void FillRightSideRectangle(int[,] array, int rectangleHeight, int iStart, int jStart, int valueCurrent)
{
    for (int i = iStart; i < iStart + rectangleHeight; i++)
    {
        array[i, jStart] = valueCurrent;
        valueCurrent += 1;
    }
}

// Метод заполнения нижней стороны нового прямоугольника
void FillBottomSideRectangle(int[,] array, int rectangleWidth, int iStart, int jStart, int valueCurrent)
{
    for (int j = jStart; j > jStart - rectangleWidth; j--)
    {
        array[iStart, j] = valueCurrent;
        valueCurrent += 1;
    }
}

// Метод заполнения левой стороны нового прямоугольника
void FillLeftSideRectangle(int[,] array, int rectangleHeight, int iStart, int jStart, int valueCurrent)
{
    for (int i = iStart; i > iStart - rectangleHeight + 1; i--)
    {
        array[i, jStart] = valueCurrent;
        valueCurrent += 1;
    }
}

// Метод вывода 2хмерного массива
void PrintArray2(int[,] array, string message = "")
{
    System.Console.WriteLine(message);
    System.Console.WriteLine($"Размеры: {array.GetLength(0)} х {array.GetLength(1)}.");
    for (int i = 0; i < array.GetLength(0); i++)                 // движение по строкам (вниз)
    {
        for (int j = 0; j < array.GetLength(1); j++) System.Console.Write($"{array[i, j]}\t");  // движение по колонкам (вправо) + вывод
        System.Console.WriteLine();
    }
}