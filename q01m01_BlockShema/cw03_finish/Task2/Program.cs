// Напишите программу, которая по заданному номеру четверти, 
//показывает диапазон возможных координат точек в этой четверти (x и y)
// Диапазон значений X > 0, Y > 0

int Prompt(string message)
{
    Console.Write($"{message} >");              // Вывод приглашения
    return Convert.ToInt32(Console.ReadLine()); // ввод числа
}
int quater = Prompt("Введите номер четверти:");

switch (quater)
{
    case 1:
        System.Console.WriteLine("Диапазон значений x > 0, y >0");
        break;
    case 2:
        System.Console.WriteLine("Диапазон значений x < 0, y >0");
        break;
    case 3:
        System.Console.WriteLine("Диапазон значений x < 0, y <0");
        break;
    case 4:
        System.Console.WriteLine("Диапазон значений x > 0, y <0");
        break;
    default:
        System.Console.WriteLine("Это не соответствует номеру чечверти!");
        break;
}
