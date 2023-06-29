import java.util.LinkedList;
import java.util.Scanner;

/*
 * Реализовать консольное приложение, которое:
 * Принимает от пользователя строку вида 
 * text~num
 * Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
 * Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.
 */

public class cw04_01
{
    public static void main(String[] args)
    {
        // Всё то, что необходимо закрыть в конце программы
        Scanner scanner = new Scanner(System.in);

        String sep = "~";
        String inputText = GetInputString(scanner, "Введите текст: ");
        Integer sepNumber = inputText.indexOf(sep);
        Integer number = Integer.parseInt(inputText.substring(sepNumber + 1, inputText.length()));
        LinkedList<String> myList = new LinkedList<>();
        myList.add("text0");
        myList.add("text1");
        myList.add("text2");
        myList.add(number, inputText.substring(0, sepNumber));
        myList.add("text4");
        myList.add("text5");

        System.out.println(myList.get(number));
        myList.remove((int)number);

        // Всё то, что необходимо закрыть в конце программы
        scanner.close();
    }

    // Ввод
    public static String GetInputString(Scanner scanner, String message){
        // здесь в будущем стоит обработать исключения
        System.out.print(message);
        String inputTxt = scanner.nextLine();
        return inputTxt;
    }
}
