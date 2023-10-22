package gb.study;

import java.util.Date;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Контроллер
 */
public class MyController {
    /**
     * Точка входа
     */
    public static void main(String[] args) {
        String filePath = "my_notes.txt";
        try (Scanner scanner = new Scanner(System.in)) {
            String myNote = MyModel.InputNote(scanner, "Введите содержимое заметки.");
            WriteNote(filePath, myNote);
            MyView.ReadNotes(filePath);
        }
    }

    /**
     * Метод контроллера, записывающий заметку с её датой
     * @param filePath адрес файла для записи заметки
     * @param inputNote заметка, которую необходимо записать
     */
    private static void WriteNote(String filePath, String inputNote) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write((new Date()) + " -> " + inputNote + "\n");
            System.out.println("Заметка добавлена.");
        } catch (IOException e) {
            System.out.println("Не удалось добавить заметку, попробуйте еще раз.");
            e.printStackTrace();
        }
    }

}