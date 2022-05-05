/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Clutchers.services;

import edu.Clutchers.entities.Categories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.Clutchers.utils.MyConnection;
import java.util.List;

/**
 *
 * @author sinda
 */
public class CategoriesCrud {
    
     Connection cnx2;
     
    public CategoriesCrud()
    {cnx2 = MyConnection.getInstance().getCnx();}
    
    public void ajouterCategories(Categories C){
        try {
            String requete = "INSERT INTO categories (nom_c)"+ "VALUES (?)";
            PreparedStatement pst = cnx2.prepareStatement(requete);
            pst.setString(1, C.getNom_c());
            
            
            pst.executeUpdate();
            System.out.println("La categorie a ete ajoute avec succes");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public List<Categories> afficherCategories2(){
        List<Categories> myList = new ArrayList<>();
        try {
            
            String requete2 = "SELECT * FROM categories order by nom_c ";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete2);
            while(rs.next()){
                Categories c = new Categories();
                c.setId(rs.getInt(1));
                c.setNom_c(rs.getString("nom_c"));
                myList.add(c);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
    
    public List<Categories> afficherCategories(){
        List<Categories> myList = new ArrayList<>();
        try {
            
            String requete2 = "SELECT * FROM categories order by id ";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete2);
            while(rs.next()){
                Categories c = new Categories();
                c.setId(rs.getInt(1));
                c.setNom_c(rs.getString("nom_c"));
                myList.add(c);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
    
    public void modifier(Categories c) {
        try {
            String req= "update categories set nom_c= ? where id=?";
            PreparedStatement cc = cnx2.prepareStatement(req);
            cc.setString(1, c.getNom_c());
            cc.setInt(2, c.getId());
            cc.executeUpdate();
            System.out.println("\n Reponse mondifier contenu cat.");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void supprimer(int id) {
        try {
            
            String req2 = "delete from produit where cat_id = ?";
            PreparedStatement ps2 = cnx2.prepareStatement(req2);
            ps2.setInt(1, id);
            ps2.executeUpdate();
            
            String req = "delete from categories where id = ?";
            PreparedStatement ps = cnx2.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public void modifier2(int id , String nom) {
        try {
            String req= "update categories set nom_c=? where id=?";
            PreparedStatement cc = cnx2.prepareStatement(req);
            cc.setString(1, nom);
            cc.setInt(2, id);
            cc.executeUpdate();
            System.out.println("\n Reponse mondifier contenu categories.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
     public ArrayList<String> combox_cat() {
        ArrayList<String> resultat = new ArrayList<>();

        try {
            Statement st = cnx2.createStatement();
            ResultSet res = st.executeQuery("select * from  categories  ");
            while (res.next()) {
               
                String k=res.getString("nom_c");
              
                resultat.add(k);
            }
            resultat.forEach((t) -> {
                System.out.println(t);
            });

        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        return resultat;

    }
    
     
      public int appel_id_cat(String n) {
        ArrayList<Categories> resultat = new ArrayList<>();
        int m=0;
        try {
            Statement st = cnx2.createStatement();
            
            ResultSet res = st.executeQuery("SELECT id FROM categories where nom_c='"+n+"'");
            while (res.next()) {
                m= res.getInt(1);
               System.out.println("id =" + m);
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(CategoriesCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }
      
      
       public String appel_nom_cat(int n) {
        ArrayList<Categories> resultat = new ArrayList<>();
        String m="";
        try {
            Statement st = cnx2.createStatement();
            
            ResultSet res = st.executeQuery("SELECT nom_c FROM categories where id='"+n+"'");
            while (res.next()) {
                m= res.getString("nom_c");
               System.out.println("nom_c =" + m);
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(CategoriesCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }
      
      
      public ArrayList<Categories> afficheCategoID(String nom) {
        ArrayList<Categories> resultat = new ArrayList<>();

        try {
            Statement st = cnx2.createStatement();
            ResultSet res = st.executeQuery("SELECT id FROM categories WHERE nom_c where nom_c='"+nom+"");
            while (res.next()) {
                Categories r = new Categories();
                r.setId(res.getInt(1));
                resultat.add(r);
            }
            resultat.forEach((t) -> {
                System.out.println(t);
            });

        } catch (SQLException ex) {
            Logger.getLogger(CategoriesCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultat;

    }
      
      public List<Categories> rechercheproduit(String n){
          
          
          List<Categories> myList = new ArrayList<>();
        try {
            
            String requete3 = "select c.* ,c.nom_c from categories c where nom_c like '%"+n+"%'  ";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while(rs.next()){
                Categories c = new Categories();
                c.setId(rs.getInt(1));
                c.setNom_c(rs.getString("nom_c"));
                myList.add(c);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
        
   }
    
}
