package org.example;

import java.util.LinkedList;
import java.util.Random;

public class Category
{
    /**
     * Наименование категории
     */
    String name;
    /**
     * Лист товаров
     */
    LinkedList<Tovar> tovars;

    /**
     * Создает экземпляр категории, содержащий лист товаров по умолчанию.
     * @param name нименование категории.
     */
    public Category(String name) {
        this.name = name;
        this.tovars = Tovar.getTovarList(this.name, new Random().nextInt(30));
        System.out.printf("Категория товаров %s по умолчанию создана.\n", this.name);
    }

    /**
     * Создает экземпляр категории, содержащий лист товаров.
     * @param name нименование категории.
     * @param tovars лист товаров.
     */
    public Category(String name, LinkedList<Tovar> tovars) {
        this.name = name;
        this.tovars = tovars;
        System.out.printf("Категория товаров %s создана.\n", this.name);
    }


    public void printCategory()
    {
        System.out.printf("Наименование категории: %s\n", this.name);
        for (var tovar : this.tovars)
        {
            System.out.printf("%s: Цена - %.2f, Рейтинг - %.1f\n", tovar.name, tovar.price, tovar.rating);
        }
    }
}
