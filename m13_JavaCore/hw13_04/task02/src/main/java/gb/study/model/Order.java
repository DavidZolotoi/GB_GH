package gb.study.model;

import gb.study.View;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Order {
    /**
     * Идентификатор заказа
     */
    private String orderId;
    /**
     * Покупатель
     */
    private Customer customer;
    /**
     * Товар
     */
    private Product product;
    /**
     * Количество товара
     */
    private int quantity;
    /**
     * Количество заказов
     */
    private static long count;  // можно было обойтись и db.getOrders().size(), но есть конструктор без использования БД

    /**
     * Создание заказа
     * @param customer покупатель
     * @param product продукт
     * @param quantity количество
     */
    public Order(Customer customer, Product product, int quantity) {
        this.orderId = getRandomOrderId();
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        count += 1;
        View.printlnMessage("Новый заказ " + this.orderId + ". Всего заказов: " + count);
    }

    /**
     * Создание заказа с проверкой наличия в БД покупателя и продукта
     * @param db база данных
     * @param customer покупатель
     * @param product продукт
     * @param quantity количество
     */
    public Order(Customer customer, Product product, int quantity, DataBase db) {
        this.orderId = getRandomOrderId();

        count += 1; // если ниже по каким-то причинам заказ не создаться, то будет уменьшено на 1

        if (db.getCustomers().contains(customer))
            this.customer = customer;
        else {
            count -= 1;
            throw new IllegalArgumentException("Не опознанный покупатель " + customer.getId() + ", необходима регистрация");
        }

        if (db.getProducts().contains(product))
            this.product = product;
        else {
            count -= 1;
            throw new IllegalArgumentException("Не опознанный продукт " + product.getId() + ", необходима регистрация");
        }

        if (quantity>0)
            this.quantity = quantity;
        else {
            count -= 1;
            throw new IllegalArgumentException("Количество продукта не может быть не положительным числом");
        }

        View.printlnMessage("Новый заказ " + this.orderId + ". Всего заказов: " + count);
    }

    /**
     * Геттер
     * @return количество заказов
     */
    public static long getCount() {
        return count;
    }

    /**
     * Генератор списка заказов
     * @param count количество заказов
     * @return список заказов
     */
    public static ArrayList<Order> getRandomList(int count) {
        ArrayList<Order> ordersRandomList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ordersRandomList.add(getRandomOrder());
        }
        return ordersRandomList;
    }

    /**
     * Генератор заказа
     * @return заказ
     */
    public static Order getRandomOrder() {
        return new Order(
                Customer.getRandomCustomer(),
                Product.getRandomProduct(),
                new Random().nextInt(5)
        );
    }

    /**
     * Генератор идентификатора заказа
     * @return идентификатор заказа
     */
    private static String getRandomOrderId() {
        Date date = new Date();
        int year = date.getYear() + 1900;
        int hour = date.getHours();
        int minute = date.getMinutes();
        int second = date.getSeconds();
        //long millisecond = date.getTime();
        int rnd = (int) (10 + Math.random() * 100);
        StringBuilder newOrderId = new StringBuilder("ORD");
        newOrderId.append(year).append(hour).append(minute).append(second).append(rnd);
        return newOrderId.toString();
    }
}
