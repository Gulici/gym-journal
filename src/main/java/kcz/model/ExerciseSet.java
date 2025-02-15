package kcz.model;

import java.time.LocalTime;

public class ExerciseSet {
    private int id;
    private int reps;
    private int weight;
    private LocalTime startTime;
    private LocalTime endTime;

    public ExerciseSet(int reps, int weight, LocalTime startTime, LocalTime endTime) {
        this.reps = reps;
        this.weight = weight;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public ExerciseSet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
