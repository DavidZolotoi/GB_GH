Console.WriteLine("Тема №3. Базовые алгоритмы. Продолжение.\nЗадача 2. Программа, которая принимает на вход координаты двух точек и находит расстояние между ними в 3D пространстве.");
// Вводим
double x1 = InputDouble("Для решения задачи необходимо ввести координаты.\nВведите координату x 1-й точки: ");
double y1 = InputDouble("Введите координату y 1-й точки: ");
double x2 = InputDouble("Введите координату x 2-й точки: ");
double y2 = InputDouble("Введите координату y 2-й точки: ");
// Счиатем
double len = Math.Sqrt(squareDif(x2, x1) + squareDif(y2, y1));
// Выводим
System.Console.WriteLine($"Расстояние между точками ({x1}, {y1}) и ({x2}, {y2}) равно {len:f}.");

// Метод возведения разницы в квадрат
double squareDif(double a1, double a2)
{
    return (a2-a1)*(a2-a1);
}

// Метод ввода double
double InputDouble(string messageText)
{
    bool isNumber = false; double number = -1;
    while (!isNumber)
    {
        System.Console.WriteLine(messageText);
        isNumber = double.TryParse(Console.ReadLine(), out number);
    }
    return number;
}