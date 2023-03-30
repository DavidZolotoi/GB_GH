package org.example;

import java.util.LinkedList;

public class User
{
    /**
     * Логин пользовтеля
     */
    String login;
    /**
     * Пароль пользовтеля
     */
    String password;
    /**
     * Корзина пользовтеля
     */
    Basket basket;
    /**
     * Имущество пользователя
     */
    LinkedList<Tovar> myTovars;

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
