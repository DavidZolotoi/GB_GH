package org.example.calcModel;

import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Класс описания логов
 */
public class Logs {
    public static Logger logger;

    /**
     * Возвращает логгер
     * @param fileLogPath путь к файлу, где будут записываться логи
     * @return логгер
     */
    public static Logger GetLogger(String fileLogPath)
    {
        /**
         * Логгер
         */
        Logger logger = Logger.getLogger(Logs.class.getName());
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
        logger.warning("\n****************************************************\n" +
                              "Работа калькулятора с комплексными числами запущена.");
        return logger;
    }

    /**
     * Возвращает путь к файлу, записанный в правильном формате, с указанием имени файла
     * @param fileName имя файла
     * @return путь к файлу
     */
    public static String GetPathForLogFile(String fileName)
    {
        //todo здесь должна быть более сложная логика в стиле вычислить местонахождение проекта и относительно него двигаться
        String fileLogPath = "E:\\Csharp\\GB\\GB_GH\\q01m10_OOP_java\\hw10_07\\hw10_07\\src\\main\\java\\org\\example\\calcModel\\" + fileName;
        return fileLogPath;
    }
}
