Console.WriteLine("Тема №3. Базовые алгоритмы. Продолжение.\nЗадача 3. Программа, которая принимает на вход число (N) и выдаёт таблицу кубов чисел от 1 до N.");
// Вводим
int N = InputInteger("Для решения задачи необходимо ввести конечное число N.\nВведите N: ");
System.Console.WriteLine($"Таблица кубов чисел от 1 до {N}");
TableCubePrint(1, N);

// Метод вывода таблицы кубов
void TableCubePrint(int a1, int a2)
{
    for (int i = a1; i <= a2; i++) System.Console.Write($"{i*i*i} ");
}

// Метод ввода int
int InputInteger(string messageText)
{
    bool isNumber = false; int number = -1;
    while (!isNumber)
    {
        System.Console.WriteLine(messageText);
        isNumber = int.TryParse(Console.ReadLine(), out number);
    }
    return number;
}