/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc;

import java.util.List;
import workshopjdbc.entities.Utilisateur;
import workshopjdbc.services.ServiceUtilisateurImpl;

/**
 *
 * @author Lenovo
 */
public class WorkshopJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Utilisateur u2 = new Utilisateur("abdellaziz2","elloumi","abd3@esprit.tn","azerty12","[\"ROLE_USER\"]", "3.jpg");
u2.setId(2325);
    ServiceUtilisateurImpl nu= new ServiceUtilisateurImpl();
   
    //ajout
   //  nu.ajouter(u2);  
    
    
    //afficher
   /*     List<Utilisateur> users= nu.afficher();
    
        for(Utilisateur user:users){
            System.out.println(user.toString());
        }
    
    */
   
   
   //update
//   nu.modifier(u2);
  
  
  //delete
  //nu.supprimer(u2);
   
  //login
  if(nu.verifPassword("abd3@esprit.tn", "azerty")!=null){
      System.out.println("Ok");
  }else{
       System.out.println("Ko");
  }
  
  
    }
    
}
