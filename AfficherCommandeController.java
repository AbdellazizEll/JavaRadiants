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
public class AfficherCommandeController implements Initializable {

    @FXML
    private Label lblProduit;
    @FXML
    private Label lblTotale;
    @FXML
    private Label lblDate;
    @FXML
    private Label lblAdresse;
    @FXML
    private Label lblMail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void setProduit(String Produit){
        lblProduit.setText(Produit);
    }
     public void setTotale(String Totale){
        lblTotale.setText(Totale);
    }
     public void setDate(String Date){
        lblDate.setText(Date);
    }
     public void setAdresse(String Adresse){
        lblAdresse.setText(Adresse);
    }
     public void setMail(String Mail){
        lblMail.setText(Mail);
    }
    
}
