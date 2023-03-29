package org.example;

public class Basket
{
    Tovar[] tovarsForShop;

    /**
     * Создает массив товаров для покупки.
     * @param tovarsForShop - массив товаров для покупки.
     */
    public Basket(Tovar[] tovarsForShop) {
        this.tovarsForShop = tovarsForShop;
    }

    /**
     * Генерирует массив товаров для покупки по умолчанию.
     * @param count - количество товаров для покупки.
     * @param maska - шаблон для наименований товаров для покупки.
     */
    public Basket(String maska, Integer count) {
        this.tovarsForShop = Tovar.getTovarArray(maska, count);
    }
}
