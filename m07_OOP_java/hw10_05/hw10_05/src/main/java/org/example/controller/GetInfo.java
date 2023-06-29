package org.example.controller;

import org.example.db.DataBase;

/**
 * Интерфейс получения открытой для пользователей информации из портала
 */
public interface GetInfo {
    /**
     * Получить информацию о всей структуре портала
     * @param dataBase база данных
     */
    String reportAll(DataBase dataBase);

    /**
     * Получить информацию о всех депортаментах портала
     * @param dataBase база данных
     */
    String reportDepartments(DataBase dataBase);

    /**
     * Получить информацию о депортаменте
     * @param dataBase база данных
     * @param departmentNumber номер депортамента
     */
    String reportDepartment(DataBase dataBase, Integer departmentNumber);

    /**
     * Получить информацию о всех пользователях
     * @param dataBase база данных
     */
    String reportUsers(DataBase dataBase);

    /**
     * Получить информацию о пользователе
     * @param dataBase база данных
     * @param userNumber номер пользователя
     */
    String reportUser(DataBase dataBase, Integer userNumber);
}
