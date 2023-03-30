package org.example;

import java.util.LinkedList;

public class Main
{
    public static void main(String[] args)
    {
        // Содержимое магазина
        LinkedList<Category> categories = new LinkedList<>();
        categories.add(new Category("Apples", Tovar.getTovarList("apple", 3)));
        categories.add(new Category("Bananas", Tovar.getTovarList("banana", 4)));
        for (var category : categories) category.printCategory();


        // Пользователи
        User fedor = new User("Fedor", "fed88");
        User petr = new User("Petr", "petr88");

        // Их корзины
        fedor.basket = new Basket();
        petr.basket = new Basket();
        fedor.basket.add(categories.get(0).tovars.get(1));
        fedor.basket.add(categories.get(1).tovars.get(2));
        petr.basket.add(categories.get(0).tovars.get(2));
        petr.basket.add(categories.get(1).tovars.get(3));

        // Операция покупки
        Pay pay = new Pay(categories, fedor);
        pay.paymentMade();
        System.out.println("После покупки Федором");
        for (var category : categories) category.printCategory();
    }
}