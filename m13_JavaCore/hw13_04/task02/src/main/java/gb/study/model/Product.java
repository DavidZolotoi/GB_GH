package gb.study.model;

import gb.study.View;

import java.util.ArrayList;
import java.util.Date;

/**
 * Продукт
 */
public class Product {
    /**
     * Идентификатор продукта
     */
    private String id;
    /**
     * Цена продукта
     */
    private double price;

    /**
     * Создание продукта
     * @param id Идентификатор продукта
     * @param price Цена продукта
     */
    public Product(String id, double price) {
        this.id = id;
        this.price = price;
        View.printlnMessage("Новый продукт " + id);
    }

    /**
     * Геттер
     * @return идентификатор продукта
     */
    public String getId() {
        return id;
    }

    /**
     * Геттер
     * @return цена продукта
     */
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", price=" + price +
                '}';
    }

    /**
     * Сеттер
     * @param id идентификатор продукта
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Сеттер
     * @param price цена продукта
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Генератор листа продуктов
     * @param count количество продуктов
     * @return лист продуктов
     */
    public static ArrayList<Product> getRandomList(int count) {
        ArrayList<Product> productsRandomList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            productsRandomList.add(getRandomProduct());
        }
        return productsRandomList;
    }

    /**
     * Генератор продукта
     * @return продукт
     */
    public static Product getRandomProduct() {
        return new Product(getRandomProductId(), Math.random() * 1000);
    }

    /**
     * Генератор идентификатора продукта
     * @return идентификатор продукта
     */
    private static String getRandomProductId() {
        Date date = new Date();
        int year = date.getYear() + 1900;
        int hour = date.getHours();
        int minute = date.getMinutes();
        int second = date.getSeconds();
        //long millisecond = date.getTime();
        int rnd = (int) (10 + Math.random() * 100);
        StringBuilder newProductId = new StringBuilder("PROD");
        newProductId.append(year).append(hour).append(minute).append(second).append(rnd);
        return newProductId.toString();
    }
}
