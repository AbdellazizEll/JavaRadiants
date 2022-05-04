/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.test;

import java.sql.SQLException;
import workshopjdbc.entities.Utilisateur;
import workshopjdbc.services.ServiceUtilisateurImpl;
import workshopjdbc.utils.MyConnection;

/**
 *
 * @author Lenovo
 */
public class MainClass {

    
    public static void main(String[] args) throws SQLException {
        Utilisateur u2 = new Utilisateur("abdellaziz","elloumi","abd@esprit.tn","azerty","['ROLE_USER']", "2.jpg");
    ServiceUtilisateurImpl nu= new ServiceUtilisateurImpl();
     nu.ajouter(u2);
    }

}
