package kcz.model;

import java.util.ArrayList;
import java.util.List;

public class Exercise {
    private int id;
    private ExerciseDetail exerciseDetail;
    private ExerciseType exerciseType;
    private List<Workout> workouts;
    private List<WorkoutPlan> workoutPlans;
    private List<ExerciseSet> exerciseSets;

    public Exercise(ExerciseDetail exerciseDetail, ExerciseType exerciseType, List<Workout> workouts, List<WorkoutPlan> workoutPlans, List<ExerciseSet> exerciseSets) {
        this.exerciseDetail = exerciseDetail;
        this.exerciseType = exerciseType;
        this.workouts = workouts;
        this.workoutPlans = workoutPlans;
        this.exerciseSets = exerciseSets;
    }

    public Exercise() {
        workouts = new ArrayList<>();
        workoutPlans = new ArrayList<>();
        exerciseSets = new ArrayList<>();
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

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }

    public List<WorkoutPlan> getWorkoutPlans() {
        return workoutPlans;
    }

    public void setWorkoutPlans(List<WorkoutPlan> workoutPlans) {
        this.workoutPlans = workoutPlans;
    }

    public List<ExerciseSet> getExerciseSets() {
        return exerciseSets;
    }

    public void setExerciseSets(List<ExerciseSet> exerciseSets) {
        this.exerciseSets = exerciseSets;
    }
}
