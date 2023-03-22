//package q01m09_Java.les05.hw05_01;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
/*
 * Реализуйте структуру телефонной книги с помощью HashMap,
 * учитывая, что 1 человек может иметь несколько телефонов.
 */
public class Program
{
    public static void main(String[] args)
    {
        // Создать файл с указанным именем рядом с исполняемым файлом
        // String phoneBookPath = GetPathForNewFile("phonebook.csv");
        //String phoneBookPath = "E:\\VirtualBox\\most\\GB_GH\\q01m09_Java\\les05\\hw05_01\\phonebook.csv";
        String phoneBookPath = ".\\phonebook.csv";
        System.out.printf("Файл справочника находится по адресу:\n%s\n", phoneBookPath);
        // Сканер
        Scanner scanner = new Scanner(System.in);
          
        // Работа в меню
        Boolean isWork = true;
        while (isWork)
        {
            System.out.println(GetMenu(scanner));
            System.out.println("Выберите пункт меню: ");
            Integer menuItem = Integer.parseInt(scanner.nextLine());
            switch (menuItem)
            {
                case 5: System.out.println("Всего доброго!\n"); isWork = false; break;
                case 1: System.out.println(ShowPhoneBook(phoneBookPath)); break;
                case 2: System.out.println(SearchContact(scanner, phoneBookPath)); break;
                case 3: System.out.println(AddContact(scanner, phoneBookPath)); break;
                case 4: System.out.println(DelContact(scanner, phoneBookPath)); break;
                default: break;
            }
            
        }

        // Уничтожить сканер
        scanner.close();
    }

    // пункт меню - удаление контакта
    private static String DelContact(Scanner scanner, String phoneBookPath)
    {
        HashMap<String, LinkedList<String>> phoneMap = GetPhoneMap(GetPhoneMapTxt(phoneBookPath));
        System.out.println("Введите имя: ");    // запрос имени = ключа
        String contactName = scanner.nextLine();
        phoneMap.remove(contactName);
        WriteNewContactTxt(phoneBookPath, phoneMap);
        return String.format("Контакт с именем %s удален.", contactName);
    }

    // пункт меню - добавить контакт
    private static String AddContact(Scanner scanner, String phoneBookPath)
    {
        HashMap<String, LinkedList<String>> phoneMap = GetPhoneMap(GetPhoneMapTxt(phoneBookPath));
        System.out.println("Введите имя: ");    // запрос имени = ключа
        String contactName = scanner.nextLine();
        LinkedList<String> listNumber;
        if (phoneMap.containsKey(contactName))    //контакт существует?
        {
            System.out.println("Такой контакт есть. Желаете добавить для него номеров?\n");
            listNumber = phoneMap.get(contactName);
        }
        else
        {
            System.out.printf("Добавление нового контакта %s:\n", contactName);
            listNumber = new LinkedList<>();
        }
        // Сбор новой информации от пользователя
        System.out.println("Укажите количество номеров для добавления:");
        Integer countNumbersForAdd = Integer.parseInt(scanner.nextLine());
        if (countNumbersForAdd == 0) return "Ничего не добавлено";
        for (int i = 0; i < countNumbersForAdd; i++)
        {
            System.out.printf("Введите новый телефон №%d для добавления к контакту: ", i+1);
            listNumber.add(scanner.nextLine());
        }
        // добавить или перезаписать в словарь
        phoneMap.put(contactName, listNumber);
        // перезаписать файл
        WriteNewContactTxt(phoneBookPath, phoneMap);
        // вернуть данные об обновленном контакте
        StringBuilder numberForAdd = new StringBuilder();
        numberForAdd.append(String.format("Обновлены данные для контакта: %s:\n", contactName));
        Integer countNumbers = 1;
        for (var numbers : phoneMap.get(contactName))
        {
            numberForAdd.append(String.format("Телефон №%d: %s;\n", countNumbers, numbers));
            countNumbers += 1;
        }
        return numberForAdd.toString();
    }

    // метод записи переданного словаря в файл
    private static String WriteNewContactTxt(String phoneBookPath, HashMap<String, LinkedList<String>> phoneMap)
    {
        StringBuilder newContactInfo = new StringBuilder();
        try(FileWriter writer = new FileWriter(phoneBookPath, false))
        {
            for (var contact : phoneMap.entrySet())
            {
                newContactInfo.append(String.format("%s;", contact.getKey()));
                for (var numbers : contact.getValue())
                {
                    newContactInfo.append(String.format("%s;", numbers));
                }
                newContactInfo.append(String.format("\n"));
            }
            System.out.printf("\nКонтакт для записи:%s\n", newContactInfo.toString());
            writer.write(newContactInfo.toString());
            writer.flush();
        }
        catch(IOException ex)
        {
            System.out.println("Что-то пошло не так:\n" + ex.getMessage());
        } 
        return newContactInfo.toString();
    }

