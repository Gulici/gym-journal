package kcz.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import kcz.Main;
import kcz.model.UserStat;
import kcz.service.UserService;

import java.time.LocalDate;
import java.util.List;

public class UserStatsController {

    @FXML
    private TableView<UserStat> userStatsTable;
    @FXML
    private TableColumn<UserStat, Integer> idColumn;
    @FXML
    private TableColumn<UserStat, Integer> weightColumn;
    @FXML
    private TableColumn<UserStat, Integer> heightColumn;
    @FXML
    private TableColumn<UserStat, String> dateColumn;

    private ObservableList<UserStat> userStatsList;

    private final UserService userService = new UserService();

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        heightColumn.setCellValueFactory(new PropertyValueFactory<>("height"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateCreate"));

        loadUserStats();
    }

    private void loadUserStats() {
        List<UserStat> stats = Main.currentUser.getUserStats();
        userStatsList = FXCollections.observableArrayList(stats);
        userStatsTable.setItems(userStatsList);
    }

    public void handleAddStatStage(ActionEvent actionEvent) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/kcz/views/addUserStats.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

            //reload user
            Main.currentUser = userService.getUser(Main.currentUser.getUsername());
            loadUserStats();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void handleDeleteStat(ActionEvent actionEvent) {
        UserStat stat = userStatsTable.getSelectionModel().getSelectedItem();
        userService.removeUserStat(stat);
        userStatsList.remove(stat);
        userStatsTable.refresh();
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
