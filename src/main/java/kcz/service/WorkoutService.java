package kcz.service;

import kcz.model.User;
import kcz.model.Workout;
import kcz.repository.WorkoutDao;

import java.util.List;

public class WorkoutService {
    WorkoutDao workoutDao = new WorkoutDao();

    public List<Workout> getWorkouts(User user) {
        if(user == null) {
            return null;
        }
        return workoutDao.getUserWorkouts(user);
    }
}
