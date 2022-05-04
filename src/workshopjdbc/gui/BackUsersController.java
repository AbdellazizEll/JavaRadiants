/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import workshopjdbc.entities.Utilisateur;
import workshopjdbc.services.ServiceUtilisateurImpl;
import workshopjdbc.utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class BackUsersController implements Initializable {
    Connection cnx = MyConnection.getInstance().getCnx();
    @FXML
    private ListView<Useer> listviewUsers;
    
    Utilisateur u = new Utilisateur();
    ServiceUtilisateurImpl us = new ServiceUtilisateurImpl();
    @FXML
    private AnchorPane home;
    @FXML
    private AnchorPane employeebg;
    @FXML
    private Text titre;
    @FXML
    private TextField searchTextfield;

       ServiceUtilisateurImpl su  = new ServiceUtilisateurImpl();
    @FXML
    private Button BackAcc;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

         ObservableList<Useer> data = FXCollections.observableArrayList();
    
       List<Utilisateur> users=su.afficher();
         for(Utilisateur u: users){
            Useer us=new Useer(u.getFirstName(), u.getLastName(), u);
            data.add(us);
         }

        listviewUsers.setItems(data);
        
        listviewUsers.setCellFactory(new Callback<ListView<Useer>, ListCell<Useer>>() {
            @Override
            public ListCell<Useer> call(ListView<Useer> listView) {
                return new CustomListCell();
            }
        });
        
        
    }

    @FXML
    private void handeSearchAction(KeyEvent event) {
    }

    @FXML
    private void handleCloseAction(MouseEvent event) {
    }

    @FXML
    private void BackAcceuil(ActionEvent event) throws IOException {
          
         Stage stage = (Stage) BackAcc.getScene().getWindow();
         
         stage.close();
        
        
    }
    
    
    public class Useer{
        Utilisateur user;
        String firstName;
        String lastName;
         
        private Hyperlink modifier;
        private Hyperlink supprimer;

        public Useer(String firstName, String lastName,Utilisateur u) {
            this.firstName = firstName;
            this.lastName = lastName;
            user=u;
            modifier=new Hyperlink("modifier");
            supprimer=new Hyperlink("supprimer");
            
            
             
        }

        public Utilisateur getUser() {
            return user;
        }

        public void setUser(Utilisateur user) {
            this.user = user;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
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
    
    
    private class CustomListCell extends ListCell<Useer> {
        private HBox content;
        private Text firsname;
        private Text lastname;
        private Hyperlink modifier;
        private Hyperlink supprimer;
        private Utilisateur user;
        

        public CustomListCell() {
            super();
            firsname = new Text();
            lastname = new Text();
            modifier=new Hyperlink("modifier");
                        supprimer=new Hyperlink("supprimer");
            VBox vBox = new VBox(firsname, lastname);
            VBox vbox2=new VBox(modifier,supprimer);
            content = new HBox(new Label("[Graphic]"), vBox,vbox2);
            content.setSpacing(10);
            
            
            
             this. supprimer.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event)  {
               
                
                
                 try{
                   Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Voulez vous vraiment supprimer cette ligne?", ButtonType.YES, ButtonType.NO);
alert.showAndWait();

if (alert.getResult() == ButtonType.YES) {
                  
                   su.supprimer(user);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("BackUsers.fxml"));
            Parent root = loader.load();
        listviewUsers.getScene().setRoot(root);
}
            }catch(IOException io){}
            }
                
                
                
        
            
                    });
            
            
             this. modifier.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event)  {
                
                   ModifierUserController.user=user;
                  FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierUser.fxml"));
            Parent root;
                try {
                    root = loader.load();
                
        listviewUsers.getScene().setRoot(root);
           } catch (IOException ex) {
                    Logger.getLogger(BackUsersController.class.getName()).log(Level.SEVERE, null, ex);
                }     
        }
            
                    });
         
        }

        @Override
        protected void updateItem(Useer item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null && !empty) { // <== test for null item and empty parameter
                firsname.setText(item.getFirstName());
                lastname.setText( item.getLastName());
                modifier=item.getModifier();
                supprimer=item.getSupprimer();
                setGraphic(content);
                user=item.getUser();
            } else {
                setGraphic(null);
            }
        }
    }

  
}
