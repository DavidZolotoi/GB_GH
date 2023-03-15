import java.io.File;
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
        Integer[] integerList = GenerateArrayInteger(20, -10, 10, logger);
        // вывод исходного листа
        System.out.printf("Сгенерированный массив: \n%s\n", OutputList(integerList, "  ", logger));
        // вывод отсортированного листа пузырьком
        System.out.printf("Сортированный массив: \n%s\n", OutputList(MergeSort(integerList, logger), "  ", logger));
        
        logger.info("Работа программы завершена.");
    }
    
    // Сортировка слиянием с логированием
    private static Integer[] MergeSort(Integer[] integerList, Logger logger)
    {
        logger.info("Начало работы метода сортировки слиянием (рекурсия).");
        
        Integer oldListLength = integerList.length;
        if (oldListLength == 1) return integerList;
        
        Integer newListLength = oldListLength / 2;
        Integer[] newListLeft = new Integer[newListLength];
        Integer[] newListRight = new Integer[oldListLength - newListLength];
        for (int i = 0; i < newListLength; i++)
            newListLeft[i] = integerList[i];
        for (int i = newListLength; i < oldListLength; i++) 
            newListRight[i - newListLength] = integerList[i];
        
        // Рекурсия
        MergeSort(newListLeft, logger);
        MergeSort(newListRight, logger);
        Merge(integerList, newListLeft, newListRight, logger);

        logger.info("Конец работы метода сортировки слиянием (рекурсия).");
        return integerList;
    }

    // Метод слияния массивов, созданных в результате рекурсии
    private static void Merge(  Integer[] integerList,
                                Integer[] newListLeft,
                                Integer[] newListRight, Logger logger)
    {
        logger.info("Начало работы метода слияния массивов, созданных в результате рекурсии.");
        Integer listLeftCount = newListLeft.length;
        Integer listRightCount = newListRight.length;
        Integer indexLeft = 0;
        Integer indexRight = 0;
        Integer indexList = 0;

        while (indexLeft < listLeftCount && indexRight < listRightCount)
        {
            if (newListLeft[indexLeft] < newListRight[indexRight])
            {
                integerList[indexList] = newListLeft[indexLeft];
                indexLeft++;
            }
            else
            {
                integerList[indexList] = newListRight[indexRight];
                indexRight++;
            }
            indexList++;
        }

        for (int i = indexLeft; i < listLeftCount; i++)
            integerList[indexList++] = newListLeft[i];
        for (int j = indexRight; j < listRightCount; j++) 
            integerList[indexList++] = newListRight[j];
        logger.info("Конец работы метода слияния массивов, созданных в результате рекурсии.");
    }

    // Вывод массива в строку с сепоратором
    private static String OutputList(Integer[] integerList, String seporator, Logger logger)
    {
        logger.info("Начало работы метода вывода массива в строку.");
        StringBuilder outputText = new StringBuilder("");
        for (int i = 0; i < integerList.length; i++)
        {
            outputText.append(integerList[i].toString());
            if (i != integerList.length - 1) outputText.append(seporator);
        }
        logger.info("Конец работы метода вывода массива в строку.");
        return outputText.toString();
    }

    // Генерация массива интеджеров
    private static Integer[] GenerateArrayInteger(Integer count, Integer minValue, Integer maxValue, Logger logger)
    {
        logger.info("Начало работы метода генерации массива.");
        Integer[] integerArray = new Integer[count];
        Random rnd = new Random();
        for (int i = 0; i < count; i++)
            integerArray[i] = minValue + rnd.nextInt(maxValue - minValue + 1);
        logger.info("Конец работы метода генерации массива.");
        return integerArray;
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
        logger.info("Программа стартовала. Создан логгер.");
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