    // Пункт меню - поиск контакта -> отчет с данными
    private static String SearchContact(Scanner scanner, String phoneBookPath)
    {
        HashMap<String, LinkedList<String>> phoneMap = GetPhoneMap(GetPhoneMapTxt(phoneBookPath));
        System.out.println("Введите строку, по которой необходимо произвести посик: ");
        String txtForSearch = scanner.nextLine();
        String contactInfo = "Ничего не найдено.";
        StringBuilder findText = new StringBuilder();
        for (var contact : phoneMap.entrySet())
        {
            StringBuilder contactToString = new StringBuilder();
            contactToString.append(String.format("Имя: %s:\n", contact.getKey()));
            Integer countNumbers = 1;
            for (var numbers : phoneMap.get(contact.getKey()))
            {
                contactToString.append(String.format("Телефон №%d: %s;\n", countNumbers, numbers));
                countNumbers += 1;
            }
            
            if (contactToString.indexOf(txtForSearch) == -1)
                continue;
            else
                findText.append(contactToString);
        }
        if (findText.length()>0) return findText.toString();
        else return contactInfo;
    }

    // Пункт меню - показ справочника = возврат в виде строки
    private static String ShowPhoneBook(String phoneBookPath)
    {
        StringBuilder phoneMapToString = new StringBuilder();
        phoneMapToString.append("Содержимое справочника: \n");
        HashMap<String, LinkedList<String>> phoneMap = GetPhoneMap(GetPhoneMapTxt(phoneBookPath));
        for (var contact : phoneMap.entrySet())
        {
            phoneMapToString.append(String.format("Имя: %s:\n", contact.getKey()));
            Integer countNumbers = 1;
            for (var numbers : phoneMap.get(contact.getKey()))
            {
                phoneMapToString.append(String.format("Телефон №%d: %s;\n", countNumbers, numbers));
                countNumbers += 1;
            }
        }
        return phoneMapToString.toString();
    }

    // Преобразовать строку (полученную из файла) в словарь
    private static HashMap<String, LinkedList<String>> GetPhoneMap(String phoneMapTxt)
    {
        HashMap<String, LinkedList<String>> phoneMap = new HashMap<>();
        String[] rows = phoneMapTxt.split("\n");
        for (int i = 0; i < rows.length; i++)               // прогон по строкам
        {
            String contactName = "";
            LinkedList<String> contactNumbers = new LinkedList<>();
            ArrayList<Integer> seporatorsNumber = new ArrayList<>(5);
            for (int j = 0; j < rows[i].length(); j++)      // прогон по строке
            {
                if (rows[i].charAt(j) == ';') seporatorsNumber.add(j);
            }
            // добавление контакта
            contactName = rows[i].substring(0, seporatorsNumber.get(0));
            // добавление номеров
            for (int n = 0; n < seporatorsNumber.size() - 1; n++)
            {
                contactNumbers.add(n, rows[i].substring(seporatorsNumber.get(n)+1, seporatorsNumber.get(n+1)));
            }
            phoneMap.put(contactName, contactNumbers);
        }
        return phoneMap;
    }

    // Метод, считывающий данные из файла в StringBuilder
    private static String GetPhoneMapTxt(String phoneBookPath)
    {
        StringBuilder phoneMapTxt = new StringBuilder();
        try(FileReader reader = new FileReader(phoneBookPath))
        {
           // читаем посимвольно
            int c;
            while((c=reader.read())!=-1)
            {
                phoneMapTxt.append(String.valueOf((char)c));
            }
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        return phoneMapTxt.toString();
    }

    // вернуть меню
    private static String GetMenu(Scanner scanner)
    {
        StringBuilder menuTxt = new StringBuilder();
        menuTxt.append("******************************\n");
        menuTxt.append("Меню справочника:\n");
        menuTxt.append("1. Показать всё.\n");
        menuTxt.append("2. Найти данные.\n");
        menuTxt.append("3. Добавить данные.\n");
        menuTxt.append("4. Удалить контакт.\n");
        menuTxt.append("5. Завершить работу программы.\n");
        return menuTxt.toString();
    }

    // Получение пути рядом с исполняемым файлом
    private static String GetPathForNewFile(String fileName)
    {
        String newFilePath = "";
        try
        {
            // путь к файлу
            String pathFileJava = Class.forName("Program").getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            // сепоратор, который есть в этом пути
            String seporator1 = (pathFileJava.indexOf("/") > -1)?"/":"\\";
            // родительский каталог
            String pathParent = pathFileJava.substring(0, pathFileJava.lastIndexOf(seporator1) + 1);
            // путь к файлу
            newFilePath = pathParent + fileName;
            File myFile = new File(newFilePath);
            if (!myFile.exists()) myFile.createNewFile();
            // сепоратор, который есть в пути к файлу (он скорее всего отличается от того, что выше)
            String seporator2 = (myFile.getAbsolutePath().indexOf("\\") > -1)?"\\":"/";
            newFilePath = newFilePath.replace(seporator1, seporator2);  
            // если в пути к созданному файлу первый символ не дробь, то и в переменной пути его не должно быть
            if (newFilePath.substring(0, 1).equals(seporator2))
                newFilePath = newFilePath.substring(1, newFilePath.length());
        }
        catch (Exception e)
        {
            System.out.println("Не удалось получить путь к исполняемому файлу.");
            System.out.println(e.getMessage());
        }
        return newFilePath;
    }

}