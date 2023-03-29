package org.example;

import java.util.Random;

public class Categoria
{
    /**
     * Наименование категории
     */
    String name;
    /**
     * Массив товаров
     */
    Tovar[] tovars;

    /**
     * Создает категорию с массивом товаров по умолчанию.
     * @param name - нименование категории.
     */
    public Categoria(String name) {
        this.name = name;
        this.tovars = Tovar.getTovarArray(this.name, new Random().nextInt(30));
        System.out.printf("Категория товаров по умолчанию создана.");
    }

    /**
     * Создает категорию с массивом товаров.
     * @param name - нименование категории.
     * @param tovars - массив товаров.
     */
    public Categoria(String name, Tovar[] tovars) {
        this.name = name;
        this.tovars = tovars;
        System.out.printf("Категория товаров создана.")ж
    }
}
