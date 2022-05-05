/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pidev.utils.DataSource;

/**
 * FXML Controller class
 *
 * @author MSI I7
 */
public class GestionEquipeController implements Initializable {

    @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Label lblNomEquipe;
    @FXML
    private TextField tfNomEquipe;
    @FXML
    private Label lblDateCreation;
    @FXML
    private Label lblLeague;
    @FXML
    private Label lblPays;
    @FXML
    private TextField tfLeague;
    @FXML
    private TextField tfPays;
    @FXML
    private DatePicker dpDateCreation;
    @FXML
    private Label lblLogo;
    @FXML
    private Label lblSiteWeb;
    @FXML
    private Label lblDescription;
    @FXML
    private Label lblPalmares;
    @FXML
    private TextField tfLogo;
    @FXML
    private TextField tfSiteWeb;
    @FXML
    private TextArea taDescription;
    @FXML
    private TextField tfPalmares;
    @FXML
    private Button btnAjouter;
    @FXML
    private Label lblRecherche;
    @FXML
    private TextField tfRecherche;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnRefresh;
    @FXML
    private Button btnRetour;
    @FXML
    private ListView<?> listV;
    Connection cnx = DataSource.getInstance().getCnx();
      
    /**
     * Initializes the controller class.
     */
    
    public void initialize(URL url, ResourceBundle rb) {
        listV.setOnMouseClicked(e ->{
                try{
                    String query="Select * from equipe where nom_equipe =?";
                PreparedStatement pst = cnx.prepareStatement(query);
           pst.setString(1, (String)listV.getSelectionModel().getSelectedItem());
               ResultSet   rs = pst.executeQuery();
               
               while(rs.next()){
                   tfNomEquipe.setText(rs.getString("nom_equipe"));
              java.sql.Date date_creation = java.sql.Date.valueOf(dpDateCreation.getValue());
                   tfLogo.setText(rs.getString("nom_equipe"));
                   tfLeague.setText(rs.getString("nom_equipe"));
                   tfPays.setText(rs.getString("nom_equipe"));
                   taDescription.setText(rs.getString("nom_equipe"));
                   tfSiteWeb.setText(rs.getString("nom_equipe"));
                   tfPalmares.setText(rs.getString("nom_equipe"));
               }
               pst.close();
               rs.close();
               
               
                } catch(SQLException ex) {
                    System.out.println(ex);
                    
                }
                
                
        }
        );
    }    

    @FXML
    private void retour(ActionEvent event) {
    }
    
}
