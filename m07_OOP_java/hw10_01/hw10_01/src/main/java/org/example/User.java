package org.example;

import java.util.LinkedList;

public class User
{
    /**
     * Логин пользовтеля
     */
    private String login;
    /**
     * Пароль пользовтеля
     */
    private String password;
    /**
     * Корзина пользовтеля
     */
    Basket basket;
    /**
     * Имущество пользователя
     */
    private LinkedList<Tovar> myTovars;

    /**
     * Добавляет товар в имущество к пользователю
     * @param tovar товар, который необходимо добавить
     */
    public void addTovar(Tovar tovar) { this.myTovars.add(tovar); }

    /**
     * Создает пользователя с параметрами
     * @param login логин пользовтеля
     * @param password пароль пользовтеля
     */
    public User(String login, String password)
    {
        this.login = login;
        this.password = password;
        this.myTovars = new LinkedList<>();
    }
}
