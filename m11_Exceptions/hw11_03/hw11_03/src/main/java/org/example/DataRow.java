package org.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DataRow {
    private String fullName;
    private Date dateOfBirth;
    private Long phoneNumber;
    private Character gender;

    private Integer codeResult;
    public Integer getCodeResult() {
        return codeResult;
    }

    // форматёр - для работы с датами
    //formatter.format(dateOfBirth) - перевод даты в текст нужного формата
    //formatter.parse(textForParse) - перевод текста нужного формата в дату
    public final static DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

    public DataRow() {
        this.fullName = null;
        this.dateOfBirth = null;
        this.phoneNumber = null;
        this.gender = null;
        this.codeResult = 0;
    }

    public String getFullName() {
        return fullName;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public Long getPhoneNumber() {
        return phoneNumber;
    }
    public Character getGender() {
        return gender;
    }

    @Override
    public String toString() {
        String result = "";
        result += (this.fullName.isEmpty())? "null" : this.fullName + ", ";
        result += (formatter.format(this.dateOfBirth).isEmpty())? "null" : formatter.format(this.dateOfBirth) + ", ";
        result += (this.phoneNumber.toString().isEmpty())? "null" : this.phoneNumber.toString() + ", ";
        result += (this.gender.toString().isEmpty())? "null" : this.gender.toString();
        return result;
    }

    /**
     * Метод, распознавания данных
     * @param newDataTxt данные для распознавания
     * @return Распознанные данные
     */
    public static DataRow newTxtParse(String newDataTxt) {
        // Объект, который будем собирать и возвращать
        DataRow newData = new DataRow();

        // Убираем все лишние пробелы и пробелы по краям строки
        newDataTxt = newDataTxt.trim().replaceAll(" +", " ");

        // Получаем список подстрок, разделенных пробелом
        ArrayList<String> newDataArray = new ArrayList<>(Arrays.asList(newDataTxt.split(" ")));

        // Проверка кол-ва данных и возврат кода ошибки в случае необходимости
        if (newDataArray.size() < 6) {
            newData.codeResult = -1;  // Что говорит о том, что введено меньшее кол-во данных
            return newData;
        }
        if (newDataArray.size() > 6){
            newData.codeResult = 1;  // Что говорит о том, что введено большее кол-во данных
            return newData;
        }

        // Распознавание каждого из элементов в цикле
        newData.fullName = newDataTxt;
        for (String element : newDataArray) {
            int countTriggered = 0;    // количество методов, успешно распознавших элемент

            // Распознаем символьное слово (фамилию, имя или отчество) и пока что игнорим, только считаем и всё
            String word = wordParse(element);
            if (word != null) countTriggered++;

            // Распознаем номер телефона, при успехе стираем его из fullName
            Long phoneNumberTemp = phoneNumberParse(element);
            if (phoneNumberTemp != null) {
                newData.phoneNumber = phoneNumberTemp;
                countTriggered++;
                newData.fullName = newData.fullName.replace(newData.phoneNumber.toString(), "");
            }

            // Распознаем дату рождения, при успехе стираем ее из fullName
            Date dateOfBirthTemp = dateOfBirthParse(element);
            if (dateOfBirthTemp != null) {
                newData.dateOfBirth = dateOfBirthTemp;
                countTriggered++;
                newData.fullName = newData.fullName.replace(DataRow.formatter.format(newData.dateOfBirth), "");
            }

            // Распознаем пол, при успехе стираем его из fullName
            Character genderTemp = genderParse(element);
            if (genderTemp != null) {
                newData.gender = genderTemp;
                countTriggered++;
                newData.fullName = newData.fullName.replace(newData.gender.toString(), "");
            }

            // Если текущий элемент распознали разные методы распознавания, то выбросить исключение
            if (countTriggered > 1){
                System.out.println("Что-то пошло не так! Неоднозначное значение \"" + element + "\".");
                throw new IllegalArgumentException("Значение \"" + element + "\" вызывает проблемы распознавания.");
            }
            // Если текущий элемент не распознал ни один из методов распознавания, то выбросить исключение
            if (countTriggered == 0) {
                System.out.println("Что-то пошло не так! Значение \"" + element + "\" не распознано.");
                throw new IllegalArgumentException("Значение \"" + element + "\" вызывает проблемы распознавания.");
            }
        }
        // После цикла в переменной newData.fullName должны остаться только ФИО + возможно пробелы
        newData.fullName = fullNameParse(newData.fullName);

        // После цикла, если есть хотя бы 1 null, то выбросить исключение
        if (    newData.fullName == null ||
                newData.phoneNumber == null ||
                newData.dateOfBirth == null ||
                newData.gender == null
        ) {
            System.out.println("Некорректный ввод.");
            throw new IllegalArgumentException("Как минимум 1 тип данных не удалось распознать, пожалуйста проверьте ввод.");
        }

        return newData;
    }

    /**
     * Метод распознавания пола
     * @param inputTextForParse входные данные для распознавания
     * @return распознанное значение - пол или null
     */
    private static Character genderParse(String inputTextForParse) {
        // Убираем все лишние пробелы и пробелы по краям строки
        inputTextForParse = inputTextForParse.trim().replaceAll(" +", " ");
        // Если в элементе записан символ 'f' или 'm', то это пол
        if (inputTextForParse.matches("m") || inputTextForParse.matches("f")) {
            //System.out.println("Пол: " + inputTextForParse.toCharArray()[0]);
            return inputTextForParse.toCharArray()[0];
        }
        return null;
    }

    /**
     * Метод распознавания дня рождения
     * @param inputTextForParse входные данные для распознавания
     * @return распознанное значение - день рождения или null
     */
    private static Date dateOfBirthParse(String inputTextForParse) {
        // Убираем все лишние пробелы и пробелы по краям строки
        inputTextForParse = inputTextForParse.trim().replaceAll(" +", " ");
        // Если в элементе записана строка с датой формата dd.mm.yyyy, то это дата рождения
        if (inputTextForParse.matches("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}")) {
            try {
                //System.out.println("Дата: " + DataRow.formatter.parse(inputTextForParse));
                return DataRow.formatter.parse(inputTextForParse);
            } catch (ParseException ex) {
                System.out.println(
                        "Не получается распознать дату рождения из подстроки \"" + inputTextForParse + "\". " +
                                ex.getMessage() + Arrays.toString(ex.getStackTrace())
                );
            }
        }
        return null;
    }

    /**
     * Метод распознавания номера телефона
     * @param inputTextForParse входные данные для распознавания
     * @return распознанное значение - номер телефона или null
     */
    private static Long phoneNumberParse(String inputTextForParse) {
        // Убираем все лишние пробелы и пробелы по краям строки
        inputTextForParse = inputTextForParse.trim().replaceAll(" +", " ");
        // Если в элементе записана строка с числом, то это номер телефона
        if (inputTextForParse.matches("[0-9]+") && inputTextForParse.length() >= 3) {
            try {
                //System.out.println("Номер: " + Long.parseLong(inputTextForParse) );
                return Long.parseLong(inputTextForParse);
            } catch (NumberFormatException ex){
                System.out.println(
                        "Не получается распознать номер телефона из подстроки \"" + inputTextForParse + "\". " +
                                ex.getMessage() + Arrays.toString(ex.getStackTrace())
                );
            }
        }
        return null;
    }

    /**
     * Метода распознавания ФИО
     * @param inputTextForParse входные данные для распознавания
     * @return распознанное значение - ФИО или null
     */
    private static String fullNameParse(String inputTextForParse) {
        // Убираем все лишние пробелы и пробелы по краям строки
        String fullName = inputTextForParse.trim().replaceAll(" +", " ");
        // Проверяем, что слов ровно 3 и что строка не пуста
        if (fullName.split(" ").length == 3 && !fullName.isEmpty() && !fullName.isBlank()) {
            //System.out.println("ФИО: " + fullName);
            return fullName;
        }
        return null;
    }

    /**
     * Метод распознавания строки из символов алфавита
     * @param inputTextForParse входные данные для распознавания
     * @return распознанное значение - строка или null
     */
    private static String wordParse(String inputTextForParse) {
        // Убираем все лишние пробелы и пробелы по краям строки
        inputTextForParse = inputTextForParse.trim().replaceAll(" +", " ");
        // Если в элементе записана строка (с количеством символов > 1 и символы из (EN || RU) алфавитов),
        // то это Фамилия, Имя или Отчество
        if (  inputTextForParse.length() > 1 &&
              (  inputTextForParse.matches("[a-zA-Z]+") || inputTextForParse.matches("[а-яА-Я]+")  )
        ) {
            //System.out.println("Слово:  " + inputTextForParse);
            return inputTextForParse;
        }
        return null;
    }
}
