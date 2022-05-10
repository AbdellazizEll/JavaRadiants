/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Match;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.MatchCrud;

/**
 * FXML Controller class
 *
 * @author MSI I7
 */
public class GestionMatchController implements Initializable {

    @FXML
    private Label lblIdTournoi;
    @FXML
    private Label lblHeure;
    @FXML
    private Label lblDate;
    @FXML
    private Label lblScore;
    @FXML
    private TextField tfIdTournoi;
    @FXML
    private TextField tfHeure;
    @FXML
    private DatePicker dpDate;
    @FXML
    private TextField tfScore;
    @FXML
    private TableView<Match> TableV;
    @FXML
    private TableColumn<Match, Integer> tcId;
    @FXML
    private TableColumn<Match, Integer> tcIdTournoi;
    @FXML
    private TableColumn<Match, String> tcHeure;
    @FXML
    private TableColumn<Match, Date> tcDate;
    @FXML
    private TableColumn<Match, String> tcScore;

    /**
     * Initializes the controller class.
     */
    int id;
     MatchCrud mc = new MatchCrud();
     ObservableList list = FXCollections.observableArrayList();
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupprimer;
    private TextField tfSearch;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     loadDataMatch();
     
     btnSupprimer.setDisable(true);
     btnModifier.setDisable(true);
       TableV.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)
                -> {
                  
                    if(newValue!=null){
                          System.out.println(newValue);
                          
                          id=((Match) newValue).getId();
                      populateInputs((Match) newValue);
               }

        });
    }    
    
    @FXML
    private void ajouterMatch(ActionEvent event) {
        
       if(validator()){
         int nom_tournoi_id = Integer.parseInt(tfIdTournoi.getText());
         String Heure = tfHeure.getText();
           java.sql.Date datedeb_match = java.sql.Date.valueOf(dpDate.getValue());
        
        String Score = tfScore.getText();
        
        
        
        Match m = new Match(nom_tournoi_id, Heure, datedeb_match, Score);
       

        mc.ajouterMatch(m);
        
      
      
       }
    }
    @FXML
    private void modifierMatch(ActionEvent event) {
             if(validator()){
         int nom_tournoi_id = Integer.parseInt(tfIdTournoi.getText());
         String Heure = tfHeure.getText();
           java.sql.Date datedeb_match = java.sql.Date.valueOf(dpDate.getValue());
        
        String Score = tfScore.getText();
        
        
        
        Match m = new Match(nom_tournoi_id, Heure, datedeb_match, Score);
       
        mc.modifierMatch(id, m);

        
         
         
             }
        
    }


   
    
 
     public void loadDataMatch(){
    //        ObservableListrMatch> list=  loarMatch();   
          list.clear();
          list.addAll(mc.getAll());
  
         tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
         tcIdTournoi.setCellValueFactory(new PropertyValueFactory<>("nom_tournoi_id"));
          tcHeure.setCellValueFactory(new PropertyValueFactory<>("heure"));
        
        
        tcDate.setCellValueFactory(new PropertyValueFactory<>("datedeb_match") );
        tcScore.setCellValueFactory(new PropertyValueFactory<>("score") );
        
         TableV.setItems(list);
 
    }  
    private void refreshTable(javafx.scene.input.MouseEvent event){
        
           list.clear();
           list.addAll(mc.getAll());
        
          TableV.setItems(list);
         
    }

    


    
   public void  populateInputs(Match Match){
       
          
         tfIdTournoi.setText(String.valueOf(Match.getIdNomTournoi()));
          
         tfHeure.setText(Match.getHeure());

        dpDate.setValue(Match.getDateDebMatch().toLocalDate());
 
         tfScore.setText(Match.getScore());
         
         
        
         
          
        btnModifier.setDisable(false);
        btnSupprimer.setDisable(false);
    
   
   }

   
    

   
         
        
         
    
    public boolean validator(){
        String msg="";
       
        if(!isNumeric(tfIdTournoi.getText())){
            msg+=" Champ Nombre must be numeric, ";
           
           
        }
              if(tfHeure.getText().length()==0){
            msg+=" Champ heure vide, \n";
           
        }
                   if(dpDate.getValue()==null){
            msg+=" Champ date vide, \n";
           
        }
                 if(tfScore.getText().length()==0){
            msg+=" Champ score vide, \n";
           
        }     
                 
                 
                 
           if(msg!="")  { 
          
          
          Alert a = new Alert(Alert.AlertType.ERROR,msg, ButtonType.OK);
            a.show();
          return false;
        }   
           return true ;
        
    
    }
    
    public  boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false;
    }
    try {
        int d = Integer.parseInt(strNum);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
}

}
