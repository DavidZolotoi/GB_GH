Console.WriteLine("Задача 2: Напишите программу, которая найдёт точку пересечения двух прямых, заданных уравнениями y = k1 * x + coefb1, y = k2 * x + b2; значения b1, k1, b2 и k2 задаются пользователем.");
(double k, double b) equation1 = (k: InputInteger("Введите k1: "), b: InputInteger("Введите b1: "));
(double k, double b) equation2 = (k: InputInteger("Введите k2: "), b: InputInteger("Введите b2: "));
(double? x, double? y, string outputMessage) intersectionPoint = GetIntersectionPoint(equation1, equation2);
System.Console.WriteLine(intersectionPoint.outputMessage);

// Метод поиска точки пересечения и создания выходного сообщения
(double? x, double? y, string outputMessage) GetIntersectionPoint((double k, double b) equation1, (double k, double b) equation2)
{
    string outputMessage;
    if ((equation1.k == equation2.k) && (equation1.b == equation2.b))
    {
        outputMessage = "Прямые совпадают";
        return (null, null, outputMessage);
    }
    if ((equation1.k == equation2.k) && (equation1.b != equation2.b))
    {
        outputMessage = "Прямые параллельны";
        return (null, null, outputMessage);
    }
    double x = (equation1.b - equation2.b) / (equation2.k - equation1.k);
    double y = equation1.k * x + equation1.b;
    outputMessage = $"Точкой пересечения прямых y = {equation1.k:f2}x + {equation1.b:f2} и y = {equation2.k:f2}x + {equation2.b:f2} является ({x:f2}, {y:f2}).";
    return (x, y, outputMessage);
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