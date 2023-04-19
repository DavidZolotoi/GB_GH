package org.example.model;

import lombok.AllArgsConstructor;

/**
 * Департамент
 */
@AllArgsConstructor
public class Department {
    /**
     * Индивидуальный номер
     */
    private Integer departmentNumber;

    /**
     * Наименование
     */
    private String departmentName;

    /**
     * Количество пользователей в департаменте
     */
    private Integer userCount;


    /**
     * Возвращает номер департамента
     * @return номер департамента
     */
    public Integer getDepartmentNumber() {
        return departmentNumber;
    }

    /**
     * Возвращает наименование департамента
     * @return наименование департамента
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * Возвращает количество пользователей в департаменте
     * @return количество пользователей в департаменте
     */
    public Integer getUserCount() {
        return userCount;
    }

    /**
     * Устанавливает количество пользователей в департаменте
     */
    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

}
