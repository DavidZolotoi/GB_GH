package gb.study;

import java.util.Arrays;
import java.util.Random;

/*
Напишите обобщенный метод compareArrays(), который принимает два массива и
возвращает true, если они одинаковые, и false в противном случае.
Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.
*/
public class Main {
    public static void main(String[] args) {
        Integer[] randomInts1 = generateRandomInts(10, 1, 100);
        System.out.println("randomInts1:\n" + Arrays.toString(randomInts1));
        Integer[] randomInts2 = generateRandomInts(10, 1, 100);
        System.out.println("randomInts2:\n" + Arrays.toString(randomInts2));
        System.out.println("Результат сравнения: " + compareArrays(randomInts1, randomInts2));

        String[] randomWords1 = generateRandomWords(5, "abcdefghijklmnopqrstuvwxyz", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        System.out.println("randomWords1\n" + Arrays.toString(randomWords1));
        String[] randomWords2 = generateRandomWords(5, "abcdefghijklmnopqrstuvwxyz", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        System.out.println("randomWords2\n" + Arrays.toString(randomWords2));

        Integer[] randomInts3 = generateRandomInts(10, 1, 100);
        System.out.println("randomInts3:\n" + Arrays.toString(randomInts3));
        System.out.println("Результат сравнения: " + compareArrays(randomInts3, randomInts3));
    }

    /**
     * Проверяет на одинаковость два массива абсолютно любого типа
     * @param array1 первый массив
     * @param array2 второй массив
     * @return true, если одинаковые
     * @param <T> тип массивов
     */
    private static <T> boolean compareArrays(T[] array1, T[] array2) {
        // если у них разные длины, то дальше можно даже не проверять
        if (array1.length != array2.length) return false;
        // поэлементная проверка
        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) return false;
        }
        // если еще не вышли, значит одинаковые
        return true;
    }

    /**
     * Генератор массива случайных Integer
     * @param count количество элементов
     * @param min минимальное значение
     * @param max максимальное значение
     * @return массив случайных Integer
     */
    public static Integer[] generateRandomInts(int count, int min, int max) {
        Integer[] randomInts = new Integer[count];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            randomInts[i] = random.nextInt(max - min + 1) + min;
        }
        return randomInts;
    }

    /**
     * Генератор массива "слов"
     * @param count количество "слов"
     * @param set1 один набор символов
     * @param set2 второй набор символов
     * @return массива случайных "слов"
     */
    public static String[] generateRandomWords(int count, String set1, String set2) {
        String[] randomWords = new String[count];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int charCount = generateRandomInts(1, 3, 5)[0];
            var randomWordsForAdd = new StringBuilder();
            for (int j = 0; j <charCount; j++){
                if(new Random().nextBoolean()){
                    randomWordsForAdd.append(set1.charAt(random.nextInt(set1.length())));
                }
                randomWordsForAdd.append(set2.charAt(random.nextInt(set2.length())));
            }
            randomWords[i] = randomWordsForAdd.toString();
        }
        return randomWords;
    }
}