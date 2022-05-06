/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.clutchers.GUI;

import com.itextpdf.text.BaseColor;
import edu.clutchers.entities.Commande;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import edu.clutchers.services.CommandeCrud;
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
import edu.clutchers.tools.MyConnection;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import static java.util.Locale.filter;
import static javafx.collections.FXCollections.sort;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javax.activation.DataSource;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ziedh
 */
public class GestionCommandesController implements Initializable {

    @FXML
    private TextField tfProduit;
    @FXML
    private TextField tfTotale;
    @FXML
    private TextField tfAdresse;
    @FXML
    private TextField tfMail;
    @FXML
    private DatePicker tfDatee;
    @FXML
    private Button btnAjouterCom;
    @FXML
    private Button btnSupprimerCom;
    @FXML
    private Button btnModifierCom;
    @FXML
    private TableView<Commande> TableV;
    @FXML
    private TableColumn<?, ?> tcProduit;
    @FXML
    private TableColumn<?, ?> tcTotale;
    @FXML
    private TableColumn<?, ?> tcDate;
    @FXML
    private TableColumn<?, ?> tcAdresse;
    @FXML
    private TableColumn<?, ?> tcMail;
    @FXML
    private Button btnRefreshCom;
    @FXML
    private Button btnRetour;
    @FXML
    private Button btnPDF;
    @FXML
    private TextField cherch;
     @FXML
    private void refreshTable(javafx.scene.input.MouseEvent event){
        
           list.clear();
           list.addAll(cc.getAll());
        
          TableV.setItems(list);
         
    }

    /**
     * Initializes the controller class.
     */
    int id;
     CommandeCrud cc = new CommandeCrud();
     ObservableList list = FXCollections.observableArrayList();
     FilteredList<Commande> filter = new FilteredList<>(list, e -> true);
    SortedList<Commande> sort = new SortedList<>(filter);
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     loadDataCommande();
     
     btnSupprimerCom.setDisable(true);
     btnModifierCom.setDisable(true);
       TableV.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)
                -> {
                  
                    if(newValue!=null){
                          System.out.println(newValue);
                          
                          id=((Commande) newValue).getId();
                      populateInputs((Commande) newValue);
               }

        });
    }    
    
    @FXML
    private void ajouterCommade(ActionEvent event) {
        
       if(validator()){
          java.sql.Date date = java.sql.Date.valueOf(tfDatee.getValue());
            
            float Totales=Float.parseFloat(tfTotale.getText());
            Commande c = new Commande (tfProduit.getText(), Totales,date ,tfAdresse.getText() ,tfMail.getText() );
            CommandeCrud cc = new CommandeCrud(){};
            cc.add(c);
        
        
       }
       refreshTable(null);
    }
    @FXML
    private void modifierCommande(ActionEvent event) {
            if(validator()){
         java.sql.Date date = java.sql.Date.valueOf(tfDatee.getValue());
            
            float Totales=Float.parseFloat(tfTotale.getText());
            Commande c = new Commande (tfProduit.getText(), Totales,date ,tfAdresse.getText() ,tfMail.getText() );
            CommandeCrud cc = new CommandeCrud(){};
            cc.update(id,c);

         
         
         
             }
       refreshTable(null); 
    }


   
 
     public void loadDataCommande(){
    //        ObservableListrTournoi> list=  loarTournoi();   
          list.clear();
          list.addAll(cc.getAll());
  
         //tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
         tcProduit.setCellValueFactory(new PropertyValueFactory<>("produit"));
         tcTotale.setCellValueFactory(new PropertyValueFactory<>("totale"));
         tcDate.setCellValueFactory(new PropertyValueFactory<>("date"));
          tcAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        
        
        tcMail.setCellValueFactory(new PropertyValueFactory<>("mail") );
        
        
         TableV.setItems(list);
 
    }  
    

    


    
    
   public void  populateInputs(Commande Commande){
       
          
         tfProduit.setText(String.valueOf(Commande.getProduit()));
          String tot = Float.toString(Commande.getTotale());
         tfTotale.setText(tot);

        tfDatee.setValue(Commande.getDate().toLocalDate());
        tfAdresse.setText(String.valueOf(Commande.getAdresse()));
        tfMail.setText(String.valueOf(Commande.getMail()));
          
         
         
         
        
         
          
        btnModifierCom.setDisable(false);
        btnSupprimerCom.setDisable(false);
    
   
   }

    @FXML
    private void supprimerCommande(ActionEvent event) {
        
        cc.delete(id);
      
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
       
        if(tfProduit.getText().length()==0){
            msg+=" Champ tfProduit vide, ";
           
           
        }
              if(tfTotale.getText().length()==0){
            msg+=" Champ tfTotale vide, \n";
           
        }
                   if(tfDatee.getValue()==null){
            msg+=" Champ dpDatee vide, \n";
           
        }
                  if(tfAdresse.getText().length()==0){
            msg+=" Champ tfAdresse vide, ";
           
           
        }
                if(tfMail.getText().length()==0){
            msg+=" Champ tfMail vide, ";
           
           
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
            Paragraph p = new Paragraph("----------Commandes-------- ", font);
            p.setAlignment(Element.ALIGN_CENTER);
            doc.add(p);
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));

            PdfPTable tabpdf = new PdfPTable(4);
            tabpdf.setWidthPercentage(100);

            PdfPCell cell;
            cell = new PdfPCell(new Phrase("produit", FontFactory.getFont("Times New Roman")));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            tabpdf.addCell(cell);

            cell = new PdfPCell(new Phrase("totale", FontFactory.getFont("Times New Roman")));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            tabpdf.addCell(cell);

            cell = new PdfPCell(new Phrase("adresse", FontFactory.getFont("Times New Roman")));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            tabpdf.addCell(cell);

            cell = new PdfPCell(new Phrase("date", FontFactory.getFont("Times New Roman")));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            tabpdf.addCell(cell);
           Connection cnx;
            cnx= MyConnection.getInstance().getCnx();
            String req = "SELECT * FROM commandes";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cell = new PdfPCell(new Phrase(rs.getString("produit"), FontFactory.getFont("Times New Roman", 11)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.WHITE);
                tabpdf.addCell(cell);

                cell = new PdfPCell(new Phrase(rs.getString("totales"), FontFactory.getFont("Times New Roman", 11)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.WHITE);
                tabpdf.addCell(cell);

                cell = new PdfPCell(new Phrase(rs.getString("adresse"), FontFactory.getFont("Times New Roman", 11)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.WHITE);
                tabpdf.addCell(cell);
                
                cell = new PdfPCell(new Phrase(rs.getString("date"), FontFactory.getFont("Times New Roman", 11)));
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
     //recherche
  @FXML
    private void recherche() {
        cherch.setOnKeyReleased(e -> {
            cherch.textProperty().addListener((observable, oldValue, newValue) -> {
                filter.setPredicate(Commande -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (Commande.getProduit().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } 
                    else if(Commande.getMail().toLowerCase().contains(lowerCaseFilter)){
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
}
