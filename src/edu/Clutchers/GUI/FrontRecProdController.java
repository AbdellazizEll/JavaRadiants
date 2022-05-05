/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Clutchers.GUI;

import edu.Clutchers.entities.Reclamation;
import edu.Clutchers.services.ReclamationCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;


/**
 * FXML Controller class
 *
 * @author sinda
 */
public class FrontRecProdController implements Initializable {

    @FXML
    private TextArea tfContent;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfEmail;
    @FXML
    private Button btnRetour;
    @FXML
    private Button btnRetour1;
    @FXML
    private ComboBox<String> sujetreclamation;
    
     List<String> de1Ju5=new ArrayList<>();
    public void generateNumbers(){
       
            de1Ju5.add("Le catalogue produit en tête de liste");
            de1Ju5.add("L’opacité des prix");
            de1Ju5.add("Le fonctionnement du site");
            de1Ju5.add("La disponiblite du stock");
            de1Ju5.add("Les retours et rembourssements");
            de1Ju5.add("la livraison");
            de1Ju5.add("Le service apres vente");
            de1Ju5.add("Autres");
        
    }
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       generateNumbers();
        sujetreclamation.setItems(FXCollections.observableArrayList(de1Ju5));
    }    

    @FXML
    private void EnvoyerRec(ActionEvent event) {
        
        
        
       if (sujetreclamation.getValue() == null ) {
            sujetreclamation.requestFocus();
            //Animations.shake(txtNom);
            Alert missingFields = new Alert(Alert.AlertType.INFORMATION);
                missingFields.setHeaderText(null);
                missingFields.setContentText("sujet");
                missingFields.initModality(Modality.APPLICATION_MODAL);
                missingFields.showAndWait();
            return;
        }
        
        if (tfContent.getText().isEmpty()) {
            tfContent.requestFocus();
            Alert missingFields = new Alert(Alert.AlertType.INFORMATION);
                missingFields.setHeaderText(null);
                missingFields.setContentText("veuillez remplir tout les champs");
                missingFields.initModality(Modality.APPLICATION_MODAL);
                missingFields.showAndWait();
            //Animations.shake(txtNom);
            return;
        }
        
        if (tfNom.getText().isEmpty()) {
            tfNom.requestFocus();
            Alert missingFields = new Alert(Alert.AlertType.INFORMATION);
                missingFields.setHeaderText(null);
                missingFields.setContentText("veuillez remplir tout les champs");
                missingFields.initModality(Modality.APPLICATION_MODAL);
                missingFields.showAndWait();
            //Animations.shake(txtNom);
            return;
        }
        
        
        if (!tfNom.getText().matches("^[A-Za-z ]+$") ) {
            tfNom.requestFocus();
            Alert missingFields = new Alert(Alert.AlertType.INFORMATION);
            missingFields.setHeaderText(null);
            missingFields.setContentText("Attention nom");
            missingFields.initModality(Modality.APPLICATION_MODAL);
            missingFields.showAndWait();
            return;
        }
        
        
        
        int position1 =  tfEmail.getText().indexOf("@");
        int position2 =  tfEmail.getText().indexOf(".");
        if (tfEmail.getText().isEmpty() ) {
            tfEmail.requestFocus();
            Alert missingFields = new Alert(Alert.AlertType.INFORMATION);
                missingFields.setHeaderText(null);
                missingFields.setContentText("veuillez remplir tout les champs");
                missingFields.initModality(Modality.APPLICATION_MODAL);
                missingFields.showAndWait();
            //Animations.shake(txtNom);
            return;
        }
        System.out.println(position1);
        System.out.println(position2);
        
        if (position1 < 2 || position2 < position1+3 )
        
      //  if(position1 == -1 || position2 == -1 )
             {
            tfEmail.requestFocus();
            //Animations.shake(txtNom);
            return;
        }
       
        
        Reclamation r = new Reclamation(sujetreclamation.getValue(),tfContent.getText(),tfNom.getText(),tfEmail.getText());
        ReclamationCRUD sr = new ReclamationCRUD();
        sr.ajouterRec2(r);
        Sms.nabil("reclamation ajoutée");
        Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Reclamation envoyée ",ButtonType.OK);
        a.show();
   
         
    }

    @FXML
    private void DetailsRec(ActionEvent event) {
          Reclamation r = new Reclamation(sujetreclamation.getValue(),tfContent.getText(),tfNom.getText(),tfEmail.getText());
         FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsRecFront.fxml"));
                Parent root;
      try {
            root = loader.load();
             tfNom.getScene().setRoot(root);
                
             DetailsRecFrontController arc = loader.getController();
            arc.setTextSujet(r.getSujet());
            arc.setTextContent(r.getContent());
            arc.setTextNom(r.getNom());
            arc.setTextEmail(r.getEmail());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void Retour(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FirstPage.fxml"));
         Parent root = loader.load();
         FirstPageController ap = loader.getController();
         btnRetour.getScene().setRoot(root);
    }
    
}
