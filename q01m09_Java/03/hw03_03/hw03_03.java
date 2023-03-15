import java.io.File;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*
 * Пусть дан произвольный список целых чисел, удалить из него чётные числа
 */

public class hw03_03
{
    public static void main(String[] args)
    {
        // Создать файл логов с указанным именем рядом с исполняемым файлом
        String fileLogPath = GetPathForLogFile("LogsMergeSort.log");
        // Логгер
        Logger logger = GetLogger(fileLogPath);
        // генерация листа
        LinkedList<Integer> integerList = GenerateArrayListInteger(20, -10, 10, logger);
        // вывод исходного листа
        System.out.printf("Сгенерированный массив: \n%s\n", OutputList(integerList, "  ", logger));
        // вывод листа, из которого удалены все четные позиции
        System.out.printf("Обработанный массив: \n%s\n", OutputList(DelEvenValue(integerList, logger), "  ", logger));
    
        logger.info("Конец работы программы.");
    }
    
    // Удаление четных чисел
    private static LinkedList<Integer> DelEvenValue(LinkedList<Integer> integerList, Logger logger)
    {
        logger.info("Начало работы метода удаления четных чисел.");

        // ОБРАБОТКА

        logger.info("Конец работы метода удаления четных чисел.");
        return integerList;
    }

    // Вывод массива в строку с сепоратором
    private static String OutputList(LinkedList<Integer> integerList, String seporator, Logger logger)
    {
        logger.info("Начало работы метода вывода массива в строку.");
        StringBuilder outputText = new StringBuilder("");
        for (int i = 0; i < integerList.size(); i++)
        {
            outputText.append(integerList.get(i).toString());
            if (i != integerList.size() - 1) outputText.append(seporator);
        }
        logger.info("Конец работы метода вывода массива в строку.");
        return outputText.toString();
    }

    // Генерация листа интеджеров
    private static LinkedList<Integer> GenerateArrayListInteger(Integer count, Integer minValue, Integer maxValue, Logger logger)
    {
        logger.info("Начало работы метода генерации листа чисел.");
        LinkedList<Integer> integerList = new LinkedList<>();
        Random rnd = new Random();
        for (int i = 0; i < count; i++)
            integerList.add(minValue + rnd.nextInt(maxValue - minValue + 1));

        logger.info("Конец работы метода генерации листа чисел.");
        return integerList;
    }

    // Возврат логгера
    private static Logger GetLogger(String fileLogPath)
    {
        // сам логгер
        Logger logger = Logger.getLogger(hw03_03.class.getName());
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
            String pathFileJava = Class.forName("hw03_03").getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
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
