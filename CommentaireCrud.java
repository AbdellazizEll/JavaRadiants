/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.clutchers.services;

import edu.clutchers.tools.MyConnection;
import edu.clutchers.entities.Commentaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aziza
 */
public class CommentaireCrud implements Iservice<Commentaire> {
    
    Connection cnx;
     public CommentaireCrud(){
         cnx = MyConnection.getInstance().getCnx();
    }
     
    @Override
      public void add(Commentaire c){
        try {  
        String requete="INSERT INTO Commentaire  (user_id , post_id, content, image, created_at )"+"VALUES (?,?,?,?,?)";
          
            PreparedStatement pst= cnx.prepareStatement(requete);
            
            pst.setInt(1, c.getUser_id());
            pst.setInt(2, c.getPost_id());
            pst.setString(3,c.getContent());
            pst.setString(4,c.getImage());
            pst.setDate(5,c.getCreated_at());
            pst.executeUpdate();
            System.out.println("Votre Commentaire a été publié avec succés!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
      
      public List <Commentaire> findAll(){
        List <Commentaire> myList = new ArrayList<>();
        try {
            
            String requete1 ="SELECT * FROM Commentaire";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete1);
            while (rs.next()){
                Commentaire c = new Commentaire();
                c.setId(rs.getInt(1));
                c.setUser_id(rs.getInt("userId"));
                c.setPost_id(rs.getInt("post_id"));
                c.setContent(rs.getString("content"));
                c.setImage(rs.getString("image"));
                c.setCreated_at(rs.getDate("created_at"));
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
            String req = "DELETE FROM Commentaire WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Commentaire supprimée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
    @Override
    public void update( int id, Commentaire c) {
         
        try {
            String req = "UPDATE Commentaire SET content = '" + c.getContent() + "', image = '" + c.getImage() + "', created_at = '" + c.getCreated_at()  +"' WHERE Commentaire.id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Commentaire modifiée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    @Override
    public List<Commentaire> getAll() {
 
    List<Commentaire> list = new ArrayList<>();
try{
String reg = "Select * from Commentaire ";
Statement st = cnx.createStatement();
ResultSet rs= st.executeQuery (reg) ;
while(rs.next ()){
Commentaire c= new Commentaire();
c.setId(rs.getInt (1) ) ;
c.setUser_id(rs.getInt ("user_id") ) ;
c.setPost_id(rs.getInt ("post_id") ) ;
c.setContent(rs. getString ( "content") ) ;
c.setImage(rs.getString ("image") ) ;
c.setCreated_at(rs.getDate ("created_at") ) ;
list.add (c) ;

} }catch (SQLException ex)
{
System.out.println(ex.getMessage());
  }
return list;
}
    
    

}
