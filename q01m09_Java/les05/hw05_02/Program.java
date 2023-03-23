/*
 * Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений.
 * Отсортировать по убыванию популярности.
 */
package q01m09_Java.les05.hw05_02;
import java.util.HashMap;
import java.util.LinkedList;
public class Program {
    public static void main(String[] args) {
        // Дан словарь людей
        LinkedList<People> peoples = new LinkedList<>();
        peoples.add(new People("Иван", "Иванов"));
        peoples.add(new People("Светлана", "Петрова"));
        peoples.add(new People("Кристина", "Белова"));
        peoples.add(new People("Анна", "Мусина"));
        peoples.add(new People("Анна", "Крутова"));
        peoples.add(new People("Иван", "Юрин"));
        peoples.add(new People("Петр", "Лыков"));
        peoples.add(new People("Павел", "Чернов"));
        peoples.add(new People("Петр", "Чернышов"));
        peoples.add(new People("Мария", "Федорова"));
        peoples.add(new People("Марина", "Светлова"));
        peoples.add(new People("Мария", "Савина"));
        peoples.add(new People("Мария", "Рыкова"));
        peoples.add(new People("Марина", "Лугова"));
        peoples.add(new People("Анна", "Владимирова"));
        peoples.add(new People("Иван", "Мечников"));
        peoples.add(new People("Петр", "Петин"));
        peoples.add(new People("Иван", "Ежов"));

        // подсчет повторений имен - создание словаря уникальных имен
        HashMap<String, Integer> peopleNames = new HashMap<>();
        for (var people : peoples) {
            if (peopleNames.containsKey(people.FirstName))  // если имя есть в словаре
                peopleNames.put(people.FirstName, peopleNames.get(people.FirstName) + 1);
            else                                            // если его нет
                peopleNames.put(people.FirstName, 1);
        }

        // Печать повторений
        for (var peopleName : peopleNames.entrySet()) {
            if (peopleName.getValue() > 1)
                System.out.printf("Имя %s встречается %d раз.\n", peopleName.getKey(), peopleName.getValue());
        }

        // Определение максимальной популярности
        Integer maxReiting = Integer.MIN_VALUE;
        for (var peopleName : peopleNames.entrySet()) {
            if (peopleName.getValue() > maxReiting) maxReiting = peopleName.getValue();
        }

        // Сортировка peoples по полулярности имени
        System.out.println("Отсортированный список по пополярности имени");
        for (People item : peoples) {   // цикл тупо для повтора встроенного цикла, больше ни для чего
            for (People people : peoples) {
                if (peopleNames.get(people.FirstName) == maxReiting) {
                    System.out.printf("%s (популярность - %d)\n", people.FullName, peopleNames.get(people.FirstName));
                }
            }
            maxReiting -= 1;
        }
    }
}
