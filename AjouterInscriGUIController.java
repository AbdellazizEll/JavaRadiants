/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.clutchers.GUI;

import edu.clutchers.entities.Inscription;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import edu.clutchers.services.InscriptionCrud;

/**
 * FXML Controller class
 *
 * @author aziza
 */
public class AjouterInscriGUIController implements Initializable {

    @FXML
    private Label lblIdTournoi;
    @FXML
    private TextField tfIdtournoi;
    @FXML
    private Button btnAjout;
    @FXML
    private Label lblNomComplet;
    @FXML
    private TextField tfNomcomplet;
    @FXML
    private TextField tfNomequipe;
    @FXML
    private TextField tfNombrejoueur;
    @FXML
    private TextField tfNomjoueur1;
    @FXML
    private Label lblNomEquipe;
    @FXML
    private Label lblNombrejoueur;
    @FXML
    private Label lblNomjoueur1;
    @FXML
    private TextField tfNomjoueur2;
    @FXML
    private TextField tfNomjoueur3;
    @FXML
    private TextField tfNomjoueur4;
    @FXML
    private TextField tfNomjoueur5;
    @FXML
    private TextField tfEmail;
    @FXML
    private Label lblNomjoueur2;
    @FXML
    private Label lblNomjoueur3;
    @FXML
    private Label lblNomjoueur4;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblNomjoueur5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterInscription(ActionEvent event) {
        
        try {
            
             int tournoi = Integer.parseInt(tfIdtournoi.getText());
             int nbj = Integer.parseInt(tfNombrejoueur.getText());
            Inscription i = new Inscription (tfIdtournoi.getText(),tfNomcomplet.getText(),tfNomequipe.getText(), nbj, tfNomjoueur1.getText(),tfNomjoueur2.getText(), tfNomjoueur3.getText(),tfNomjoueur4.getText(),tfNomjoueur5.getText(),tfEmail.getText());
            InscriptionCrud ic= new InscriptionCrud(){};
            ic.ajouterInscri(i);
            Alert a= new Alert(Alert.AlertType.CONFIRMATION,"Inscription Envoyée", ButtonType.APPLY);
            a.show();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AfficherInscription.fxml"));
            Parent root = loader.load();
            tfNomcomplet.getScene().setRoot(root);
            AfficherInscriptionController aic = loader.getController();
            aic.setNomTournoi(tfIdtournoi.getText());
            aic.setNomComplet(tfNomcomplet.getText());
            aic.setNomEquipe(tfNomequipe.getText());
            aic.setNombrejoueur(tfNombrejoueur.getText());
            aic.setNomJoueur1(tfNomjoueur1.getText());
            aic.setNomJoueur2(tfNomjoueur2.getText());
            aic.setNomJoueur3(tfNomjoueur3.getText());
            aic.setNomJoueur4(tfNomjoueur4.getText());
            aic.setNomJoueur5(tfNomjoueur5.getText());
            aic.setEmail(tfEmail.getText());
            
        } catch (IOException ex) {
           System.err.println(ex.getMessage());
        }
        }
    
}
