/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI I7
 */
public class AcceuilController implements Initializable {

    @FXML
    private Button btnEquipe;
    @FXML
    private Button btnTournoi;
    @FXML
    private Button btnMatch;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void ouvrirEquipe(ActionEvent event){
        try {
       
            Stage stage = (Stage) btnEquipe.getScene().getWindow();
            stage.close();
            Stage PrimaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/GestionEquipe.fxml"));
            
           PrimaryStage.setTitle("Gestion Des Equipes");
           PrimaryStage.setScene(new Scene(root));
           PrimaryStage.show();
           
            
        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }      
    }
    
    @FXML
    private void ouvrirTournoi(ActionEvent event){
        try {
       
            Stage stage = (Stage) btnTournoi.getScene().getWindow();
            stage.close();
            Stage PrimaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/GestionTournoi.fxml"));
            
           PrimaryStage.setTitle("Gestion Des Tournoi");
           PrimaryStage.setScene(new Scene(root));
           PrimaryStage.show();
           
            
        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }      
    }
    
    @FXML
    private void ouvrirMatch(ActionEvent event){
        try {
       
            Stage stage = (Stage) btnMatch.getScene().getWindow();
            stage.close();
            Stage PrimaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/GestionMatch.fxml"));
            
           PrimaryStage.setTitle("Gestion Des Match");
           PrimaryStage.setScene(new Scene(root));
           PrimaryStage.show();
           
            
        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }      
    }
}
