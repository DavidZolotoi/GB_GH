package org.example.controller;

import org.example.db.DataBase;

/**
 * Получить конфиденциальную информацию
 */
public interface GetCloseInfo {
    /**
     * Получить информацию о сумме перечисляемых денег пользователю (зарплата, стипендия и т.п.)
     * @param dataBase база данных
     * @param userNumber номер пользователя
     * @return сумма перечисляемых денег
     */
    String getAmountMoney(DataBase dataBase, Integer userNumber);
}
