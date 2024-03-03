package gb.study.hw16_08_01.aspects;

import gb.study.hw16_08_01.model.Equation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import java.util.Arrays;

@Aspect
public class RegisterUserAction {

    //todo В ДАННОМ ПРИМЕРЕ ИЗ РЕЗУЛЬТАТОВ, ВЫВЕДЕННЫХ НА КОНСОЛЬ ВИДНО,
    // ЧТО ДЛЯ ВЫЗОВА МЕТОДА addEquation(..) КЛАССА EquationService ПРИОТЕТНОСТЬ,
    // УКАЗАННЯЯ В @Order(1) И @Order(2) НЕ СОБЛЮДАЕТСЯ.

    //https://docs.spring.io/spring-framework/reference/core/aop/ataspectj.html
    @Around("execution(* gb.study.hw16_08_01.service.EquationService.addEquation(..))")
    @Order(1)
    public Object methodExecutionControl(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();

        System.out.println("### Заработал метод класса с @Aspect, имеющий приоритет @Order(1)" +
                " для только что вызванного декорируемого метода " + methodName +
                "\n### имеющего параметры (т.е. массив, состоящий из 1 экземпляра класса Equation)" + Arrays.asList(arguments));

        System.out.println("Сообщение в консоль до вызова декорируемого метода");

        //Заменяем введенные пользователем данные, т.е. массив, состоящий из 1 экземпляра класса Equation
        Equation equation = new Equation(1,-5,6,2);
        Object [] newArguments = {equation};
        Object returnedByMethod = joinPoint.proceed(newArguments);

        System.out.println("Сообщение в консоль после вызова декорируемого метода");

        return returnedByMethod;
    }

    @Around("execution(* gb.study.hw16_08_01.service.*.*(..))")
    @Order(2)
    public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("### Заработал метод класса с @Aspect, имеющий приоритет @Order(2)" +
                " для только что вызванного декорируемого метода " + joinPoint.getSignature().getName());
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() -start;
        System.out.println("Время выполнения метода: " + joinPoint.getSignature().getName() + ": " + elapsedTime + " миллисекунд");
        return result;
    }

    @AfterReturning(value = "@annotation(TrackUserAction)", returning = "returnedValue")
    public void methodExecutionControl(Object returnedValue) {
        System.out.println("### Заработал метод класса с @Aspect, целью которого являются методы с аннотацией @TrackUserAction" +
                " для только что вызванного декорируемого метода " + returnedValue.getClass().getName());
        System.out.println("Метод " + returnedValue.getClass().getName() + " выполнен и вернул " + returnedValue);
    }

}
