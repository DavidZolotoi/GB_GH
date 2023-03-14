import java.io.File;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*
 * Реализовать алгоритм сортировки слиянием
 */

public class hw03_01
{
    public static void main(String[] args)
    {
        // Создать файл логов с указанным именем рядом с исполняемым файлом
        String fileLogPath = GetPathForLogFile("LogsMergeSort.log");
        // Логгер
        Logger logger = GetLogger(fileLogPath);
        // генерация листа
        LinkedList<Integer> integerList = GenerateArrayListInteger(20, -10, 10);
        // вывод исходного листа
        System.out.printf("Сгенерирован массив: \n%s\n", OutputList(integerList, "  "));
        // вывод отсортированного листа пузырьком
        System.out.printf("Сортированный массив: \n%s\n", OutputList(MergeSort(integerList, logger), "  "));
    }
    
    // Сортировка слиянием методами класса LinkedList с логированием
    private static LinkedList<Integer> MergeSort(LinkedList<Integer> integerList, Logger logger) {
        logger.info("Начало метода сортировки.");

        Integer oldListLength = integerList.size();
        if (oldListLength == 1) return integerList;

        Integer newListLength = oldListLength / 2;
        LinkedList<Integer> newListLeft = new LinkedList<>();
        LinkedList<Integer> newListRight = new LinkedList<>();
        for (int i = 0; i < newListLength; i++)
            newListLeft.add(i, integerList.get(i));
        for (int i = newListLength; i < oldListLength; i++) 
            newListRight.add(i - newListLength, integerList.get(i));

        // Рекурсия
        MergeSort(newListLeft, logger);
        MergeSort(newListRight, logger);
        Merge(integerList, newListLeft, newListRight);

        logger.info("Конец метода сортировки.");
        return integerList;
    }

    // 
    private static void Merge(  LinkedList<Integer> integerList,
                                LinkedList<Integer> newListLeft,
                                LinkedList<Integer> newListRight)
    {
        Integer listLeftCount = newListLeft.size();
        Integer listRightCount = newListRight.size();
        Integer indexLeft = 0;
        Integer indexRight = 0;
        Integer indexList = 0;

        while (indexLeft < listLeftCount && indexRight < listRightCount)
        {
            if (newListLeft.get(indexLeft) < newListRight.get(indexRight))
            {
                integerList.add(indexList, newListLeft.get(indexLeft));
                indexLeft++;
            }
            else
            {
                integerList.add(indexList, newListRight.get(indexRight));
                indexRight++;
            }
            indexList++;

            for (int i = indexLeft; i < listLeftCount; i++)
                newListLeft.add(indexList++, newListLeft.get(i));
            for (int i = indexRight; i < listRightCount; i++) 
                newListRight.add(indexList++, newListRight.get(i));
        }
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

    // Возврат логгера
    private static Logger GetLogger(String fileLogPath)
    {
        // сам логгер
        Logger logger = Logger.getLogger(hw03_01.class.getName());
        try
        {
            FileHandler fileLog = new FileHandler(fileLogPath);  
            Formatter simpleFormatter = new SimpleFormatter();
            fileLog.setFormatter(simpleFormatter);
            logger.setUseParentHandlers(false);
            logger.addHandler(fileLog);
        }
        catch (Exception e)
        {
            System.out.println("Не удалось создать логгер.");
            System.out.println(e.getMessage());
        }
        return logger;
    }
    
    // Получение пути рядом с исполняемым файлом
    private static String GetPathForLogFile(String fileName)
    {
        String fileLogPath = "";
        try
        {
            // путь к файлу
            String pathFileJava = Class.forName("hw03_01").getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            // сепоратор, который есть в этом пути
            String seporator1 = (pathFileJava.indexOf("/") > -1)?"/":"\\";
            // родительский каталог
            String pathParent = pathFileJava.substring(0, pathFileJava.lastIndexOf(seporator1) + 1);
            // путь к файлу логов
            fileLogPath = pathParent + fileName;
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
            System.out.println("Не удалось получить путь к исполняемому файлу.");
            System.out.println(e.getMessage());
        }
        return fileLogPath;
    }
}
