/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.clutchers.GUI;

import edu.clutchers.entities.Post;
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
import edu.clutchers.services.PostCrud;
import java.awt.AWTException;
import java.awt.Insets;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author aziza
 */
public class GestionPostController implements Initializable {

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
    private Button btnAjout;
    @FXML
    private Button btnRetour;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupprimer;
    private ScrollPane scrollT;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TableView<Post> tableV;
    @FXML
    private TableColumn<Post, Integer> tcUser;
    @FXML
    private TableColumn<Post, String> tcTitre;
    @FXML
    private TableColumn<Post, String> tcContenu;
    @FXML
    private TableColumn<Post, String> tcImage;
    @FXML
    private TableColumn<Post, Date> tcCreatedAt;
    @FXML
    private Button btntri;
    
    private void refreshTable(javafx.scene.input.MouseEvent event){
        
           list.clear();
           list.addAll(pc.getAll());
        
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
        PostCrud pc = new PostCrud();
     ObservableList list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     loadDataPost();
     
     btnSupprimer.setDisable(true);
     btnModifier.setDisable(true);
       tableV.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)
                -> {
                  
                    if(newValue!=null){
                          System.out.println(newValue);
                          
                          id=((Post) newValue).getId();
                      populateInputs((Post) newValue);
               }

        });
    }    
    
    @FXML
    
   /*public void uploadFileWithRobot(String imagePath) {
        StringSelection stringSelection = new StringSelection(imagePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        Robot robot = null;

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        robot.delay(250);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(150);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }*/
    private void ajouterPost(ActionEvent event) {
        
       if(validator()){
           try {
               java.sql.Date date = java.sql.Date.valueOf(tfCreatedAt.getValue());
               
               int user = Integer.parseInt(tfUser.getText());
               
               Post p = new Post (user, tfTitre.getText(), taContent.getText(), tfImage.getText(), date) ;
               PostCrud pc = new PostCrud(){};
               pc.add(p);
           } catch (SQLException ex) {
                System.err.println(ex.getMessage());
           }
           
              Notifications notificationBuilder = Notifications.create()
                    .title("Notification")
                    .text("Post ajouté avec succés!")
                    .hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER);
            notificationBuilder.show();
        refreshTable(null);
        
       }
    }
   @FXML
    private void modifierPost(ActionEvent event) {
            if(validator()){
                try {
                    java.sql.Date date = java.sql.Date.valueOf(tfCreatedAt.getValue());
                    
                    int user = Integer.parseInt(tfUser.getText());
                    Post p = new Post (user, tfTitre.getText(), taContent.getText(), tfImage.getText(), date) ;
                    PostCrud pc = new PostCrud(){};
                    
                    pc.update(id, p);
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
   Notifications notificationBuilder = Notifications.create()
                    .title("Notification")
                    .text("Post modifié avec succés!")
                    .hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER);
            notificationBuilder.show();
          refreshTable(null);
             }
        
    }


   
 
    /* public void loadDataPost(){
    
          list.clear();
          list.addAll(pc.getAll());
  
         tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
         tcUser.setCellValueFactory(new PropertyValueFactory<>("user_id"));
         tcTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
         tcContenu.setCellValueFactory(new PropertyValueFactory<>("content"));
         tcImage.setCellValueFactory(new PropertyValueFactory<>("image"));
         tcCreatedAt.setCellValueFactory(new PropertyValueFactory<>("created_at") );
        
         tableV.setItems(list);
 
    }  */
    

      public void loadDataPost(){
    //        ObservableListrTournoi> list=  loarTournoi();   
          list.clear();
          list.addAll(pc.getAll());
  
        
         tcUser.setCellValueFactory(new PropertyValueFactory<>("user_id"));
         tcTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
         tcImage.setCellValueFactory(new PropertyValueFactory<>("image"));
         tcContenu.setCellValueFactory(new PropertyValueFactory<>("content"));
         tcCreatedAt.setCellValueFactory(new PropertyValueFactory<>("created_at") );
        
         tableV.setItems(list);
 
    }  


    
    
   public void  populateInputs(Post post){
       
          
         tfUser.setText(String.valueOf(post.getUser_id()));
         tfTitre.setText(post.getTitre());
         taContent.setText(post.getContent());
         tfImage.setText(post.getImage());
         tfCreatedAt.setValue(post.getCreated_at().toLocalDate()); 
         
         
         
        btnModifier.setDisable(false);
        btnSupprimer.setDisable(false);
    
   
   }

    @FXML
    private void supprimerPost(ActionEvent event) {
       
        String c = "Voulez vous supprimer cette equipe ? Nom Equipe :   " ;
        
        
         Alert a = new Alert(Alert.AlertType.CONFIRMATION,c+taContent.getText(), ButtonType.OK,ButtonType.CANCEL);
        a.showAndWait().ifPresent(response -> {
        if (response == ButtonType.OK) {
            try {
                pc.delete(id);
            } catch (SQLException ex) {
                Logger.getLogger(GestionPostController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });
           Notifications notificationBuilder = Notifications.create()
                    .title("Notification")
                    .text("Post supprimé avec succés!")
                    .hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER);
            notificationBuilder.show();
        refreshTable(null);
        
        
      
        
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
              if(taContent.getText().length()==0){
            msg+=" Veuillez saisir le contenu svp \n";
           
        }
                   if(tfCreatedAt.getValue()==null){
            msg+=" Veuillez remplir le champ de date svp \n";
           
        }
                   
                      
                 
                 
                 
           if(msg!="")  { 
          
          
          Alert a = new Alert(Alert.AlertType.ERROR,msg, ButtonType.OK);
            a.show();
          return false;
        }   
           return true ;
        
    
    }
    
    @FXML
    private void tri(ActionEvent event) {

        PostCrud pc = new PostCrud();
        Post p=new Post();
      List <Post> a = pc.trier();
       
        tcTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
         tcContenu.setCellValueFactory(new PropertyValueFactory<>("content"));
         tcImage.setCellValueFactory(new PropertyValueFactory<>("image"));
         tcCreatedAt.setCellValueFactory(new PropertyValueFactory<>("created_at"));

        ObservableList<Post> data=FXCollections.observableArrayList(a);
         tableV.getItems().setAll(a);            
         System.out.println(a);

    }
    
    
}

