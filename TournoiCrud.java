/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Equipe;
import entities.Tournoi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.DataSource;

/**
 *
 * @author MSI I7
 */
public class TournoiCrud implements ServiceTournoi<Tournoi> {
    
    Connection cnx = DataSource.getInstance().getCnx();
    
    public void ajouterTournoi (Tournoi t) {
        

        try {
        String req = "INSERT INTO `tournoi` (`nom_tournoi`,`jeux`,`date_debut`,`date_fin`,`couleur`) VALUES (?,?,?,?,?)";
                
           PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getNomTournoi());
            ps.setString(2, t.getJeux());
            ps.setDate(3, t.getDateDebut());
            ps.setDate(4, t.getDateFin());
            ps.setString(5, t.getCouleur());
            ps.executeUpdate();
            System.out.println("Tournoi Ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void supprimerTournoi(int id) {
        try {
            String req = "DELETE FROM `tournoi` WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Tournoi deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public void modifierTournoi(int id,Tournoi t) {
        try {
            String req = "UPDATE `equipe` SET `nom_tournoi` = '" + t.getNomTournoi()+ "', `jeux` = '" + t.getJeux()+ "',`date_debut` = '" + t.getDateDebut()+ "',`date_fin` = '" + t.getDateFin()+ "', `couleur` = '" + t.getCouleur()+  "'  WHERE `tournoi`.`id` = " + t.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Tournoi updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<Tournoi> getAll() {
        List<Tournoi> list = new ArrayList<>();
        try {
            String req = "Select * from tournoi";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Tournoi t = new Tournoi();
                t.setId(rs.getInt(1));
                t.setNomTournoi(rs.getString("nom_tournoi"));
                t.setJeux(rs.getString("jeux"));
                t.setDateDebut(rs.getDate("date_debut"));
                t.setDateFin(rs.getDate("date_fin"));
                t.setCouleur(rs.getString("couleur"));
                list.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    

    
  

   
   

    
}
