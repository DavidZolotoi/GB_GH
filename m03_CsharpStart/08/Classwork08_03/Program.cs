// Задача 3: Составить частотный словарь элементов двумерного массива.
//  Частотный словарь содержит информацию о том, сколько раз 
//  встречается элемент входных данных. Значения элементов массива 0..9
int[,] CreateFillArray(int m)
{
    int[,] array = new int[m, m];
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < m; j++)
        {
            array[i, j] = new Random().Next(1, 10);
        }
    }
    return array;
}
void PrintArray(int[,] list)
{
    for (int i = 0; i < list.GetLength(0); i++)
    {
        for (int j = 0; j < list.GetLength(1); j++)
        {
            System.Console.Write($"{list[i, j]} ");
        }
        System.Console.WriteLine();
    }
}
int[] Dictionary(int[,] array)
{
    int[] Dict = new int[10];
    foreach (int item in array)
    {
        Dict[item]++;
    }
    return Dict;
}
void PrintList(int[] list)
{
    for (int i = 0; i < list.Length; i++)
    {
        System.Console.WriteLine(list[i]);
    }
}
int[,] matrix = CreateFillArray(4);
PrintArray(matrix);
System.Console.WriteLine();
PrintList(Dictionary(matrix));