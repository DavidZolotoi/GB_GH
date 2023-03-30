package org.example;

import java.util.LinkedList;
import java.util.Random;

public class Tovar
{
    /**
     * Наименование товара
     */
    String name;
    /**
     * Цена товара
     */
    Double price;
    /**
     * Рейтинг товара
     */
    Double rating;

    /**
     * Создает экземпляр класса Tovar
     * @param name Наименование товара
     * @param price Цена товара
     * @param rating Рейтинг товара
     */
    public Tovar(String name, Double price, Double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    /**
     * Генерирует лист товаров по умолчанию.
     * @param count количество необходимых товаров.
     * @return массив товаров, указанного количества, с указанной маской в имени.
     */
    public static LinkedList<Tovar> getTovarList(Integer count)
    {
        LinkedList<Tovar> tovars = new LinkedList<>();
        for (int i = 0; i < count; i++)
        {
            tovars.add  (
                    new Tovar
                            (
                            "tovar" + i,
                            new Random().nextDouble() * 100,
                            new Random().nextDouble() * 10
                            )
                        );
        }
        System.out.printf("Массив товаров сгенерирован.\n");
        return tovars;
    }

    /**
     * Генерирует массив товаров.
     * @param maska шаблон для наименований товаров.
     * @param count количество необходимых товаров.
     * @return массив товаров, указанного количества, с указанной маской в имени.
     */
    public static LinkedList<Tovar> getTovarList(String maska, Integer count)
    {
        LinkedList<Tovar> tovars = new LinkedList<>();
        for (int i = 0; i < count; i++)
        {
            tovars.add  (
                    new Tovar
                            (
                            maska + i,
                            new Random().nextDouble() * 100,
                            new Random().nextDouble() * 10
                            )
                        );
        }
        System.out.printf("Лист товаров сгенерирован.\n");
        return tovars;
    }
}
