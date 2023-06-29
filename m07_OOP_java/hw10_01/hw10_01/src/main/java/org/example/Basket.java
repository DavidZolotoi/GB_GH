package org.example;

import java.util.LinkedList;

public class Basket
{
    /**
     * Лист товаров для покупки.
     */
    private LinkedList<Tovar> tovarsForShop;

    /**
     * Создает экземплаяр корзины.
     */
    public Basket()
    {
        this.tovarsForShop = new LinkedList<>();
    }

    /**
     * Создает экземплаяр, содержащий лист товаров для покупки.
     * @param tovarsForShop лист товаров для покупки.
     */
    public Basket(LinkedList<Tovar> tovarsForShop)
    {
        this.tovarsForShop = tovarsForShop;
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
     * @param tovar товар для добавления в корзину.
     */
    public void addTovar(Tovar tovar)
    {
        this.tovarsForShop.add(tovar);
    }

    /**
     * Удаляет товар из корзины (например после покупки)
     * @param tovar товар, который надо удалить (например его купили)
     */
    public void delTovar(Tovar tovar)
    {
        this.tovarsForShop.remove(this.tovarsForShop.indexOf(tovar));
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
