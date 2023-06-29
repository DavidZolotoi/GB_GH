package org.example.model;

import lombok.AllArgsConstructor;
import org.example.controller.GetInfo;
import org.example.db.DataBase;

/**
 * Абстрактный пользователь портала
 */
@AllArgsConstructor
public abstract class AUser implements GetInfo {
    /**
     * Индивидуальный номер
     */
    Integer userNumber;

    /**
     * Имя
     */
    String name;

    /**
     * Возраст
     */
    Integer age;

    /**
     * Занимаемая позиция
     */
    Position position;

    /**
     * Сумма перечисляемых денег (зарплата, стрипендия и т.п.)
     */
    private String amountMoney;

    /**
     * Индивидуальный номер департамента, в котором состоит пользователь
     */
    Integer departmentFrom;

    /**
     * Возвращает позицию, которую занимает пользователь
     * @return позиция
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Возвращает индивидуальный номер пользователя
     * @return индивидуальный номер пользователя
     */
    public Integer getUserNumber() {
        return userNumber;
    }

    /**
     * Возвращает имя пользователя
     * @return имя пользователя
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает возраст пользователя
     * @return возраст пользователя
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Возвращает номер департамента, в котором состоит пользователь
     * @return номер департамента, в котором состоит пользователь
     */
    public Integer getDepartmentFrom() {
        return departmentFrom;
    }

    /**
     * Возвращает сумму перечисляемых денег
     * @return сумма перечисляемых денег
     */
    public String getAmountMoney() {
        return amountMoney;
    }

    @Override
    public String reportAll(DataBase dataBase) {
        StringBuilder report = new StringBuilder();
        report.append("Отчет - вся структура организации.\n");
        for (var department : dataBase.getDepartments().entrySet()){
            report.append(this.reportDepartment(dataBase, department.getKey()));
        }
        return report.toString();
    }

    @Override
    public String reportDepartments(DataBase dataBase) {
        StringBuilder report = new StringBuilder();
        report.append("Отчет по департаментам.\n");
        for (var department : dataBase.getDepartments().entrySet()){
            report.append(
                    String.format(
                            "  Департамент №%d. Наименование - %s. Количество пользователей - %d\n",
                            department.getValue().getDepartmentNumber(),
                            department.getValue().getDepartmentName(),
                            department.getValue().getUserCount()
                    )
            );
            //todo в будущем можно добавить отчет лидера (нужно еще цикл прогнать)
        }
        return report.toString();
    }

    @Override
    public String reportDepartment(DataBase dataBase, Integer departmentNumber) {
        StringBuilder report = new StringBuilder();
        var department = dataBase.getDepartments().get(departmentNumber);
        report.append(
                String.format(
                        "  Департамент №%d. Наименование - %s:\n",
                        department.getDepartmentNumber(), department.getDepartmentName()
                )
        );
        Integer findUserCount = 0;
        for (var user : dataBase.getUsers().values()) {
            if (user.getDepartmentFrom().equals(departmentNumber)){
                findUserCount++;
                report.append(
                        String.format(
                                "    №%d. Имя: %s, Возраст: %d, Позиция: %s.\n",
                                findUserCount, user.name, user.age, user.position
                        )
                );
            }
        }
        return report.toString();
    }

    @Override
    public String reportUsers(DataBase dataBase) {
        StringBuilder report = new StringBuilder();
        report.append("Отчет по пользователям.\n");
        for (var user : dataBase.getUsers().values()) {
            report.append(reportUser(dataBase, user.userNumber));
        }
        return report.toString();
    }

    @Override
    public String reportUser(DataBase dataBase, Integer userNumber) {
        StringBuilder report = new StringBuilder();
        report.append("Отчет по пользователю.\n");
        report.append(
                String.format(
                        "    Номер %d. Имя: %s. Возраст: %d. Позиция: %s.\n",
                        dataBase.getUsers().get(userNumber).userNumber,
                        dataBase.getUsers().get(userNumber).name,
                        dataBase.getUsers().get(userNumber).age,
                        dataBase.getUsers().get(userNumber).position
                )
        );
        return report.toString();
    }
}
