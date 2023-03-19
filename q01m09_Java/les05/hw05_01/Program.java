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
        String phonebookPath = GetPathForNewFile("Phonebook.csv");
        // Сканер
        Scanner scanner = new Scanner(System.in);
        // Загрузить справочник из файла в строку
        StringBuilder phoneMapTxt = new StringBuilder();
        GetPhoneMapTxt(phonebookPath, phoneMapTxt);     // загрузка в phoneMapTxt
        // Создать словарь и заполнить его из строки
        HashMap<String, LinkedList<String>> phoneMap = new HashMap<>();
        GetPhoneMap(phoneMap, phoneMapTxt.toString());  // расчленить и добавить в словарь
        //System.out.println(phoneMap.get("Lastname1 F.").get(0));    // проверка

        while (true)
        {
            System.out.println(GetMenu(scanner));
            if (true) break;
        }

        // Уничтожить сканер
        scanner.close();
    }

    // Преобразовать строку (полученную из файла) в словарь
    private static void GetPhoneMap(HashMap<String, LinkedList<String>> phoneMap, String phoneMapTxt)
    {
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
    }

    // Метод, считывающий данные из файла в StringBuilder
    private static void GetPhoneMapTxt(String phonebookPath, StringBuilder phoneMapTxt)
    {
        try(FileReader reader = new FileReader(phonebookPath))
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
    }

    // вернуть меню
    private static String GetMenu(Scanner scanner)
    {
        StringBuilder menuTxt = new StringBuilder();
        menuTxt.append("This is menu.");
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