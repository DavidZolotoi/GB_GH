// 2-ой подход: условия вытащил из метода, не использовал Null, только один кортеж для точки пересечения
Console.WriteLine("Задача 2: Напишите программу, которая найдёт точку пересечения двух прямых, заданных уравнениями y = k1 * x + coefb1, y = k2 * x + b2; значения b1, k1, b2 и k2 задаются пользователем.");
double k1 = InputInteger("Введите k1: ");   double b1 = InputInteger("Введите b1: ");
double k2 = InputInteger("Введите k2: ");   double b2 = InputInteger("Введите b2: ");
(double x, double y) intersectionPoint = default;
string outputMessage;
if ((k1 == k2) && (b1 == b2))
    outputMessage = "Прямые совпадают";
else if ((k1 == k2) && (b1 != b2))
    outputMessage = "Прямые параллельны";
else
{
    GetIntersectionPoint(k1, b1, k2, b2, out intersectionPoint);
    outputMessage = $"Точкой пересечения прямых y = {k1:f2}x + {b1:f2} и y = {k2:f2}x + {b2:f2} является ({intersectionPoint.x:f2}, {intersectionPoint.y:f2}).";
}
System.Console.WriteLine(outputMessage);

// Метод поиска точки пересечения 
void GetIntersectionPoint
            (
                double k1, double b1,
                double k2, double b2,
                out (double x, double y) intersectionPoint
            )
{
    intersectionPoint.x = (b1 - b2) / (k2 - k1);
    intersectionPoint.y = k1 * intersectionPoint.x + b1;
    return;
}

// Метод ввода double
double InputInteger(string messageText = "")
{
    bool isNumber = false; double number = -1;
    while (!isNumber)
    {
        System.Console.Write(messageText);
        isNumber = Double.TryParse(Console.ReadLine(), out number);
    }
    return number;
}