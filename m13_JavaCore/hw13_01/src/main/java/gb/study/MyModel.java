package gb.study;

import java.util.Scanner;

/**
 * Модель
 */
public class MyModel {
    /**
     * Метод модели для получения содержимого заметки от пользователя
     * @param scanner передаваемый сканер
     * @param mes сообщение для отображения пользователю
     * @return введенное пользователем содержимое заметки
     */
    public static String InputNote(Scanner scanner, String mes) {
        System.out.println(mes);
        return scanner.nextLine();
    }
}
