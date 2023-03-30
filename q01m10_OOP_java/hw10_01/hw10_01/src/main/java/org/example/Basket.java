package org.example;

import java.util.LinkedList;

public class Basket
{
    /**
     * Лист товаров для покупки.
     */
    LinkedList<Tovar> tovarsForShop;

    /**
     * Создает экземплаяр корзины.
     */
    public Basket()
    {
        this.tovarsForShop = new LinkedList<>();
        System.out.printf("Экземплаяр корзины создан.\n");
    }

    /**
     * Создает экземплаяр, содержащий лист товаров для покупки.
     * @param tovarsForShop лист товаров для покупки.
     */
    public Basket(LinkedList<Tovar> tovarsForShop)
    {
        this.tovarsForShop = tovarsForShop;
        System.out.printf("Экземплаяр корзины, содержащий лист товаров для покупки создан.\n");
    }

    /**
     *
     * @return лист товаров для покупки.
     */
    public LinkedList<Tovar> getTovarsForShop()
    {
        return tovarsForShop;
    }

    /**
     * Принимает товар для покупки в корзину.
     * @param tovarForShop товар для добавления в корзину.
     */
    public void add(Tovar tovarForShop)
    {
        this.tovarsForShop.add(tovarForShop);
    }

    /**
     * Генерирует лист товаров для покупки по умолчанию.
     * @param maska шаблон для наименований товаров.
     * @param count количество необходимых товаров.
     */
    public void setTovarsForShop(String maska, Integer count)
    {
        this.tovarsForShop = Tovar.getTovarList(maska, count);
    }

}
