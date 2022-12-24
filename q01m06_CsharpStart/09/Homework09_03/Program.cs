// Задача 3: Напишите программу вычисления функции Аккермана с помощью рекурсии. Даны два неотрицательных числа m и n.
Console.WriteLine("Задача 3: Напишите программу вычисления функции Аккермана с помощью рекурсии. Даны два неотрицательных числа m и n.");
System.Console.WriteLine($"Akker(0, 0) = {Akker()}");
System.Console.WriteLine($"Akker(1, 2) = {Akker(1, 2)}");
System.Console.WriteLine($"Akker(2, 3) = {Akker(2, 3)}");
System.Console.WriteLine($"Akker(3, 2) = {Akker(3, 2)}");

// Вычисления Akker(4, 3) вряд ли дождемся
double Akker(double m = 0, double n = 0)
{
    if (m < 0 || n < 0) { System.Console.WriteLine("Неверное условие"); return -1; }

    double AkkerValue;
    if (m == 0) return n + 1;

    if (m > 0 && n == 0)
    {
        AkkerValue = Akker(m - 1, 1);
        return AkkerValue;
    }

    AkkerValue = Akker(m - 1, Akker(m, n - 1));
    return AkkerValue;
}

/*
akkerValue = Akker(1, 5)
akkerValue = Akker(1, Akker(0, Akker(1, 4)))
akkerValue = Akker(1, Akker(0, Akker(0, Akker(0, 3))))
akkerValue = Akker(1, Akker(0, Akker(0, Akker(0, Akker(0, 2)))))
akkerValue = Akker(1, Akker(0, Akker(0, Akker(0, Akker(0, Akker(0, 1))))))
akkerValue = Akker(1, Akker(0, Akker(0, Akker(0, Akker(0, Akker(0, Akker(0, 0)))))))
akkerValue = Akker(1, Akker(0, Akker(0, Akker(0, Akker(0, Akker(0, 1))))))
akkerValue = Akker(1, Akker(0, Akker(0, Akker(0, Akker(0, 2)))))
akkerValue = Akker(1, Akker(0, Akker(0, Akker(0, 3))))
akkerValue = Akker(1, Akker(0, Akker(0, 4)))
akkerValue = Akker(1, Akker(0, 5))
akkerValue = Akker(1, 6)
akkerValue = 7
*/