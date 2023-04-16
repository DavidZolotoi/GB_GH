package org.example.model;


abstract public class APeople {
    private int id;

    public APeople() {
        this.id = Index.createId();
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "id=" + id;
    }
}