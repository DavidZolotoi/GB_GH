/*
Домашнее задание на закрепление :
1)Создайте три класса: Человек, Кот, Робот, которые не наследуются от одного класса.
Эти классы должны уметь бегать и прыгать, все также с выводом информации о действии в консоль.
2) Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники
должны выполнять соответствующие действия (бежать или прыгать), результат выполнения
печатаем в консоль (успешно пробежал, не смог пробежать и т.д.). У препятствий есть длина
(для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
3) Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти
этот набор препятствий. Если участник не смог пройти одно из препятствий, то дальше по
списку он препятствий не идет.
*/

package org.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args)
    {
        // Коллекция препятствий (полоса препятствий)
        Integer obstaclesCount = (new Random().nextInt(5) * 2);  // кол-во препятствий
        LinkedList<Obstacle> obstacles = new LinkedList<Obstacle>();
        // Коллекция беговых дорожек
        Double maxDistance = 5.0;                                       // максимум 5.0 км
        LinkedList<Treadmill> treadmills = Treadmill.GetRandomList(obstaclesCount/2, maxDistance);
        // Коллекция стен
        Double maxWall = 1.7;                                           // максимум 1.7 м
        LinkedList<Wall> walls = Wall.GetRandomList(obstaclesCount/2, maxWall);
        // Построение полосы препятствий (чередование)
        Integer treadmillIndex = 0, wallIndex = 0;
        Boolean randomBoolean = new Random().nextBoolean();
        for (int obstacleIndex = 0; obstacleIndex < obstaclesCount; obstacleIndex++) {
            if (randomBoolean)
            {
                obstacles.add(obstacleIndex, treadmills.get(treadmillIndex));
                treadmillIndex += 1;
                if (treadmills.size() == obstacleIndex) treadmillIndex -= 1;
            }
            else
            {
                obstacles.add(obstacleIndex, walls.get(wallIndex));
                wallIndex += 1;
                if (walls.size() == obstacleIndex) wallIndex -= 1;
            }
            randomBoolean = !randomBoolean;
        }

        // Коллекция участников
        LinkedList<Participant> participants = new LinkedList<Participant>();
        participants.add(new Human("Fedor"));
        participants.add(new Cat("Tom"));
        participants.add(new Robot("GPT3"));
        participants.add(new Human("Petr"));
        participants.add(new Cat("Bars"));
        participants.add(new Robot("GPT4"));

        // Их регистрация в соревновании
        System.out.println("Начальный список участников:");
        HashMap<Participant, Boolean> participantStatus = new HashMap<>();
        for (var participant : participants)
        {
            participantStatus.put(participant, true);
            System.out.printf("%s\n", participant.getName());
        }

        // Соревнования
        System.out.println("ОБЪЯВЛЯЕМ СОРЕВНОВАНИЯ ОТКРЫМИ.");
        for (var obstacle : obstacles)
        {
            if (participants.size() < 1) continue;
            System.out.printf("*** Препятствие \"%s\", сложность %.2f ед.изм.\n", obstacle.name, obstacle.obstacleValue);
            for (var participant : participants)
            {
                if (!participantStatus.get(participant)) continue;
                Boolean isCan = true;
                if (obstacle instanceof Treadmill) isCan = participant.run(obstacle);
                else if (obstacle instanceof Wall) isCan = participant.jump(obstacle);
                else System.out.println("Не могу опознать тип участника");
                if(!isCan)
                {
                    System.out.printf("-- Участник %s отстранен.\n", participant.getName());
                    participantStatus.put(participant, false);
                }
            }
        }
        System.out.println("ОБЪЯВЛЯЕМ СОРЕВНОВАНИЯ ЗАКРЫТЫМИ.");

        // Итоги соревнований
        LinkedList<Participant> winParticipants = new LinkedList<>();
        for (var participant : participantStatus.entrySet())
        {
            if (participant.getValue()) winParticipants.add(participant.getKey());
        }
        if (winParticipants.size() > 0)
        {
            System.out.println("Список участников, преодолевших все препятствия:");
            for (var participant : winParticipants)
            {
                System.out.println(participant.getName());
            }
        }
        else System.out.println("Никто не смог дойти до конца");
    }
}