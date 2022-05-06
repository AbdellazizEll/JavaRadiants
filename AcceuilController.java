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
 * @author ziedh
 */
public class AcceuilController implements Initializable {

    @FXML
    private Button btnCommande;
    @FXML
    private Button btnPublicite;

    /**
     * Initializes the controller class.
     */
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void ouvrirCommande(ActionEvent event){
        try {
       
            Stage stage = (Stage) btnCommande.getScene().getWindow();
            stage.close();
            Stage PrimaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/GestionCommandes.fxml"));
            
           PrimaryStage.setTitle("Gestion Des Commandes");
           PrimaryStage.setScene(new Scene(root));
           PrimaryStage.show();
           
            
        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }      
    }
    
    @FXML
    private void ouvrirPublicite(ActionEvent event){
        try {
       
            Stage stage = (Stage) btnPublicite.getScene().getWindow();
            stage.close();
            Stage PrimaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/GestionPublicite.fxml"));
            
           PrimaryStage.setTitle("Gestion Des Publixite");
           PrimaryStage.setScene(new Scene(root));
           PrimaryStage.show();
           
            
        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }      
    }
    
  
    }

    

