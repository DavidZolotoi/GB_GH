// Задача 5*: Напишите программу, которая генерирует последовательность случайных чисел из 10 элементов
//  в диапазоне от 1 до 10, и подсчитывает, сколько сгенерировалось чисел больше 5.

int [] numArray = new int [10];
int numQuant = 0;

for (int i=0;i<numArray.Length;i++)
{
    int tmp = new Random().Next(1,10);
    numArray [i] = tmp;
    System.Console.WriteLine(tmp);
    if (numArray [i] > 5)
    {
        numQuant += 1;
    }
}
System.Console.WriteLine($"Количество значений больше 5 - {numQuant}");
