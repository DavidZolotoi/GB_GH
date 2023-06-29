/* Задача 5: * Найдите максимальное значение в матрице по каждой строке, получите сумму этих максимумов.
Затем найдите минимальное значение по каждой колонке,получите сумму этих минимумов.
Затем из первой суммы (с максимумами) вычтите вторую сумму(с минимумами)

ПЛАН
    1. Генерация массива:
        - диапозон размера: 5-10
        - дипозон значения элемента: 0-9
    2. Вывод массива
    3. Цикл в цикле по всему массиву с поиском всех макс по колонкам и строкам
    4. Вероятнее всего сумму можно посчитать сразу?
*/

Console.WriteLine("Задача 5: * Найдите максимальное значение в матрице по каждой строке, получите сумму этих максимумов. Затем найдите минимальное значение по каждой колонке,получите сумму этих минимумов. Затем из первой суммы (с максимумами) вычтите вторую сумму(с минимумами)");
// Генерация случайного двумерного массива
int[,] array = GetRandomArray2(new Random().Next(5, 10), new Random().Next(5, 10));
// Вывод двумерного массива
PrintArray2(array);
// Обработка анализ массива
(string sumMaxMessageY, int sumMaxY, string sumMaxMessageX, int sumMaxX) maxSpecifications = GetMaxSpecifications(array);
// Вывод результатов
System.Console.WriteLine($"{maxSpecifications.sumMaxMessageY}");
System.Console.WriteLine($"{maxSpecifications.sumMaxMessageX}");
System.Console.WriteLine($"Разница между суммой max по строкам и суммой max по колонкам = {maxSpecifications.sumMaxY} - {maxSpecifications.sumMaxX} = {maxSpecifications.sumMaxY - maxSpecifications.sumMaxX}");


// Метод обработки массива
(string, int, string, int) GetMaxSpecifications(int[,] array)
{
    // Размеры массива
    int deltaX = array.GetLength(1);        // ширина (габарит) (количество колонок)
    int[] maxY = new int[deltaX];           // массив максимумов в колонках
    int deltaY = array.GetLength(0);        // высота (габарит) (количество строк)
    int[] maxX = new int[deltaY];           // массив максимумов в строках
    // Получение массивов максимумов по строкам и столбцам
    string sumMaxMessageY = "Сумма максимумов в строках:\n"; int sumMaxY = 0;
    string sumMaxMessageX = "Сумма максимумов в колонках:\n"; int sumMaxX = 0;
    for (int i = 0; i < deltaY; i++)                // движение по строкам (по оси y)
    {
        maxX[i] = array[i, 0];                      // задать начальные условные максимумы колонок
        for (int j = 0; j < deltaX; j++)            // движение по колонкам (по оси x)
        {
            if (i == 0) maxY[j] = array[0, j];      // условие только для того, чтоб один раз в начале задать начальные условные максимумы строк
            if (array[i, j] > maxY[j]) maxY[j] = array[i, j];
            if (array[i, j] > maxX[i]) maxX[i] = array[i, j];
            if (i == deltaY-1)  // если конец колонки, несмотря на то, что бежим по строкам
            {
                sumMaxX += maxY[j];
                sumMaxMessageX += (j < deltaX-1)?$"{maxY[j]} + ":$"{maxY[j]} = {sumMaxX}.";
            }
        }
        sumMaxY += maxX[i];
        sumMaxMessageY += (i < deltaY-1)?$"{maxX[i]} + ":$"{maxX[i]} = {sumMaxY}.";
    }
    return (sumMaxMessageY, sumMaxY, sumMaxMessageX, sumMaxX);
}

// Метод вывода 2хмерного массива
void PrintArray2(int[,] array)
{
    System.Console.WriteLine($"Задан массив {array.GetLength(0)} х {array.GetLength(1)}:");
    for (int i = 0; i < array.GetLength(0); i++)                 // движение по строкам
    {
        for (int j = 0; j < array.GetLength(1); j++)             // движение по колонкам
        {
            System.Console.Write($"{array[i, j]}\t");
        }
        System.Console.WriteLine();
    }
}

// Метод генерации случайного 2-хмерного массива
int[,] GetRandomArray2(int y = 5, int x = 5)        // ось x - колонки, y - строки
{
    int[,] array = new int[y, x];
    for (int i = 0; i < y; i++)                 // движение по строкам
    {
        for (int j = 0; j < x; j++)             // движение по колонкам
        {
            array[i, j] = new Random().Next(0, 10);
        }
    }
    return array;
}