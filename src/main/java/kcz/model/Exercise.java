package kcz.model;

import java.util.ArrayList;
import java.util.List;

public class Exercise {
    private int id;
    private ExerciseDetail exerciseDetail;
    private ExerciseType exerciseType;
    private List<ExerciseSet> exerciseSets;

    public Exercise(ExerciseDetail exerciseDetail, ExerciseType exerciseType, List<Workout> workouts, List<WorkoutPlan> workoutPlans, List<ExerciseSet> exerciseSets) {
        this.exerciseDetail = exerciseDetail;
        this.exerciseType = exerciseType;
        this.exerciseSets = exerciseSets;
    }

    public Exercise() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ExerciseDetail getExerciseDetail() {
        return exerciseDetail;
    }

    public void setExerciseDetail(ExerciseDetail exerciseDetail) {
        this.exerciseDetail = exerciseDetail;
    }

    public ExerciseType getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(ExerciseType exerciseType) {
        this.exerciseType = exerciseType;
    }

    public List<ExerciseSet> getExerciseSets() {
        return exerciseSets;
    }

    public void setExerciseSets(List<ExerciseSet> exerciseSets) {
        this.exerciseSets = exerciseSets;
    }
}
