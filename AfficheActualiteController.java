/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.gui;

import edu.pidev.entities.Actualite;
import edu.pidev.services.ServiceActualite;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


/**
 * FXML Controller class
 *
 * @author sof
 */
public class AfficheActualiteController implements Initializable {
    
            ServiceActualite<Actualite> actDao = new ServiceActualite();


    @FXML
 
    private Text titre;
    @FXML
    private TableView<ListaActualite> TableTypeAct;
    @FXML
    private TableColumn<ListaActualite, Integer> idAct;
    @FXML
    private TableColumn<ListaActualite, String> Titre;
    @FXML
    private TableColumn<ListaActualite, String> Content;
    @FXML
    private TableColumn<ListaActualite, String> Image;
    @FXML
    private TableColumn<ListaActualite, Hyperlink> modifier;
    @FXML
    private TableColumn<ListaActualite, Hyperlink> supprimer;
    
            ObservableList<ListaActualite> lista=FXCollections.observableArrayList();

    @FXML
    private TextField searchTextfield;
    
    @FXML
    private AnchorPane home;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                 home.setStyle("-fx-background-color:transparent");
        List<Actualite> listAct=actDao.getAll(); 
        for (Actualite t: listAct)
        {
            
            ListaActualite listaO=new ListaActualite(t.getId(), t.getTitre(),t.getContent(),t.getImage(), new Hyperlink("modifier"), new Hyperlink("supprimer"));
        lista.add(listaO);
        }
        
        idAct.setCellValueFactory(new PropertyValueFactory<ListaActualite,Integer>("id"));
        Titre.setCellValueFactory(new PropertyValueFactory<ListaActualite,String>("Titre"));
             Image.setCellValueFactory(new PropertyValueFactory<ListaActualite,String>("Image"));
        Content.setCellValueFactory(new PropertyValueFactory<ListaActualite,String>("Content"));
   
        
        modifier.setCellValueFactory(new PropertyValueFactory<ListaActualite,Hyperlink>("modifier"));
        
        supprimer.setCellValueFactory(new PropertyValueFactory<ListaActualite,Hyperlink>("supprimer"));
        try{
        TableTypeAct.setItems(lista);}
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }    
 

    @FXML
    private void handeSearchAction(KeyEvent event) {
        
    }

    @FXML
    private void handleCloseAction(MouseEvent event) {
    }
      public class ListaActualite{
        private int idAct;
        private String Titre;
        private String Content;
        private String Image;
        
        
        private Hyperlink modifier;
        private Hyperlink supprimer;

        public ListaActualite(int id, String Titre, String Content ,String Image, Hyperlink modifier, Hyperlink supprimer) {
            this.idAct = id;
            this.Titre = Titre;
            this.Content = Content;
            this.Image = Image;
            this.modifier = modifier;
            this.supprimer = supprimer;
           
            this.modifier.setOnAction(new EventHandler<ActionEvent>() {
           
            @Override
            public void handle(ActionEvent event)  {
               
            }
        });
       
        this.supprimer.setOnAction(new EventHandler<ActionEvent>() {
           
            @Override
            public void handle(ActionEvent event)  {
               
                   Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Voulez vous vraiment supprimer cette ligne?", ButtonType.YES, ButtonType.NO);
alert.showAndWait();

if (alert.getResult() == ButtonType.YES) {
            /*       Vehicule tp= vdao.afficherById(idAct);
                   vdao.supprimer(tp);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherVehicule.fxml"));
            Parent root = loader.load();
        TableEmail.getScene().setRoot(root);*/
}
            }    
        });
   
           
        }

        public int getIdAct() {
            return idAct;
        }

        public void setIdAct(int idAct) {
            this.idAct = idAct;
        }

        public String getTitre() {
            return Titre;
        }

        public void setTitre(String Titre) {
            this.Titre = Titre;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String Content) {
            this.Content = Content;
        }

        public String getImage() {
            return Image;
        }

        public void setImage(String Image) {
            this.Image = Image;
        }

        public Hyperlink getModifier() {
            return modifier;
        }

        public void setModifier(Hyperlink modifier) {
            this.modifier = modifier;
        }

        public Hyperlink getSupprimer() {
            return supprimer;
        }

        public void setSupprimer(Hyperlink supprimer) {
            this.supprimer = supprimer;
        }

      
      }
}
