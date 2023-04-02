/*
Домашнее задание на закрепление:
1)Создать класс Товар, имеющий переменные имя, цена, рейтинг.
2)Создать класс Категория, имеющий переменные имя и массив товаров. Создать несколько объектов класса Категория.
3)Создать класс Basket, содержащий массив купленных товаров.
4)Создать класс User, содержащий логин, пароль и объект класса Basket. Создать несколько объектов класса User.
5)Вывести на консоль каталог продуктов. (все продукты магазина)
6)Вывести на консоль покупки посетителей магазина. (После покупки у пользователя добавляется товар, а из магазина - удаляется)
*/

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