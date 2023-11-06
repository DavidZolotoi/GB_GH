package gb.study.model;

import gb.study.View;

import java.util.ArrayList;

/**
 * База данных
 */
public class DataBase {
    /**
     * Лист покупателей
     */
    private ArrayList<Customer> customers;
    /**
     * Лист товаров
     */
    private ArrayList<Product> products;
    /**
     * Лист заказов
     */
    private ArrayList<Order> orders;

    /**
     * Метод для загрузки базы данных
     */
    public void getDB() {
        // Список заказов
        this.orders = Order.getRandomList(3);
        // А это новые списки продуктов и покупателей - С НИМИ БУДУТ НОВЫЕ ПОКУПКИ
        this.customers = Customer.getRandomList(3);
        this.products = Product.getRandomList(3);
        View.printlnMessage("База данных загружена.");
    }

    /**
     * Геттер
     * @return лист покупателей
     */
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    /**
     * Сеттер для добавления одного покупателя
     * @param customers покупатель для добавления в лист покупателей
     */
    public void setCustomer(Customer customers) {
        this.customers.add(customers);
    }

    /**
     * Геттер
     * @return лист товаров
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * Сеттер для добавления одного товара
     * @param product товар для добавления в лист товаров
     */
    public void setProduct(Product product) {
        this.products.add(product);
    }

    /**
     * Геттер
     * @return лист заказов
     */
    public ArrayList<Order> getOrders() {
        return orders;
    }

    /**
     * Сеттер для добавления одного заказа
     * @param order заказ для добавления в лист заказов
     */
    public void setOrder(Order order) {
        orders.add(order);
    }

    /**
     * Конструктор для создания базы данных
     * @param customers коллекция покупателей
     * @param products коллекция товаров
     * @param orders коллекция заказов
     */
    public DataBase(ArrayList<Customer> customers, ArrayList<Product> products, ArrayList<Order> orders) {
        this.customers = customers;
        this.products = products;
        this.orders = orders;
    }

    /**
     * Конструктор для создания базы данных
     */
    public DataBase() {}
}
