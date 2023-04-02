package org.example;

import java.util.LinkedList;
import java.util.Random;

public class Wall extends Obstacle
{
    public Wall(Double maxWall)
    {
        super.name = "Стена";
        super.obstacleValue = new Random().nextDouble() * maxWall;
    }

    /**
     * Генерирует лист случайных стен
     * @param wallsCount количество стен
     * @param maxWall макисмальная дистанция стен
     * @return лист случайных стен
     */
    public static LinkedList<Wall> GetRandomList(Integer wallsCount, Double maxWall)
    {
        LinkedList<Wall> randomList = new LinkedList<>();
        for (int i = 0; i < wallsCount; i++)
        {
            randomList.add(i, new Wall(maxWall));
        }
        return randomList;
    }
}
