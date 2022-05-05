/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import pidev.entities.Equipe;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.utils.DataSource;

/**
 *
 * @author MSI I7
 */
public class EquipeCrud implements IService<Equipe> {
    
    Connection cnx = DataSource.getInstance().getCnx();
    
    
    public void ajouter(Equipe e) {
        

        try {
        String req = "INSERT INTO `equipe` (`nom_equipe`,`date_creation`,`logo`,`league`,`pays`,`description`,`site_web`,`palmares`) VALUES (?,?,?,?,?,?,?,?)";
                
           PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, e.getNomEquipe());
            ps.setDate(2, e.getDateCreation());
            ps.setString(5, e.getPays());
            ps.setString(3, e.getLogo());
            ps.setString(4, e.getLeague());
            ps.setString(7, e.getSiteweb());
            ps.setString(6, e.getDescription());
            ps.setString(8, e.getPalmares());
            ps.executeUpdate();
            System.out.println("Equipe Ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `equipe` WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Equipe deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
    public void modifier(int id,Equipe e) {
        try {
            
          
            String req = "UPDATE `equipe` SET `nom_equipe` = '" + e.getNomEquipe()+ "', `date_creation` = '" + e.getDateCreation()+ "',`logo` = '" + e.getLogo()+ "',`league` = '" + e.getLeague()+  "',`description` = '" + e.getDescription()+  "',`site_web` = '" + e.getSiteweb()+  "',`palmares` = '" + e.getPalmares()+  "'  WHERE `equipe`.`id` = " + id;
           System.out.println(req);
            Statement st = cnx.createStatement();
            
            st.executeUpdate(req);
            System.out.println("Equipe updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
    @Override
    public List<Equipe> getAll() {
        List<Equipe> list = new ArrayList<>();
        try {
            String req = "Select * from equipe";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Equipe e = new Equipe();
                e.setId(rs.getInt(1));
                e.setNomEquipe(rs.getString("nom_equipe"));
                e.setDateCreation(rs.getDate("date_creation"));
                e.setLogo(rs.getString("logo"));
                e.setLeague(rs.getString("league"));
                e.setPays(rs.getString("pays"));
                e.setDescription(rs.getString("description"));
                e.setSiteweb(rs.getString("site_web"));
                e.setPalmares(rs.getString("palmares"));
                list.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
    public List<Equipe> nom() {
        List<Equipe> listNom = new ArrayList<>();
        try {
            String req = "Select nom_equipe from equipe";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Equipe e = new Equipe();
                
                e.setNomEquipe(rs.getString("nom_equipe"));
               
                listNom.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return listNom;
    }

  

   

   

    
   

    

    
    
}
