package org.example.model;

import java.util.List;

public class Colleague
        extends AUser{
    /**
     * Коллекция актуальных лидеров для пользователя
     */
    List<Integer> leaders;

    /**
     * Создать обычного пользователя
     * @param userNumber номер пользователя на портале
     * @param name имя
     * @param age возраст
     * @param position занимаемая позиция
     * @param departmentFrom департамент, в котором он состоит
     * @param amountMoney сумма перечисляемых денег
     * @param leaders коллекция актуальных лидеров для пользователя
     */
    public Colleague(Integer userNumber, String name, Integer age, Position position, String amountMoney, Integer departmentFrom, List<Integer> leaders) {
        super(userNumber, name, age, position, amountMoney, departmentFrom);
        this.leaders = leaders;
    }

    /**
     * Возвращает коллекцию актуальных лидеров для пользователя
     * @return коллекцию актуальных лидеров для пользователя
     */
    public List<Integer> getLeaders() {
        return leaders;
    }

    /**
     * Устанавливает коллекцию актуальных лидеров для пользователя
     * @param leaders коллекция актуальных лидеров для пользователя для установки
     */
    public void setLeaders(List<Integer> leaders) {
        this.leaders = leaders;
    }
}
