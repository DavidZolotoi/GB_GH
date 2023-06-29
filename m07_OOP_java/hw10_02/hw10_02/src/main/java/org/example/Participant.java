package org.example;

public interface Participant
{
    Boolean run(Obstacle obstacle);
    Boolean jump(Obstacle obstacle);
    String getName();
}
