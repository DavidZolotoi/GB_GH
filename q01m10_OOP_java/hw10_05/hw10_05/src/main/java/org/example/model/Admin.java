package org.example.model;


import org.example.controller.AddInfo;
import org.example.controller.GetCloseInfo;
import org.example.db.DataBase;

import java.util.List;

/**
 * Пользователь - админ - имеет право смотреть и редактировать информацию на портале
 */
public class Admin
        extends AUser
        implements AddInfo, GetCloseInfo {
    /**
     * Создать пользователя - админа
     * @param userNumber номер пользователя на портале
     * @param name имя
     * @param age возраст
     * @param position занимаемая позиция
     * @param amountMoney сумма перечисляемых денег
     * @param departmentFrom департамент, в котором он состоит
     */
    public Admin(Integer userNumber, String name, Integer age, Position position, String amountMoney, Integer departmentFrom) {
        super(userNumber, name, age, position, amountMoney, departmentFrom);
    }

    @Override
    public void addDepartment(DataBase dataBase, Department department) {
        dataBase.setDepartment(department);
    }

    @Override
    public void addDepartments(DataBase dataBase, List<Department> departments) {
        for (var department : departments) {
            dataBase.setDepartment(department);
        }
    }

    @Override
    public void addUser(DataBase dataBase, AUser user) {
        dataBase.setUser(user);
        for (var department : dataBase.getDepartments().entrySet()) {               // цикл по всем департаментам
            if (department.getValue().getDepartmentNumber().equals(user.departmentFrom)){ // если нашли депратамент юзера,
                dataBase.setDepartment(                                             // то заменить департамент в базе
                        user.departmentFrom,                                        // под указанным номером
                        new Department(                                             // на департамент
                                department.getValue().getDepartmentNumber(),        // с таким же номером,
                                department.getValue().getDepartmentName(),          // с таким же наименованием,
                                department.getValue().getUserCount() + 1            // но с увеличеснным кол-вом
                                )
                        );
                break;                                                              // и остановить цикл
            }
        }
    }

    @Override
    public void addUsers(DataBase dataBase, List<AUser> users) {
        for (var user : users) {
            this.addUser(dataBase, user);
        }
    }

    @Override
    public void setAmountMoney(DataBase dataBase, Integer userNumber, String amountMoney) {
        Position pos = dataBase.getUsers().get(userNumber).getPosition();
        switch (pos) {
            case ADMIN:
                dataBase.setUser(
                        userNumber,
                        new Admin(
                                dataBase.getUsers().get(userNumber).getUserNumber(),
                                dataBase.getUsers().get(userNumber).getName(),
                                dataBase.getUsers().get(userNumber).getAge(),
                                dataBase.getUsers().get(userNumber).getPosition(),
                                amountMoney,
                                dataBase.getUsers().get(userNumber).getDepartmentFrom()
                        )
                );
            break;
            case LEADER:
                dataBase.setUser(
                        userNumber,
                        new Leader(
                                dataBase.getUsers().get(userNumber).getUserNumber(),
                                dataBase.getUsers().get(userNumber).getName(),
                                dataBase.getUsers().get(userNumber).getAge(),
                                dataBase.getUsers().get(userNumber).getPosition(),
                                amountMoney,
                                dataBase.getUsers().get(userNumber).getDepartmentFrom(),
                                ((Leader)dataBase.getUsers().get(userNumber)).getDepartments()
                        )
                );
            break;
            case COLLEAGUE:
                dataBase.setUser(
                        userNumber,
                        new Colleague(
                                dataBase.getUsers().get(userNumber).getUserNumber(),
                                dataBase.getUsers().get(userNumber).getName(),
                                dataBase.getUsers().get(userNumber).getAge(),
                                dataBase.getUsers().get(userNumber).getPosition(),
                                amountMoney,
                                dataBase.getUsers().get(userNumber).getDepartmentFrom(),
                                ((Colleague)dataBase.getUsers().get(userNumber)).getLeaders()
                        )
                );
            break;
        }
    }

    @Override
    public String getAmountMoney(DataBase dataBase, Integer userNumber) {
        return dataBase.getUsers().get(userNumber).getAmountMoney();
    }

}
