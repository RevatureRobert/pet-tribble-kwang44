package dev.model;

public class Tribble {
    int id;
    int lab;

    public Tribble(int id, int lab) {
        this.id = id;
        this.lab = lab;
    }

    public Tribble(int id) {
        this.id = id;
        this.lab = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLab() {
        return lab;
    }

    public void setLab(int lab) {
        this.lab = lab;
    }

    @Override
    public String toString() {
        return "Tribble{" +
                "id=" + id +
                ", lab=" + lab +
                '}';
    }
}
