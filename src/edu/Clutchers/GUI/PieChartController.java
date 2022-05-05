/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Clutchers.GUI;

import edu.Clutchers.entities.Reclamation;
import edu.Clutchers.services.ReclamationCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javax.naming.Binding;

/**
 * FXML Controller class
 *
 * @author sinda
 */
public class PieChartController implements Initializable {

    @FXML
    private PieChart piechart;
    @FXML
    private PieChart piechart2;
    @FXML
    private Button btnRetour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       /* ObservableList<PieChart.Data> pieChartData = 
                FXCollections.observableArrayList(
                        new PieChart.Data("A", 10),
                        new PieChart.Data("A", 25),
                        new PieChart.Data("A", 65)
                
                );
        piechart.setData(pieChartData);
        piechart.setTitle("aaaaa");
        */
        
        
        
        ReclamationCRUD es = new ReclamationCRUD();
        List<Reclamation> events = es.afficherRec();
       // stats =es.getAllevents()
        ObservableList<PieChart.Data> pieChartData
                = FXCollections.observableArrayList();
        int true1=0;
        int false1=0;
        for (int i = 0; i < events.size(); i++) {
                if (events.get(i).getStatut())
                {true1=true1+1;}
                else
                 {false1=false1+1;}
               
                    
                 
        }
       
      
        pieChartData.add(new PieChart.Data("true", true1));
            pieChartData.add(new PieChart.Data("false", false1));
            
            piechart.getData().addAll(pieChartData);
   // piechart.setData(pieChartData);
    piechart.setTitle("Le taux de traitement des reclamations");
   
   
   ReclamationCRUD es2 = new ReclamationCRUD();
        List<Reclamation> events2 = es2.afficherRec();
   
   
        ObservableList<PieChart.Data> pieChartData2= FXCollections.observableArrayList();
        int SUJ1=0;
        int SUJ2=0;
        int SUJ3=0;
        int SUJ4=0;
        int SUJ5=0;
        int SUJ6=0;
        int SUJ7=0;
        int SUJ8=0;


            
        for (int j = 0; j < events2.size(); j++) {
                if (events2.get(j).getSujet().equals("Le catalogue produit en tête de liste")) {SUJ1=SUJ1+1;}
                if (events2.get(j).getSujet().equals("L’opacité des prix")) {SUJ2=SUJ2+1;}
                if (events2.get(j).getSujet().equals("Le fonctionnement du site")) {SUJ3=SUJ3+1;}
                if (events2.get(j).getSujet().equals("La disponiblite du stock")) {SUJ4=SUJ4+1;}
                if (events2.get(j).getSujet().equals("Les retours et rembourssements")) {SUJ5=SUJ5+1;}
                if (events2.get(j).getSujet().equals("la livraison")) {SUJ6=SUJ6+1;}
                if (events2.get(j).getSujet().equals("Le service apres vente")) {SUJ7=SUJ7+1;}
                if (events2.get(j).getSujet().equals("Autres")) {SUJ8=SUJ8+1;}
                System.out.println(SUJ1);
               
                    
                 
        }
       
      
        pieChartData2.add(new PieChart.Data("Le catalogue produit en tête de liste", SUJ1));
        pieChartData2.add(new PieChart.Data("L’opacité des prix", SUJ2));
        pieChartData2.add(new PieChart.Data("Le fonctionnement du site", SUJ3));
        pieChartData2.add(new PieChart.Data("La disponiblite du stock", SUJ4));
        pieChartData2.add(new PieChart.Data("Les retours et rembourssements", SUJ5));
        pieChartData2.add(new PieChart.Data("la livraison", SUJ6));
        pieChartData2.add(new PieChart.Data("Le service apres vente", SUJ7));
        pieChartData2.add(new PieChart.Data("Autres", SUJ8));
        
            

            piechart2.getData().addAll(pieChartData2);
             piechart2.setTitle("le nombre de reclamations par sujet ");
   // piechart.setData(pieChartData);
    }    

    @FXML
    private void Retour(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("GestionProduit.fxml"));
         Parent root = loader.load();
         GestionProduitController ap = loader.getController();
         btnRetour.getScene().setRoot(root);
    }
    
}
