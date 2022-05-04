/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.clutchers.GUI;

import edu.clutchers.entities.Commentaire;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import edu.clutchers.services.CommentaireCrud;
import java.io.File;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author aziza
 */
public class GestionCommentaireController implements Initializable {

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
    @FXML
    private TextField tfUser;
    @FXML
    private TextField tfTitre;
    @FXML
    private TextArea taContent;
    @FXML
    private TextField tfImage;
    @FXML
    private DatePicker tfCreatedAt;
    @FXML
    private TableView<Commentaire> tableV;
    @FXML
    private TableColumn<Commentaire, Integer> tcId;
    @FXML
    private TableColumn<Commentaire, Integer> tcUser;
    @FXML
    private TableColumn<Commentaire, Integer> tcPost;
    @FXML
    private TableColumn<Commentaire, String> tcTitre;
    @FXML
    private TableColumn<Commentaire, String> tcImage;
    @FXML
    private TableColumn<Commentaire, String> tcContenu;
    @FXML
    private TableColumn<Commentaire, Date> tcCreatedAt;
    @FXML
    private Button btnAjout;
    @FXML
    private Button btnRetour;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Label lblPost;
    @FXML
    private TextField tfPost;

       @FXML
    private void refreshTable(javafx.scene.input.MouseEvent event){
        
           list.clear();
           list.addAll(cc.getAll());
        
          tableV.setItems(list);
    }
     @FXML
    private void retour(){
        try {

            Stage stage = (Stage) btnRetour.getScene().getWindow();
            stage.close();
            Stage PrimaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));

           PrimaryStage.setTitle("Menu");
           PrimaryStage.setScene(new Scene(root));
           PrimaryStage.show();


        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    /**
     * Initializes the controller class.
     */
     int id;
     CommentaireCrud cc = new CommentaireCrud();
     ObservableList list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     loadDataCommentaire();
     
     btnSupprimer.setDisable(true);
     btnModifier.setDisable(true);
       tableV.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)
                -> {
                  
                    if(newValue!=null){
                          System.out.println(newValue);
                          
                          id=((Commentaire) newValue).getId();
                      populateInputs((Commentaire) newValue);
               }

        });
    }    
    
    @FXML
    private void ajouterComm(ActionEvent event) {
        
       if(validator()){
         java.sql.Date date = java.sql.Date.valueOf(tfCreatedAt.getValue());
           
            int user = Integer.parseInt(tfUser.getText());
            int post = Integer.parseInt(tfPost.getText());
            Commentaire c = new Commentaire (user, post, taContent.getText(),tfImage.getText(),date);
            CommentaireCrud cc = new CommentaireCrud(){};
            cc.add(c);
        
               Notifications notificationBuilder = Notifications.create()
                    .title("Notification")
                    .text("Commentaire ajouté avec succés!")
                    .hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER);
            notificationBuilder.show();
        refreshTable(null);
       }
    }
    @FXML
    private void modifierComm(ActionEvent event) {
            if(validator()){
         java.sql.Date date = java.sql.Date.valueOf(tfCreatedAt.getValue());
           
            int user = Integer.parseInt(tfUser.getText());
            int post = Integer.parseInt(tfPost.getText());
            Commentaire c = new Commentaire (user, post, taContent.getText(),tfImage.getText(),date);
            CommentaireCrud cc = new CommentaireCrud(){};
       
            
        cc.update(id, c);

            Notifications notificationBuilder = Notifications.create()
                    .title("Notification")
                    .text("Commentaire modifié avec succés!")
                    .hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER);
            notificationBuilder.show();
         refreshTable(null);
         
             }
        
    }


   
 
     public void loadDataCommentaire(){
    //        ObservableListrTournoi> list=  loarTournoi();   
          list.clear();
          list.addAll(cc.getAll());
  
         
         tcUser.setCellValueFactory(new PropertyValueFactory<>("user_id"));
         tcPost.setCellValueFactory(new PropertyValueFactory<>("post_id"));
         tcImage.setCellValueFactory(new PropertyValueFactory<>("image"));
         tcContenu.setCellValueFactory(new PropertyValueFactory<>("content"));
         tcCreatedAt.setCellValueFactory(new PropertyValueFactory<>("created_at") );
        
         tableV.setItems(list);
 
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

    
    
   public void  populateInputs(Commentaire commentaire){
       
          
         tfUser.setText(String.valueOf(commentaire.getUser_id()));
         tfPost.setText(String.valueOf(commentaire.getPost_id()));
         taContent.setText(commentaire.getContent());
         tfImage.setText(String.valueOf(commentaire.getImage()));
         tfCreatedAt.setValue(commentaire.getCreated_at().toLocalDate()); 
           
        btnModifier.setDisable(false);
        btnSupprimer.setDisable(false);
    
   
   }

    @FXML
    private void supprimerComm(ActionEvent event) {
        String c = "Voulez vous supprimer cette equipe ? Nom Equipe :   " ;
        
        
         Alert a = new Alert(Alert.AlertType.CONFIRMATION,c+taContent.getText(), ButtonType.OK,ButtonType.CANCEL);
        a.showAndWait().ifPresent(response -> {
        if (response == ButtonType.OK) {
           cc.delete(id);
        }
        });
           Notifications notificationBuilder = Notifications.create()
                    .title("Notification")
                    .text("Commentaire supprimé avec succés!")
                    .hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER);
            notificationBuilder.show();
        refreshTable(null);
        
        
      
        
    }
    

   
         
       
         
    
    public boolean validator(){
        String msg="";
        
        if(tfUser.getText()==null){
            msg+=" Veuillez choisir l'utilisateur \n";
           
        }
       
        if(tfPost.getText().length()==0){
            msg+=" Veuillez choisir le post ";
           
           
        }
              if(taContent.getText().length()==0){
            msg+=" Veuillez saisir le contenu du commentaire \n";
           
        }
                   if(tfCreatedAt.getValue()==null){
            msg+=" Veuillez donner date de création \n";
           
        }
                   
                      
                 
                 
                 
           if(msg!="")  { 
          
          
          Alert a = new Alert(Alert.AlertType.ERROR,msg, ButtonType.OK);
            a.show();
          return false;
        }   
           return true ;
        
    
    }
    
    
}
