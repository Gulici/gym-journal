package kcz.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import kcz.Main;
import kcz.model.UserStat;
import kcz.service.UserService;

import java.util.List;

public class UserStatsController {

    @FXML
    private TableView<UserStat> userStatsTable;

    @FXML
    private TableColumn<UserStat, Integer> idColumn;

    @FXML
    private TableColumn<UserStat, Integer> userIdColumn;

    @FXML
    private TableColumn<UserStat, Integer> weightColumn;

    @FXML
    private TableColumn<UserStat, Integer> heightColumn;

    @FXML
    private TableColumn<UserStat, String> dateColumn;

    private final UserService userStatService = new UserService();
    private ObservableList<UserStat> userStatsList;

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

    public void handleAddStat(ActionEvent actionEvent) {
    }

    public void handleDeleteStat(ActionEvent actionEvent) {
    }
}
