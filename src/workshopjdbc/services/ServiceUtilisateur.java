/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.services;

import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import workshopjdbc.entities.Utilisateur;

/**
 *
 * @author Lenovo
 */
public class ServiceUtilisateur {
    ServiceUtilisateurImpl<Object> serviceUtilisateurImpl;
    
    
      public int existeMail(Utilisateur u) throws SQLException  {
      
      int size= serviceUtilisateurImpl.existeMail(u);
      
      return size;
      }
      
public void ajouter(Utilisateur utilisateur) throws SQLException{
    serviceUtilisateurImpl.ajouter(utilisateur);
}    

public ObservableList<Utilisateur> afficher(){
            ObservableList<Utilisateur> users = FXCollections.observableArrayList();

    serviceUtilisateurImpl.afficher();
    
    return users;
    
}
}
