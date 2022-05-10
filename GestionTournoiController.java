/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Tournoi;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.TournoiCrud;

/**
 * FXML Controller class
 *
 * @author MSI I7
 */
public class GestionTournoiController implements Initializable {

    @FXML
    private Label lblNomTournoi;
    @FXML
    private Label lblJeux;
    @FXML
    private Label lblDateDebut;
    @FXML
    private Label lblDateFin;
    @FXML
    private Label lblCouleur;
    @FXML
    private TextField tfNomTournoi;
    @FXML
    private TextField tfJeux;
    @FXML
    private DatePicker dpDateDebut;
    @FXML
    private DatePicker dpDateFin;
    @FXML
    private ColorPicker cpCouleur;
    @FXML
    private TableView<Tournoi> TableV;
    @FXML
    private TableColumn<Tournoi, Integer> tcId;
    @FXML
    private TableColumn<Tournoi, String> tcNomTournoi;
    @FXML
    private TableColumn<Tournoi, String> tcJeux;
    @FXML
    private TableColumn<Tournoi, Date> tcDateDeb;
    @FXML
    private TableColumn<Tournoi, Date> tcDateFin;
    @FXML
    private TableColumn<Tournoi, String> tcCouleur;
    private TextField tfSearch;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupprimer;

    /**
     * Initializes the controller class.
     */
    int id;
     TournoiCrud tc = new TournoiCrud();
     ObservableList list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     loadDataTournoi();
     
     btnSupprimer.setDisable(true);
     btnModifier.setDisable(true);
       TableV.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)
                -> {
                  
                    if(newValue!=null){
                          System.out.println(newValue);
                          
                          id=((Tournoi) newValue).getId();
                      populateInputs((Tournoi) newValue);
               }

        });
    }    
    
    @FXML
    private void ajouterTournoi(ActionEvent event) {
        
       if(validator()){
         String nom_tournoi = tfNomTournoi.getText();
         String jeux = tfJeux.getText();
           java.sql.Date date_debut = java.sql.Date.valueOf(dpDateDebut.getValue());
        java.sql.Date date_fin = java.sql.Date.valueOf(dpDateFin.getValue());
        String couleur = String.valueOf(cpCouleur.getValue()).replace("0x", "#");
        
        
        
        Tournoi t = new Tournoi(nom_tournoi, jeux, date_debut, date_fin, couleur);
       

        tc.ajouterTournoi(t);
        
        
       }
    }
    @FXML
    private void modifierTournoi(ActionEvent event) {
            if(validator()){
         String nom_tournoi = tfNomTournoi.getText();
         String jeux = tfJeux.getText();
           java.sql.Date date_debut = java.sql.Date.valueOf(dpDateDebut.getValue());
        java.sql.Date date_fin = java.sql.Date.valueOf(dpDateFin.getValue());
        String couleur = String.valueOf(cpCouleur.getValue()).replace("0x", "#");
        
        
        
        Tournoi t = new Tournoi(nom_tournoi, jeux, date_debut, date_fin, couleur);
       
        tc.modifierTournoi(id, t);

         
         
         
             }
        
    }


   
 
     public void loadDataTournoi(){
    //        ObservableListrTournoi> list=  loarTournoi();   
          list.clear();
          list.addAll(tc.getAll());
  
         tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
         tcNomTournoi.setCellValueFactory(new PropertyValueFactory<>("nom_tournoi"));
         tcJeux.setCellValueFactory(new PropertyValueFactory<>("jeux"));
          tcDateDeb.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        
        
        tcDateFin.setCellValueFactory(new PropertyValueFactory<>("date_fin") );
        tcCouleur.setCellValueFactory(new PropertyValueFactory<>("couleur") );
        
         TableV.setItems(list);
 
    }  
    

    


    
    
   public void  populateInputs(Tournoi Tournoi){
       
          
         tfNomTournoi.setText(String.valueOf(Tournoi.getNomTournoi()));
          
         tfJeux.setText(Tournoi.getJeux());

        dpDateDebut.setValue(Tournoi.getDateDebut().toLocalDate());
          dpDateFin.setValue(Tournoi.getDateFin().toLocalDate());
         
         
         
        
         
          
        btnModifier.setDisable(false);
        btnSupprimer.setDisable(false);
    
   
   }

    @FXML
    private void supprimerTournoi(ActionEvent event) {
        
        tc.supprimerTournoi(id);
      
        
    }
    

   
         
       
         
    
    public boolean validator(){
        String msg="";
       
        if(tfNomTournoi.getText().length()==0){
            msg+=" Champ nom tournoi vide, ";
           
           
        }
              if(tfJeux.getText().length()==0){
            msg+=" Champ jeux vide, \n";
           
        }
                   if(dpDateDebut.getValue()==null){
            msg+=" Champ date debut vide, \n";
           
        }
                   if(dpDateFin.getValue()==null){
            msg+=" Champ date fin vide, \n";
           
        }
                 if(cpCouleur.getValue()==(null)){
            msg+=" Champ couleur vide, \n";
           
        }     
                 
                 
                 
           if(msg!="")  { 
          
          
          Alert a = new Alert(Alert.AlertType.ERROR,msg, ButtonType.OK);
            a.show();
          return false;
        }   
           return true ;
        
    
    }
    
    
}
