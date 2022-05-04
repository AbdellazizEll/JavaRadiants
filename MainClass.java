/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.clutchers.tests;

import edu.clutchers.entities.Commande;
import edu.clutchers.entities.Inscription;
import edu.clutchers.entities.Post;
import edu.clutchers.services.CommandeCrud;
import edu.clutchers.services.InscriptionCrud;
import edu.clutchers.tools.MyConnection;
import edu.clutchers.services.PostCrud;
import java.sql.SQLException;

/**
 *
 * @author aziza
 */
public class MainClass {
    public static void main (String [] args) throws SQLException{
        //MyConnection mc= MyConnection.getInstance();
        //MyConnection mc2= MyConnection.getInstance();
        //System.out.println(mc.hashCode()+ "-"+mc2.hashCode());
        //String str="2022/02/02";
        //java.sql.Date d=java.sql.Date.valueOf(str);
        PostCrud c= new PostCrud();
        //Post cmd= new Post(1,"idk", "pppp", "idkk",d);
        //c.add(cmd);
        
       // System.out.println(i.afficherInscription());
    }
    
    
}
