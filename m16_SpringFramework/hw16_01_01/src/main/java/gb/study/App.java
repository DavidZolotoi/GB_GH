package gb.study;

import com.google.gson.Gson;

/**
 Создать проект с использованием Maven или Gradle, добавить в него несколько зависимостей и написать код, использующий эти зависимости.
 Пример решения:
 1. Создайте новый Maven или Gradle проект, следуя инструкциям из блока 1 или блока 2.
 2. Добавьте зависимости org.apache.commons:commons-lang3:3.12.0 и com.google.code.gson:gson:2.8.6.
 3. Создайте класс Person с полями firstName, lastName и age.
 4. Используйте библиотеку commons-lang3 для генерации методов toString, equals и hashCode.
 5. Используйте библиотеку gson для сериализации и десериализации объектов класса Person в формат JSON.
 */
public class App 
{
    public static void main( String[] args )
    {
        // Serialize to JSON
        Person person = new Person("Petr", "Ivanov", 33);
        Gson gson = new Gson();
        String personJson = gson.toJson(person);
        System.out.println("Person в виде json:\n" + personJson);

        // Deserialize from JSON
        Person personFromJson = gson.fromJson(personJson, Person.class);
        System.out.println("Десериализованный из json объект Person:\n" + personFromJson);

    }
}