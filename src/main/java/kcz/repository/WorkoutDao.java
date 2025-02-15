package kcz.repository;

import kcz.model.Workout;

import java.sql.*;

public class WorkoutDao extends Dao {
    public WorkoutDao() {
        super();
    }
    public void createWorkout(Workout workout) {
        String sql = "insert into workouts (user_id, start_date, end_time) values(?,?,?)";
        try(Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,workout.getUser().getId());
            ps.setDate(2,Date.valueOf(workout.getStartDate()));
            ps.setTime(3, Time.valueOf(workout.getEndTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Workout getWorkout(int id) {
        String selectWorkout = "select * from workouts where id = ?";
        String selectExercises = "select * from exercises e "+
                "join workouts_exercises we on e.id = we.ex_id "+
                "where we.workout_id = ?";
        Workout workout = null;
        try (Connection con = getConnection();
            PreparedStatement psW = con.prepareStatement(selectWorkout);
            PreparedStatement psE = con.prepareStatement(selectExercises)) {

            psW.setInt(1,id);
            ResultSet rs = psE.executeQuery();

            if(!rs.isBeforeFirst()) return null;

            rs.next();
            workout = new Workout();
            workout.setId(rs.getInt("id"));
            workout.setStartDate(rs.getDate("start_date").toLocalDate());
            workout.setEndTime(rs.getTime("end_time").toLocalTime());
            rs.close();

            psE.setInt(1,id);
            rs = psE.executeQuery();
            while(rs.next()) {

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return workout;
    }
}
