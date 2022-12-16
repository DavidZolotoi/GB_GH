Console.WriteLine("Задача 1: Пользователь вводит c клавиатуры M чисел. Посчитайте, сколько чисел больше 0 ввёл пользователь.");
int[] array = CreateFillArrayInteger();    // Здесь создание массива array не нужно, но я так сделал, чтоб был понятен смысл строки
System.Console.WriteLine($"Количество положительных элементов в массиве: {GetNumbersPositive(array)}.");

// Подсчет положительных
int GetNumbersPositive(int[] array)
{
    int numbersPositive = 0;
    foreach (var item in array) numbersPositive = (item>0)? numbersPositive+1 : numbersPositive;
    return numbersPositive;
}

// Заполнение массива пользователем
int[] CreateFillArrayInteger()
{
    int number = -1;
    while (number < 0) number = InputInteger("Введите количество элементов для ввода: ");
    int[] array = new int [number]; 
    System.Console.WriteLine("Введите элементы массива.");
    for (int i = 0; i < array.Length; i++) array[i] = InputInteger($"{i+1}-й элемент: ");
    return array;
}

// Метод ввода int
int InputInteger(string messageText)
{
    bool isNumber = false; int number = -1;
    while (!isNumber)
    {
        System.Console.Write(messageText);
        isNumber = int.TryParse(Console.ReadLine(), out number);
    }
    return number;
}