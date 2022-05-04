/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.clutchers.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aziza
 */
public class MainMenuController implements Initializable {

    @FXML
    private Button btnFront;
    @FXML
    private Button btnBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     @FXML
    private void ouvrirBack(ActionEvent event){
        try {

            Stage stage = (Stage) btnBack.getScene().getWindow();
            stage.close();
            Stage PrimaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("../GUI/Menu.fxml"));

           PrimaryStage.setTitle("Back");
           PrimaryStage.setScene(new Scene(root));
           PrimaryStage.show();


        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
     @FXML
    private void ouvrirFront(ActionEvent event){
        try {

            Stage stage = (Stage) btnFront.getScene().getWindow();
            stage.close();
            Stage PrimaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/FrontMenu.fxml"));

           PrimaryStage.setTitle("Front");
           PrimaryStage.setScene(new Scene(root));
           PrimaryStage.show();


        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
    
}
