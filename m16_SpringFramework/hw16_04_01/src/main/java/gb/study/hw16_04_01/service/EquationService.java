package gb.study.hw16_04_01.service;

import gb.study.hw16_04_01.model.Equation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquationService {

    /**
     * Хранилище уравнений
     */
    List<Equation> equations = new ArrayList<>();

    /**
     * Добавление уравнения, предварительно решив его.
     * @param equation нерешенное уравнение.
     */
    public void addEquation(Equation equation){;
        equations.add(solution(equation));
    }

    /**
     * Возврат всех уравнений
     * @return все уравнения
     */
    public List<Equation> getAllEquations(){
        return equations;
    }

    /**
     * Метод решения еще
     * @param e нерешенного уравнения.
     * @return Решенное уравнение.
     */
    private Equation solution(Equation e) {
        e.setEquation(
                withSign(e.getA()).replace("+", "") + " * x^2 " + withSign(e.getB()) + " * x " + withSign(e.getA()) + " = 0."
        );
        e.setD(e.getB() * e.getB() - 4 * e.getA() * e.getC());
        double roundD = round(e.getD(), e.getPrecision());
        if (e.getD() < 0) {
            e.setSolution(
                    "D = " + roundD + " < 0; =>\n" +
                    "Корней нет"
            );
        }
        else if (e.getD() == 0) {
            e.setX1(-e.getB() / (2 * e.getA()));
            e.setX2(e.getX1());
            e.setSolution(
                    "D = " + roundD + "; =>\n" +
                    "Единственное решение: " + round(e.getX1(), e.getPrecision())
            );
        }
        else {
            e.setX1((-e.getB() + Math.sqrt(e.getD())) / (2 * e.getA()));
            e.setX2((-e.getB() - Math.sqrt(e.getD())) / (2 * e.getA()));
            e.setSolution(
                    "D = " + roundD + " >0; =>\n" +
                    "Два решения: x1 = " + round(e.getX1(), e.getPrecision()) + " и x2 = " + round(e.getX2(), e.getPrecision())
            );
        }
        return e;
    }

    /**
     * Возврат в виде строки со знаком
     * @param value коэффициента.
     * @return Коэффициент со знаком в виде строки.
     */
    private String withSign(double value) {
        if (value < 0) {
            return " - " + Math.abs(value);
        }
        else {
            return " + " + value;
        }
    }

    /**
     * Метод округления
     * @param value значения до
     * @param precision знаков после запятой.
     * @return Округленное значение
     */
    public double round(double value, int precision) {
        double scale = Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
}
