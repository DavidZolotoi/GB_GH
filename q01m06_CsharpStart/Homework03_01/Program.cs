Console.WriteLine("Тема №3. Базовые алгоритмы. Продолжение.\nЗадача 1. Программа, которая принимает на вход пятизначное число и проверяет, является ли оно палиндромом. Не использовать строки");
int number = InputInteger("Для решения задачи необходимо ввести число.\nВведите число: ");
int temp = number;
int numberBack = 0;
while(temp > 0)
{
    numberBack = (numberBack * 10) + (temp % 10);
    temp /= 10;
}
if (number == numberBack)
    System.Console.WriteLine($"Число {number} является палиндромом.");
else
    System.Console.WriteLine($"Число {number} не является палиндромом.");

// // Способ решения через тернарные операторы
// System.Console.WriteLine
// (
//     (number == numberBack)?
//         $"Число {number} является палиндромом."
//     :
//         $"Число {number} не является палиндромом."
// );

// Метод ввода int
int InputInteger(string messageText)
{
    bool isNumber = false; int number = -1;
    while(!isNumber)
    {
        System.Console.WriteLine(messageText);
        isNumber = int.TryParse(Console.ReadLine(), out number);
    }
    return number;
}