package gb.study;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
 Java Development Kit (семинары). Урок 4. Коллекции
Создать справочник сотрудников.
Необходимо:
Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников -
каждый сотрудник должен иметь следующие атрибуты:
- Табельный номер
- Номер телефона
- Имя
- Стаж
Добавить метод, который ищет сотрудника по стажу (может быть список)
Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
Добавить метод, который ищет сотрудника по табельному номеру
Добавить метод добавление нового сотрудника в справочник
*/
public class Program {

    public static void main(String[] args) {
        Employee petr = new Employee(
                new Random().nextInt(1000) + 1,
                new Random().nextLong(2_000_000_0001L) + 7_000_000_0000L,
                "Petr",
                randomLocalDateTime(LocalDateTime.of(2023, 1, 1, 0, 0), LocalDateTime.of(2023, 12, 31, 23, 59))
        );
        Employee anna = new Employee(
                new Random().nextInt(1000) + 1,
                new Random().nextLong(2_000_000_0001L) + 7_000_000_0000L,
                "Anna",
                randomLocalDateTime(LocalDateTime.of(2023, 1, 1, 0, 0), LocalDateTime.of(2023, 12, 31, 23, 59))
        );
        Employee elena = new Employee(
                new Random().nextInt(1000) + 1,
                new Random().nextLong(2_000_000_0001L) + 7_000_000_0000L,
                "Elena",
                randomLocalDateTime(LocalDateTime.of(2023, 1, 1, 0, 0), LocalDateTime.of(2023, 12, 31, 23, 59))
        );
        Employee igor = new Employee(
                new Random().nextInt(1000) + 1,
                new Random().nextLong(2_000_000_0001L) + 7_000_000_0000L,
                "Igor",
                randomLocalDateTime(LocalDateTime.of(2023, 1, 1, 0, 0), LocalDateTime.of(2023, 12, 31, 23, 59))
        );

        EmployeeDirectory employees = new EmployeeDirectory();
        employees.add(petr);
        employees.add(anna);
        employees.add(elena);
        employees.add(igor);

        var annaExperience = anna.experience();
        var annaEmployee = employees.searchEmployeeByExperience(annaExperience);
        System.out.println("Со стажем " + annaExperience +" работает " + annaEmployee.getName());

        var pertName = "Petr";
        var pertEmployee = employees.searchEmployeeByName(pertName);
        System.out.println("С именем " + pertName +" работает " + pertEmployee.getName());

        var igorId = igor.getId();
        var igorEmployee = employees.searchEmployeeById(igorId);
        System.out.println("С id " + igorId +" работает " + igorEmployee.getName());
    }

    /**
     * Возвращает случайные дату и время между двумя датами
     * @param startDateTime начальная дата
     * @param finishDateTime конечная дата
     * @return случайные дата и время
     */
    private static LocalDateTime randomLocalDateTime(LocalDateTime startDateTime, LocalDateTime finishDateTime) {
        long start = startDateTime.toEpochSecond(ZoneOffset.UTC);
        long end = finishDateTime.toEpochSecond(ZoneOffset.UTC);
        long randomEpochSecond = ThreadLocalRandom.current().nextLong(start, end);
        LocalDateTime randomDateTime = LocalDateTime.ofEpochSecond(randomEpochSecond, 0, ZoneOffset.UTC);
        return randomDateTime;
    }
}