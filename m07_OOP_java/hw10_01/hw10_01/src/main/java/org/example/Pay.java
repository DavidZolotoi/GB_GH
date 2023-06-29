package org.example;

import java.util.LinkedList;

public class Pay
{
    /**
     * Имущество магазина
     */
    private LinkedList<Category> categories;
    /**
     * Пользователь, с его имуществом и корзиной
     */
    private User user;

    /**
     * Создает сделку (покупку, договор, обмен, взаимодействие между разными экземплярами)
     * @param categories имущество магазина
     * @param user пользователь, с его имуществом и корзиной
     */
    public Pay(LinkedList<Category> categories, User user)
    {
        this.categories = categories;
        this.user = user;
    }

    /**
     * Проводит сделку, меняет имущество участников
     */
    public void paymentMade()
    {
        for (var newCategory : this.categories)     // прогон по категориям
        {
            for (var tovar : this.user.basket.getTovarsForShop())   // прогон по корзине
            {
                if(newCategory.getTovars().indexOf(tovar) >= 0)  // если товар из корзины есть в категории
                {
                    this.user.addTovar(tovar);          // добавить товар пользователю в имущество
                    newCategory.delTovar(tovar);        // убрать товар из категории в магазине
                    this.user.basket.delTovar(tovar);   // убрать товар из корзины
                }
            }
        }
    }
}
