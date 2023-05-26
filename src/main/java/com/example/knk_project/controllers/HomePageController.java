package com.example.knk_project.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HomePageController implements Initializable {
    @FXML
    private MenuButton LogIn;
    
    @FXML
    private AnchorPane anchorePaneHomePage;

    @FXML
    private MenuItem adminItem;

    @FXML
    private MenuItem studentItem;

    @FXML
    private MenuItem professorItem;
    @FXML
    private Button goBackButton;


    // Action event handler for the adminItem
    @FXML
    private void adminSignUp(ActionEvent actionEvent) {
        loadFXML("sign-up-admin-view");
    }

    // Action event handler for the studentItem
    @FXML
    private void studentSignUp(ActionEvent actionEvent) {
        loadFXML("sign-up-nxenesi-view");
    }

    // Action event handler for the professorItem
    @FXML
    private void professorSignUp(ActionEvent actionEvent) {
        loadFXML("sign-up-profesori-view");
    }
    public void adminLogIn(ActionEvent actionEvent) {
        loadFXML("log-in-admin-view");
    }
    public void studentLogIn(ActionEvent actionEvent) {
        loadFXML("log-in-nxenesi-view");
    }
    public void professorLogIn(ActionEvent actionEvent){
        loadFXML("log-in-profesori-view");

    }

    private void loadFXML(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/knk_project/" + fxmlPath + ".fxml"));
            AnchorPane loadedPane = loader.load();
            anchorePaneHomePage.getChildren().setAll(loadedPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void GoBack(javafx.scene.input.MouseEvent mouseEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/knk_project/homepage-view.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setTitle("Homepage");
            stage.setScene(new Scene(root));
            stage.show();

            // Close the current stage
            Stage currentStage = (Stage) goBackButton.getScene().getWindow();
            currentStage.close();
        } catch (IOException ex) {
            Logger.getLogger(ProfesorPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
