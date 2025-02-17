package kcz.repository;

import kcz.model.Exercise;
import kcz.model.User;
import kcz.model.Workout;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class WorkoutDao extends Dao {
    public WorkoutDao() {
        super();
    }
    public void createWorkout(Workout workout) {
        String sql = "insert into workouts (user_id, start_date, start_time, end_time) values(?,?,?,?)";
        try(Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,workout.getUser().getId());
            ps.setDate(2,Date.valueOf(workout.getStartDate()));
            ps.setTime(3, Time.valueOf(workout.getStartTime()));
            ps.setTime(4, Time.valueOf(workout.getEndTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Workout getWorkout(int id) {
        String selectWorkout = "select * from workouts where id = ?";
        String selectExercises = "select * from exercises e "+
                "where w_id = ?";
        Workout workout = null;
        try (Connection con = getConnection();
            PreparedStatement psW = con.prepareStatement(selectWorkout);
            PreparedStatement psE = con.prepareStatement(selectExercises)) {

            psW.setInt(1,id);
            ResultSet rs = psE.executeQuery();

            if(!rs.isBeforeFirst()) return null;
            // fetch workout
            rs.next();
            workout = new Workout();
            workout.setId(rs.getInt("id"));
            workout.setStartDate(rs.getDate("start_date").toLocalDate());
            workout.setEndTime(rs.getTime("end_time").toLocalTime());
            rs.close();
            // fetch eager list of exercises
            psE.setInt(1,id);
            rs = psE.executeQuery();
            List<Exercise> exercises= new ArrayList<>();
            if(rs.isBeforeFirst()){
                while(rs.next()) {
                    Exercise ex = new Exercise();
                    // fetching only id, other fields are lazy
                    ex.setId(rs.getInt("id"));
                    exercises.add(ex);
                }
            }
            workout.setExercises(exercises);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return workout;
    }

    public List<Workout> getUserWorkouts(User user) {
        List<Workout> workouts = new ArrayList<>();
        String sql = "select * from workouts where user_id = ?";
        try(Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,user.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Workout workout = new Workout();
                workout.setId(rs.getInt("id"));
                workout.setUser(user);

                String startDateStr = rs.getString("start_date");
                LocalDate startDate = LocalDate.parse(startDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                workout.setStartDate(startDate);

                String startTimeStr = rs.getString("start_time");
                LocalTime startTime = LocalTime.parse(startTimeStr, DateTimeFormatter.ofPattern("HH:mm"));
                workout.setStartTime(startTime);

                String endTimeStr = rs.getString("end_time");
                LocalTime endTime = LocalTime.parse(endTimeStr, DateTimeFormatter.ofPattern("HH:mm"));
                workout.setEndTime(endTime);
                workouts.add(workout);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return workouts;
    }
}
