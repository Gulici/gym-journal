package kcz.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kcz.model.Exercise;
import kcz.model.ExerciseDetail;
import kcz.model.ExerciseType;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;
import java.util.ArrayList;

public class NewWorkoutController implements Initializable {

    @FXML
    private ListView<Exercise> exerciseListView;

    private ObservableList<Exercise> exercises;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Przykładowe dane
        exercises = FXCollections.observableArrayList(generateSampleExercises());
        exerciseListView.setItems(exercises);
        exerciseListView.setCellFactory(param -> new ExerciseCellController());
    }

    // Tworzy przykładowe ćwiczenia
    private List<Exercise> generateSampleExercises() {
        List<Exercise> list = new ArrayList<>();

        Exercise exercise1 = new Exercise();
        ExerciseDetail d1 = new ExerciseDetail();
        d1.setId(1);
        d1.setRate(5);
        d1.setComment("test");
        exercise1.setExerciseDetail(d1);
        ExerciseType t1 = new ExerciseType();
        t1.setId(1);
        t1.setName("t1");
        exercise1.setExerciseType(t1);
        exercise1.setExerciseSets(new ArrayList<>());

        Exercise exercise2 = new Exercise();
        ExerciseDetail d2 = new ExerciseDetail();
        d2.setId(2);
        d2.setRate(8);
        d2.setComment("test2");
        ExerciseType t2 = new ExerciseType();
        t2.setId(1);
        t2.setName("t2");
        exercise2.setExerciseDetail(d2);
        exercise2.setExerciseType(t2);
        exercise2.setExerciseSets(new ArrayList<>());

        list.add(exercise1);
        list.add(exercise2);
        return list;
    }

    public void handleAddExercise(ActionEvent actionEvent) {
    }
}
