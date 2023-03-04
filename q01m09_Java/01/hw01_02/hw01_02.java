import java.util.Scanner;

/*
 * Вывести все простые числа от 1 до 1000 
 */
public class hw01_02 {
    public static void main(String[] args) {
        // Всё то, что необходимо закрыть в конце программы
        Scanner scanner = new Scanner(System.in);
        Integer inputInt = GetInputInt(scanner, "Введите число: ");
        while(inputInt>1)
        {
            for (int i = 2; i <= inputInt; i++) {
                if (inputInt % i == 0){
                    System.out.printf("%d   \t| %d\n", inputInt, i);
                    inputInt /= i;
                    break;
                }
            }
        }
        System.out.printf("%d   \t|", inputInt);

        // Всё то, что необходимо закрыть в конце программы
        scanner.close();
    }

    // Ввод
    public static Integer GetInputInt(Scanner scanner, String message){
        // здесь в будущем стоит обработать исключения
        System.out.print(message);
        Integer inputTxt = scanner.nextInt();
        return inputTxt;
    }
}
