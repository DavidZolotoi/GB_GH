package gb.study.model;

import gb.study.View;

import java.util.ArrayList;
import java.util.Date;

/**
 * Покупатель
 */
public class Customer {
    /**
     * Идентификатор покупателя
     */
    private String id;

    /**
     * Генератор списка покупателей
     * @param count количество покупателей
     * @return список покупателей
     */
    public static ArrayList<Customer> getRandomList(int count) {
        ArrayList<Customer> customersRandomList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            customersRandomList.add(getRandomCustomer());
        }
        return customersRandomList;
    }

    /**
     * Генератор покупателя
     * @return покупатель
     */
    public static Customer getRandomCustomer() {
        return new Customer(getRandomCustomerId());
    }

    /**
     * Генератор идентификатора покупателя
     * @return идентификатор покупателя
     */
    private static String getRandomCustomerId() {
        Date date = new Date();
        int year = date.getYear() + 1900;
        int hour = date.getHours();
        int minute = date.getMinutes();
        int second = date.getSeconds();
        //long millisecond = date.getTime();
        int rnd = (int) (10 + Math.random() * 100);
        StringBuilder newOrderId = new StringBuilder("CUST");
        newOrderId.append(year).append(hour).append(minute).append(second).append(rnd);
        return newOrderId.toString();
    }

    /**
     * Геттер
     * @return идентификатор покупателя
     */
    public String getId() {
        return id;
    }

    /**
     * Сеттер
     * @param id идентификатор покупателя
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Создание покупателя
     * @param id имя покупателя
     */
    public Customer(String id) {
        this.id = id;
        View.printlnMessage("Новый покупатель " + id);
    }

    /**
     * Создание покупателя
     */
    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                '}';
    }
}
