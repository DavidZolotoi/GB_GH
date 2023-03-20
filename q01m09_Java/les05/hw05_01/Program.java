//package q01m09_Java.les05.hw05_01;
import java.io.File;
import java.io.FileReader;
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
        String phoneBookPath = GetPathForNewFile("PhoneBook.csv");
        // Сканер
        Scanner scanner = new Scanner(System.in);
        // Прочитать файл в строку и расчленить ее на словарь
        HashMap<String, LinkedList<String>> phoneMap = GetPhoneMap(GetPhoneMapTxt(phoneBookPath));
        //System.out.println(phoneMap.get("Lastname1 F.").get(0));    // проверка
        
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
                //case 3: AddContact(); break;
                //case 4: DelContact(); break;
                default: break;
            }
            
        }

        // Уничтожить сканер
        scanner.close();
    }

    // Поиск контакта -> отчет с данными
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

    // Показ справочника = возврат в виде строки
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
        menuTxt.append("2. Найти контакт.\n");
        menuTxt.append("3. Добавить контакт.\n");
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