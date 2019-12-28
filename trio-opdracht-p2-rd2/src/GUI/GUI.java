package GUI;

import DatabaseConnection.DatabaseConnection;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application implements EventHandler<ActionEvent> {

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
        button.setOnAction(this);

        layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 500, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(actionEvent.getSource() == button) {
            DatabaseConnection dbcon = new DatabaseConnection();
            Text field = new Text(dbcon.execute());
            layout.getChildren().add(field);
        }
    }
}
