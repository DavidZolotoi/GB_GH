// Напишите программу, которая принимает на вход число (N) и выдаёт таблицу квадратов чисел от 1 до N.
// 5 -> 1, 4, 9, 16, 25.
// 2 -> 1,4

int Prompt(string message)
{
    System.Console.Write($"{message}>");                // вывод приглашения
    int answer = Convert.ToInt32(Console.ReadLine());   // ввод числа
    return answer;
}

int number = Prompt("Введите число");
int start = 1;

int mod = number;
if (mod <0)
{
    mod = -mod;
}

while (start <= mod)
{
    int square = start*start;
    System.Console.WriteLine(square);
    start += 1;
}
