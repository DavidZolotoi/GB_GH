import java.util.Scanner;

/*
 * Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
 */
public class hw01_01 {
    public static void main(String[] args) {
        // Всё то, что необходимо закрыть в конце программы
        Scanner scanner = new Scanner(System.in);
        Integer inputInt = GetInputInt(scanner, "Введите число: ");
        Integer Tn = 0;
        Long F = (long) 1;
        for (int i = 1; i <= inputInt; i++) {
            Tn += i;
            F *= i;
        }
        System.out.printf("Треугольное число, вычисленное через цикл: %d", Tn);
        System.out.println();
        System.out.printf("Треугольное число, вычисленное по формуле: %d", inputInt*(inputInt+1)/2);
        System.out.println();
        System.out.printf("Факториял, вычисленный через цикл: %d", F);
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
