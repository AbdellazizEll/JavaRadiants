/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.clutchers.tests;

import edu.clutchers.entities.Commande;
import edu.clutchers.services.CommandeCrud;
import edu.clutchers.tools.MyConnection;

/**
 *
 * @author Zied
 */
public class MainClass {
    public static void main (String [] args){
        //MyConnection mc= MyConnection.getInstance();
        //MyConnection mc2= MyConnection.getInstance();
        //System.out.println(mc.hashCode()+ "-"+mc2.hashCode());
        String str = "2021-08-03";
        java.sql.Date d = java.sql.Date.valueOf(str);
        CommandeCrud c= new CommandeCrud();
        Commande cmd= new Commande("radiants",1,d,"gggggg","a@idk.fr");
       c.ajouterCom(cmd);
        
       // System.out.println(c.afficherCom());
    }
    
    
}
