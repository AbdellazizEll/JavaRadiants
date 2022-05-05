/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.test;

import pidev.entities.Equipe;
import pidev.entities.Match;
import pidev.entities.Tournoi;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.services.EquipeCrud;
import pidev.services.MatchCrud;
import pidev.services.TournoiCrud;
import pidev.utils.DataSource;




/**
 *
 * @author MSI I7
 */
public class MainClass {

    
    public static void main(String[] args) {
       
        String str = "2021-08-03";
        java.sql.Date d = java.sql.Date.valueOf(str);
        
        Equipe e1 = new Equipe("e1", d , "France", "e1.png", "www.aa.com","zz", "description", "palmares");
        EquipeCrud ec= new EquipeCrud();
        
       //Tournoi t1 = new Tournoi("t1","valorant", "2022-04-08", "2022-04-12", "x0000");
       TournoiCrud tc= new TournoiCrud();
       
       ///Match m1 = new Match(1,"14:00:00","2022-04-05","3-12");
       MatchCrud mc = new MatchCrud();
       
      // ec.ajouterEquipe(e1);
       
      // QRCodeGenerator qr = new QRCodeGenerator();
        //try {
         //   qr.QRCode();
        //} catch (IOException ex) {
         //   Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
       // }
    }
    
    
}
