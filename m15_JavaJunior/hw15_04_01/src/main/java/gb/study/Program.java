package gb.study;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Program {
    /**
     * Урок 4. Базы данных и инструменты взаимодействия с ними
     * Создайте базу данных (например, SchoolDB).
     * В этой базе данных создайте таблицу Courses с полями id (ключ), title, и duration.
     * Настройте Hibernate для работы с вашей базой данных.
     * Создайте Java-класс Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate.
     * Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.
     * Убедитесь, что каждая операция выполняется в отдельной транзакции.
     */
    public static void main(String[] args) {
        // Создание фабрики сессий
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // Создание сессии
        try (Session session = sessionFactory.getCurrentSession()){
            // Начало транзакции
            session.beginTransaction();

            // Создание объекта
            Course course1 = Course.create();
            Course course2 = Course.create();

            // Сохранение объекта в базе данных
            session.save(course1);
            System.out.println("Object course save successfully");

            // Чтение объекта из базы данных
            Course retrievedCourse = session.get(Course.class, course1.getId());
            System.out.println("Object course retrieved successfully");
            System.out.println("Retrieved course object: " + retrievedCourse);

            // Обновление объекта
            retrievedCourse.updateTitle();
            retrievedCourse.updateDuration();
            session.update(retrievedCourse);
            System.out.println("Object course update successfully");

            // Удаление объекта
            //session.delete(retrievedCourse);
            //System.out.println("Object course delete successfully");

            // Коммит транзакции
            session.getTransaction().commit();
            System.out.println("Transaction commit successfully");
        }

    }
}