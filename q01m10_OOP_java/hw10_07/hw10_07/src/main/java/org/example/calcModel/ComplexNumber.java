package org.example.calcModel;

import java.util.Random;

/**
 * Комплексное число a+bi, где i = корень(-1)
 */
public class ComplexNumber {
    /**
     * Действительная часть
     */
    private Double a;

    /**
     * Мнимая часть
     */
    private Double b;

    /**
     * Создает случайное комплексное число
     */
    public ComplexNumber() {
        this.a = getDoubleNotZero(-10.0, +10.0);
        this.b = getDoubleNotZero(-10.0, +10.0);
        Logs.logger.info("Создано случайное комплексное число: " + this.toString());
    }

    /**
     * Создает комплексное число с указанными действительной и мнимой частями
     * @param a действительная часть
     * @param b мнимая часть
     */
    public ComplexNumber(Double a, Double b) {
        this.a = a;
        this.b = b;
        Logs.logger.info("Создано комплексное число: " + this.toString());
    }


//    // перегрузка оператора "+" для сложения двух комплексных чисел
//    public ComplexNumber operator+(ComplexNumber other) {
//        return new ComplexNumber(this.a + other.getA(), this.b + other.getB());
//    }


    @Override
    public String toString() {
        return String.format("%.2f", a) + ((b>=0.0)?"+":"") + String.format("%.2f", b) + "i";
    }

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    /**
     * Возвращает случайное Double, отличное от нуля, в диапазоне от x1 до x2
     * @param x1 граница диапазона
     * @param x2 граница диапазона
     * @return случайное Double, отличное от нуля, в диапазоне от x1 до x2
     */
    private Double getDoubleNotZero(Double x1, Double x2){
        Double rand = 0.0;
        while(rand == 0.0) rand = new Random().nextDouble() * (Double.max(x1, x2) - Double.min(x1, x2)) + Double.min(x1, x2);
        return rand;
    }
}
