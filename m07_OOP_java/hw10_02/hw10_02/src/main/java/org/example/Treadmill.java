package org.example;

import java.util.LinkedList;
import java.util.Random;

public class Treadmill extends Obstacle
{
    public Treadmill(Double maxDistance)
    {
        super.name = "Беговая дорожка";
        super.obstacleValue = new Random().nextDouble() * maxDistance;
    }

    /**
     * Генерирует лист случайных беговых дорожек
     * @param treadmillsCount количество беговых дорожек
     * @param maxDistance макисмальная дистанция беговых дорожек
     * @return лист случайных беговых дорожек
     */
    public static LinkedList<Treadmill> GetRandomList(Integer treadmillsCount, Double maxDistance)
    {
        LinkedList<Treadmill> randomList = new LinkedList<>();
        for (int i = 0; i < treadmillsCount; i++)
        {
            randomList.add(i, new Treadmill(maxDistance));
        }
        return randomList;
    }


}
