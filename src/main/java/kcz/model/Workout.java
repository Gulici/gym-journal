package kcz.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Workout {
    private int id;
    private User user;
    private LocalDate startDate;
    private LocalTime endTime;
    private List<Exercise> exercises;

    public Workout(User user, LocalDate startDate, LocalTime endTime, List<Exercise> exercises) {
        this.user = user;
        this.startDate = startDate;
        this.endTime = endTime;
        this.exercises = exercises;
    }

    public Workout() {
        exercises = new ArrayList<>();
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
