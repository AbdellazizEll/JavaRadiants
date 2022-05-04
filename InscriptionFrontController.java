/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.clutchers.GUI;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import edu.clutchers.entities.Inscription;
import edu.clutchers.services.InscriptionCrud;
import edu.clutchers.tools.MyConnection;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.mail.PasswordAuthentication;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.Session;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author aziza
 */
public class InscriptionFrontController implements Initializable {

    @FXML
    private Label lblTournoi;
    @FXML
    private Label lblNomComplet;
    @FXML
    private Label lblNomEquipe;
    @FXML
    private Label lblNbreJoueurs;
    @FXML
    private Label lblmail;
    @FXML
    private Label lblNom5;
    @FXML
    private Label lblNom1;
    @FXML
    private Label lblNom2;
    @FXML
    private Label lblNom3;
    @FXML
    private Label lblNom4;
    @FXML
    private TextField tfTournoi;
    @FXML
    private TextField tfNomComplet;
    @FXML
    private TextField tfNomEquipe;
    @FXML
    private TextField tfNbreJoueurs;
    @FXML
    private TextField tfMail;
    @FXML
    private TextField tfNom5;
    @FXML
    private TextField tfNom1;
    @FXML
    private TextField tfNom2;
    @FXML
    private TextField tfNom3;
    @FXML
    private TextField tfNom4;
    @FXML
    private Button btnAjout;

    
    private void retour(){
        try {

            Stage stage = (Stage) btnRetour.getScene().getWindow();
            stage.close();
            Stage PrimaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("MenuFront.fxml"));

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
     InscriptionCrud ic = new InscriptionCrud();
     ObservableList list = FXCollections.observableArrayList();
    @FXML
    private Button btnPrint;
    @FXML
    private Button btnRetour;
        @Override
    public void initialize(URL location, ResourceBundle resources) {
     
    }
    
    @FXML
    private void ajouterInscription(ActionEvent event) throws SQLException, AddressException
            {
        
       if(validator()){
            int tournoi = Integer.parseInt(tfTournoi.getText());
            int Nbre = Integer.parseInt(tfNbreJoueurs.getText());
             Inscription i = new Inscription (tournoi,tfNomComplet.getText(),tfNomEquipe.getText(), Nbre, tfNom1.getText(),tfNom2.getText(), tfNom3.getText(),tfNom4.getText(),tfNom5.getText(),tfMail.getText());
            ic.sendEmail(i);
            ic.add(i);
             Notifications notificationBuilder = Notifications.create()
                    .title("Notification")
                    .text("Inscription envoyé avec succés!")
                    .hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER);
            notificationBuilder.show();
           
        
        
       }
    }  
    
     public boolean validator(){
        String msg="";
        
        if(tfTournoi.getText()==null){
            msg+=" Veuillez choisir le tournoi";
           
        }
       
        if(tfNomComplet.getText().length()==0){
            msg+=" Veuillez donner votre nom";
           
           
        }
              if(tfNomEquipe.getText().length()==0){
            msg+=" Veuillez donner le nom de votre equipe";
           
        }
                   if(tfNbreJoueurs.getText().length()==0){
            msg+=" Veuillez donner le nombre de joueurs ";
           
        }
                   
                     if(tfMail.getText().length()==0 ){
            msg+=" Veuillez saisir un prpopre mail";
           
        }
                       if(tfNom1.getText().length()==0){
            msg+=" Veuillez donner le nom du premier joueur";
           
        }
                        
                               
                   
                      
                 
                 
                 
           if(msg!="")  { 
          
          
          Alert a = new Alert(Alert.AlertType.ERROR,msg, ButtonType.OK);
            a.show();
          return false;
        }   
           msg="Votre Inscription a été envoyé avec succés!";
            Alert a = new Alert(Alert.AlertType.CONFIRMATION,msg, ButtonType.OK);
            a.show();
           return true ;
        
    
    } 
     
     
    
 
    
    
    
}
