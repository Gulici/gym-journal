package kcz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import kcz.model.User;
import kcz.repository.utils.SQLiteExecutor;

import java.util.Objects;

public class Main extends Application {
    public static User currentUser;

    public static void main(String[] args) {
//        SQLiteExecutor executor = new SQLiteExecutor();
//        executor.resetDB();
//        executor.printDatabase();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("views/login.fxml")));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}