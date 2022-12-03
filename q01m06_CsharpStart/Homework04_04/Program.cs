// Напишите программу, которая из массива случайных чисел. Ищет второй максимум (число меньше максимального элемента, но больше всех остальных). Сделать одним циклом
System.Console.WriteLine("Тема №4. Функции.\nПрограмма, которая из массива случайных чисел. Ищет второй максимум (число меньше максимального элемента, но больше всех остальных). Сделать одним циклом");
int[] array = GenerateArray(6, 0, 100);
array[0] = 2;
array[1] = 3;
array[2] = 5;
array[3] = 6;
array[4] = 6;
array[5] = 4;
PrintArray(array);
int max = GetMaxValue(array);
System.Console.WriteLine($"\nmax2 = {max}");

// Метод вычисления максимума
int GetMaxValue(int[] array)
{
    int len = array.Length;
    int maxValueLeft = int.MinValue;
    int maxValueLeft1 = int.MinValue;
    int maxValueLeft2 = int.MinValue;
    int maxValueRight1 = int.MinValue;
    int maxValueRight2 = int.MinValue;
    for (int i=1; i<len; i++)
    {
        //System.Console.WriteLine($"i={i}, l-i={len-i}");
        if (array[i] > maxValueLeft1)
        {
            maxValueLeft2 = maxValueLeft1;
            maxValueLeft1 = array[i];
        }
        if (array[len - i] > maxValueRight1)
        {
            maxValueRight2 = maxValueRight1;
            maxValueRight1 = array[len - i];
        }
    }
    if (maxValueLeft2 > maxValueRight2)
        maxValueLeft = maxValueLeft2;
    else
        maxValueLeft = maxValueRight2;

    return maxValueLeft;
}

// Метод заполнения массива случайными
int[] GenerateArray(int Length, int minRange, int maxRange)
{
    int[] array = new int[Length];
    for (int i = 0; i < array.Length; i++)
    {
        array[i] = new Random().Next(minRange, maxRange + 1);
    }
    return array;
}

// Метод вывода массива в одну строку
void PrintArray(int[] array)
{
    for (int j = 0; j < array.Length; j++)
    {
        Console.Write(array[j] + " ");
    }
}