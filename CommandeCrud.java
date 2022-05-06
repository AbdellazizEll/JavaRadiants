/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.clutchers.services;

import edu.clutchers.tools.MyConnection;
import edu.clutchers.entities.Commande;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zied
 */
public class CommandeCrud implements Iservice<Commande>{
    
     Connection cnx;
     public CommandeCrud(){
         cnx = MyConnection.getInstance().getCnx();
    }
     
     @Override
      public void add(Commande c){
        try {  
        String requete="INSERT INTO Commandes  (produit, totales, date, adresse, mail)"+"VALUES ( ?, ?, ?, ?, ?)";
          
            PreparedStatement pst= cnx.prepareStatement(requete);
            
            pst.setString(1,c.getProduit());
            pst.setFloat(2, c.getTotale());
             pst.setDate(3,c.getDate());
             pst.setString(4,c.getAdresse());
             pst.setString(5,c.getMail());
            pst.executeUpdate();
            System.out.println("Votre Commande a été enregistré avec succés!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
      
      public List <Commande> afficherPub(){
        List <Commande> myList = new ArrayList<>();
        try {
            
            String requete1 ="SELECT * FROM Commandes";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete1);
            while (rs.next()){
                Commande c = new Commande();
                c.setId(rs.getInt(1));
                c.setProduit(rs.getString("produit"));
                c.setTotale(rs.getFloat("totale"));
                c.setDate(rs.getDate("date"));
                c.setAdresse(rs.getString("adresse"));
                c.setMail(rs.getString("mail"));
                myList.add(c);
                
            }
          
           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
         return myList;
    }
      
       
     @Override
    public void delete(int id) {
        try {
            String req = "DELETE FROM Commandes WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Commande supprimée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    
     @Override
    public void update(int id,Commande c) {
        try {
            String req = "UPDATE Commandes SET produit = '" + c.getProduit() + "', totales = '" + c.getTotale() + "',`date` = '" + c.getDate() +"', adresse = '" + c.getAdresse() + "', mail = '" + c.getMail() +"' WHERE Commandes.`id` = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Commande modifiée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

   
     @Override
 public List <Commande> getAll() {
  List<Commande> list = new ArrayList<>();
try{
String reg = "Select * from commandes";
Statement st = cnx.createStatement();
ResultSet rs= st.executeQuery (reg) ;
while(rs.next ()){
Commande c= new Commande();
c.setId(rs.getInt (1) ) ;
c.setProduit(rs.getString ("produit") ) ;
c.setTotale(rs. getInt ( "totales") ) ;
c.setDate(rs.getDate ("date") ) ;
c.setAdresse(rs.getString ("adresse") ) ;
c.setMail(rs.getString ("mail") ) ;
list.add (c) ;

}}catch (SQLException ex)
{
System.out.println(ex.getMessage());

    }
return list;
    }

    
}
