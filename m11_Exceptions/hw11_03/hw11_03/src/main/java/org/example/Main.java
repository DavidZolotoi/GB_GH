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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Открытие сканера
        Scanner  scanner = new Scanner(System.in);

        // Метод, запрашивающий (и распознающий) у пользователя новые данные одной строкой
        ArrayList<String> inputTxt = inputAndParseNewData(scanner);

        // Метод, создающий файл с названием, равным фамилии
        createFileWithNewData(inputTxt);

        // Закрытие сканера
        scanner.close();
    }

    private static void createFileWithNewData(ArrayList<String> inputTxt) {
    }

    /**
     * Метод, получения данных
     * @param scanner сканер
     * @return полученные данные
     */
    private static ArrayList<String> inputAndParseNewData(Scanner scanner) {
        Boolean isInputCorrect = false;
        ArrayList<String> newData = new ArrayList<>();

        while (!isInputCorrect){
            try {
                System.out.println("Введите данные для добавления: ");
                String newDataTxt = scanner.nextLine();
                newData = newDataTxtParse(newDataTxt);
                // Если дошли сюда, значит исключение не было выкинуто => распознали,
                // но может быть код ошибки, говорящий о неправильном количестве данных
                isInputCorrect = true;
                if (newData.get(0).equals("-1")) {
                    System.out.println("Метод newDataTxtParse() завершил работу с кодом ошибки \"-1\".\n" +
                            "Введено меньшее кол-во данных, чем ожидалось. Попробуйте еще раз.");
                    isInputCorrect = false;
                }
                if (newData.get(0).equals("+1")) {
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
        // Если дошли сюда, значит был корректный ввод
        return newData;
    }

    /**
     * Метод, распознавания данных
     * @param newDataTxt данные для распознавания
     * @return Либо распознанные данные, либо код ошибки, либо исключение
     */
    private static ArrayList<String> newDataTxtParse(String newDataTxt) {
        // Убираем все лишние пробелы и пробелы по краям строки
        newDataTxt = newDataTxt.trim().replaceAll(" +", " ");

        // Получаем список подстрок, разделенных пробелом
        ArrayList<String> newData = new ArrayList<>(Arrays.asList(newDataTxt.split(" ")));

        // Проверка кол-ва данных и возврат кода ошибки в случае необходимости
        if (newData.size() < 6)
            return new ArrayList<>(List.of("-1"));  // Что говорит о том, что введено меньшее кол-во данных
        if (newData.size() > 6)
            return new ArrayList<>(List.of("+1"));  // Что говорит о том, что введено большее кол-во данных

        // Распознавание каждого из элементов в цикле
        String  fullName = newDataTxt,
                phoneNumber = null, dateOfBirth = null, gender = null;
        for (String element : newData) {
            int countSuccessfullyTriggered = 0;    // количество методов, успешно распознавших элемент

            // Распознаем символьное слово (фамилию, имя или отчество)
            String word = wordParse(element);
            if (word != null) countSuccessfullyTriggered++;

            // Распознаем номер телефона, при успехе стираем его из fullName
            phoneNumber = phoneNumberParse(element);
            if (phoneNumber != null) {
                countSuccessfullyTriggered++;
                fullName = fullName.replace(phoneNumber, "");
            }

            // Распознаем дату рождения, при успехе стираем ее из fullName
            dateOfBirth = dateOfBirthParse(element);
            if (dateOfBirth != null) {
                countSuccessfullyTriggered++;
                fullName = fullName.replace(dateOfBirth, "");
            }

            // Распознаем пол, при успехе стираем его из fullName
            gender = genderParse(element);
            if (gender != null) {
                countSuccessfullyTriggered++;
                fullName = fullName.replace(gender, "");
            }

            // Если текущий элемент распознали разные методы распознавания todo выбросить исключение
            if (countSuccessfullyTriggered > 1) System.out.println("Что-то пошло не так! Неоднозначное значение.");
            // Если текущий элемент не распознал ни один из методов распознавания todo выбросить исключение
            if (countSuccessfullyTriggered == 0) System.out.println("Что-то пошла не так! Значение не распознано.");
        }

        // После цикла в переменной fullName должны остаться только ФИО + возможно пробелы
        fullName = fullNameParse(fullName);

        return new ArrayList<>(Arrays.asList(fullName, dateOfBirth, phoneNumber, gender));
    }

    /**
     * Метода распознавания ФИО
     * @param inputTextForParse входные данные для распознавания
     * @return распознанное значение - ФИО
     */
    private static String fullNameParse(String inputTextForParse) {
        // Убираем все лишние пробелы и пробелы по краям строки
        String fullName = inputTextForParse.trim().replaceAll(" +", " ");
        // Проверяем, что слов ровно 3 и что строка не пуста
        if (fullName.split(" ").length != 3 || fullName.isEmpty() || fullName.isBlank()) {

            // todo выбросить исключение

        }
        return fullName;
    }

    /**
     * Метод распознавания пола
     * @param inputTextForParse входные данные для распознавания
     * @return распознанное значение - пол или null
     */
    private static String genderParse(String inputTextForParse) {
        // Если в элементе записан символ 'f' или 'm', то это пол
        if (inputTextForParse.matches("[fm]")) {
            return inputTextForParse;
        }
        return null;
    }

    /**
     * Метод распознавания дня рождения
     * @param inputTextForParse входные данные для распознавания
     * @return распознанное значение - день рождения или null
     */
    private static String dateOfBirthParse(String inputTextForParse) {
        // Если в элементе записана строка с датой формата dd.mm.yyyy, то это дата рождения
        if (inputTextForParse.matches("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}")) {
            // ...
        }
        return null;
    }

    /**
     * Метод распознавания номера телефона
     * @param inputTextForParse входные данные для распознавания
     * @return распознанное значение - номер телефона или null
     */
    private static String phoneNumberParse(String inputTextForParse) {
        // Если в элементе записана строка с числом, то это номер телефона
        if (inputTextForParse.matches("[0-9]+") && inputTextForParse.length() >= 3) {
            // ...
        }
        return null;
    }

    /**
     * Метод распознавания строки из символов алфавита
     * @param inputTextForParse входные данные для распознавания
     * @return распознанное значение - строка или null
     */
    private static String wordParse(String inputTextForParse) {
        // Если в элементе записана строка с количеством символов больше 1, то это Фамилия, Имя или Отчество
        if (inputTextForParse.matches("[a-zA-Z]+") || inputTextForParse.matches("[а-яА-Я]+")
                && inputTextForParse.length() > 1) {
            // ...
        }
        return null;
    }
}






