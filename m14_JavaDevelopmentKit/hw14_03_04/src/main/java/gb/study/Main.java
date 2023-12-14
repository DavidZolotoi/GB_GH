package gb.study;

/*
 Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
 Класс должен иметь методы getFirst(), getSecond() для получения значений пары,
 а также переопределение метода toString(), возвращающее строковое представление пары.
 */
public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<>(12, "December");
        System.out.println(
                "1-ый элемент: " + pair1.getFirst() + "\n" +
                "2-ой элемент: " + pair1.getSecond() + "\n" +
                "Сам кортеж: " + pair1
        );

        Pair<String, Double> pair2 = new Pair<>("Mass", 78.4);
        System.out.println(
                "1-ый элемент: " + pair2.getFirst() + "\n" +
                "2-ой элемент: " + pair2.getSecond() + "\n" +
                "Сам кортеж: " + pair2
        );
    }
}