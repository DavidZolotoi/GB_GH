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

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Открытие сканера
        Scanner  scanner = new Scanner(System.in);

        // "Бесконечный" ввод новых данных
        while (true){
            // Метод, запрашивающий (и распознающий) у пользователя новые данные одной строкой
            DataRow newData = inputAndParseNewData(scanner);

            // Код, создающий файл с названием, равным фамилии и дозаписывающий в него данные
            try{
                createFileWithNewData(newData);
            } catch (WriteInFileException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

            // Выход из бесконечного цикла
            System.out.println("Завершить работу?\n" +
                    "Введите символ y или Y для завершения или любой другой ввод для продолжения ввода");
            if(scanner.nextLine().equals("y") || scanner.nextLine().equals("Y")){
                break;
            }
        }

        // Закрытие сканера
        scanner.close();
    }

    /**
     * Метод, создающий новый файл, в наименовании которого фамилия из данных
     * @param newData данные, которые необходимо запиковать в фаил
     * @throws WriteInFileException Ошибка связанная с сохранением
     */
    private static void createFileWithNewData(DataRow newData) throws WriteInFileException {
        String fileName = newData.getFullName().split(" ")[0];
        try (FileWriter writer = new FileWriter(fileName, true)){
            writer.write(newData.toString() + "\n");
            writer.flush();
        } catch (IOException e){
            throw new WriteInFileException("Ошибка связанная с сохранением", e);
        }

    }

    /**
     * Метод, получения данных
     * @param scanner сканер
     * @return полученные данные. Могут быть выброшены исключения и коды ошибок
     */
    private static DataRow inputAndParseNewData(Scanner scanner) {
        Boolean isInputCorrect = false;
        DataRow newData = new DataRow();

        while (!isInputCorrect){
            try {
                System.out.println("Введите данные для добавления: ");
                String newDataTxt = scanner.nextLine();
                newData = DataRow.newTxtParse(newDataTxt);
                // Если дошли сюда, значит исключение не было выкинуто => распознали,
                // но может быть код ошибки, говорящий о неправильном количестве данных
                isInputCorrect = true;
                if (newData.getCodeResult() == -1) {
                    System.out.println("Метод newDataTxtParse() завершил работу с кодом ошибки \"-1\".\n" +
                            "Введено меньшее кол-во данных, чем ожидалось. Попробуйте еще раз.");
                    isInputCorrect = false;
                    continue;
                }
                if (newData.getCodeResult() == 1) {
                    System.out.println("Метод newDataTxtParse() завершил работу с кодом ошибки \"1\".\n" +
                            "Введено большее кол-во данных, чем ожидалось. Попробуйте еще раз.");
                    isInputCorrect = false;
                    continue;
                }
                System.out.println("Введено:  " + newData);
            } catch (IllegalArgumentException e) {
                System.out.println("Нераспознаваемый формат данных.\n" +
                                e.getMessage() + Arrays.toString(e.getStackTrace()) + ". Попробуйте еще раз.");
                isInputCorrect = false;
            }
        }
        // Если дошли сюда, значит был корректный ввод
        return newData;
    }

}






