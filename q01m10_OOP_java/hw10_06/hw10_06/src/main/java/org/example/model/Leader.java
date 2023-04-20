package org.example.model;

import java.util.List;

public class Leader
        extends AUser{
    /**
     * Акутальная коллекция департаментов, в которых является лидером
     */
    private List<Integer> departments;

    /**
     * Создает нового пользователя - лидера
     * @param userNumber номер пользователя на портале
     * @param name имя
     * @param age возраст
     * @param position занимаемая позиция
     * @param amountMoney сумма перечисляемых денег
     * @param departmentFrom департамент, в котором он состоит
     * @param departments акутальная коллекция департаментов, в которых пользователь является лидером
     */
    public Leader(Integer userNumber, String name, Integer age, Position position, String amountMoney, Integer departmentFrom, List<Integer> departments) {
        super(userNumber, name, age, position, amountMoney, departmentFrom);
        this.departments = departments;
    }

    /**
     * Возвращает акутальную коллекцию департаментов, в которых является лидером
     * @return акутальную коллекцию департаментов, в которых является лидером
     */
    public List<Integer> getDepartments() {
        return departments;
    }

    /**
     * Устанавливает акутальную коллекцию департаментов, в которых является лидером
     * @param departments акутальная коллекция департаментов для установки
     */
    public void setDepartments(List<Integer> departments) {
        this.departments = departments;
    }
}
