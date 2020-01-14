package gui.logic;

import gui.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/** Controller for the Overview Selection screen. */
public class OverviewSelectionScreenController {
    public Button buttonOverview1;
    public Button buttonOverview2;
    public Button buttonOverview3;
    public Button buttonOverview4;
    public Button buttonOverview5;
    public Button buttonOverview6;
    public Button buttonBack;
    public Stage stage;

    /** Returns to the Main Menu screen. */
    public void returnToMainMenu() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/MainMenu.fxml"));

        stage.setScene(new Scene(root));
    }

    /** Shows Overview 1. */
    public void showOverview1() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/overviews/Overview1.fxml"));

        stage.setScene(new Scene(root));
    }

    /** Shows Overview 2. */
    public void showOverview2() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/overviews/Overview2.fxml"));

        stage.setScene(new Scene(root));
    }

    /** Shows Overview 3. */
    public void showOverview3() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/overviews/Overview3.fxml"));

        stage.setScene(new Scene(root));
    }

    /** Shows Overview 4. */
    public void showOverview4() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/overviews/Overview4.fxml"));

        stage.setScene(new Scene(root));
    }

    /** Shows Overview 5. */
    public void showOverview5() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/overviews/Overview5.fxml"));

        stage.setScene(new Scene(root));
    }

    /** Shows Overview 6. */
    public void showOverview6() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/overviews/Overview6.fxml"));

        stage.setScene(new Scene(root));
    }
}
