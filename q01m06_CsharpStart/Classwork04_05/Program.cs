// Задача *: Напишите программу, 
// которая из массива случайных чисел. Ищет второй максимум
//  (число меньше максимального элемента, но больше всех остальных).
//   Постарайтесь сделать одним циклом 
// [1, 3, 5, 6, 6, 4] -> 5

int[] GenerateArray(int Length, int minRange, int maxRange)
{

    int[] array = new int[Length];
    for (int i = 0; i < array.Length; i++)
    {
        array[i] = new Random().Next(minRange, maxRange+1);
    }
    return array;
}

void PrintArray(int[] array)
{
    for (int j = 0; j < array.Length; j++)
    {
        Console.Write(array[j] + " ");
    }
}

int Promt(String message)
{
    System.Console.Write(message);
    return Convert.ToInt32(Console.ReadLine());
}

// int maxValueIndex(int[] array){
//     int maxValue = array[0];
//     for (int i=1; i<array.Length; i++){
//         if (maxValue<array[i]){
//             maxValue = array[i];
//         }
//     }
//     return maxValue;
// }

int maxValueIndex(int[] array){
    int maxValue1 = int.MinValue;
    int maxValue2 = int.MinValue;
    for (int i=1; i<array.Length; i++){
        if (maxValue1<array[i]){
            maxValue1 = array[i];

        }
    }

    for (int i=1; i<array.Length; i++) {
        if (array[i] == maxValue1){
                continue;
        }
        if (maxValue2 < array[i]) {
            maxValue2 = array[i];
        }
    }

    return maxValue2;
}


int Range = Promt("Введите длину массива ");
int minValue = Promt("Введите минимальное значение ");
int maxValue = Promt("Введите максимальное значение ");


int [] arr = GenerateArray(Range, minValue, maxValue);
PrintArray(arr);
Console.WriteLine("Второй максимум массива равен: " + maxValueIndex(arr));