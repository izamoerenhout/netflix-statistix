package GUI;

import Backend.Account;
import DatabaseConnection.Database;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.List;

public class GUI extends Application {

    List<Account> accounts;
    Database db = new Database();

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Drie buttons en een Label voor de eerste scene.
        Button buttonAccounts = new Button("Accounts");
        Button buttonProfiles = new Button("Profiles");
        Button buttonWatched = new Button("Watched");
        Label pickAnOption = new Label("Pick an option:");

        // Twee HBoxes, de eerste voor de Label, de andere voor de drie Buttons.
        // Beide HBoxes hebben center alignment.
        HBox options = new HBox(12);
        options.setAlignment(Pos.CENTER);
        options.getChildren().addAll(buttonAccounts, buttonProfiles, buttonWatched);
        HBox text = new HBox();
        text.setAlignment(Pos.CENTER);
        text.getChildren().add(pickAnOption);

        // De HBoxes worden gestopt in een BorderPane.
        // HBox "text" heeft een top margin van 20 en HBox "options" een bottom margin van 20,
        // zo wordt de BorderPane netjes uitgelijnd in het midden van de scene.
        BorderPane pane = new BorderPane();
        pane.setTop(text);
        pane.setMargin(text, new Insets(20, 0, 0 , 0));
        pane.setCenter(options);
        pane.setMargin(options, new Insets(0, 0, 20, 0));

        Scene selectionScreen = new Scene(pane, 500, 100);

        primaryStage.setTitle("Netflix Statistix door S. Jaspers, I. Moerenhout en Z. Usmaeva");
        primaryStage.setResizable(false);
        primaryStage.setScene(selectionScreen);
        primaryStage.show();

        // EventHandler voor de Accounts Button.
        buttonAccounts.setOnAction(e -> {
            Button buttonCreateAccount = new Button("Create");
            Button buttonEditAccount = new Button("Edit");
            Button buttonDeleteAccount = new Button("Delete");
            Button back = new Button("Back");
            Label createEditOrDelete = new Label("Create a new account, or edit/delete an existing account:");

            back.setOnAction(e1 -> primaryStage.setScene(selectionScreen));

            HBox text1 = new HBox();
            text1.setAlignment(Pos.CENTER);
            text1.getChildren().add(createEditOrDelete);
            HBox options1 = new HBox(12);
            options1.setAlignment(Pos.CENTER);
            options1.getChildren().addAll(buttonCreateAccount, buttonEditAccount, buttonDeleteAccount);
            HBox text2 = new HBox();
            text2.setSpacing(50);
            text2.getChildren().add(back);

            BorderPane pane1 = new BorderPane();
            pane1.setTop(text1);
            pane1.setMargin(text1, new Insets(15, 0, 0, 0));
            pane1.setCenter(options1);
            pane1.setMargin(options1, new Insets(0, 0, 15, 0));
            pane1.setBottom(text2);

            Scene accounts = new Scene(pane1, 500, 100);
            primaryStage.setScene(accounts);
        });

        // EventHandler voor de Profiles Button.
        buttonProfiles.setOnAction(e -> {
            Button buttonCreateProfile = new Button("Create");
            Button buttonEditProfile = new Button("Edit");
            Button buttonDeleteProfile = new Button("Delete");
            Button back = new Button("Back");
            Label createEditOrDelete = new Label("Create a new profile, or edit/delete an existing profile:");

            back.setOnAction(e1 -> primaryStage.setScene(selectionScreen));

            HBox text1 = new HBox();
            text1.setAlignment(Pos.CENTER);
            text1.getChildren().add(createEditOrDelete);
            HBox options1 = new HBox(12);
            options1.setAlignment(Pos.CENTER);
            options1.getChildren().addAll(buttonCreateProfile, buttonEditProfile, buttonDeleteProfile);
            HBox text2 = new HBox();
            text2.setSpacing(50);
            text2.getChildren().add(back);

            BorderPane pane1 = new BorderPane();
            pane1.setTop(text1);
            pane1.setMargin(text1, new Insets(15, 0, 0, 0));
            pane1.setCenter(options1);
            pane1.setMargin(options1, new Insets(0, 0, 15, 0));
            pane1.setBottom(text2);

            Scene profiles = new Scene(pane1, 500, 100);
            primaryStage.setScene(profiles);
        });

        // EventHandler voor de Watched Button.
        buttonWatched.setOnAction(e -> {
            Button buttonAddWatched = new Button("Add");
            Button buttonEditWatched = new Button("Edit");
            Button buttonDeleteWatched = new Button("Delete");
            Button back = new Button("Back");
            Label createEditOrDelete = new Label("Add a new watched program, or edit/delete an existing watched program:");

            back.setOnAction(e1 -> primaryStage.setScene(selectionScreen));

            HBox text1 = new HBox();
            text1.setAlignment(Pos.CENTER);
            text1.getChildren().add(createEditOrDelete);
            HBox options1 = new HBox(12);
            options1.setAlignment(Pos.CENTER);
            options1.getChildren().addAll(buttonAddWatched, buttonEditWatched, buttonDeleteWatched);
            HBox text2 = new HBox();
            text2.setSpacing(50);
            text2.getChildren().add(back);

            BorderPane pane1 = new BorderPane();
            pane1.setTop(text1);
            pane1.setMargin(text1, new Insets(15, 0, 0, 0));
            pane1.setCenter(options1);
            pane1.setMargin(options1, new Insets(0, 0, 15, 0));
            pane1.setBottom(text2);

            Scene watched = new Scene(pane1, 500, 100);
            primaryStage.setScene(watched);
        });
    }
}
