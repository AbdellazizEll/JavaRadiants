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
public class AfficherPubliciteController implements Initializable {

    @FXML
    private Label lblTitre;
    @FXML
    private Label lblTeaser;
    @FXML
    private Label lblImage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setTitre(String Titre){
        lblTitre.setText(Titre);
    }
    public void setTeaser(String Teaser){
       lblTeaser.setText(Teaser);
    }
    public void setImage(String Image){
       lblImage.setText(Image);
    }
    
}
