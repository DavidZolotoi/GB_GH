package org.example;

import java.util.Random;

public class Robot implements Participant
{
    String name;
    Double maxDistance;
    Double maxWall;
    public Robot(String name)
    {
        this.name = name;
        this.maxDistance = new Random().nextDouble() * 5.5;
        this.maxWall     = new Random().nextDouble() * 2.0;
    }

    @Override
    public Boolean run(Obstacle obstacle)
    {
        if (this.maxDistance >= obstacle.obstacleValue)
        {
            System.out.printf("%s пробежал\n", this.name);
            return true;
        }
        else
        {
            System.out.printf("%s не добежал. Его максимум %.2f\n", this.name, this.maxDistance);
            return false;
        }
    }

    @Override
    public Boolean jump(Obstacle obstacle)
    {
        if (this.maxWall >= obstacle.obstacleValue)
        {
            System.out.printf("%s перепрыгнул\n", this.name);
            return true;
        }
        else
        {
            System.out.printf("%s не допрыгнул. Его максимум %.2f\n", this.name, this.maxWall);
            return false;
        }
    }

    @Override
    public String getName()
    {
        return this.name;
    }
}
