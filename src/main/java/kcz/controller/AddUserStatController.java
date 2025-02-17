package kcz.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import kcz.model.UserStat;
import kcz.service.UserService;

public class AddUserStatController {

    @FXML
    private TextField weightField;
    @FXML
    private TextField heightField;

    private UserService userService = new UserService();

    public void handleAddStat(ActionEvent actionEvent) {
        UserStat stat = new UserStat();
        try {
            stat.setWeight(Integer.parseInt(weightField.getText()));
            stat.setHeight(Integer.parseInt(heightField.getText()));
            userService.addUserStat(stat);

            Stage stage = (Stage) weightField.getScene().getWindow();
            stage.close();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Incorrect data!");
            alert.showAndWait();
        }
    }

    public void handleCancel(ActionEvent actionEvent) {
        Stage stage = (Stage) weightField.getScene().getWindow();
        stage.close();
    }
}
