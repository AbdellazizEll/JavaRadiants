/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import workshopjdbc.services.ServiceUtilisateur;
import workshopjdbc.services.ServiceUtilisateurImpl;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ValidationController implements Initializable {

    @FXML
    private TextField ValidEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Valider(ActionEvent event) throws SQLException, IOException {
        
        int id; 
        String pw; 
        
        if(ValidEmail.getText().equals(""))
        {
            Alert alert=new Alert(Alert.AlertType.ERROR, "Veuillez saisir un code non nulle", ButtonType.OK);
            alert.showAndWait();
        }else{
            String[] chaine=ValidEmail.getText().split("-");
            if(chaine.length<2 ){
                Alert alert=new Alert(Alert.AlertType.ERROR, "Veuillez saisir un code valide", ButtonType.OK);
            alert.showAndWait();
            }
            else{
               try{
                id=Integer.parseInt(chaine[0]);
                pw=chaine[1];
                
                ServiceUtilisateurImpl  su = new ServiceUtilisateurImpl();
                
                if(su.getUserByIdPw(id, pw)==1){
                    
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Authentifaction.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
                    
                }else {
Alert alert=new Alert(Alert.AlertType.ERROR, "Veuillez saisir un code valide", ButtonType.OK);
            alert.showAndWait();
                }
               }catch (Exception ex){
                Alert alert=new Alert(Alert.AlertType.ERROR, "Veuillez saisir un code valide", ButtonType.OK);
            alert.showAndWait();   
               }
                
            }
        }
    }
    
}
