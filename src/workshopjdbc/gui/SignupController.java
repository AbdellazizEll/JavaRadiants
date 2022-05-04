/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;
import workshopjdbc.entities.Utilisateur;
import workshopjdbc.services.ServiceUtilisateur;
import workshopjdbc.services.ServiceUtilisateurImpl;
import workshopjdbc.utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class SignupController implements Initializable {

    
    @FXML
    private TextField FirstnameTF;
    @FXML
    private TextField LastnameTF;
    @FXML
    private TextField EmailTF;
    @FXML
    private PasswordField PasswordTF;
    @FXML
    private TextField CPasswordTF;
    @FXML
    private TextField PictureTF;

    /**
     * Initializes the controller class.
     */
       Connection cnx = MyConnection.getInstance().getCnx();
    @FXML
    private Label ErrorLabel;


    @FXML
    public  void AjoutUser(ActionEvent event) throws SQLException, IOException {
        
            
      if(FirstnameTF.getText().equals(""))
      {
          ErrorLabel.setText("Le nom est Obligatoire");
      }else if (LastnameTF.getText().equals(""))
      {
          ErrorLabel.setText("Le prenom est obligatoire! ");
      }else if (EmailTF.getText().equals(""))
      {
          ErrorLabel.setText("L'email est obligatoire! ");
      }else if (PasswordTF.getText().equals(""))
      {
          ErrorLabel.setText("Le password est obligatoire! ");
      }else if (CPasswordTF.getText().equals(""))
      {
          ErrorLabel.setText("La confirmation est obligatoire! ");
      }
      else {
          Utilisateur utilisateur = new Utilisateur();
            ServiceUtilisateurImpl nu = new ServiceUtilisateurImpl();
             if (validateFNAME())
                 utilisateur.setFirstName(FirstnameTF.getText());
          if(validateLNAME())
               utilisateur.setLastName(LastnameTF.getText());
               
               if(validateEmail()){
                utilisateur.setEmail(EmailTF.getText());
                
               }else 
               {
                   System.out.println("Email n'est pas validé ");
               }
               if(validatePW()){
                utilisateur.setPassword(PasswordTF.getText());
               }
                utilisateur.setRoles("[\"ROLE_USER\"]");
                utilisateur.setPicture(PictureTF.getText());
                
               
                
                if(nu.signup(utilisateur)==0 &&  nu.SendMail(utilisateur,"null")){
                    
                      FXMLLoader loader = new FXMLLoader(getClass().getResource("Validation.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
                }
                   else if (nu.signup(utilisateur)==1)
       {
           ErrorLabel.setText("L'adresse email deja existe");
       }else if (nu.signup(utilisateur)==2)
       {
           ErrorLabel.setText("Le login est deja utilisé \n Login Disponible :"+nu.Login_Dispo(utilisateur)+"  !");

       }
    
            
      }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            // validationSupport.setErrorDecorationEnabled(false);
        
    }

    
    private boolean validateEmail(){
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9.]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p.matcher(EmailTF.getText());
        
        if(m.find() && m.group().equals(EmailTF.getText())){
            return true; 
            
        } else {
            Alert alert= new Alert(AlertType.WARNING);
            
            alert.setTitle("Validate Email");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Valid Email");
            alert.showAndWait();
            
            
            return false;
            
        }
        
        
    }
    
    private boolean validateFNAME(){
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(FirstnameTF.getText());
        
        if(m.find() && m.group().equals(FirstnameTF.getText())){
            return true; 
            
        } else {
            Alert alert= new Alert(AlertType.WARNING);
            
            alert.setTitle("Validate Firstname");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Valid Firstname");
            alert.showAndWait();
            
            
            return false;
            
        }

    
    }
    
     private boolean validateLNAME(){
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(LastnameTF.getText());
        
        if(m.find() && m.group().equals(LastnameTF.getText())){
            return true; 
            
        } else {
            Alert alert= new Alert(AlertType.WARNING);
            
            alert.setTitle("Validate Lastname");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Valid Lastname");
            alert.showAndWait();
            
            
            return false;
            
        }

    
    }
     
     private boolean validatePW(){
          Pattern p = Pattern.compile(".{0,8}[a-zA-Z0-9]+");
        Matcher m = p.matcher(PasswordTF.getText());
        
         if(m.find() && m.group().equals(PasswordTF.getText())){
             return true;
             
         }else {
             Alert alert = new Alert(AlertType.WARNING);
             alert.setTitle("Validate Password");
             alert.setHeaderText(null);
             alert.setContentText("Please Enter a valid Password");
             alert.showAndWait();
             
             return false;
         }
     }

    @FXML
    private void Backtologin(ActionEvent event) throws IOException {
        
          
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Authentifaction.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        ((Stage) FirstnameTF.getScene().getWindow()).close();

    }
     
     
}
