package kcz.model;

import java.time.LocalTime;

public class ExerciseDetail {
    private int id;
    private LocalTime startTime;
    private int rate;
    private String comment;

    public ExerciseDetail(LocalTime startTime, int rate, String comment) {
        this.startTime = startTime;
        this.rate = rate;
        this.comment = comment;
    }

    public ExerciseDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
