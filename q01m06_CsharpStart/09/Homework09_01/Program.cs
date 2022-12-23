// Задача 1: Задайте значения M и N. Напишите программу, которая выведет все чётные натуральные числа в промежутке от M до N с помощью рекурсии.
Console.WriteLine("Задача 1: Задайте значения M и N. Напишите программу, которая выведет все чётные натуральные числа в промежутке от M до N с помощью рекурсии.");
(int start, int finish) range = (new Random().Next(1, 11), new Random().Next(10, 21));
System.Console.WriteLine($"Выбран диапозон с {range.start} по {range.finish}.");
string txt = recurs(range); // результат работы рекурсивного метода
System.Console.WriteLine(txt);

// Рекурсивный способ выведения четных чисел в промежутке
string recurs((int start, int finish) range, string outputText="Четные числа в указанном диапазоне: ")
{
    if(range.start % 2 == 0)
        outputText += range.start.ToString() + "  ";
    range.start += 1;
    if (range.start > range.finish) return outputText;
    return recurs(range, outputText);
}