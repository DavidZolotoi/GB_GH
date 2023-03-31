package org.example;

import java.util.LinkedList;
import java.util.Random;

public class Category
{
    /**
     * Наименование категории
     */
    private String name;
    /**
     * Лист товаров
     */
    private LinkedList<Tovar> tovars;

    /**
     *
     * @return список товаров
     */
    public LinkedList<Tovar> getTovars(){ return tovars; }

    /**
     *
     * @param number номер (индекс) товара
     * @return товар конкретного номера (индекса)
     */
    public Tovar getTovars(Integer number){ return tovars.get(number); }

    /**
     * Удаляет переданный товар из категории
     * @param tovar товар, который надо удалить из категории
     */
    public void delTovar(Tovar tovar)
    {
        this.tovars.remove(tovars.indexOf(tovar));
    }

    /**
     * Создает экземпляр категории, содержащий лист товаров по умолчанию.
     * @param name нименование категории.
     */
    public Category(String name)
    {
        this.name = name;
        this.tovars = Tovar.getTovarList(this.name, new Random().nextInt(30));
    }

    /**
     * Создает экземпляр категории, содержащий лист товаров.
     * @param name нименование категории.
     * @param tovars лист товаров.
     */
    public Category(String name, LinkedList<Tovar> tovars)
    {
        this.name = name;
        this.tovars = tovars;
    }

    /**
     * Вывод в консоль информацию о товарах в категории
     */
    public void printCategory()
    {
        System.out.printf("Наименование категории: %s\n", this.name);
        for (var tovar : this.tovars)
        {
            System.out.printf
                    (
                            "%s: Цена - %.2f, Рейтинг - %.1f\n",
                            tovar.getName(),
                            tovar.getPrice(),
                            tovar.getRating()
                    );
        }
    }
}
