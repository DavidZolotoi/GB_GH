package gb.study;
//Modifier 'static' not allowed here
public final class Calculator {
    public static <T extends Number, U extends Number> double sum(T num1, U num2) {
         return num1.doubleValue() + num2.doubleValue();
    }

    public static <T extends Number, U extends Number> double multiply(T num1, U num2) {
         return num1.doubleValue() * num2.doubleValue();
    }

    public static <T extends Number, U extends Number> double divide(T num1, U num2) {
        if (num2.doubleValue() == 0.0) throw new IllegalArgumentException("Деление на ноль вроде как бесконечность :-)");
         return num1.doubleValue() / num2.doubleValue();
    }

    public static <T extends Number, U extends Number> double subtract(T num1, U num2) {
         return num1.doubleValue() - num2.doubleValue();
    }
 }


