/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.clutchers.GUI;

import edu.clutchers.entities.Commentaire;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import edu.clutchers.services.CommentaireCrud;
import java.io.File;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author aziza
 */
public class AjouterCommentaireGUIController implements Initializable {

    @FXML
    private Label lblContent;
    @FXML
    private Label lblImage;
    @FXML
    private Label lblCreatedAt;
    @FXML
    private Label lblUser;
    @FXML
    private Label lblPost;
    @FXML
    private TextField tfUser;
    @FXML
    private TextField tfPost;
    @FXML
    private TextField tfContent;
    @FXML
    private TextField tfImage;
    @FXML
    private DatePicker dpCreatedAt;
    @FXML
    private Button btnUp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void ajouterComm(ActionEvent event) {
        
       if(validator()){
         java.sql.Date date = java.sql.Date.valueOf(dpCreatedAt.getValue());
           
            int user = Integer.parseInt(tfUser.getText());
            int post = Integer.parseInt(tfPost.getText());
            Commentaire c = new Commentaire (user, post, tfContent.getText(),tfImage.getText(),date);
            CommentaireCrud cc = new CommentaireCrud(){};
            cc.add(c);
        

       }
    }
    
     @FXML
    private void loadIMG(ActionEvent event) {

        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {

     tfImage.setText(selectedFile.getAbsolutePath());
           Image image = new Image(selectedFile.toURI().toString(), 50, 50, true, true) {};

            System.out.println(selectedFile.getName());
        } else {
            System.out.println("erreur files");
        }
    }
    
    
    public boolean validator(){
        String msg="";
        
        if(tfUser.getText()==null){
            msg+=" Veuillez choisir l'utilisateur \n";
           
        }
       
        if(tfPost.getText().length()==0){
            msg+=" Veuillez choisir le post ";
           
           
        }
              if(tfContent.getText().length()==0){
            msg+=" Veuillez saisir le contenu du commentaire \n";
           
        }
                   if(dpCreatedAt.getValue()==null){
            msg+=" Veuillez donner date de création \n";
           
        }
                   
                      
                 
                 
                 
           if(msg!="")  { 
          
          
          Alert a = new Alert(Alert.AlertType.ERROR,msg, ButtonType.OK);
            a.show();
          return false;
        }  
           msg="Votre Commentaire a été publié!";
            Alert a = new Alert(Alert.AlertType.CONFIRMATION,msg, ButtonType.OK);
            a.show();
           return true ;
        
    
    }
    
    
    
}
