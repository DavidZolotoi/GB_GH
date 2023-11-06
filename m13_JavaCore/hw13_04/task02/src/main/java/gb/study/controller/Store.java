package gb.study.controller;

/*
Эмуляция интернет-магазина
1 - написать классы покупатель, товар и заказ;
2 - создать массив покупателей, массив товаров и массив заказов;
3 - создать статический метод “совершить покупку” со строковыми параметрами, соответствующими полям объекта заказа.
Метод должен вернуть объект заказа
4 - Если в метод передан несуществующий покупатель, товар или отрицательное количество,
метод должен выбросить соответствующее исключение;
5 - Вызвать метод совершения покупки несколько раз таким образом, чтобы заполнить массив покупок возвращаемыми значениями.
Обработать исключения.
6 - Вывести в консоль итоговое количество совершённых покупок после выполнения приложения.
*/

import gb.study.model.DataBase;
import gb.study.model.Customer;
import gb.study.model.Order;
import gb.study.model.Product;
import gb.study.View;

import java.util.Random;

public class Store {
    public static void main(String[] args) {
        // Начало рабочего дня - включение компов - загрузка базы (для решения задачи - генерация)
        DataBase db = new DataBase();
        db.getDB();

        View.printlnMessage("На начало рабочего дня оформлено: " + db.getOrders().size() + " заказов");

        View.printlnMessage("--- --- ---");
        // 1 заказ - совершится без исключений
        newOrder(
                db.getCustomers().get(new Random().nextInt(db.getCustomers().size())),
                db.getProducts().get(new Random().nextInt(db.getProducts().size())),
                new Random().nextInt(5),
                db
        );

        View.printlnMessage("--- --- ---");
        // 2 заказ - совершится с исключением - покупателя нет в базе
        newOrder(
                Customer.getRandomCustomer(),
                db.getProducts().get(new Random().nextInt(db.getProducts().size())),
                new Random().nextInt(5),
                db
        );

        View.printlnMessage("--- --- ---");
        // 3 заказ - совершится с исключением - продукта нет в базе
        newOrder(
                db.getCustomers().get(new Random().nextInt(db.getCustomers().size())),
                Product.getRandomProduct(),
                new Random().nextInt(5),
                db
        );

        View.printlnMessage("--- --- ---");
        // 4 заказ - совершится с исключением - отрицательное количество товара
        newOrder(
                db.getCustomers().get(new Random().nextInt(db.getCustomers().size())),
                db.getProducts().get(new Random().nextInt(db.getProducts().size())),
                -5,
                db
        );

        View.printlnMessage("--- --- ---");
        View.printlnMessage("На конец рабочего дня оформлено: " + db.getOrders().size() + " заказов");
    }

    /**
     * Создание заказа
     * @param customer покупатель
     * @param product продукт
     * @param quantity количество
     * @param db база данных
     * @return заказ
     */
    private static Order newOrder(Customer customer, Product product, int quantity, DataBase db) {
        Order order = null;
        try {
            order = new Order(customer, product, quantity, db);
            db.setOrder(order);
        } catch (IllegalArgumentException argEx){
            View.printlnMessage("Не удалось добавить заказ:\n" + argEx.getMessage());
        }
        catch (Exception ex){
            View.printlnMessage("Не удалось добавить заказ:\n" + ex.getMessage());
        }
        return order;
    }

}