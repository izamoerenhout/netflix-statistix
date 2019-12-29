package GUI;

import DatabaseConnection.Database;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application {

    Button button;
    StackPane layout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Netflix Statistix door S. Jaspers, I. Moerenhout en Z. Usmaeva");

        button = new Button();
        button.setText("Klik hier.");

        layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 500, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
