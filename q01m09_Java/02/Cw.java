import java.util.Scanner;

/*
 * Напишите метод, который сжимает строку. Пример: вход aaaabbbcdd.
 *                                                      a3
 */
public class Cw {
    public static void main(String[] args) {
        // Всё то, что необходимо закрыть в конце программы
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Введите строку: ");
        String inputText = scanner.next();
        StringBuilder editTxt = GetCrypt(inputText);
        System.out.printf("Вывод: %s", editTxt);

        // Всё то, что необходимо закрыть в конце программы
        scanner.close();
    }

    public static StringBuilder GetCrypt(String inputText) {
        StringBuilder editTxt = new StringBuilder();
        int count = 1;
        for (int i = 1; i < inputText.length(); i++) {
            if (inputText.charAt(i) == inputText.charAt(i-1))
            {
                count += 1;
            }
            else
            {
                editTxt.append(inputText.charAt(i-1));
                if (count != 1) editTxt.append(count);
                count = 1;
            }
        }
        editTxt.append(inputText.charAt(inputText.length()-1));
        editTxt.append(count);
        return editTxt;
    }
}
