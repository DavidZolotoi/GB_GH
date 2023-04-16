package org.example.model;

public class Index {
    private static int index = 0;

    synchronized static public int createId() {
        return index++;
    }

}
