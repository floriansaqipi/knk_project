package com.example.knk_project.controllers;

import com.example.knk_project.models.Profesori;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfesorPageController implements Initializable {
    private MainController mainController;
    private Profesori profesori ;
    @FXML
    private AnchorPane ap;

    @FXML
    private BorderPane bp;
    @FXML
    private Button logOutButton;

    public void setProfesori(Profesori profesori) {
        this.profesori = profesori;
    }


    @FXML
    public void loadProfesoriHomePage(ActionEvent event){
        initData();
    }

    private void setProfesorPage() throws IOException {
        AnchorPane root = null;

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/knk_project/" + "profesor-home-page-view" + ".fxml"));
            root =  fxmlLoader.load();
            ProfesorHomePageController profesorHomePageController = fxmlLoader.getController();
//        System.out.println(this.mainController);
            profesorHomePageController.setMainController(this.mainController);
            profesorHomePageController.setProfesori(this.profesori);
//            profesorHomePageController.printProfesori();

//            AddGradeController addGradeController = fxmlLoader.getController();
//            addGradeController.setProfesori(this.profesori);
//            addGradeController.initData();

        bp.setCenter(root);
    }

    private void reset(){
        try{
        this.setProfesorPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void ShtoNoten(MouseEvent event) {

        AnchorPane root = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/knk_project/" + "add-nota-view" + ".fxml"));
            root =  fxmlLoader.load();
            AddGradeController addGradeController = fxmlLoader.getController();
            addGradeController.setProfesori(this.profesori);
            addGradeController.initData();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        bp.setCenter(root);

    }
    @FXML
    public void Notat(MouseEvent event) {
        AnchorPane anchorPane = null;
        try{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/knk_project/" + "table-nota-view-new" + ".fxml"));
        anchorPane = fxmlLoader.load();
        TableNotaControllerNew tableNotaControllerNew = fxmlLoader.getController();
        tableNotaControllerNew.setProfesori(this.profesori);
        tableNotaControllerNew.initData();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        bp.setCenter(anchorPane);

    }
    @FXML
    public void ShikoProfilin(MouseEvent event) {
      loadPage("profile-professor-view");
    }
    public void LogOut(MouseEvent event) {
        this.mainController.reset();

    }

    public void shikoDashboard(MouseEvent event){

    }

    private void loadPage(String page){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/com/example/knk_project/"+page + ".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ProfesorPageController.class.getName()).log(Level.SEVERE,null,ex);
        }
        bp.setCenter(root);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void initData(){
        try {
            this.setProfesorPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
