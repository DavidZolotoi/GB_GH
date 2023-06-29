/*
 * Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.
 * Создать множество ноутбуков.
 * Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
 * отвечающие фильтру. Критерии фильтрации можно хранить в Map.
 * Например:
 * Введите цифру, соответствующую необходимому критерию:
 * 1 - ОЗУ
 * 2 - Объём ЖД
 * 3 - Операционная система
 * 4 - Цвет …
 * Далее нужно запросить минимальные значения для указанных критериев — сохранить параметры фильтрации можно также в Map.
 * Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
 */
package q01m09_Java.les06.hw01_01;

import java.util.HashMap;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        // то, что надо не забыть закрыть в конце программы
        Scanner scanner = new Scanner(System.in);

        // Словарь ноутбуков
        var notebooks = CreateNooteBooks();

        // Показать все ноутбуки
        PrintAllNoteBooks(notebooks);

        // Запрос номера критерия, по которому будем фильровать
        System.out.println("Выберите число, соответствующее критерию, для задания минимума:");
        System.out.println("1. RAM,");
        System.out.println("2. ROM.");
        Integer parameterNumber = Integer.parseInt(scanner.nextLine());
        // Стоит добавить проверку на дурака, а также ловить исключения

        // Запрос минимального значения для выбранного критерия
        // если выбранный критерий имеет числовые значения, то запросить минимум
        if (parameterNumber == 1 || parameterNumber == 2)
        {
            System.out.println("Задайте минимум для выбранного критерия: ");
            Integer parameterMin = Integer.parseInt(scanner.nextLine());
            // Стоит добавить ловить исключения
            // Отфильтровать и распечать
            PrintFilterList(notebooks, parameterNumber, parameterMin);
        }
        else
        {
            System.out.println("Не получается распознать ввод.");
        }

        // то, что надо не забыть закрыть в конце программы
        scanner.close();
    }

    // Отфильтровать и распечать
    private static void PrintFilterList
                        (
                            HashMap<Integer, notebook> notebooks,
                            Integer parameterNumber,
                            Integer parameterMin
                        )
    {
        System.out.println("ОТФИЛЬРОВАННЫЙ СПИСОК:");
        for (var notebook : notebooks.entrySet()) {
            if (parameterNumber == 1 && notebook.getValue().RAM >= parameterMin)
            System.out.printf(
                "*** Артикул: %d: ***\n-Операцион. система:   \t%s,\n-Оперативная память:   \t%d,\n-Память:   \t\t%d,\n-Цвет:   \t\t%s\n",
                notebook.getValue().ID,
                notebook.getValue().OS,
                notebook.getValue().RAM,
                notebook.getValue().ROM,
                notebook.getValue().Color
            );
            if (parameterNumber == 2 && notebook.getValue().ROM >= parameterMin)
            System.out.printf(
                "*** Артикул: %d: ***\n-Операцион. система:   \t%s,\n-Оперативная память:   \t%d,\n-Память:   \t\t%d,\n-Цвет:   \t\t%s\n",
                notebook.getValue().ID,
                notebook.getValue().OS,
                notebook.getValue().RAM,
                notebook.getValue().ROM,
                notebook.getValue().Color
            );
        }
    }

    // Распечатать все ноутбуки
    private static void PrintAllNoteBooks(HashMap<Integer, notebook> notebooks) {
        for (var notebook : notebooks.entrySet()) {
            System.out.printf(
                "*** Артикул: %d: ***\n-Операцион. система:   \t%s,\n-Оперативная память:   \t%d,\n-Память:   \t\t%d,\n-Цвет:   \t\t%s\n",
                notebook.getValue().ID,
                notebook.getValue().OS,
                notebook.getValue().RAM,
                notebook.getValue().ROM,
                notebook.getValue().Color
            );
        }
    }

    // Создать словарь ноутбуков
    private static HashMap<Integer, notebook> CreateNooteBooks() {
        HashMap<Integer, notebook> notebooks = new HashMap<>();
        notebooks.put(0, new notebook(2, 128, "Windows 10", "White"));
        notebooks.put(1, new notebook(4, 256, "Windows 11", "Black"));
        notebooks.put(2, new notebook(6, 512, "Linux Debian", "Red"));
        notebooks.put(3, new notebook(8, 1024, "Linux Mint", "Green"));
        notebooks.put(4, new notebook(16, 2048, "Ubuntu", "Blue"));
        notebooks.put(5, new notebook(32, 4096, "Windows 11", "White"));
        notebooks.put(6, new notebook(2, 128, "Linux Debian", "Black"));
        notebooks.put(7, new notebook(4, 256, "Linux Mint", "Red"));
        notebooks.put(8, new notebook(6, 512, "Ubuntu", "Green"));
        notebooks.put(9, new notebook(8, 1024, "Pure", "Blue"));
        return notebooks;
    }
}
