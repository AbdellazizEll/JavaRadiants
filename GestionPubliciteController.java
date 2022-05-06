/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.clutchers.GUI;

import edu.clutchers.entities.Publicite;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import edu.clutchers.services.PubliciteCrud;
import java.io.File;
import java.util.List;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author ziedh
 */
public class GestionPubliciteController implements Initializable {

    @FXML
    private TextArea tfTeaser;
    @FXML
    private TextField tfTitre;
    @FXML
    private TextField tfImage;
    @FXML
    private TableView<Publicite> TableV;
    @FXML
    private TableColumn<Publicite, Integer> tcId;
    @FXML
    private TableColumn<Publicite, String> tcTitre;
    @FXML
    private TableColumn<Publicite, String> tcTeaser;
    @FXML
    private TableColumn<Publicite, String> tcImage;
    @FXML
    private Button btnAjouterPub;
    @FXML
    private Button btnSupprimerPub;
    @FXML
    private Button btnModifierPub;
    @FXML
    private Button btnRefreshPub;
    @FXML
    private Button btnRetour;

    @FXML
    private void refreshTable(javafx.scene.input.MouseEvent event){
        
           list.clear();
           list.addAll(pc.getAll());
        
          TableV.setItems(list);
         
    }

    /**
     * Initializes the controller class.
     */
    int id;
     PubliciteCrud pc = new PubliciteCrud();
     ObservableList list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     loadDataPublicite();
     
     btnSupprimerPub.setDisable(true);
     btnModifierPub.setDisable(true);
       TableV.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)
                -> {
                  
                    if(newValue!=null){
                          System.out.println(newValue);
                          
                          id=((Publicite) newValue).getId();
                      populateInputs((Publicite) newValue);
               }

        });
    }    
    
    @FXML
    private void ajouterPublicite(ActionEvent event) {
        
       if(validator()){
         
        
            Publicite p = new Publicite (tfTitre.getText(), tfTeaser.getText(),tfImage.getText() );
            PubliciteCrud pc = new PubliciteCrud(){};
            pc.add(p);
        
        
       }
       refreshTable(null);
    }
    @FXML
    private void modifierPublicite(ActionEvent event) {
            if(validator()){
        
            
            Publicite p = new Publicite (tfTitre.getText(), tfTeaser.getText(),tfImage.getText() );
            PubliciteCrud pc = new PubliciteCrud(){};
            pc.update(id,p);

         
         
         
             }
        refreshTable(null);
    }


   
 
     public void loadDataPublicite(){
    //        ObservableListrTournoi> list=  loarTournoi();   
          list.clear();
          list.addAll(pc.getAll());
  
        // tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
         tcTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
         tcTeaser.setCellValueFactory(new PropertyValueFactory<>("teaser"));
         tcImage.setCellValueFactory(new PropertyValueFactory<>("image"));
        
        
        
         TableV.setItems(list);
 
    }  
    

    


    
    
   public void  populateInputs(Publicite Publicite){
       
          
         tfTitre.setText(String.valueOf(Publicite.getTitre()));
         tfTeaser.setText(String.valueOf(Publicite.getTeaser()));
         tfImage.setText(String.valueOf(Publicite.getImage()));
          
          
         
         
         
        
         
          
        btnModifierPub.setDisable(false);
        btnSupprimerPub.setDisable(false);
    
   
   }

    @FXML
    private void supprimerPublicite(ActionEvent event) {
        
        pc.delete(id);
      
        refreshTable(null);
    }
    

    @FXML
    private void retour(){
        try {

            Stage stage = (Stage) btnRetour.getScene().getWindow();
            stage.close();
            Stage PrimaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Acceuil.fxml"));

           PrimaryStage.setTitle("Acceuil");
           PrimaryStage.setScene(new Scene(root));
           PrimaryStage.show();


        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
         
       
         
    
    public boolean validator(){
        String msg="";
       
        if(tfTitre.getText().length()==0){
            msg+=" Champ tfTitre vide, ";
           
           
        }
              if(tfTeaser.getText().length()==0){
            msg+=" Champ tfTeaser vide, \n";
           
        }
                   
             if(tfImage.getText().length()==0){
            msg+=" Champ tfImage vide, \n";
           
        }     
                 
                 
                 
           if(msg!="")  { 
          
          
          Alert a = new Alert(Alert.AlertType.ERROR,msg, ButtonType.OK);
            a.show();
          return false;
        }   
           return true ;
        
    
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
    @FXML
    private void tri(ActionEvent event) {

        PubliciteCrud evt = new PubliciteCrud();
        Publicite t=new Publicite();
      List<Publicite> a = evt.tripub();;
       
        tcTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
         tcImage.setCellValueFactory(new PropertyValueFactory<>("image"));
         tcTeaser.setCellValueFactory(new PropertyValueFactory<>("teaser"));

         ObservableList<Publicite> data=FXCollections.observableArrayList(a);
         TableV.getItems().setAll(a);
         System.out.println(a);

    }
} 
    

