package org.example;

public class Singleton {

    /**
     * Член класса, в котором будет объект Singleton
     */
    private static Singleton instance;

    private int mySetting;
    public int getMySetting() {return mySetting;}
    public void setMySetting(int mySetting) {this.mySetting = mySetting;}

    /**
     * Создает объект класса Singleton и перезаписывает им значение static instance
     * @return объект класса Singleton, хранящийся в static instance
     */
    public static Singleton getInstance(){
        if (instance == null)
            instance = new Singleton();
        return instance;
    }

    /**
     * Закрываем конструктор
     */
    private Singleton(){}

}