import java.util.LinkedList;
import java.util.Random;
/*
 * Реализуйте алгоритм сортировки пузырьком числового массива,
 * результат после каждой итерации запишите в лог-файл.
 */
public class hw02_02
{
    public static void main(String[] args)
    {
        // генерация листа
        LinkedList<Integer> integerList = GenerateArrayListInteger(20, -10, 10);
        // вывод исходного листа
        System.out.printf("Сгенерирован массив: \n%s\n", OutputList(integerList, "  "));
        // вывод отсортированного листа пузырьком
        System.out.printf("Сортированный массив: \n%s\n", OutputList(BubbleSort(integerList), "  "));
    }

    // Сортировка листа пузырьком методами добавления и удаления элементов класса LinkedList
    private static LinkedList<Integer> BubbleSort(LinkedList<Integer> integerList)
    {
        for (int i = 0; i < integerList.size(); i++)
        {
            for (int j = 1; j < integerList.size() - i; j++)
            {
                if (integerList.get(j - 1) > integerList.get(j))        // нашли пару для замены
                {
                    integerList.add(j + 1, integerList.get(j - 1));     // добавили справа от пары больший
                    integerList.remove(j - 1);                          // удалили больший слева
                }
            }
        }
        return integerList;
    }

    // Вывод массива в строку с сепоратором
    private static String OutputList(LinkedList<Integer> integerList, String seporator)
    {
        StringBuilder outputText = new StringBuilder("");
        for (int i = 0; i < integerList.size(); i++)
        {
            outputText.append(integerList.get(i).toString());
            if (i != integerList.size() - 1) outputText.append(seporator);
        }
        return outputText.toString();
    }

    // Генерация листа интеджеров
    private static LinkedList<Integer> GenerateArrayListInteger(Integer count, Integer minValue, Integer maxValue)
    {
        LinkedList<Integer> integerList = new LinkedList<>();
        Random rnd = new Random();
        for (int i = 0; i < count; i++)
            integerList.add(minValue + rnd.nextInt(maxValue - minValue + 1));

        return integerList;
    }
}
