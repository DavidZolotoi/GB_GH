package gb.study.hw16_04_01.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Equation {
    private int precision;
    private double a;
    private double b;
    private double c;
    /**
     * Дискриминант
     */
    private double D;
    /**
     * Первый корень уравнения
     */
    private double x1;
    /**
     * Второй корень уравнения
     */
    private double x2;
    /*
     * Исходный вид уравнения
     */
    private String equation;
    /*
     * Решение уравнения
     */
    private String solution;

    /**
     * Создание экземпляра класса уравнений
     * @param a коэффициент a
     * @param b коэффициент b
     * @param c коэффициент c
     * @param precision точность вычислений (количество знаков после запятой в расчетах)
     */
    public Equation(double a, double b, double c, int precision) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.precision = precision;
    }
}
