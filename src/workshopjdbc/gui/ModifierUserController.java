/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import workshopjdbc.entities.Utilisateur;
import workshopjdbc.services.ServiceUtilisateurImpl;
import workshopjdbc.utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ModifierUserController implements Initializable {

     @FXML
    private Label ErrorLabel;
    @FXML
    private TextField FNedit;
    @FXML
    private TextField LNedit;
    @FXML
    private TextField Eedit;
    @FXML
    private TextField PWedit;
    @FXML
    private TextField CPedit;
    @FXML
    private TextField Pedit;
    
    public static Utilisateur user;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO


        FNedit.setText(user.getFirstName());
        LNedit.setText(user.getLastName());
        Eedit.setText(user.getEmail());
        Pedit.setText(user.getPicture());
        
    }

    @FXML
    private void Editprofil(ActionEvent event) throws IOException {
        
        if(FNedit.getText().equals(""))
      {
          ErrorLabel.setText("Le nom est Obligatoire");
      }else if (LNedit.getText().equals(""))
      {
          ErrorLabel.setText("Le prenom est obligatoire! ");
      }else if (Eedit.getText().equals(""))
      {
          ErrorLabel.setText("L'email est obligatoire! ");
      }else if (PWedit.getText().equals(""))
      {
          ErrorLabel.setText("Le password est obligatoire! ");
      }else if (Pedit.getText().equals(""))
      {
          ErrorLabel.setText("La confirmation est obligatoire! ");
      }
      else {
          
          Utilisateur u=new Utilisateur();
         
            ServiceUtilisateurImpl nu = new ServiceUtilisateurImpl();
            u.setFirstName(FNedit.getText());
               u.setLastName(LNedit.getText());
                u.setEmail(Eedit.getText());
                u.setPassword(PWedit.getText());
                if(user.getRoles().toLowerCase().contains("admin"))
                u.setRoles("[\"ROLE_ADMIN\"]");
                else
                    u.setRoles("[\"ROLE_USER\"]");
                u.setPicture(Pedit.getText());
                u.setId(user.getId());
                
                if(nu.modifier(u)==1){
                    user=u;
                      FXMLLoader loader = new FXMLLoader(getClass().getResource("BackUsers.fxml"));
       Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            
            stage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);
            stage.show();
           ((Stage) FNedit.getScene().getWindow()).close();
                
                  
       }else  
       {
           ErrorLabel.setText("Mail deja existant");

       }
    
            
      }
        
        
    }
}
