/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.clutchers.GUI;

import edu.clutchers.entities.Post;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import edu.clutchers.services.PostCrud;
import java.io.File;
import java.sql.SQLException;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author aziza
 */
public class AjouterPostGUIController implements Initializable {

    @FXML
    private Label lblTitre;
    @FXML
    private Label lblContent;
    @FXML
    private Label lblImage;
    @FXML
    private Label lblUser;
    @FXML
    private Label lblCreatedAt;
    @FXML
    private TextField tfTitre;
    @FXML
    private TextField tfUser;
    @FXML
    private TextField tfImage;
    @FXML
    private TextArea tfContent;
    @FXML
    private Button btnAjout;
    @FXML
    private DatePicker dpCreatedAt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void ajouterPost(ActionEvent event) throws SQLException{
        if(validator()){
           try {
               java.sql.Date date = java.sql.Date.valueOf(dpCreatedAt.getValue());
               
               int user = Integer.parseInt(tfUser.getText());
               
               Post p = new Post (user, tfTitre.getText(), tfContent.getText(), tfImage.getText(), date) ;
               PostCrud pc = new PostCrud(){};
               pc.add(p);
           } catch (SQLException ex) {
                System.err.println(ex.getMessage());
           }
       
        
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
            System.out.println("erruer files");
        }
    }
         
    
    public boolean validator(){
        String msg="";
        
        if(tfUser.getText()==null){
            msg+=" Veuillez choisir l'utilisateur \n";
           
        }
       
        if(tfTitre.getText().length()==0){
            msg+=" Veuillez remplir le champ du titre svp ";
           
           
        }
              if(tfContent.getText().length()==0){
            msg+=" Veuillez saisir le contenu svp \n";
           
        }
                   if(dpCreatedAt.getValue()==null){
            msg+=" Veuillez remplir le champ de date svp \n";
           
        }
                   
                      
                 
                 
                 
           if(msg!="")  { 
          
          
          Alert a = new Alert(Alert.AlertType.ERROR,msg, ButtonType.OK);
            a.show();
          return false;
        }   
           
           msg="Votre Post a été publié avec succés!";
             Alert a = new Alert(Alert.AlertType.CONFIRMATION,msg, ButtonType.OK);
            a.show();
           
           return true ;
        
    
    }
    
    
}
