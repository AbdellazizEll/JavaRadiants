/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.gui;

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
 * @author sof
 */
public class MenuController implements Initializable {

    @FXML
    private Button btnActualite;
    @FXML
    private Button btnJeux;

    /**
     * Initializes the controller class.
     */
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void ouvrirActualite(ActionEvent event){
        try {
       
            Stage stage = (Stage) btnActualite.getScene().getWindow();
            stage.close();
            Stage PrimaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/GestionActualite.fxml"));
            
           PrimaryStage.setTitle("Gestion Des Commandes");
           PrimaryStage.setScene(new Scene(root));
           PrimaryStage.show();
           
            
        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }      
    }
    
    @FXML
    private void ouvrirJeux(ActionEvent event){
        try {
       
            Stage stage = (Stage) btnJeux.getScene().getWindow();
            stage.close();
            Stage PrimaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/GestionJeux.fxml"));
            
           PrimaryStage.setTitle("Gestion Des Jeux");
           PrimaryStage.setScene(new Scene(root));
           PrimaryStage.show();
           
            
        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }      
    }  
    
}
