package gb.study;

import java.io.*;

/*
Java Junior (семинары)
Урок 3. Сериализация
Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
Обеспечьте поддержку сериализации для этого класса.
Создайте объект класса Student и инициализируйте его данными.
Сериализуйте этот объект в файл.
Десериализуйте объект обратно в программу из файла.
Выведите все поля объекта, включая GPA, и ответьте на вопрос,
почему значение GPA не было сохранено/восстановлено.
*/
public class Student implements Serializable {
    String name;
    int age;
    transient double GPA;


    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", GPA=" + GPA +
                '}';
    }

    public static void main(String[] args) {
        Student student = new Student("John", 20, 3.5);
        System.out.println("Исходный сериализуемый объект:\n" + student);

        String fileName = "student.ser";
        serializedMethod(student, fileName);

        Student deserializedStudent = (Student) deserializedMethod(fileName);
        if (deserializedStudent == null) {
            System.out.println("Не удалось десериализовать объект.");
            return;
        }
        System.out.println("Десериализованный объект:\n" + deserializedStudent);
    }

    /**
     * Сериализация объекта
     * @param objectForSerialized объект для сериализации
     */
    private static void serializedMethod(Student objectForSerialized, String fileName) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)
        ){
            out.writeObject(objectForSerialized);
            System.out.println("Объект сериализован и записан в файл " + fileName + ".");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Десериализация объекта
     * @return десериализованный объект
     */
    private static Object deserializedMethod(String fileName) {
        Object deserializedStudent = null;
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn)
        ){
            deserializedStudent = in.readObject();
            System.out.println("Объект прочитан из файла " + fileName + " и десериализован.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return deserializedStudent;
    }

}