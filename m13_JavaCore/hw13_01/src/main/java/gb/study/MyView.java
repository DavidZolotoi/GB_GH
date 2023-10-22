package gb.study;

import java.io.FileReader;
import java.io.IOException;

/**
 * Представление
 */
public class MyView {
    /**
     * Метод представления для прочтения заметок из файла
     * @param filePath адрес файла, в котором хранятся заметки
     */
    public static void ReadNotes(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            System.out.println("Заметки:");
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            System.out.println("Не удалось прочитать заметки, попробуйте еще раз.");
            e.printStackTrace();
        }
    }
}
