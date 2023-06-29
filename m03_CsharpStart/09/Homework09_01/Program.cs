// Задача 1: Задайте значения M и N. Напишите программу, которая выведет все чётные натуральные числа в промежутке от M до N с помощью рекурсии.
Console.WriteLine("Задача 1: Задайте значения M и N. Напишите программу, которая выведет все чётные натуральные числа в промежутке от M до N с помощью рекурсии.");
(int start, int finish) range = (new Random().Next(1, 11), new Random().Next(10, 21));
System.Console.WriteLine($"Четные числа в диапазоне с {range.start} по {range.finish}: {ShowEvenNumbers(range)}");

// Рекурсивный способ выведения четных чисел в промежутке
string ShowEvenNumbers((int start, int finish) range, string outputText="")
{
    if(range.start % 2 == 0) outputText += range.start.ToString() + "  ";
    range.start += 1;
    if (range.start > range.finish) return outputText;
    return ShowEvenNumbers(range, outputText);
}
