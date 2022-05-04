package edu.pidev.gui;

import javafx.scene.image.Image;
import edu.pidev.entities.Actualite;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
import edu.pidev.services.ServiceActualite;
import java.io.File;
import java.io.IOException;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author MSI I7
 */

public class GestionActualiteController implements Initializable {
    @FXML
    private Button btnAjouter;
     @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupprimer;
    @FXML
    private TableView<Actualite> TableV;
    @FXML
    private TableColumn<Actualite, Integer> tcId;
    @FXML
    private TableColumn<Actualite, String> tcTitre;
    @FXML
    private TableColumn<Actualite, Date> tcContent;
    @FXML
    private TableColumn<Actualite, String> tcImage;

    

    ServiceActualite acc = new ServiceActualite();
         ObservableList list = FXCollections.observableArrayList();
          FilteredList<Actualite> filter = new FilteredList<>(list, e -> true);
    SortedList<Actualite> sort = new SortedList<>(filter);
   
    @FXML
    private TextField tfTitre;
    @FXML
    private TextField tfImage;
    @FXML
    private TextField tfContent;
    @FXML
    private Button btnRefresh;
    @FXML
    private Button btnRetour;
    @FXML
    private Label lblIdTournoi;
    @FXML
    private Label lblHeure;
    @FXML
    private Label lblScore;
    @FXML
    private TextField cherch;
         
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         loadDataActualite();
         btnSupprimer.setDisable(true);
     btnModifier.setDisable(true);
       TableV.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)
                -> {
                  
                    if(newValue!=null){
                          System.out.println(newValue);
                          
                          id=((Actualite) newValue).getId();
                      populateInputs((Actualite) newValue);
               }

        });
    }
    
    @FXML
    private void ajouterActualite(ActionEvent event) {
        
       if(validator()){
          
        String Titre = tfTitre.getText();
        String Image = tfImage.getText();
        String Content = tfContent.getText();
        
        
        
        Actualite a = new Actualite(Titre, Image, Content);
       

        acc.ajouter(a);
        
       
        
        
      
       }
    }
    @FXML
    private void modifierActualite(ActionEvent event) {
             if(validator()){
        String Titre = tfTitre.getText();
        String Image = tfImage.getText();
        String Content = tfContent.getText();
        
        
        
        Actualite a = new Actualite(Titre, Image, Content);
       

        acc.modifier(id,a);

         
         
         
             }
        
    }
    
    public void loadDataActualite(){
    //        ObservableListrMatch> list=  loadActualite();   
          list.clear();
          list.addAll(acc.getAll());
  
         tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
         tcTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
           tcImage.setCellValueFactory(new PropertyValueFactory<>("image") );
         tcContent.setCellValueFactory(new PropertyValueFactory<>("content"));
        
        
      
      
        
         TableV.setItems(list);
 
    }  
    
    @FXML
      private void refreshTable(javafx.scene.input.MouseEvent event){
        
           list.clear();
           list.addAll(acc.getAll());
        
          TableV.setItems(list);
         
    }

    public void  populateInputs(Actualite Actualite){
       
         tfTitre.setText(Actualite.getTitre());
         tfImage.setText(Actualite.getImage());
         tfContent.setText(Actualite.getContent());
         
        btnModifier.setDisable(false);
        btnSupprimer.setDisable(false);
    
   }
int id;
    @FXML
    private void supprimerActualite(ActionEvent event) {
        
        acc.supprimer(id);
        
        
    }
    

   
        
         
    
    public boolean validator(){
        String msg="";
       
        if(tfTitre.getText().length()==0){
            msg+=" Champ Titre vide, ";
           
        }
          
              if(tfImage.getText().length()==0){
            msg+=" Champ image vide, \n";
           
        }
                   if(tfContent.getText().length()==0){
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
    private void recherche() {
        cherch.setOnKeyReleased(e -> {
            cherch.textProperty().addListener((observable, oldValue, newValue) -> {
                filter.setPredicate(Actualite -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (Actualite.getTitre().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } 
                    
                    else if(Actualite.getImage().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    }
                     else if(String.valueOf(Actualite.getContent()).toLowerCase().contains(lowerCaseFilter)){
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
    private void retour(){
        try {

            Stage stage = (Stage) btnRetour.getScene().getWindow();
            stage.close();
            Stage PrimaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));

           PrimaryStage.setTitle("Acceuil");
           PrimaryStage.setScene(new Scene(root));
           PrimaryStage.show();


        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
