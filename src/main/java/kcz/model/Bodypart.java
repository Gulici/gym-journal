package kcz.model;

public class Bodypart {
    private int id;
    private String name;

    public Bodypart(String name) {
        this.name = name;
    }

    public Bodypart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
