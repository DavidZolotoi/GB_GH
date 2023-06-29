// Задача 3: Не используя рекурсию, выведите первые N чисел Фибоначчи. Первые два числа Фибоначчи: 0 и 1.
// Если N = 5 -> 0 1 1 2 3
// Если N = 3 -> 0 1 1
// Если N = 7 -> 0 1 1 2 3 5 8

int Prompt(string message)
{
    Console.Write($"{message} >");              // Вывод приглашения
    return Convert.ToInt32(Console.ReadLine()); // ввод числа
}
void PrintList(int[] list)
{
    for (int i = 0; i < list.Length; i++)
    {
        System.Console.WriteLine(list[i]);
    }
}
int[] Fibonacci(int arg)
{
    int[] FibRow=new int[arg];
    FibRow[0]=0;
    FibRow[1]=1;
    for (int i = 2; i < arg; i++)
    {
        FibRow[i]=FibRow[i-1]+FibRow[i-2];
    }
    return FibRow;
}
PrintList(Fibonacci(Prompt("Введите количество необходимых чисел")));
