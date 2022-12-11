// Задача 2: Задайте двумерный массив. Найдите элементы,
//  у которых обе позиции чётные, и замените эти элементы на их квадраты.

int[,] ChangeArray(int[,] matr)
{
    for (int i = 1; i < matr.GetLength(0); i+=2)
    {
        for (int j = 1; j < matr.GetLength(1); j+=2)
        {
            matr[i,j]=matr[i, j] * matr[i, j];
        }
    }
    return matr;
}

void PrintArray(int[,] matr)
{
    for (int i = 0; i < matr.GetLength(0); i++)
    {
        for (int j = 0; j < matr.GetLength(1); j++)
        {
            System.Console.Write($"{matr[i, j]}\t");
        }
        System.Console.WriteLine();
    }
}
int[,] matrix ={
    {1,4,2,1,7,},
    {8,4,2,7,9,},
    {4,7,0,2,3}
};
PrintArray(matrix);
System.Console.WriteLine();
PrintArray(ChangeArray(matrix));
