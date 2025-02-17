package kcz.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String username;
    private List<UserStat> userStats;

    private List<Workout> workouts;
    private List<WorkoutPlan> workoutPlans;

    public User(String username, List<UserStat> userStats, List<Workout> workouts, List<WorkoutPlan> workoutPlans) {
        this.username = username;
        this.userStats = userStats;
        this.workouts = workouts;
        this.workoutPlans = workoutPlans;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<UserStat> getUserStats() {
        return userStats;
    }

    public void setUserStats(List<UserStat> userStats) {
        this.userStats = userStats;
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
}
