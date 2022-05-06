/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.clutchers.services;

import edu.clutchers.tools.MyConnection;
import edu.clutchers.entities.Publicite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Zied
 */
public class PubliciteCrud implements Iservice<Publicite>{
    
    Connection cnx;
     public PubliciteCrud(){
         cnx = MyConnection.getInstance().getCnx();
    }
     
      public void add(Publicite p){
        try {  
        String requete="INSERT INTO Publicite  (titre ,  teaser, img)"+"VALUES (?,?,?)";
          
            PreparedStatement pst= cnx.prepareStatement(requete);
            
            pst.setString(1,p.getTitre());
            pst.setString(2,p.getTeaser());
             pst.setString(3,p.getImage());
            pst.executeUpdate();
            System.out.println("Votre Pub a été publié avec succés!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
      
      public List <Publicite> afficherPub(){
        List <Publicite> myList = new ArrayList<>();
        try {
            
            String requete1 ="SELECT * FROM Publicite";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete1);
            while (rs.next()){
                Publicite p = new Publicite();
                p.setId(rs.getInt(1));
                p.setTitre(rs.getString("titre"));
                p.setTeaser(rs.getString("teaser"));
                p.setImage(rs.getString("image"));
                myList.add(p);
                
            }
          
           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
         return myList;
    }
      
       
    @Override
    public void delete(int id) {
        try {
            String req = "DELETE FROM Publicite WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Pub supprimé!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void update(int id,Publicite p) {
        try {
            String req = "UPDATE Publicite SET titre = '" + p.getTitre() + "', teaser = '" + p.getTeaser() + "',`img` = '" + p.getImage() + "' WHERE Publicite.`id` = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Pub modifié!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Publicite> getAll() {
        List<Publicite> list = new ArrayList<>();
try{
String reg = "Select * from publicite";
Statement st = cnx.createStatement();
ResultSet rs= st.executeQuery (reg) ;
while(rs.next ()){
Publicite p= new Publicite();
p.setId(rs.getInt (1) ) ;
p.setTitre(rs.getString ("titre") ) ;
p.setTeaser(rs. getString ( "teaser") ) ;
p.setImage(rs.getString ("img") ) ;
list.add (p) ;

}}catch (SQLException ex)
{
System.out.println(ex.getMessage());

    }
return list;
    }
    public  List<Publicite> tripub(){
      List<Publicite> list1= new ArrayList<>();
         List<Publicite> list2= getAll();

         list1= list2.stream().sorted((o1,o2)->o1.getTitre().compareTo(o2.getTitre())).collect(Collectors.toList());
return list1;
     }
}
