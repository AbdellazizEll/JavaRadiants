/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.gui;


import java.io.IOException;
import java.security.MessageDigest;
import sun.misc.BASE64Encoder;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import workshopjdbc.entities.Utilisateur;
import workshopjdbc.services.ServiceUtilisateurImpl;

/**
 * FXML Controller class
 *
 * @author aziz
 */
public class AuthentifactionController implements Initializable {

    //@FXML
    //private Text TitreAuthentification;
    @FXML
    private AnchorPane BackTextGroupBox;

    @FXML
    private StackPane GroupBox;

    @FXML
    private TextField UserName;

    @FXML
    private PasswordField Mdp;

    @FXML
    private Text erreurText;

    ServiceUtilisateurImpl<Utilisateur> userDao = new ServiceUtilisateurImpl();
    @FXML
    private Hyperlink Inscrire;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void HandleConnexionAction(ActionEvent event) throws IOException {
        Utilisateur connexion = userDao.verifPassword( UserName.getText(),Mdp.getText());
        if (connexion != null) {
            
            
            if (connexion.getRoles().equals("admin")) {
              
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AcceuilBack.fxml"));
            Parent root = loader.load();
            AcceuilBackController personController = loader.getController();
             
                 Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            // stage.show();
            Stage ThisStage = (Stage) erreurText.getScene().getWindow();

            stage.setTitle("Entrepot");

            stage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);
            stage.show();

            ThisStage.close();
            }
           
          else {
               Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "succés", ButtonType.OK);
               alert.show();
          }
           
        } else {
            erreurText.setVisible(true);
            Mdp.setText("");
        }
    }

    @FXML
    private void HandleInscrireConnexion(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Signup.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        ((Stage) erreurText.getScene().getWindow()).close();

        // stage.show();
    }

    @FXML
    private void ForgotPW(ActionEvent event) {
    }

    @FXML
    private void validerCompte(ActionEvent event) throws IOException {
        
                      FXMLLoader loader = new FXMLLoader(getClass().getResource("Validation.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
                ((Stage) erreurText.getScene().getWindow()).close();
    }

}
