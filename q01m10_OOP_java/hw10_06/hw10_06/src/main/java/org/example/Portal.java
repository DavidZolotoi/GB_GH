package org.example;

import org.example.db.DataBase;
import org.example.model.AUser;
import org.example.model.Admin;
import org.example.model.Colleague;
import org.example.model.Position;
import org.example.view.OutputInfo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Portal {
    public static void main(String[] args)
    {
        /**
         *  База: подразделений и сотрудников.
         *  Сейчас в качестве примера в конструкторе создания базы запускается метод,
         *  заполняющий случайно структуру организации.
         *  Организация (компания, ВУЗ, школа)
         *  состоит из департаментов (отделов, подразделений, факультетов, классов),
         *  в которые входят лидеры (начальник отдела, староста, куратор и т.п.),
         *  и другие (коллеги, учашиеся и т.п.).
         *  Также присутствуют админы - те, кто имеют право редактировать информацию на портале
         */
        var dbPortal = new DataBase();

        /**
         * Объект класса для отправки информации на вывод
         */
        OutputInfo outputInfo = new OutputInfo();

        /**
         * На портал входит админ, имеющий право корректировать инфу на портале.
         * Находим его из базы пользователей
         */
        Admin admin = null;
        for (var user : dbPortal.getUsers().values()) {
            if (user.getPosition().equals(Position.ADMIN)) {
                admin = (Admin) user;
                break;
            }
        }

        /**
         * Админ запускает отчет о всей структуре организации
         */
        outputInfo.sendInfo("**************");
        outputInfo.sendInfo(admin.reportAll(dbPortal));

        /**
         * Админ добавляет пользователя в первый департамент
         * и проверяет отчет по конкретному департаменту
         */
        Integer newUserNumb = dbPortal.getUsers().size();
        admin.addUser(
                dbPortal,
                new Colleague(
                        newUserNumb,
                        "Новенький"+dbPortal.getDepartments().size()+"#"+dbPortal.getUsers().size(),
                        31,
                        Position.COLLEAGUE,
                        "100000",
                        1,
                        new LinkedList<Integer>(Arrays.asList(dbPortal.getDepartments().get(0).getUserCount()))
                )
        );
        outputInfo.sendInfo("**************");
        outputInfo.sendInfo(admin.reportDepartment(dbPortal, 1));

        /**
         * Админ понимает, что "накосячил" и надо увеличить зарплату
         * только что добавленного на 20000. Исправляет и проверяет результат.
         */
        outputInfo.sendInfo("**************");
        outputInfo.sendInfo("Неправильно указанная ранее зарплата " + admin.getAmountMoney(dbPortal, newUserNumb));
        admin.setAmountMoney(dbPortal, newUserNumb, "120000");
        outputInfo.sendInfo("Правильно исправленная сейчас зарплата " + admin.getAmountMoney(dbPortal, newUserNumb));

        /**
         * На портал заходит рандомный пользователь
         * И сначала смотрит информацию про себя
         */
        AUser user = dbPortal.getUsers().get(new Random().nextInt(dbPortal.getUsers().size()-2));
        outputInfo.sendInfo("\n**************");
        outputInfo.sendInfo(user.reportUser(dbPortal, user.getUserNumber()));

        /**
         * Затем смотрит информацию про другого пользователя
         */
        outputInfo.sendInfo("**************");
        outputInfo.sendInfo(user.reportUser(dbPortal, new Random().nextInt(dbPortal.getUsers().size()-2)));

        /**
         * Тут админу пригодилось посмотреть отдельо отчет по всем департаментам
         */
        outputInfo.sendInfo("**************");
        outputInfo.sendInfo(admin.reportDepartments(dbPortal));

        /**
         * А пользователю - отчет по всем пользователям
         */
        outputInfo.sendInfo("**************");
        outputInfo.sendInfo(user.reportUsers(dbPortal));
    }
}