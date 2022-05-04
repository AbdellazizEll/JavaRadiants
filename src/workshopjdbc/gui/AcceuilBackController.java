/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *


 */

 
public class AcceuilBackController implements Initializable {

  
    @FXML
    private AnchorPane navbarbg;
    @FXML
    private ImageView livreuricon1;
    @FXML
    private ImageView debouicon1;
    @FXML
    private ImageView employeeicon1;
    @FXML
    private ImageView employeeicon;
    @FXML
    private ImageView debouicon;
    @FXML
    private ImageView exitIcon;
    @FXML
    private ImageView livreuricon;
    @FXML
    private ImageView fouricon1;
    @FXML
    private ImageView fourricon;
    @FXML
    private ImageView paniericon1;
    @FXML
    private ImageView paniericon;
    @FXML
    private ImageView produiticon1;
    @FXML
    private ImageView produiticon;
    @FXML
    private AnchorPane home;
  
    @FXML
    private Label e1;
    @FXML
    private Label d1;
    @FXML
    private Label p1;
    @FXML
    private Label l1;
    @FXML
    private Label f1;
    @FXML
    private Polygon e2;
    @FXML
    private Polygon d2;
    @FXML
    private Polygon c2;
    @FXML
    private Polygon p2;
    @FXML
    private Polygon l2;
    @FXML
    private Polygon f2;
    @FXML
    private Label c145;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        produiticon1.setVisible(false);
        paniericon1.setVisible(false);
        fouricon1.setVisible(false);
        debouicon1.setVisible(false);
        livreuricon1.setVisible(false);
        employeeicon1.setVisible(false);

        p1.setVisible(false);
        c145.setVisible(false);
        f1.setVisible(false);
        d1.setVisible(false);
        l1.setVisible(false);
        e1.setVisible(false);

        p2.setVisible(false);
        c2.setVisible(false);
        f2.setVisible(false);
        d2.setVisible(false);
        l2.setVisible(false);
        e2.setVisible(false);

