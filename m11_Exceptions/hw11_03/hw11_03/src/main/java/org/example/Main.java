/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке,
разделенные пробелом (данные вводятся одной строкой без запятых):
Фамилия Имя Отчество, дата рождения, номер телефона, пол

Форматы данных:
фамилия, имя, отчество - строки
дата рождения - строка формата dd.mm.yyyy
номер телефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству.
Если количество не совпадает с требуемым, вернуть код ошибки.
Создать метод, который обработает его и покажет пользователю сообщение,
что он ввел меньше или больше данных, чем требуется.

Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
Можно использовать встроенные типы java или создать свои.
Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии.
В него в одну строку должны записаться полученные данные, вида:
Фамилия Имя Отчество, дата рождения, номер телефона, пол
Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

Не забудьте закрыть соединение с файлом.
При возникновении проблемы с чтением-записью в файл,
исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
*/
package org.example;

import java.util.Scanner;

import static sun.security.jca.JCAUtil.def;

public class Main {
    public static void main(String[] args) {
        // Открытие сканера
        Scanner  scanner = new Scanner(System.in);

        // Метод, запрашивающий (и распознающий) у пользователя новые данные одной строкой
        String[] inputTxt = inputAndParseNewData(scanner);

        // Метод, создающий файл с названием, равным фамилии
        createFileWithNewData(inputTxt);

        // Закрытие сканера
        scanner.close();
    }

    private static void createFileWithNewData(String[] inputTxt) {
    }

    /**
     * Метод, получения данных
     * @param scanner сканер
     * @return полученные данные
     */
    private static String[] inputAndParseNewData(Scanner scanner) {
        Boolean isInputCorrect = false;
        String[] newData = new String[];

        while (!isInputCorrect){
            try {
                System.out.println("Введите данные для добавления: ");
                String newDataTxt = scanner.nextLine();
                newData = newDataTxtParse(newDataTxt);
                // Если дошли сюда, значит исключение не было выкинуто => распознали, но может быть код ошибки
                isInputCorrect = true;
                if (newData[0].equals("-1")) {
                    System.out.println("Метод newDataTxtParse() завершил работу с кодом ошибки \"-1\".\n" +
                            "Введено меньшее кол-во данных, чем ожидалось. Попробуйте еще раз.");
                    isInputCorrect = false;
                }
                if (newData[0].equals("+1")) {
                    System.out.println("Метод newDataTxtParse() завершил работу с кодом ошибки \"+1\".\n" +
                            "Введено большее кол-во данных, чем ожидалось. Попробуйте еще раз.");
                    isInputCorrect = false;
                }
            } catch (Exception e) { // todo сделать свое исключение
                System.out.println("Нераспознаваемый формат данных.\n" +
                                e.toString() + ". Попробуйте еще раз.");
                isInputCorrect = false;
            }

        }

        return newData;
    }

    /**
     * Метод, распознавания данных
     * @param newDataTxt данные для распознавания
     * @return Либо распознанные данные, либо код ошибки, либо исключение
     */
    private static String[] newDataTxtParse(String newDataTxt) {
        String[] newData = newDataTxt.split(" ");

        // Проверка кол-ва данных и возврат кода ошибки в случае необходимости
        if (newData.length < 6) return new String[]{"-1"};  // Что говорит о том, что введено меньшее кол-во данных
        if (newData.length > 6) return new String[]{"+1"};  // Что говорит о том, что введено большее кол-во данных

        // Распознавание элементов в цикле
        for (int i = 0; i < newData.length; i++) {
            var element = newData[i];
            int n=0;    // количество методов, успешно распознавших элемент

            // Переменная с фамилией, именем и отчеством
            String fullName = fullNameParse(element);
            if (fullName != null) n++;

            // Переменная с номером телефона
            String phoneNumber = phoneNumberParse(element);
            if (phoneNumber != null) n++;

            // Переменная с датой рождения
            String dateOfBirth = dateOfBirthParse(element);
            if (dateOfBirth != null) n++;

            // Переменная с полом
            String gender = genderParse(element);
            if (gender != null) n++;

            // Если текущий элемент распознали разные методы распознавания todo выбросить исключение
            if (n>1) System.out.println("Что-то пошло не так! Неоднозначное значение.");
            // Если текущий элемент не распознал ни один из методов распознавания todo выбросить исключение
            if (n==0) System.out.println("Что-то пошла не так! Значение не распознано.");
        }

        return newData;
    }

    /**
     * Метод распознавания пола
     * @param element элемент, значение которого нужно распознать
     * @return распознанное значение или null
     */
    private static String genderParse(String element) {
        // Если в элементе записан символ 'f' или 'm', то это пол
        if (element.matches("[fm]")) {
            return element;
        }
        return null;
    }

    private static String dateOfBirthParse(String element) {
        // Если в элементе записана строка с датой формата dd.mm.yyyy, то это дата рождения
        if (element.matches("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}")) {
            // ...
        }
        return null;
    }

    private static String phoneNumberParse(String element) {
        // Если в элементе записана строка с числом, то это номер телефона
        if (element.matches("[0-9]+") && element.length() >= 3) {
            // ...
        }
        return null;
    }

    private static String fullNameParse(String element) {
        // Если в элементе записана строка с количеством символов больше 1, то это Фамилия, Имя или Отчество
        if (element.matches("[a-zA-Z]+") && element.length() > 1) {
            // ...
        }
        return null;
    }
}






