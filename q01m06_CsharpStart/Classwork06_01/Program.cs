// Напишите программу, которая перевернёт одномерный массив 
// (последний элемент будет на первом месте, а первый - на последнем и т.д.)

int[] GenerateArray(int len)
{
    int[] array = new int[len];
    for (int i = 0; i < array.Length; i++)
    {
        array[i] = new Random().Next(1, 10);
    }
    return array;
}

void PrintArray(int[] array)
{
    foreach (int item in array)
    {
        System.Console.Write($"{item}  ");
    }
    System.Console.WriteLine();
}

int[] ReverseArray(int[] array)
{
    for (int i = 0; i < array.Length / 2; i++)
    {
        swap2(array, i, array.Length - 1 - i);
    }
    return array;
}

void swap1(int[] array, int i1, int i2)
{
    int temp = array[i1];
    array[i1] = array[i2];
    array[i2] = temp;
}

void swap2(int[] array, int i1, int i2)
{
    (array[i1], array[i2]) = (array[i2], array[i1]);
}

int[] array = GenerateArray(10);
PrintArray(array);
PrintArray(ReverseArray(array));
