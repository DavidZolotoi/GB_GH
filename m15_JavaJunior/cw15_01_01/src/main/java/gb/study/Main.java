package gb.study;

import java.lang.reflect.*;

/*
ШПАРГАЛКА ПО РЕФЛЕКСИИ..
Вывод, написанной ниже программы:
-- Конструкторы gb.study.SomeClass:
new ()
new (java.lang.String, java.lang.Integer)

-- Созданный экземпляр, через конструктор с параметрами:
SomeClass{name='word', age=7}

-- Все поля экземпляра (в том числе private):
private String name = 'word';
private Integer age = '7';

-- Экземпляр с измененным значением поля (в том числе private):
SomeClass{name='word', age=100}

-- Запуск приватного метода:
Я - приватный метод и меня никто и никогда не сможет запустить извне!
*/
public class Main {
    public static void main(String[] args) {
        // Получить класс, зная только его название
        Class clazz = null;
        try {
            clazz = Class.forName(SomeClass.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Посмотреть какие конструкторы есть и с какими параметрами
        System.out.println("-- Конструкторы " + clazz.getName() + ":");
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            Class[] paramTypes = constructor.getParameterTypes();
            String paramsReport = "new (";
            for (Class paramType : paramTypes) {
                paramsReport += paramType.getName() + ", ";
            }
            if (paramsReport.contains(",")) // удаление последних ненужных ", "
                paramsReport = paramsReport.substring(0, paramsReport.length() - 2);
            paramsReport += ")";
            System.out.println(paramsReport);
        }
        // Получив и проанализировав все конструкторы,
        // выбираем вариант с аргументами (java.lang.String, java.lang.Integer, )
        // и создаем экземпляр
        SomeClass someClass = null;
        try {
            someClass = (SomeClass) constructors[1].newInstance("word", 7);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        System.out.println("\n-- Созданный экземпляр, через конструктор с параметрами:\n" + someClass);
        // Получить все поля, записанные разработчиком в классе
        Field[] fields = someClass.getClass().getDeclaredFields();
        //Field field = SomeClass.class.getDeclaredField("имя поля, если оно известно"); //еще способ
        System.out.println("\n-- Все поля экземпляра (в том числе private):");
        for (var field : fields) {
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
                fieldStringValue =field.get(someClass).toString();
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
        // Получить поле другим способом (можно любым) и ...
        Field fieldForCorrect = null;
        try {
            fieldForCorrect = SomeClass.class.getDeclaredField("age");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        // ... отредактировать его значение
        fieldForCorrect.setAccessible(true);
        try {
            fieldForCorrect.set(someClass, 100);    //изменение значения приватного поля
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n-- Экземпляр с измененным значением поля (в том числе private):\n" + someClass);
        // Получение и запуск приватного метода
        System.out.println("\n-- Запуск приватного метода:");
        try {
            Method method = someClass.getClass().getDeclaredMethod("somePrivateMethod");
            method.setAccessible(true);
            method.invoke(someClass);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}