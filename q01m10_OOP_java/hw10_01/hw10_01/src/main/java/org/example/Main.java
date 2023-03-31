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
        System.out.println("***   Состояние магазина до покупок   ***");
        for (var category : categories) category.printCategory();

        // Пользователи
        User fedor = new User("Fedor", "fed88");
        User petr = new User("Petr", "petr88");

        // Их корзины
        fedor.basket = new Basket();
        petr.basket = new Basket();
        fedor.basket.addTovar(categories.get(0).getTovars(1));
        fedor.basket.addTovar(categories.get(1).getTovars(2));
        petr.basket.addTovar(categories.get(0).getTovars(2));
        petr.basket.addTovar(categories.get(1).getTovars(3));

        // Операция покупки (договор, сделка, обмен, взаимодействие между разными экземплярами)
        Pay pay1 = new Pay(categories, fedor);
        pay1.paymentMade();
        System.out.println("***Состояние магазина после покупки Федором***");
        for (var category : categories) category.printCategory();
        Pay pay2 = new Pay(categories, petr);
        pay2.paymentMade();
        System.out.println("***Состояние магазина после покупки Петром  ***");
        for (var category : categories) category.printCategory();
    }
}