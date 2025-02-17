package kcz.model;

import java.util.List;

public class WorkoutPlan {
    private int id;
    private User user;
    private String name;
    private String comment;

    private List<Exercise> exercises;

    public WorkoutPlan(User user, String name, String comment) {
        this.user = user;
        this.name = name;
        this.comment = comment;
    }

    public WorkoutPlan() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
