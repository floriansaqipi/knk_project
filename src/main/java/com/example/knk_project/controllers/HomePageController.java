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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HomePageController extends BaseController implements Initializable {
    private MainController mainController;
    @FXML
    private MenuButton LogIn;

    @FXML
    private MenuItem adminItem;

    @FXML
    private MenuItem adminSignUpItem;

    @FXML
    private AnchorPane anchorePaneHomePage;

    @FXML
    private Button goBackButton;

    @FXML
    private Label goBackInstruction;

    @FXML
    private Label homeControllerBaner;



    @FXML
    private ImageView homePageImage;



    @FXML
    private Label homePageWelcome;

    @FXML
    private BorderPane homePagebp;

    @FXML
    private MenuItem professorItem;

    @FXML
    private MenuItem professorSignUpItem;

    @FXML
    private MenuButton signUp;

    @FXML
    private MenuItem studentItem;

    @FXML
    private MenuItem studentSignUpItem;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }


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

    @FXML
    void loadManuali(ActionEvent event) {
        loadFXML("user-manual-view");
    }
    // Action event handler for the professorItem
    @FXML
    private void professorSignUp(ActionEvent actionEvent) {
        loadFXML("sign-up-profesori-view");
    }
    public void adminLogIn(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/knk_project/" + "log-in-admin-view" + ".fxml"));
            AnchorPane loadedPane = loader.load();
            LogInAdminiController logInAdminiController = loader.getController();
            logInAdminiController.setMainController(mainController);
            anchorePaneHomePage.getChildren().setAll(loadedPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void studentLogIn(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/knk_project/" + "log-in-nxenesi-view" + ".fxml"));
            AnchorPane loadedPane = loader.load();
            LogInNxenesiController logInNxenesiController = loader.getController();
            logInNxenesiController.setMainController(mainController);
            anchorePaneHomePage.getChildren().setAll(loadedPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void professorLogIn(ActionEvent actionEvent){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/knk_project/" + "log-in-profesori-view" + ".fxml"));
            AnchorPane loadedPane = loader.load();
            LogInProfesoriController logInProfesoriController = loader.getController();
            logInProfesoriController.setMainController(mainController);
            anchorePaneHomePage.getChildren().setAll(loadedPane);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        Locale.setDefault(new Locale("en"));

        loadLang();
    }

    @FXML
    void loadAlbanianText(ActionEvent event) {
        Locale.setDefault(new Locale("sq"));
        loadLang();
    }

    @FXML
    void loadEnglishText(ActionEvent event) {
        Locale.setDefault(new Locale("en"));
        loadLang();
    }



    @Override
    public void translate(ResourceBundle bundle) {
        this.LogIn.setText(bundle.getString("login.button.text"));
        this.signUp.setText(bundle.getString("signup.button.text"));
        this.goBackInstruction.setText(bundle.getString("goback.instruction"));
        this.homePageWelcome.setText(bundle.getString("home.welcome"));
        this.homeControllerBaner.setText(bundle.getString("home.banner"));
        this.professorSignUpItem.setText(bundle.getString("home.professor.option"));
        this.professorItem.setText(bundle.getString("home.professor.option"));
        this.studentSignUpItem.setText(bundle.getString("home.student.option"));        this.professorSignUpItem.setText(bundle.getString("home.professor.option"));
        this.studentItem.setText(bundle.getString("home.student.option"));

    }


    public void GoBack(javafx.scene.input.MouseEvent mouseEvent) {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/knk_project/homepage-view.fxml"));
//            BorderPane root = loader.load();
            this.mainController.reset();
//            this.mainController.setMainPane(root);
//            this.setMainController(mainController);
//            this.mainController.setMainPane(root);

            // Close the current stage
//            Stage currentStage = (Stage) goBackButton.getScene().getWindow();
//            currentStage.close();
//        } catch (IOException ex) {
//            Logger.getLogger(ProfesorPageController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }



}
