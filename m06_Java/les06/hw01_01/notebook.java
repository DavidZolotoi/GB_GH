package q01m09_Java.les06.hw01_01;

import java.util.Random;
public class notebook
{
    // ID
    Integer ID;
    //1 - ОЗУ (оперативка)
    Integer RAM;
    //2 - Объём ЖД
    Integer ROM;
    //3 - Операционная система
    String OS;
    //4 - Цвет
    String Color;
    public notebook(Integer ram, Integer rom, String os, String color) {
        ID = new Random().nextInt(1000000);
        RAM = ram;
        ROM = rom;
        OS = os;
        Color = color;
    }
}