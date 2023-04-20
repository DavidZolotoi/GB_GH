package org.example.db;

import org.example.model.*;

import java.util.*;

public class DataBase {
    private Map<Integer, Department> departments;
    private Map<Integer, AUser> users;
    private Integer usersCount;

    /**
     * Соединение с базой и ее загрузка в словарь
     */
    public DataBase() {
        // в качестве заглушки - случайное заполнение
        RandomFilledUsers();
    }

    /**
     * Возвращает количество зарегистрированных в базе пользователей
     * @return количество зарегистрированных в базе пользователей
     */
    public Integer getUsersCount() {
        return usersCount;
    }

    /**
     * Возвращает словарь депортаментов
     * @return словарь депортаментов
     */
    public Map<Integer, Department> getDepartments() {
        return departments;
    }

    /**
     * Добавляет в словарь новый департамент
     * @param department добавляемый департамент
     */
    public void setDepartment(Department department) {
        this.departments.put(this.departments.size(), department);
    }

    /**
     * Заменяет все содержимое департамента
     * @param departmentNumber индивидуальный номер депортамента для замены
     * @param department обновленный департамент для вставки
     */
    public void setDepartment(Integer departmentNumber, Department department) {
        for (var depart : departments.entrySet() ) {
            if (depart.getValue().getDepartmentNumber().equals(departmentNumber)){
                this.departments.put(depart.getKey(), department);
                break;
            }
        }
    }

    /**
     * Возвращает словарь пользователей
     * @return словарь пользователей
     */
    public Map<Integer, AUser> getUsers() {
        return users;
    }

    /**
     * Добавляет в словарь нового пользователя
     * @param user добавляемый пользователь
     */
    public void setUser(AUser user) {
        this.users.put(this.users.size(), user);
    }

    /**
     * Заменяет все содержимое пользователя
     * @param userNumber индивидуальный номер пользователя для замены
     * @param user обновленный пользователь для вставки
     */
    public void setUser(Integer userNumber, AUser user) {
        if (users.containsKey(userNumber)) this.users.put(userNumber, user);
        else System.out.println("Такого пользователя нет!");
    }



    /**
     * Случайное заполнение структуры портала
     */
    private void RandomFilledUsers() {
        departments = new HashMap<>();
        users = new HashMap<>();
        usersCount = 0;

        // Добавление департаментов
        Integer departmentCount = 3 + new Random().nextInt(2);
        for (int i = 0; i < departmentCount; i++) {
            departments.put(
                    i,
                    new Department(i, "Department"+i, 2+new Random().nextInt(5))
            );
        }

        // Добавление админов
        Integer adminCount = 1 + new Random().nextInt(5);
        for (int i = 0; i < adminCount; i++) {
            users.put(
                    usersCount,
                    new Admin(
                            usersCount,
                            "Admin" + i + "#" + usersCount,
                            25 + new Random().nextInt(15),
                            Position.ADMIN,
                            String.format("%s", 50000 + new Random().nextInt(150000)),
                            0   // просто в качестве примера админы сидят с 0-го отдела
                    )
            );
            usersCount += 1;
        }

        // Заполнение департаментов
        for (var department : departments.values()) {
            // Добавление лидера в департамент
            users.put(
                    usersCount,
                    new Leader(
                            usersCount,
                            "Leader" + 0 + "#" + usersCount,    // лидер внутри департамента всегда под номером 0
                            25 + new Random().nextInt(15),
                            Position.LEADER,
                            String.format("%s", 50000 + new Random().nextInt(150000)),
                            department.getDepartmentNumber(),                                   // из какого департамента
                            new LinkedList<>(Arrays.asList(department.getDepartmentNumber()))   // в каких департаментах лидерствует
                    )
            );
            Integer leaderNumber = usersCount;
            usersCount += 1;
            // Добавление остальных пользователей
            for (int i = 1; i < department.getUserCount(); i++) {
                    users.put(
                            usersCount,
                            new Colleague(
                                    usersCount,
                                    "Colleague" + i + "#" + usersCount,
                                    25 + new Random().nextInt(15),
                                    Position.COLLEAGUE,
                                    String.format("%s", 50000 + new Random().nextInt(150000)),
                                    department.getDepartmentNumber(),
                                    new LinkedList<>(Arrays.asList(leaderNumber))   // Лист - это задел на будущее, если лидеров будет много
                            )
                    );
                    usersCount += 1;
            }
        }
    }


}
