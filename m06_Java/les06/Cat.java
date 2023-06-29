/* 1. Продумайте структуру класса Кот.
 * Какие поля и методы будут актуальны для приложения, которое является
 * а) информационной системой ветеринарной клиники
 * б) архивом выставки котов
 * в) информационной системой Театра кошек Ю. Д. Куклачёва
 * Можно записать в текстовом виде, не обязательно реализовывать в java.
 * 
 * класс Кот:       // общий
 * Не статические:
 * поля:
 * - порода,
 * - пол,
 * - цвет,
 * - кличка,
 * - возраст,
 * методы:
 * - редактирования полей,
 * ****************************************************
 * а) класс Кот информационной системой ветеринарной клиники
 * Поля:
 *  - ID,
 *  - диагноз,
 *  - дата поступления,
 *  - врач ФИО,
 *  - способ лечения,
 *  - адрес проживания,
 * Методы
 * - сравнения экземпляров???????????
 * - "поставить диагноз" (поход к врачу)
 */

package q01m09_Java.les06;

import java.util.ArrayList;
import java.util.Random;

public class Cat
{
    Integer Id;
    String Poroda;
    String Gender;
    String Color;
    String Name;
    Integer Age;
    //Date DateRegistration;
    String NameDoctor;

    public String GetDiagnoz()
    {
        ArrayList<String> Bolezn = new ArrayList<>();
        Bolezn.add("Грипп");
        Bolezn.add("Лишай");
        Bolezn.add("Почки");
        Bolezn.add("Операция");
        Bolezn.add("Печень");
        return Bolezn.get(new Random().nextInt(5));
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
        result.append("Харктеристики кота:\n");
        result.append(String.format("Id %d\n", Id));
        result.append(String.format("Порода %s\n", Poroda));
        result.append(String.format("Пол %s\n", Gender));
        result.append(String.format("Цвета %s\n", Color));
        result.append(String.format("Кличка %s\n", Name));
        //result.append(String.format("Дата поступления " + DateRegistration.toString()));
        result.append(String.format("Имя врача %s\n", NameDoctor));
        result.append(String.format("Диагноз %s\n", GetDiagnoz()));

        return result.toString();
    }
}
