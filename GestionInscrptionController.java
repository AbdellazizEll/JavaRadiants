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
import edu.clutchers.entities.Inscription;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import edu.clutchers.services.InscriptionCrud;
import edu.clutchers.tools.MyConnection;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import javafx.geometry.Pos;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
/**
 * FXML Controller class
 *
 * @author aziza
 */
public class GestionInscrptionController implements Initializable {

    @FXML
    private Label lblTournoi;
    @FXML
    private Label lblNomComplet;
    @FXML
    private Label lblNomEquipe;
    @FXML
    private Label lblNbreJoueurs;
    @FXML
    private Label lblMail;
    @FXML
    private Label lblNom1;
    @FXML
    private Label lblNom2;
    @FXML
    private Label lblNom3;
    @FXML
    private Label lblNom4;
    @FXML
    private Label lblNom5;
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
    private TextField tfNom1;
    @FXML
    private TextField tfNom2;
    @FXML
    private TextField tfNom3;
    @FXML
    private TextField tfNom4;
    @FXML
    private TextField tfNom5;
    @FXML
    private Button btnAjout;
    @FXML
    private Button btnRetour;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupprimer;
    @FXML
    private TableView<?> tableV;
    @FXML
    private TableColumn<Inscription, Integer> tcId;
    @FXML
    private TableColumn<Inscription, Integer> tcTournoi;
    @FXML
    private TableColumn<Inscription, String> tcNomComplet;
    @FXML
    private TableColumn<Inscription, String> tcNomEquipe;
    @FXML
    private TableColumn<Inscription, Integer> tcNombreJoueurs;
    @FXML
    private TableColumn<Inscription, String> tcMail;
    @FXML
    private TableColumn<Inscription, String> tcNom1;
    @FXML
    private TableColumn<Inscription, String> tcNom2;
    @FXML
    private TableColumn<Inscription, String> tcNom3;
    @FXML
    private TableColumn<Inscription, String> tcNom4;
    @FXML
    private TableColumn<Inscription, String> tcNom5;
    
