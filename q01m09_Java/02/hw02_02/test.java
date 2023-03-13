import java.io.File;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
/*
 * Реализуйте алгоритм сортировки пузырьком числового массива,
 * результат после каждой итерации запишите в лог-файл.
 */
public class test
{
    public static void main(String[] args)
    {
        // генерация листа
        LinkedList<Integer> integerList = GenerateArrayListInteger(20, -10, 10);
        // вывод исходного листа
        System.out.printf("Сгенерирован массив: \n%s\n", OutputList(integerList, "  "));
        // путь к файлу логов
        String fileLogPath = GetPathForLogFile();
        // вывод отсортированного листа пузырьком
        System.out.printf("Сортированный массив: \n%s\n", OutputList(BubbleSort(integerList, fileLogPath), "  "));
    }

    // Сортировка листа пузырьком методами добавления и удаления элементов класса LinkedList с логированием
    private static LinkedList<Integer> BubbleSort(LinkedList<Integer> integerList, String fileLogPath)
    {
        FileHandler fileLog;
        Logger logger = Logger.getLogger(test.class.getName());
        try
        {
            fileLog = new FileHandler(fileLogPath);
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
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return integerList;
    }

    private static String GetPathForLogFile()
    {
        String fileLogPath = "";
        try
        {
            // путь к файлу
            String pathFileJava = Class.forName("hw02_02").getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            // сепоратор, который есть в этом пути
            String seporator1 = (pathFileJava.indexOf("/") > -1)?"/":"\\";
            // родительский каталог
            String pathParent = pathFileJava.substring(0, pathFileJava.lastIndexOf(seporator1) + 1);
            // путь к файлу логов
            fileLogPath = pathParent + "MyLogFile.log";
            File myLogFile = new File(fileLogPath);
            if (!myLogFile.exists()) myLogFile.createNewFile();
            // сепоратор, который есть в пути к файлу логов (он скорее всего отличается от того, что выше)
            String seporator2 = (myLogFile.getAbsolutePath().indexOf("\\") > -1)?"\\":"/";
            fileLogPath = fileLogPath.replace(seporator1, seporator2);  
            // если в пути к созданному файлу логов первый символ не дробь, то и в переменной пути его не должно быть
            if (fileLogPath.substring(0, 1).equals(seporator2))
                fileLogPath = fileLogPath.substring(1, fileLogPath.length());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return fileLogPath;
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
