package org.example.controller;

import java.util.List;

import org.example.db.DataBase;
import org.example.model.*;

/**
 * Добавляет информацию на портал
 */
public interface AddInfo {
    /**
     * Добавляет департамент
     * @param dataBase база данных
     * @param department департамент
     */
    void addDepartment(DataBase dataBase, Department department);

    /**
     * Добавляет коллекцию департаментов
     * @param dataBase база данных
     * @param departments коллекция департаментов
     */
    void addDepartments(DataBase dataBase, List<Department> departments);

    /**
     * Добавляет пользователя
     * @param dataBase база данных
     * @param user пользователь
     */
    void addUser(DataBase dataBase, AUser user);

    /**
     * Добавляет коллекцию пользователей
     * @param dataBase база данных
     * @param users коллекция пользователей
     */
    void addUsers(DataBase dataBase, List<AUser> users);

    /**
     * Установить сумму перечисляемых денег пользователю (зарплата, стипендия и т.п.)
     * @param dataBase база данных
     * @param userNumber номер пользователя
     * @param salary устанавливаемая сумма
     */
    void setAmountMoney(DataBase dataBase, Integer userNumber, String amountMoney);
}
