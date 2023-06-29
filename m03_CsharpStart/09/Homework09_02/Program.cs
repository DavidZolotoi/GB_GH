// Задача 2: Задайте значения M и N. Напишите программу, которая найдёт сумму натуральных элементов в промежутке от M до N с помощью рекурсии.
Console.WriteLine("Задача 2: Задайте значения M и N. Напишите программу, которая найдёт сумму натуральных элементов в промежутке от M до N с помощью рекурсии.");
(int start, int finish) range = (new Random().Next(-20, 0), new Random().Next(0, 21));
System.Console.WriteLine($"Сумма натуральных в диапазоне с {range.start} по {range.finish} = {SumBetweenNumbers(range)}");

// Рекурсивный способ выведения четных чисел в промежутке
// Судя по википедии в мире между математиками нет единой договоренности о том, включать 0 в натуральные или нет
// Но написано, что в РФ в основном НЕ включают.
long SumBetweenNumbers((int start, int finish) range, long Snatural = 0)
{
    if(range.start > 0) Snatural += range.start;
    range.start += 1;
    if (range.start > range.finish) return Snatural;
    return SumBetweenNumbers(range, Snatural);
}
