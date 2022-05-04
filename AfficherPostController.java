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
public class AfficherPostController implements Initializable {

    @FXML
    private Label lblUser;
    @FXML
    private Label lblTitre;
    @FXML
    private Label lblContent;
    @FXML
    private Label lblImage;
    @FXML
    private Label lblCreatedAt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setUser(String User){
        lblUser.setText(User);
    }
    public void setTitre(String Titre){
        lblTitre.setText(Titre);
    }
    public void setContent(String Content){
        lblContent.setText(Content);
    }
    public void setImage(String Image){
        lblImage.setText(Image);
    }
    public void setCreatedAt(String CreatedAt){
        lblCreatedAt.setText(CreatedAt);
    }
    
}
