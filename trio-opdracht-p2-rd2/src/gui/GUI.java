package gui;

import database.DatabaseConnection;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class GUI extends Application {

    DatabaseConnection db = new DatabaseConnection();

    @Override
    public void start(Stage stage) throws Exception {
        // Three buttons and a Label for the first scene.
        Button buttonAccounts = new Button("Accounts");
        Button buttonProfiles = new Button("Profiles");
        Button buttonWatched = new Button("Watched");
        Label pickAnOption = new Label("Pick an option:");

        // Two HBoxes, first one for the Label, the other one for the three Buttons.
        // Both HBoxes are aligned in the center.
        HBox options = new HBox(12);
        options.setAlignment(Pos.CENTER);
        options.getChildren().addAll(buttonAccounts, buttonProfiles, buttonWatched);
        HBox text = new HBox();
        text.setAlignment(Pos.CENTER);
        text.getChildren().add(pickAnOption);

        // The HBoxes are placed in a BorderPane.
        // HBox "text" has a top margin of 20 and HBox "options" has a bottom margin of 20.
        // This way, the BorderPane will be nicely aligned in the middle of the scene.
        BorderPane pane = new BorderPane();
        pane.setTop(text);
        pane.setMargin(text, new Insets(20, 0, 0 , 0));
        pane.setCenter(options);
        pane.setMargin(options, new Insets(0, 0, 20, 0));

        Scene selectionScreen = new Scene(pane, 500, 100);

        stage.setTitle("Netflix Statistix door S. Jaspers, I. Moerenhout en Z. Usmaeva");
        stage.setResizable(false);
        stage.setScene(selectionScreen);
        stage.show();

        // EventHandler for the Accounts Button.
        buttonAccounts.setOnAction(e -> {
            Button buttonCreateAccount = new Button("Create");
            Button buttonEditAccount = new Button("Edit");
            Button buttonDeleteAccount = new Button("Delete");
            Button back = new Button("Back");
            Label createEditOrDelete = new Label("Create a new account, or edit/delete an existing account:");

            back.setOnAction(e1 -> stage.setScene(selectionScreen));

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
            stage.setScene(accounts);

            // EventHandler for the Create Account button.
            buttonCreateAccount.setOnAction(e1 -> {
                GridPane grid = new GridPane();
                grid.setPadding(new Insets(10, 10, 10, 10));
                grid.setVgap(8);
                grid.setHgap(10);

                Button buttonSave = new Button("Save");
                Button buttonCancel = new Button("Cancel");

                buttonCancel.setOnAction(e3 -> {
                    stage.setScene(accounts);
                });

                Label accountName = new Label("Name:");
                Label accountAddress = new Label("Address:");
                Label accountCity = new Label("City:");

                TextField accountNameInput = new TextField();
                TextField accountAddressInput = new TextField();
                TextField accountCityInput = new TextField();

                grid.add(accountName, 0, 0);
                grid.add(accountNameInput, 1, 0);
                grid.add(accountAddress, 0, 1);
                grid.add(accountAddressInput, 1, 1);
                grid.add(accountCity, 0, 2);
                grid.add(accountCityInput, 1, 2);
                grid.add(buttonSave, 2, 3);
                grid.add(buttonCancel, 3, 3);

                Scene accountCreation = new Scene(grid);
                stage.setScene(accountCreation);

                buttonSave.setOnAction(e2 -> {

                });
            });

            // EventHandler for the Edit Account button.
            buttonEditAccount.setOnAction(e3 -> {

            });

            // EventHandler for the Delete Account button.
            buttonDeleteAccount.setOnAction(e4 -> {

            });
        });

        // EventHandler for the Profiles Button.
        buttonProfiles.setOnAction(e -> {
            Button buttonCreateProfile = new Button("Create");
            Button buttonEditProfile = new Button("Edit");
            Button buttonDeleteProfile = new Button("Delete");
            Button back = new Button("Back");
            Label createEditOrDelete = new Label("Create a new profile, or edit/delete an existing profile:");

            back.setOnAction(e1 -> stage.setScene(selectionScreen));

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
            stage.setScene(profiles);
        });

        // EventHandler for the Watched Button.
        buttonWatched.setOnAction(e -> {
            Button buttonAddWatched = new Button("Add");
            Button buttonEditWatched = new Button("Edit");
            Button buttonDeleteWatched = new Button("Delete");
            Button back = new Button("Back");
            Label createEditOrDelete = new Label("Add a new watched program, or edit/delete an existing watched program:");

            back.setOnAction(e1 -> stage.setScene(selectionScreen));

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
            stage.setScene(watched);
        });
    }

    public void showAccountsScreen(Stage stage) {
        Button buttonCreateAccount = new Button("Create");
        Button buttonEditAccount = new Button("Edit");
        Button buttonDeleteAccount = new Button("Delete");
        Button back = new Button("Back");
        Label createEditOrDelete = new Label("Create a new account, or edit/delete an existing account:");

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

        Scene accountsScreen = new Scene(pane1, 500, 100);
        stage.setScene(accountsScreen);
    }
}
