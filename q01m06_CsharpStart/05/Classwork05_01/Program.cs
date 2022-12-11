// Напишите программу замены элементов массива: положительные элементы замените на соответствующие отрицательные, и наоборот.
// [-4, -8, 8, 2] -> [4, 8, -8, -2]

int[] numbers = GenerateArray(15, -10, 10);
System.Console.WriteLine("Сгенерированный массив");
PrintArray(numbers);
System.Console.WriteLine("\nОбработанный массив");
PrintArray(inverseElement(numbers));

int[] inverseElement(int[] numbers)
{
    for (int i = 0; i < numbers.Length; i++)
    {
        numbers[i] = -numbers[i];
    }
    return numbers;
}

int[] GenerateArray(int Length, int minRange, int maxRange)
{

    int[] array = new int[Length];
    for (int i = 0; i < array.Length; i++)
    {
        array[i] = new Random().Next(minRange, maxRange + 1);
    }
    return array;
}

void PrintArray(int[] array)
{
    for (int j = 0; j < array.Length; j++)
    {
        Console.Write(array[j] + "\t");
    }
}

