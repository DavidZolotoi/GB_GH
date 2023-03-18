import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
/*
 * В калькулятор добавьте возможность отменить последнюю операцию.
 */
public class hw04_03
{
    public static void main(String[] args)
    {
        // Создать файл логов с указанным именем рядом с исполняемым файлом
        String fileLogPath = GetPathForLogFile("LogsCalc.log");
        // Логгер
        Logger logger = GetLogger(fileLogPath);
        logger.info("Создан логгер.");

        // Всё то, что необходимо закрыть в конце программы
        Scanner scanner = new Scanner(System.in);
        logger.info("Создан объект сканнера.");

        // Набор констант ("жалкая пародия на класс")
        HashMap<String, String> consts = new HashMap<>();
        consts.put("operand1",  "0");
        consts.put("operand2",  "0");
        consts.put("plus",      "+");
        consts.put("minus",     "-");
        consts.put("increase",  "*");
        consts.put("divide",    "/");
        consts.put("result",    "0");
        consts.put("cancel",    "c");
        consts.put("exit",      "e");
        consts.put("isCancel",  "0");
        consts.put("isExit",    "0");

        // работа калькулятора
        Calculator(consts, scanner, logger);

        // Всё то, что необходимо закрыть в конце программы
        scanner.close();
        logger.info("Уничтожен объект сканнера.");
    }

    // Сам калькулятор
    private static void Calculator
                        (
                            HashMap<String, String> consts,
                            Scanner scanner,
                            Logger logger
                        )
    {
        logger.info("Начало работы калькулятора.");
        // история результатов - для будущей отмены
        Integer numberHistory = 0;
        LinkedList<Double> resultHistory = new LinkedList<>();
        resultHistory.add(numberHistory, 0.0);
        while (consts.get("isExit").equals("0"))
        {
            // первый операнд
            Double operand1 = GetInputDouble("Введите первый операнд: ", scanner, consts, resultHistory, logger);
            if (consts.get("isCancel").equals("1")) 
            {
                if (resultHistory.size() > 0) resultHistory.removeLast();
                consts.put("isCancel", "0");
                System.out.printf("Произведена отмена последнего действия.\n%s\n", resultHistory.getLast());
                continue;
            }
            if (consts.get("isExit").equals("1")) 
            {
                System.out.println("Выбрано завершение работы программы.\nВсего доброго!");
                return;
            }
            // операция
            String operation = GetInputChar("Выберите операцию (+-*/): ", scanner, consts, resultHistory, logger);
            if (consts.get("isCancel").equals("1")) 
            {
                if (resultHistory.size() > 0) resultHistory.removeLast();
                consts.put("isCancel", "0");
                System.out.printf("Произведена отмена последнего действия.\n%s\n", resultHistory.getLast());
                continue;
            }
            if (consts.get("isExit").equals("1")) 
            {
                System.out.println("Выбрано завершение работы программы.\nВсего доброго!");
                return;
            }
            // второй операнд
            Double operand2 = GetInputDouble("Введите второй операнд: ", scanner, consts, resultHistory, logger);
            if (consts.get("isCancel").equals("1")) 
            {
                if (resultHistory.size() > 0) resultHistory.removeLast();
                consts.put("isCancel", "0");
                System.out.printf("Произведена отмена последнего действия.\n%s\n", resultHistory.getLast());
                continue;
            }
            if (consts.get("isExit").equals("1")) 
            {
                System.out.println("Выбрано завершение работы программы.\nВсего доброго!");
                return;
            }
            // результат
            numberHistory += 1;
            resultHistory.add(numberHistory, GetResult(operand1, operand2, operation, consts, resultHistory, logger));
            // вывод
            System.out.printf("%.2f %s %.2f = %.2f\n", operand1, operation, operand2, resultHistory.get(numberHistory));
        }
        logger.info("Конец работы калькулятора.");
    }

    // Выполнение действия
    private static Double GetResult
                            (
                                Double operand1,
                                Double operand2,
                                String operation,
                                HashMap<String, String> consts,
                                LinkedList<Double> resultHistory,
                                Logger logger
                            )
    {
        logger.info("Начало работы метода возврата результата Double GetResult(,,,). Заходим в switch.");
        Double result = 0d;
        if (operation.equals(consts.get("plus"))) 
        {
            result = operand1 + operand2;
            logger.info("Ветка сложения '+'. Результат = " + operand1 + "+" + operand2 + "=" + result);
        }
        if (operation.equals(consts.get("minus"))) 
        {
            result = operand1 - operand2;
            logger.info("Ветка разницы '-'. Результат = " + operand1 + "-" + operand2 + "=" + result);
        }
        if (operation.equals(consts.get("increase"))) 
        {
            result = operand1 * operand2;
            logger.info("Ветка умножения '*'. Результат = " + operand1 + "*" + operand2 + "=" + result);
        }
        if (operation.equals(consts.get("divide"))) 
        {
            result = operand1 / operand2;
            logger.info("Ветка деления '/'. Результат = " + operand1 + "/" + operand2 + "=" + result);
        }
        logger.warning("Конец работы метода возврата результата. Возвращаем результат = " + result);
        return result;
    }

    // Ввод числа
    private static Double GetInputDouble
                            (
                                String message,
                                Scanner scanner,
                                HashMap<String, String> consts,
                                LinkedList<Double> resultHistory,
                                Logger logger
                            )
    {
        logger.info("Начало работы метода ввода оеперанда Double GetInputDouble(,,).");
        // здесь в будущем стоит обработать исключения
        System.out.print(message);
        String inputTxt = scanner.nextLine();
        if (inputTxt.equals(consts.get("cancel"))) 
        {
            consts.put("isCancel", "1");
            return resultHistory.getLast();
        }
        if (inputTxt.equals(consts.get("exit"))) 
        {
            consts.put("isExit", "1");
            return resultHistory.getLast();
        }
        logger.info("Конец работы метода ввода оеперанда Double GetInputDouble(,,).");
        return Double.parseDouble(inputTxt);
    }
    
    // Ввод символа
    private static String GetInputChar
                        (
                            String message,
                            Scanner scanner,
                            HashMap<String, String> consts,
                            LinkedList<Double> resultHistory,
                            Logger logger
                        )
    {
        logger.info("Начало работы метода ввода знака GetInputChar().");
        // здесь в будущем стоит обработать исключения
        Boolean isInput = true;
        String inputTxt = "+";
        while(isInput)
        {
            logger.info("Бессконечный цикл ввода знака (с проверкой).");
            System.out.print(message);
            inputTxt = Character.toString(scanner.next().toCharArray()[0]);
            scanner.nextLine();
            if (inputTxt.equals("+") ||
                inputTxt.equals("-") ||
                inputTxt.equals("*") ||
                inputTxt.equals("/"))
            {
                isInput = false;
                logger.warning("Знак введен верно.");
            }
            else if (inputTxt.equals(consts.get("cancel"))) 
            {
                consts.put("isCancel", "1");
                return "+";
            }
            else if (inputTxt.equals(consts.get("exit"))) 
            {
                consts.put("isExit", "1");
                return "+";
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
        Logger logger = Logger.getLogger(hw04_03.class.getName());
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
            String pathFileJava = Class.forName("hw04_03").getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
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
