// Напишите программу, которая принимает на вход координаты двух точек
// и находит расстояние между ними в 2D пространстве.
// A (3,6); B (2,1) -> 5,09 
// A (7,-5); B (1,-1) -> 7,21

int Prompt(string message)
{
    Console.Write($"{message} >");              // Вывод приглашения
    return Convert.ToInt32(Console.ReadLine()); // ввод числа
}
int x1 = Prompt("Введите x1");
int x2 = Prompt("Введите x2");
int y1 = Prompt("Введите y1");
int y2 = Prompt("Введите y2");
int deltax = x1 - x2;
int deltay = y1 - y2;
double distance = Math.Sqrt(deltax*deltax+deltay*deltay);
System.Console.WriteLine(distance);
