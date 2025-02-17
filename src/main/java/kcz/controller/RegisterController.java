package kcz.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import kcz.model.User;
import kcz.service.UserService;

public class RegisterController {
    @FXML
    TextField newUsernameField;
    @FXML
    TextField newPasswordField;
    @FXML
    TextField confirmPasswordField;

    private final UserService userService = new UserService();

    public void handleRegister(ActionEvent actionEvent) {
        //check password
        if(!newPasswordField.getText().equals(confirmPasswordField.getText())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Wrong input");
            alert.setHeaderText(null);
            alert.setContentText("Passwords do not match");
            newPasswordField.setText("");
            confirmPasswordField.setText("");
            alert.showAndWait();
            return;
        }
        if(newPasswordField.getLength() < 1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Wrong input");
            alert.setHeaderText(null);
            alert.setContentText("Passwords field empty");
            alert.showAndWait();
            return;
        }

        // create new user
        String newUsername = newUsernameField.getText();
        User user = new User();
        user.setUsername(newUsername);

        if(!userService.createUser(user)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Wrong input");
            alert.setHeaderText(null);
            alert.setContentText("Username already exists");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("New User");
            alert.setHeaderText(null);
            alert.setContentText("New user: " + newUsername + " created");
            alert.showAndWait();

            alert.setOnHidden(event -> {
                handleCancel(actionEvent);
            });
        }
    }

    public void handleCancel(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/kcz/views/login.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
