package kcz.model;

public class ExerciseType {
    private int id;
    private Bodypart bodypart;
    private String name;

    public ExerciseType(Bodypart bodypart, String name) {
        this.bodypart = bodypart;
        this.name = name;
    }

    public ExerciseType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bodypart getBodypart() {
        return bodypart;
    }

    public void setBodypart(Bodypart bodypart) {
        this.bodypart = bodypart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
