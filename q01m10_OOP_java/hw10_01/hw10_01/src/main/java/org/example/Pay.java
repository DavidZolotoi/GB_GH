package org.example;

import java.util.LinkedList;

public class Pay
{
    LinkedList<Category> categories;
    User user;

    public Pay(LinkedList<Category> categories, User user)
    {
        this.categories = categories;
        this.user = user;
    }

    public LinkedList<Category> getCategories() {
        return categories;
    }

    public void setCategories(LinkedList<Category> categories) {
        this.categories = categories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void paymentMade()
    {
        for (int i = 0; i < user.basket.getTovarsForShop().size(); i++)
        {
            var tovar = user.basket.getTovarsForShop().get(i);
            for (int j = 0; j < this.categories.size(); j++)
            {
                Integer tovarNumber = this.categories.get(j).tovars.indexOf(tovar);
                if(tovarNumber >= 0)
                {
                    // добавить товар пользователю в имущество
                    user.myTovars.add(tovar);
                    // убрать товар из категории в магазине = заменить категорию на новую
                    // новое имя для категории = старому
                    String newName = this.categories.get(j).name;
                    // новая коллекция товаров = старая, но без одного элемента
                    LinkedList <Tovar> newListAfterRemove = this.categories.get(j).tovars;
                    newListAfterRemove.remove(tovarNumber);
                    // новая категория на замену
                    Category newCategory = new Category(newName, newListAfterRemove);
                    System.out.println("печать новой категории");
                    newCategory.printCategory();
                    this.categories.set(j, newCategory);
                    System.out.printf("купил, теперь длина %d\n", categories.get(0).tovars.size() + categories.get(1).tovars.size());
                }
            }
        }

//        for (var tovar : user.basket.getTovarsForShop())
//        {
//            if(this.categories.indexOf(tovar) >= 0)
//            {
//                // добавить товар пользователю в имущество
//                user.myTovars.add(tovar);
//                // убрать товар с полки в магазине
//                categories.remove(this.categories.indexOf(tovar));
//            }
//        }
    }
}
