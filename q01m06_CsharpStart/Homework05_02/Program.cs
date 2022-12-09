Console.WriteLine("Задача 2: Задайте одномерный массив, заполненный случайными числами. Найдите сумму элементов, стоящих на нечётных позициях.");

int[] array = CreateArray(5, 0, 10);
System.Console.WriteLine("Имеющийся массив:");
PrintArray(array);
int sum = getSumAddNumber(array);
System.Console.WriteLine($"Сумма элементов, стоящих на нечётных позициях равна {sum}.");

// определение суммы элементов, стоящих на нечётных позициях (сделал не применяя if(){}else{})
int getSumAddNumber(int[] array)
{
    int sum = 0;
    for (int i = 0; i < array.Length; i++)
        sum += (i % 2==1) ? array[i] : 0;
    return sum;
}

// генерация массива
int[] CreateArray(int Length, int minRange, int maxRange)
{

    int[] numbers = new int[Length];
    for (int i = 0; i < numbers.Length; i++)
    {
        numbers[i] = new Random().Next(minRange, maxRange + 1);
    }
    return numbers;
}

// вывод массива
void PrintArray(int[] array)
{
    for (int j = 0; j < array.Length; j++)
    {
        Console.Write(array[j] + "\t");
    }
    Console.WriteLine();
}