/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.clutchers.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author aziza
 */
public class AfficherInscriptionController implements Initializable {
     @FXML
    private Label lblNomTournoi;
     @FXML
    private Label lblNomequipe;
     @FXML
    private Label lblNomComplet;
     @FXML
    private Label lblEmail;
     @FXML
    private Label lblNombrejoueur;
     @FXML
    private Label lblNomjoueur1;
     @FXML
    private Label lblNomjoueur2;
     @FXML
    private Label lblNomjoueur3;
     @FXML
    private Label lblNomjoueur4;
     @FXML
    private Label lblNomjoueur5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void setNomTournoi(String NomTournoi){
        lblNomTournoi.setText(NomTournoi);
    }
     public void setNomEquipe(String NomEquipe){
         lblNomequipe.setText(NomEquipe);
     }
      public void setNomComplet(String NomComplet){
         lblNomComplet.setText(NomComplet);
     }
      public void setEmail(String Email){
         lblEmail.setText(Email);
     }
      public void setNombrejoueur(String NombreJoueur){
         lblNombrejoueur.setText(NombreJoueur);
     }
      public void setNomJoueur1(String NomJoueur1){
        lblNomjoueur1.setText(NomJoueur1);
     }
      public void setNomJoueur2(String NomJoueur2){
        lblNomjoueur2.setText(NomJoueur2);
     }
      public void setNomJoueur3(String NomJoueur3){
        lblNomjoueur3.setText(NomJoueur3);
     }
      public void setNomJoueur4(String NomJoueur4){
        lblNomjoueur4.setText(NomJoueur4);
     }
      public void setNomJoueur5(String NomJoueur5){
        lblNomjoueur5.setText(NomJoueur5);
     }
     
    
}
