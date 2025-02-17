package kcz.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import kcz.Main;
import kcz.model.User;
import kcz.service.UserService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField username;

    private UserService userService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.userService = new UserService();
    }

    @FXML
    private void openRegisterWindow(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/kcz/views/register.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleLogin(ActionEvent actionEvent) throws IOException {
        // look for user
        User user = userService.getUser(username.getText());
        if (user == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login error");
            alert.setHeaderText(null);
            alert.setContentText("User: " + username.getText()+ " not found!");
            alert.showAndWait();
            return;
        }

        // hold logged user as global static variable
        Main.currentUser = user;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/kcz/views/userStats.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
