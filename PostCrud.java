/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.clutchers.services;

import edu.clutchers.tools.MyConnection;
import edu.clutchers.entities.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author aziza
 */
public class PostCrud implements Iservice<Post> {
    
    Connection cnx3;
    
    public PostCrud(){
         cnx3 = MyConnection.getInstance().getCnx();
    }
    
    @Override
     public void add(Post p) throws SQLException {
        try {  
        String requete="INSERT INTO Post  (user_id ,  titre, content, image, created_at)"+"VALUES (?,?,?,?,?)";
          
            PreparedStatement pst= cnx3.prepareStatement(requete);
            
            pst.setInt(1,p.getUser_id());
            pst.setString(2,p.getTitre());
            pst.setString(3,p.getContent());
            pst.setString(4,p.getImage());
            pst.setDate(5,p.getCreated_at());
            pst.executeUpdate();
            System.out.println("Votre Post a été publié avec succés!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    @Override
     public List <Post> findAll(){
        List <Post> myList = new ArrayList<>();
        try {
            
            String requete1 ="SELECT * FROM Post";
            Statement st = cnx3.createStatement();
            ResultSet rs = st.executeQuery(requete1);
            while (rs.next()){
                Post p = new Post();
                p.setId(rs.getInt(1));
                p.setUser_id(rs.getInt("userId"));
                p.setTitre(rs.getString("titre"));
                p.setContent(rs.getString("content"));
                p.setImage(rs.getString("image"));
                p.setCreated_at(rs.getDate("created_at"));
                myList.add(p);
                
            }
          
           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
         return myList;
    }
    
     
     
    @Override
    public void delete(int id) throws SQLException  {
          try {
            String req = "DELETE FROM Post WHERE id = " + id;
            Statement st = cnx3.createStatement();
            st.executeUpdate(req);
            System.out.println("Post supprimée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
    
    @Override
    public void update(int id, Post p) throws SQLException {
         try {
            String req = "UPDATE Post SET titre = '" + p.getTitre() + "', content = '" + p.getContent() + "',image = '" + p.getImage()  +"' WHERE Post.id = " + id;
            Statement st = cnx3.createStatement();
            st.executeUpdate(req);
            System.out.println("Commande modifiée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Post> getAll() {
    List<Post> list = new ArrayList<>();
try{
String reg = "Select * from post";
Statement st = cnx3.createStatement();
ResultSet rs= st.executeQuery (reg) ;
while(rs.next ()){
Post p= new Post();
p.setId(rs.getInt (1) ) ;
p.setUser_id(rs.getInt ("user_id")) ;
p.setTitre(rs.getString ("titre") ) ;
p.setContent(rs. getString ( "content") ) ;
p.setImage(rs.getString ("image") ) ;
p.setCreated_at(rs.getDate ("created_at") ) ;
list.add (p) ;

} }catch (SQLException ex)
{
System.out.println(ex.getMessage());
  }
return list;
}

    
     public  List<Post> trier(){
      List<Post> list1= new ArrayList<>();
         List<Post> list2= getAll();
         
         list1= list2.stream().sorted((o1,o2)->o1.getCreated_at().compareTo(o2.getCreated_at())).collect(Collectors.toList());
return list1;               
     }
   
}
