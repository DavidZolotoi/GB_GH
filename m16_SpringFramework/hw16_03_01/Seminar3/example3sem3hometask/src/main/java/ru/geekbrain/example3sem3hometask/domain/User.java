package ru.geekbrain.example3sem3hometask.domain;

/**
 * Пользователь
 */
public class User {

    //region Поля

    /**
     * Имя
     */
    private String name;
    /**
     * Возраст
     */
    private int age;
    /**
     * Почта
     */
    private String email;

    //endregion

    //region Геттеры, сеттеры

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //endregion
}