        home.setBackground(Background.EMPTY);
    }

    @FXML
    private void unlight(MouseEvent event) {
        if (event.getTarget() == employeeicon) {
            employeeicon.setOpacity(1);
            employeeicon1.setVisible(false);

            
        } else if (event.getTarget() == livreuricon) {

            livreuricon.setOpacity(1);
            livreuricon1.setVisible(false);
            
        } else if (event.getTarget() == paniericon) {
            paniericon.setOpacity(1);
            paniericon1.setVisible(false);


        } else if (event.getTarget() == fourricon) {
            fourricon.setOpacity(1);
            fouricon1.setVisible(false);


        } else if (event.getTarget() == debouicon) {
            debouicon.setOpacity(1);
            debouicon1.setVisible(false);


        } else if (event.getTarget() == produiticon) {
            produiticon.setOpacity(1);
            produiticon1.setVisible(false);



        }
        
                p1.setVisible(false);
        c145.setVisible(false);
        f1.setVisible(false);
        d1.setVisible(false);
        l1.setVisible(false);
        e1.setVisible(false);

        p2.setVisible(false);
        c2.setVisible(false);
        f2.setVisible(false);
        d2.setVisible(false);
        l2.setVisible(false);
        e2.setVisible(false);
    }

    @FXML
    private void light(MouseEvent event) {
        if (event.getTarget() == employeeicon) {
            employeeicon.setOpacity(0);
            employeeicon1.setVisible(true);
            
            p1.setVisible(false);
            c145.setVisible(false);
            f1.setVisible(false);
            d1.setVisible(false);
            l1.setVisible(false);
            e1.setVisible(true);

            p2.setVisible(false);
            c2.setVisible(false);
            f2.setVisible(false);
            d2.setVisible(false);
            l2.setVisible(false);
            e2.setVisible(true);


        } else if (event.getTarget() == livreuricon) {

            livreuricon.setOpacity(0);
            livreuricon1.setVisible(true);
            
            p1.setVisible(false);
            c145.setVisible(false);
            f1.setVisible(false);
            d1.setVisible(false);
            l1.setVisible(true);
            e1.setVisible(false);

            p2.setVisible(false);
            c2.setVisible(false);
            f2.setVisible(false);
            d2.setVisible(false);
            l2.setVisible(true);
            e2.setVisible(false);

        } else if (event.getTarget() == paniericon) {
            paniericon.setOpacity(0);
            paniericon1.setVisible(true);
            
                        p1.setVisible(false);
            c145.setVisible(true);
            f1.setVisible(false);
            d1.setVisible(false);
            l1.setVisible(false);
            e1.setVisible(false);

            p2.setVisible(false);
            c2.setVisible(true);
            f2.setVisible(false);
            d2.setVisible(false);
            l2.setVisible(false);
            e2.setVisible(false);

        } else if (event.getTarget() == fourricon) {
            fourricon.setOpacity(0);
            fouricon1.setVisible(true);
            
            
            p1.setVisible(false);
            c145.setVisible(false);
            f1.setVisible(true);
            d1.setVisible(false);
            l1.setVisible(false);
            e1.setVisible(false);

            p2.setVisible(false);
            c2.setVisible(false);
            f2.setVisible(true);
            d2.setVisible(false);
            l2.setVisible(false);
            e2.setVisible(false);

        } else if (event.getTarget() == debouicon) {
            debouicon.setOpacity(0);
            debouicon1.setVisible(true);
            
                        p1.setVisible(false);
            c145.setVisible(false);
            f1.setVisible(false);
            d1.setVisible(true);
            l1.setVisible(false);
            e1.setVisible(false);

            p2.setVisible(false);
            c2.setVisible(false);
            f2.setVisible(false);
            d2.setVisible(true);
            l2.setVisible(false);
            e2.setVisible(false);

        } else if (event.getTarget() == produiticon) {
            produiticon.setOpacity(0);
            produiticon1.setVisible(true);

                        p1.setVisible(true);
            c145.setVisible(false);
            f1.setVisible(false);
            d1.setVisible(false);
            l1.setVisible(false);
            e1.setVisible(false);

            p2.setVisible(true);
            c2.setVisible(false);
            f2.setVisible(false);
            d2.setVisible(false);
            l2.setVisible(false);
            e2.setVisible(false);
        }

    }

    @FXML
    private void handleButtonAction(MouseEvent event) throws IOException {
        if (event.getTarget() == livreuricon) {
          

        } else if (event.getTarget() == employeeicon) {
            try{
         

            FXMLLoader loader = new FXMLLoader(getClass().getResource("BackUsers.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            
            stage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);
            stage.show();
            Stage ThisStage = (Stage) livreuricon.getScene().getWindow();
           // ThisStage.close();
            }catch(Exception ex){
                System.out.println("com.maxi.gui.AcceuilBackController.handleButtonAction()");
            }
        }else if (event.getTarget() == produiticon) {
            

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Modifierprofil.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            
            stage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);
            stage.show();
            Stage ThisStage = (Stage) livreuricon.getScene().getWindow();
            ThisStage.close();

        }else if (event.getTarget() == debouicon) {
            

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Stock.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            
            stage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);
            stage.show();
            Stage ThisStage = (Stage) livreuricon.getScene().getWindow();
            ThisStage.close();

        }else if (event.getTarget() == fourricon) {
            

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Fournisseur.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            
            stage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);
            stage.show();
            Stage ThisStage = (Stage) livreuricon.getScene().getWindow();
            ThisStage.close();

            
        
            
        } else if (event.getTarget() == exitIcon) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Authentifaction.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            ((Stage) home.getScene().getWindow()).close();

        }
            else if (event.getTarget() == paniericon) {
            

            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutBon.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            
            stage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);
            stage.show();
            Stage ThisStage = (Stage) livreuricon.getScene().getWindow();
            ThisStage.close();

            
        
            
        }
        
        

    }

}
