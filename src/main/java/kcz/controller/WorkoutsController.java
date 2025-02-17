package kcz.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import kcz.Main;
import kcz.model.Workout;
import kcz.service.WorkoutService;

import java.util.List;


public class WorkoutsController {

    @FXML
    private TableView<Workout> workoutsTable;
    @FXML
    private TableColumn<Workout, Integer> idColumn;
    @FXML
    private TableColumn<Workout, String> startDate;

    private final WorkoutService workoutService = new WorkoutService();

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        startDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));

        loadWorkouts();
    }

    private void loadWorkouts() {
        List<Workout> workouts = workoutService.getWorkouts(Main.currentUser);
        ObservableList<Workout> workoutsList = FXCollections.observableList(workouts);
        workoutsTable.setItems(workoutsList);
    }


    public void handleNewWorkout(ActionEvent actionEvent) {
    }

    public void handleWorkoutDetails(ActionEvent actionEvent) {
    }

    public void backToMenu(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/kcz/views/menu.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