    @FXML
    private void refreshTable(javafx.scene.input.MouseEvent event){
        
           list.clear();
           list.addAll(ic.getAll());
        
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
     InscriptionCrud ic = new InscriptionCrud();
     ObservableList list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     loadDataInscription();
     
     btnSupprimer.setDisable(true);
     btnModifier.setDisable(true);
       tableV.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)
                -> {
                  
                    if(newValue!=null){
                          System.out.println(newValue);
                          
                          id=((Inscription) newValue).getId();
                      populateInputs((Inscription) newValue);
               }

        });
    }    
    
    @FXML
    private void ajouterInscription(ActionEvent event) {
        
       if(validator()){
            int tournoi = Integer.parseInt(tfTournoi.getText());
            int Nbre = Integer.parseInt(tfNbreJoueurs.getText());
             Inscription i = new Inscription (tournoi,tfNomComplet.getText(),tfNomEquipe.getText(), Nbre, tfNom1.getText(),tfNom2.getText(), tfNom3.getText(),tfNom4.getText(),tfNom5.getText(),tfMail.getText());
            InscriptionCrud ic = new InscriptionCrud( ){};
            ic.add(i);
               Notifications notificationBuilder = Notifications.create()
                    .title("Notification")
                    .text("Inscription ajouté avec succés!")
                    .hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER);
            notificationBuilder.show();
        refreshTable(null);
       }
    }
    @FXML
    private void modifierInscription(ActionEvent event) {
            if(validator()){
         int tournoi = Integer.parseInt(tfTournoi.getText());
            int Nbre = Integer.parseInt(tfNbreJoueurs.getText());
            Inscription i = new Inscription (tournoi,tfNomComplet.getText(),tfNomEquipe.getText(), Nbre, tfNom1.getText(),tfNom2.getText(), tfNom3.getText(),tfNom4.getText(),tfNom5.getText(),tfMail.getText());
            InscriptionCrud ic = new InscriptionCrud(){};
       
        ic.update(id, i);
       
           Notifications notificationBuilder = Notifications.create()
                    .title("Notification")
                    .text("Inscription modifié avec succés!")
                    .hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER);
            notificationBuilder.show();
         refreshTable(null);
         
         
             }
        
    }


   
 
     public void loadDataInscription(){
    
          list.clear();
          list.addAll(ic.getAll());
  
        
         tcTournoi.setCellValueFactory(new PropertyValueFactory<>("nom_tournoi_id"));
         tcNomComplet.setCellValueFactory(new PropertyValueFactory<>("nom_complet"));
         tcNomEquipe.setCellValueFactory(new PropertyValueFactory<>("nom_equipe"));
         tcNombreJoueurs.setCellValueFactory(new PropertyValueFactory<>("nombre_joueurs") );
         tcMail.setCellValueFactory(new PropertyValueFactory<>("email"));
         tcNom1.setCellValueFactory(new PropertyValueFactory<>("nom_joueur1"));
         tcNom2.setCellValueFactory(new PropertyValueFactory<>("nom_joueur2"));
         tcNom3.setCellValueFactory(new PropertyValueFactory<>("nom_joueur3"));
         tcNom4.setCellValueFactory(new PropertyValueFactory<>("nom_joueur4") );
         tcNom5.setCellValueFactory(new PropertyValueFactory<>("nom_joueur5"));
         
        
         tableV.setItems(list);
 
    }  
    

    


    
    
   public void  populateInputs(Inscription inscri){
       
          
         tfTournoi.setText(String.valueOf(inscri.getNom_tournoi_id()));
         tfNomComplet.setText(inscri.getNom_complet());
         tfNomEquipe.setText(inscri.getNom_equipe());
         tfNbreJoueurs.setText(String.valueOf(inscri.getNombre_joueurs()));
         tfMail.setText(inscri.getEmail()); 
         tfNom1.setText(inscri.getNom_joueur1()); 
         tfNom2.setText(inscri.getNom_joueur2()); 
         tfNom3.setText(inscri.getNom_joueur3()); 
         tfNom4.setText(inscri.getNom_joueur4()); 
         tfNom5.setText(inscri.getNom_joueur5()); 
         
         
         
        btnModifier.setDisable(false);
        btnSupprimer.setDisable(false);
    
   
   }

    @FXML
    private void supprimerInscription(ActionEvent event) {
        
        String c = "Voulez vous supprimer cette inscription? " ;
        
        
         Alert a = new Alert(Alert.AlertType.CONFIRMATION,c+tfNomEquipe.getText(), ButtonType.OK,ButtonType.CANCEL);
        a.showAndWait().ifPresent(response -> {
        if (response == ButtonType.OK) {
           ic.delete(id);
        }
        });
        Notifications notificationBuilder = Notifications.create()
                    .title("Notification")
                    .text("Inscription supprimé avec succés!")
                    .hideAfter(javafx.util.Duration.seconds(5))
                    .position(Pos.TOP_CENTER);
            notificationBuilder.show();
        refreshTable(null);
        
        
      
        
    }
    

   
         
       
         
    
    public boolean validator(){
        String msg="";
        
        if(tfTournoi.getText()==null){
            msg+=" Veuillez choisir le tournoi \n";
           
        }
       
        if(tfNomComplet.getText().length()==0){
            msg+=" Veuillez donner votre nom ";
           
           
        }
              if(tfNomEquipe.getText().length()==0){
            msg+=" Veuillez donner le nom de votre equipe \n";
           
        }
                   if(tfNbreJoueurs.getText().length()==0){
            msg+=" Veuillez donner le nombre de joueurs \n";
           
        }
                   
                     if(tfMail.getText().length()==0){
            msg+=" Veuillez saisir un propre mail";
           
        }
                       if(tfNom1.getText().length()==0){
            msg+=" Veuillez donner le no du premier jouaur \n";
           
        }
                        
                               
                   
                      
                 
                 
                 
           if(msg!="")  { 
          
          
          Alert a = new Alert(Alert.AlertType.ERROR,msg, ButtonType.OK);
            a.show();
          return false;
        }   
           return true ;
        
    
    } 
    
    
     @FXML
    private void CreatePDF(ActionEvent event) throws SQLException, IOException, DocumentException {

        try {
            
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("pdf.pdf"));
            doc.open();
            doc.add(new Paragraph(" "));
            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 28, Font.UNDERLINE, BaseColor.BLACK);
            Paragraph p = new Paragraph("----------Inscriptions-------- ", font);
            p.setAlignment(Element.ALIGN_CENTER);
            doc.add(p);
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));

            PdfPTable tabpdf = new PdfPTable(3);
            tabpdf.setWidthPercentage(100);

            PdfPCell cell;
            cell = new PdfPCell(new Phrase("nom_complet", FontFactory.getFont("Times New Roman")));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            tabpdf.addCell(cell);

            cell = new PdfPCell(new Phrase("nom_equipe", FontFactory.getFont("Times New Roman")));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            tabpdf.addCell(cell);

            cell = new PdfPCell(new Phrase("email", FontFactory.getFont("Times New Roman")));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            tabpdf.addCell(cell);


           Connection cnx;
            cnx= MyConnection.getInstance().getCnx();
            String req = "SELECT * FROM Inscription";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cell = new PdfPCell(new Phrase(rs.getString("nom_complet"), FontFactory.getFont("Times New Roman", 11)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.WHITE);
                tabpdf.addCell(cell);

                cell = new PdfPCell(new Phrase(rs.getString("nom_equipe"), FontFactory.getFont("Times New Roman", 11)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.WHITE);
                tabpdf.addCell(cell);

                cell = new PdfPCell(new Phrase(rs.getString("email"), FontFactory.getFont("Times New Roman", 11)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.WHITE);
                tabpdf.addCell(cell);

            }
            doc.add(tabpdf);
            JOptionPane.showMessageDialog(null, "Fichier PDF crée !");
            doc.close();
            Desktop.getDesktop().open(new File("pdf.pdf"));
        } catch (DocumentException e) {
            System.out.println("ERROR PDF");
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.out.println(e.getMessage());
        }

    }
    
}
