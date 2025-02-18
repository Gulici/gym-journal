package kcz.controller;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import kcz.model.Exercise;
import kcz.model.ExerciseSet;

import java.io.IOException;

public class ExerciseCellController extends ListCell<Exercise> {

    @FXML
    private Label nameLabel;

    @FXML
    private ListView<ExerciseSet> setListView;

    @FXML
    private TextField repsField;

    @FXML
    private TextField weightField;

    @FXML
    private Button addSetButton;

    private ObservableList<ExerciseSet> sets;

    private final FXMLLoader loader;

    public ExerciseCellController() {
        loader = new FXMLLoader(getClass().getResource("/kcz/views/exerciseCell.fxml"));
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void updateItem(Exercise exercise, boolean empty) {
        super.updateItem(exercise, empty);

        if (empty || exercise == null) {
            setGraphic(null);
        } else {
            nameLabel.setText(exercise.getExerciseType().getName());

            if (sets == null) { // Nie twórz nowej listy za każdym razem
                sets = FXCollections.observableArrayList();
                setListView.setItems(sets);
            }

//            setListView.prefWidthProperty().bind(Bindings.size(setListView.getItems()).multiply(setListView.getFixedCellSize()).add(2));

            sets.setAll(exercise.getExerciseSets()); // Zamiast tworzyć nową listę

            addSetButton.setOnAction(event -> {
                try {
                    int reps = Integer.parseInt(repsField.getText());
                    int weight = Integer.parseInt(weightField.getText());

                    ExerciseSet newSet = new ExerciseSet();
                    newSet.setReps(reps);
                    newSet.setWeight(weight);

                    sets.add(newSet);
                    exercise.getExerciseSets().add(newSet);

                    repsField.clear();
                    weightField.clear();
                } catch (NumberFormatException e) {
                    System.out.println("Błąd: Nieprawidłowe dane");
                }
            });

            setGraphic(loader.getRoot());
        }
    }

}
