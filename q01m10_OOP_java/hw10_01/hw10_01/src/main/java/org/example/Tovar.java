package org.example;

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
     * @param name - Наименование товара
     * @param price - Цена товара
     * @param rating - Рейтинг товара
     */
    public Tovar(String name, Double price, Double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    /**
     * Генерирует массив товаров по умолчанию.
     * @param count - количество необходимых товаров.
     * @return массив товаров, указанного количества, с указанной маской в имени.
     */
    public static Tovar[] getTovarArray(Integer count)
    {
        Tovar[] tovarArray = new Tovar[count];
        for (int i = 0; i < count; i++)
        {
            tovarArray[i] = new Tovar
                    (
                            "tovar" + i,
                            new Random().nextDouble() * 100,
                            new Random().nextDouble() * 10
                    );
        }
        System.out.printf("Массив товаров сгенерирован.\n");
        return tovarArray;
    }

    /**
     * Генерирует массив товаров.
     * @param maska - шаблон для наименований товаров.
     * @param count - количество необходимых товаров.
     * @return массив товаров, указанного количества, с указанной маской в имени.
     */
    public static Tovar[] getTovarArray(String maska, Integer count)
    {
        Tovar[] tovarArray = new Tovar[count];
        for (int i = 0; i < count; i++)
        {
            tovarArray[i] = new Tovar
                    (
                            maska + i,
                            new Random().nextDouble() * 100,
                            new Random().nextDouble() * 10
                    );
        }
        System.out.printf("Массив товаров сгенерирован.\n");
        return tovarArray;
    }
}
