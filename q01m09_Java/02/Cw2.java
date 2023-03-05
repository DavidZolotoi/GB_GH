import java.util.Scanner;
/*
 * Напишите метод, который принимает на вход строку (String) и
 * определяет является ли строка палиндромом (возвращает boolean значение).
*/
public class Cw2 {
    public static void main(String[] args) {
        // Всё то, что необходимо закрыть в конце программы
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Введите строку на латинице: ");
        String inputText = scanner.next();
        Boolean result = isPalindrom(inputText);
        if (result)
            System.out.printf("Строка является палиндромом.");
        else
            System.out.printf("Строка не является палиндромом.");
        
        // Всё то, что необходимо закрыть в конце программы
        scanner.close();
    }

    private static Boolean isPalindrom(String inputText)
    {
        Boolean result;
        StringBuilder reverseText = new StringBuilder();
        for (int i = inputText.length()-1; i >= 0; i--) {
            reverseText.append(inputText.charAt(i));
        }
        result = inputText.equals(reverseText.toString());
        return result;
    }
}