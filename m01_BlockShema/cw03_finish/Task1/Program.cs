// Напишите программу, которая принимает на вход координаты точки (X и Y),
// причём X ≠ 0 или Y ≠ 0 и выдаёт номер четверти плоскости, в которой находится эта точка.

// Напишите программу, которая принимает на вход координаты точки (X и Y),
// причём X ≠ 0 или Y ≠ 0 и выдаёт номер четверти плоскости, в которой находится эта точка.

// Функция вывода приглашения и ввода целого числа
int Prompt(string message)
{
    Console.Write($"{message} >");              // Вывод приглашения
    return Convert.ToInt32(Console.ReadLine()); // ввод числа
}

// Проверка на корректность данных, x и y должны быть больше 0
bool ValidateQuarter(int x, int y)
{
    if (x == 0 || y == 0)       // Сама проверка
    {
        // проверку не прошли
        System.Console.WriteLine("Одна из координат равна 0");
        return false;
    }

    // проверку прошли, работаем дальше
    return true;
}

// Получение номера четверти по координатам
int GetQuarter(int x, int y)
{
    if (y > 0 && x > 0) // 1-я четверть
    {
        return 1;
    }
    if (y > 0 && x < 0) // 2-я четверть
    {
        return 2;
    }
    if (y < 0 && x < 0) // 3-я четверть
    {
        return 3;
    }
    return 4;           // Все остальное 4-я четверть
}

int coordX = Prompt("Введите X");
int coordY = Prompt("Введите Y");

if (ValidateQuarter(coordX, coordY))
{
    int quarter = GetQuarter(coordX, coordY);
    System.Console.WriteLine($"Полученная четверть {quarter}");
}
// -----------------

