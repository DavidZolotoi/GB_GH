package gb.study;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Random;

/*
Создайте абстрактный класс "Animal" с полями "name" и "age".
Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
Выведите на экран информацию о каждом объекте.
Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
*/
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        ArrayList<Animal> animals = animalsGenerate();

        for (var animal : animals) {
            Class<?> clazz = animal.getClass();
            System.out.println(clazz.getName() + ":");
            for (var field : clazz.getSuperclass().getDeclaredFields()) {
                //получить доступ к полю
                field.setAccessible(true);
                //модификатор поля
                String fieldModifier =  //выдает int: 1 - public, 2 - private и т.п.
                        (field.getModifiers() == Modifier.PUBLIC)? "public" : (
                                (field.getModifiers() == Modifier.PRIVATE)?
                                        "private" :
                                        String.valueOf(field.getModifiers())
                        );
                //тип поля
                String fieldType = String.valueOf(field.getType());
                //имя поля
                String fieldName = field.getName();
                //значение поля
                String fieldStringValue = null;
                try {
                    fieldStringValue = field.get(animal).toString();
                } catch (IllegalAccessException e) {
                    fieldStringValue = "";
                    e.printStackTrace();
                }
                //вывод всей инфо о поле
                System.out.println(
                        fieldModifier + " " + fieldType.replace("class java.lang.", "") + " " +
                                fieldName + " = '" + fieldStringValue + "';"
                );
            }
            //вызов "makeSound()", если такой метод присутствует.
            for (var method : animal.getClass().getDeclaredMethods()) {
                if (method.getName().equals("makeSound")) {
                    System.out.printf("Результат работы метода " + method.getName() + "(): ");
                    method.setAccessible(true);
                    method.invoke(animal);  //may be throws IllegalAccessException, InvocationTargetException
                }
            }
            System.out.println();
        }

    }

    /**
     *  Случайное заполнение животными (кошками и собаками)
     */
    private static ArrayList<Animal> animalsGenerate() {
        final int ELEM_MIN = 3;
        final int ELEM_MAX = 5;
        ArrayList<Animal> animals = new ArrayList<>();
        for (int i = 0; i < (new Random()).nextInt(ELEM_MAX - ELEM_MIN + 1) + ELEM_MIN; i++) {
            if(new Random().nextBoolean()){
                animals.add(
                        new Cat(
                            Character.toString((char)((new Random()).nextInt((int)'Z' - (int)'A' + 1) + (int)'A')),
                        (new Random()).nextInt(15 - 1 + 1) + 1
                        )
                );
            }else {
                animals.add(
                        new Dog(
                            Character.toString((char)((new Random()).nextInt((int)'Z' - (int)'A' + 1) + (int)'A')),
                        (new Random()).nextInt(15 - 1 + 1) + 1
                        )
                );
            }
        }
        return animals;
    }
}