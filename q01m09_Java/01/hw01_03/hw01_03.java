import java.util.Scanner;

/*
 * Реализовать простой калькулятор
 */
public class hw01_03 {
    public static void main(String[] args) {
        // Всё то, что необходимо закрыть в конце программы
        Scanner scanner = new Scanner(System.in);
        
        Double operand1 = GetInputDouble(scanner, "Введите первый операнд: ");
        Character operation = GetInputTxt(scanner, "Выберите операцию (+-*/): ");
        Double operand2 = GetInputDouble(scanner, "Введите второй операнд: ");
        Double result = GetResult(operand1, operand2, operation);
        System.out.printf("%.2f %s %.2f = %.2f", operand1, operation, operand2, result);
        
        // Всё то, что необходимо закрыть в конце программы
        scanner.close();
    }

    private static Double GetResult(Double operand1, Double operand2, Character operation) {
        Double result = 0d;
        switch (operation) {
            case '+':
            result = operand1 + operand2;
                break;
            case '-':
            result = operand1 - operand2;
                break;
            case '*':
            result = operand1 * operand2;
                break;
            case '/':
            result = operand1 / operand2;
                break;
            default:
            System.out.print("Что-то пошло не так!");
                break;
        }
        return result;
    }

    // Ввод числа
    private static Double GetInputDouble(Scanner scanner, String message){
        // здесь в будущем стоит обработать исключения
        System.out.print(message);
        Double inputTxt = scanner.nextDouble();
        return inputTxt;
    }
    
    // Ввод текста
    private static char GetInputTxt(Scanner scanner, String message){
        // здесь в будущем стоит обработать исключения
        Boolean isInput = true;
        char inputTxt = '+';
        while(isInput)
        {
            System.out.print(message);
            inputTxt = scanner.next().toCharArray()[0];
            if (inputTxt == '+' ||
                inputTxt == '-' ||
                inputTxt == '*' ||
                inputTxt == '/') isInput = false;
            else isInput = true;
        }
        return inputTxt;
    }
}
