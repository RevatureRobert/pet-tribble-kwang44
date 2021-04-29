package dev.model;

public class Lab {
    int id;

    public Lab(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "id=" + id +
                '}';
    }
}
