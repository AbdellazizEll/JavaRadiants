/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.gui;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import edu.pidev.entities.Jeu;
import javafx.scene.image.Image;
import edu.pidev.services.ServiceJeu;
import edu.pidev.utils.DataSource;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import static java.util.Locale.filter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.sort;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author sof
 */
public class GestionJeuxController implements Initializable {

      
    
    private TextField tfnom;
    @FXML
    private TextField tfDescription;
    @FXML
    private TextField tfImage;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupprimer;
    @FXML
    private TableView<Jeu> TableV;
    @FXML
    private TableColumn<Jeu,Integer> tcId;
    @FXML
    private TableColumn<Jeu, String> tcNom;
    @FXML
    private TableColumn<Jeu, String> tcImage;
    @FXML
    private TableColumn<Jeu, String> tcDescription;
    @FXML
    private Button btnRefresh;

    /**
     * Initializes the controller class.
     */
    ServiceJeu acc = new ServiceJeu();
         ObservableList list = FXCollections.observableArrayList();
          FilteredList<Jeu> filter = new FilteredList<>(list, e -> true);
    SortedList<Jeu> sort = new SortedList<>(filter);
    @FXML
    private TextField tfNom;
    @FXML
    private Button btnRetour;
    @FXML
    private TextField cherch;
    @FXML
    private RadioButton triNom;
     @Override
    public void initialize(URL location, ResourceBundle resources) {
         loadDataJeu();
         btnSupprimer.setDisable(true);
     btnModifier.setDisable(true);
       TableV.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)
                -> {
                  
                    if(newValue!=null){
                          System.out.println(newValue);
                          
                          id=((Jeu) newValue).getId();
                      populateInputs((Jeu) newValue);
               }

        });
    }
    
    @FXML
    private void ajouterJeu(ActionEvent event) {
        
       if(validator()){
          
        String nom = tfNom.getText();
        String image = tfImage.getText();
        String description = tfDescription.getText();
        
        
        
        Jeu a = new Jeu(nom,image,description);
       

        acc.ajouter(a);
        
       
        
        
      
       }
    }
    @FXML
    private void modifierJeu(ActionEvent event) {
             if(validator()){
        String nom = tfNom.getText();
        String Image = tfImage.getText();
        String Description = tfDescription.getText();
        
        
        
        Jeu a = new Jeu(nom, Image, Description);
       

        acc.modifier(id,a);

         
         
         
             }
        
    }
    
    public void loadDataJeu(){
    //        ObservableListrMatch> list=  loadJeu();   
          list.clear();
          list.addAll(acc.getAll());
  
         tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
         tcNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
           tcImage.setCellValueFactory(new PropertyValueFactory<>("image") );
         tcDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        
        
      
      
        
         TableV.setItems(list);
 
    }  
    
    @FXML
      private void refreshTable(javafx.scene.input.MouseEvent event){
        
           list.clear();
           list.addAll(acc.getAll());
        
          TableV.setItems(list);
         
    }

    public void  populateInputs(Jeu Jeu){
       
          tfNom.setText(Jeu.getNom());
         
          
         

         tfImage.setText(Jeu.getImage());
 
         tfDescription.setText(Jeu.getDescription());
         
         
        
        
         
          
        btnModifier.setDisable(false);
        btnSupprimer.setDisable(false);
    
   
   }
int id;
    @FXML
    private void supprimerJeu(ActionEvent event) {
        
        acc.supprimer(id);
        
        
    }
    

   
        
         
    
    public boolean validator(){
        String msg="";
       
        if(tfNom.getText().length()==0){
            msg+=" Champ nom vide, ";
           
        }
          
              if(tfImage.getText().length()==0){
            msg+=" Champ image vide, \n";
           
        }
                   if(tfDescription.getText().length()==0){
            msg+=" Champ contenu vide, \n";
           
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
    private void recherche() {
        cherch.setOnKeyReleased(e -> {
            cherch.textProperty().addListener((observable, oldValue, newValue) -> {
                filter.setPredicate(Jeu -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (Jeu.getNom().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } 
                    
                    else if(Jeu.getImage().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    }
                     else if(String.valueOf(Jeu.getDescription()).toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    }
                    else {
                        return false;
                    }
                });

            });
            sort.comparatorProperty().bind(TableV.comparatorProperty());
            TableV.setItems(sort);
        });
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

    @FXML
    private void trinom(ActionEvent event) {
       
        ServiceJeu evt = new ServiceJeu();
        Jeu t=new Jeu();
      List<Jeu> a = evt.TRInom();;
        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
         tcImage.setCellValueFactory(new PropertyValueFactory<>("image"));
         tcDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

         ObservableList<Jeu> data=FXCollections.observableArrayList(a);
         TableV.getItems().setAll(a);            
         System.out.println(a);
         
    }

    @FXML
    private void CreatePDF(ActionEvent event) throws SQLException, IOException, DocumentException {

        try {
            
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("pdf.pdf"));
            doc.open();
            doc.add(new Paragraph(" "));
            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 28, Font.UNDERLINE, BaseColor.BLACK);
            Paragraph p = new Paragraph("----------Jeux-------- ", font);
            p.setAlignment(Element.ALIGN_CENTER);
            doc.add(p);
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));

            PdfPTable tabpdf = new PdfPTable(3);
            tabpdf.setWidthPercentage(100);

            PdfPCell cell;
            cell = new PdfPCell(new Phrase("Nom", FontFactory.getFont("Times New Roman")));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            tabpdf.addCell(cell);

            cell = new PdfPCell(new Phrase("Image", FontFactory.getFont("Times New Roman")));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            tabpdf.addCell(cell);

            cell = new PdfPCell(new Phrase("Description", FontFactory.getFont("Times New Roman")));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            tabpdf.addCell(cell);


           Connection cnx;
            cnx= DataSource.getInstance().getCnx();
            String req = "SELECT * FROM jeu";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cell = new PdfPCell(new Phrase(rs.getString("nom"), FontFactory.getFont("Times New Roman", 11)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.WHITE);
                tabpdf.addCell(cell);

                cell = new PdfPCell(new Phrase(rs.getString("image"), FontFactory.getFont("Times New Roman", 11)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.WHITE);
                tabpdf.addCell(cell);

                cell = new PdfPCell(new Phrase(rs.getString("description"), FontFactory.getFont("Times New Roman", 11)));
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
