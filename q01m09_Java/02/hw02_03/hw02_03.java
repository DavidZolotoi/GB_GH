import java.io.File;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
/*
 * Реализовать простой калькулятор с логированием
 */
public class hw02_03
{
    public static void main(String[] args)
    {
        // Создать файл логов с указанным именем рядом с исполняемым файлом
        String fileLogPath = GetPathForLogFile("LogsBubbleSort.log");
        // Логгер
        Logger logger = GetLogger(fileLogPath);
        logger.info("Создан логгер.");

        // Всё то, что необходимо закрыть в конце программы
        Scanner scanner = new Scanner(System.in);
        logger.info("Создан объект сканнера.");

        // работа калькулятора
        logger.info("Начало работы калькулятора.");
        Double operand1 = GetInputDouble(scanner, "Введите первый операнд: ", logger);
        Character operation = GetInputChar(scanner, "Выберите операцию (+-*/): ", logger);
        Double operand2 = GetInputDouble(scanner, "Введите второй операнд: ", logger);
        Double result = GetResult(operand1, operand2, operation, logger);
        System.out.printf("%.2f %s %.2f = %.2f", operand1, operation, operand2, result);
        logger.info("Конец работы калькулятора.");

        // Всё то, что необходимо закрыть в конце программы
        scanner.close();
        logger.info("Уничтожен объект сканнера.");
    }

    // Выполнение действия
    private static Double GetResult(Double operand1, Double operand2, Character operation, Logger logger)
    {
        logger.info("Начало работы метода возврата результата Double GetResult(,,,). Заходим в switch.");
        Double result = 0d;
        switch (operation)
        {
            case '+':
            result = operand1 + operand2;
            logger.info("switch определил case со сложением '+'. Результат = " + operand1 + "+" + operand2 + "=" + result);
                break;
            case '-':
            result = operand1 - operand2;
            logger.info("switch определил case с разницей '-'. Результат = " + operand1 + "-" + operand2 + "=" + result);
                break;
            case '*':
            result = operand1 * operand2;
            logger.info("switch определил case с умножением '*'. Результат = " + operand1 + "*" + operand2 + "=" + result);
                break;
            case '/':
            result = operand1 / operand2;
            logger.info("switch определил case с делением '/'. Результат = " + operand1 + "/" + operand2 + "=" + result);
                break;
            default:
            System.out.print("Что-то пошло не так!");
            logger.warning("Что-то пошло не так. switch определил case с default.");
                break;
        }
        logger.warning("Вышли из switch. Также выходим из метода и возвращаем результат = " + result);
        return result;
    }

    // Ввод числа
    private static Double GetInputDouble(Scanner scanner, String message, Logger logger)
    {
        logger.info("Начало работы метода ввода оеперанда Double GetInputDouble(,,).");
        // здесь в будущем стоит обработать исключения
        System.out.print(message);
        Double inputTxt = scanner.nextDouble();
        logger.info("Конец работы метода ввода оеперанда Double GetInputDouble(,,).");
        return inputTxt;
    }
    
    // Ввод символа
    private static char GetInputChar(Scanner scanner, String message, Logger logger)
    {
        logger.info("Начало работы метода ввода знака GetInputChar().");
        // здесь в будущем стоит обработать исключения
        Boolean isInput = true;
        char inputTxt = '+';
        while(isInput)
        {
            logger.info("Бессконечный цикл ввода знака (с проверкой).");
            System.out.print(message);
            inputTxt = scanner.next().toCharArray()[0];
            if (inputTxt == '+' ||
                inputTxt == '-' ||
                inputTxt == '*' ||
                inputTxt == '/')
            {
                isInput = false;
                logger.warning("Знак введен верно.");
            }
            else
            {
                isInput = true;
                logger.warning("Знак введен неверно.");
            }
        }
        logger.info("Вышел из бессконечного цикла ввода знака (с проверкой).");
        logger.info("Вышел из метода ввода знака GetInputChar() с возращаемым значением inputTxt = " + inputTxt);
        return inputTxt;
    }

        // Возврат логгера
        private static Logger GetLogger(String fileLogPath)
        {
            // сам логгер
            Logger logger = Logger.getLogger(hw02_03.class.getName());
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
                String pathFileJava = Class.forName("hw02_03").getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
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
