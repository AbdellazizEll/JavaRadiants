/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import pidev.entities.Match;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pidev.utils.DataSource;

/**
 *
 * @author MSI I7
 */
public class MatchCrud implements IService<Match> {
    
    Connection cnx = DataSource.getInstance().getCnx();
    
    public void ajouter (Match m) {
        

        try {
        String req = "INSERT INTO `matchh` (`nom_tournoi_id`,`heure`,`datedeb_match`,`score`) VALUES (?,?,?,?)";
                
           PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, m.getIdNomTournoi());
            ps.setString(2, m.getHeure());
            ps.setDate(3, m.getDateDebMatch());
            ps.setString(4, m.getScore());
            ps.executeUpdate();
            System.out.println("Match Ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `matchh` WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Match deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void modifier(int id,Match m) {
        try {
            String req = "UPDATE `matchh` SET `nom_tournoi_id` = '" + m.getIdNomTournoi()+ "', `heure` = '" + m.getHeure()+ "',`datedeb_match` = '" + m.getDateDebMatch()+ "',`score` = '" + m.getScore()+  "'  WHERE `matchh`.`id` = "+ id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Equipe updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public List<Match> getAll() {
        List<Match> list = new ArrayList<>();
        try {
            String req = "Select * from matchh";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Match m = new Match();
                m.setId(rs.getInt("id"));
                m.setIdNomTournoi(rs.getInt("nom_tournoi_id"));
                m.setHeure(rs.getString("heure"));
                m.setDateDebMatch(rs.getDate("datedeb_match"));
                m.setScore(rs.getString("score"));
                list.add(m);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    

    
}
