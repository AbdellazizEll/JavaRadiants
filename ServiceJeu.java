/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.services;

import edu.pidev.entities.Jeu;
import edu.pidev.entities.Jeu;
import edu.pidev.utils.DataSource;
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
 * @author sof
 */
public class ServiceJeu implements IService<Jeu> {
     Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Jeu a) {
    try {
            String req = "INSERT INTO `jeu` (`nom`, `image`,`description`) VALUES (?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, a.getNom());
             ps.setString(2, a.getImage());
            ps.setString(3, a.getDescription());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
       
       try {
            String req = "DELETE FROM `jeu` WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("jeu deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modifier(int id,Jeu a) {
        try {
            String req = "UPDATE `jeu` SET `nom` = '" + a.getNom() + "', `image` = '" + a.getImage() + "' WHERE `jeu`.`id` = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Jeu updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Jeu> getAll() {
         List<Jeu> list = new ArrayList<>();
        try {
            String req = "Select * from Jeu";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
            Jeu a = new Jeu();
            a.setId(rs.getInt(1));
            a.setNom(rs.getString("nom"));
            a.setImage(rs.getString("image"));
            a.setDescription(rs.getString("description"));
                list.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    public  List<Jeu> TRInom(){
      List<Jeu> list1= new ArrayList<>();
         List<Jeu> list2= getAll();
         
         list1= list2.stream().sorted((o1,o2)->o1.getNom().compareTo(o2.getNom())).collect(Collectors.toList());
return list1;               
     }
    }
    

