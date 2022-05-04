/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.services;

import edu.pidev.entities.Actualite;
import edu.pidev.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author sof
 */
public class ServiceActualite<s> implements IService<Actualite> {
     Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Actualite a) {
    try {
            String req = "INSERT INTO `actualite` (`titre`, `image`,`content`) VALUES (?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, a.getTitre());
             ps.setString(2, a.getImage());
            ps.setString(3, a.getContent());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
       
       try {
            String req = "DELETE FROM `actualite` WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Personne deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modifier(int id,Actualite a) {
        try {
            String req = "UPDATE `actualite` SET `titre` = '" + a.getTitre() + "', `image` = '" + a.getImage() + "' WHERE `actualite`.`id` = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Personne updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
 

    @Override
    public List<Actualite> getAll() {
         List<Actualite> list = new ArrayList<>();
        try {
            String req = "Select * from actualite";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
            Actualite a = new Actualite();
            a.setId(rs.getInt(1));
            a.setTitre(rs.getString("titre"));
            a.setImage(rs.getString("image"));
            a.setContent(rs.getString("content"));
                list.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    }
    

