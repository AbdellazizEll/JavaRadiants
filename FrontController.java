/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.clutchers.GUI;

import edu.clutchers.entities.Post;
import edu.clutchers.tools.MyListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aziza
 */
public class FrontController implements Initializable {

    @FXML
    private VBox chosenplat;
    @FXML
    private HBox articleNameLable;
    @FXML
    private Label lblTitre;
    @FXML
    private Label lblContenu;
    @FXML
    private Label lblCreatedAt;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    private MyListener myListener;
    private Post post;
    private Button addCom;
    @FXML
    private Button addPost;
    @FXML
    private Button addComm;

    /**
     * Initializes the controller class.
     */
   @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    public void setData(Post post, MyListener myListener) {
        
        
        this.myListener = myListener;
        lblTitre.setText(post.getTitre());
        lblContenu.setText(post.getContent());
        lblCreatedAt.setText(post.getCreated_at().toString());
        this.post = post;
       
        //Image image = new Image(getClass().getResourceAsStream(plat.getImg()));
        //img.setImage(image);
        
    }   
    
    
    

    private void details(MouseEvent event) {
        myListener.onClickListener(post);
    }
    

   

    @FXML
    private void ajouterCom(ActionEvent event) {
         try {

            Stage stage = (Stage) addComm.getScene().getWindow();
            stage.close();
            Stage PrimaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/AjouterCommentaireGUI.fxml"));

           PrimaryStage.setTitle("Ajouter Commenatire");
           PrimaryStage.setScene(new Scene(root));
           PrimaryStage.show();


        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    private void ajouterPost(ActionEvent event) {
         try {

            Stage stage = (Stage) addPost.getScene().getWindow();
            stage.close();
            Stage PrimaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/AjouterPostGUI.fxml"));

           PrimaryStage.setTitle("Ajouter Post");
           PrimaryStage.setScene(new Scene(root));
           PrimaryStage.show();


        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
