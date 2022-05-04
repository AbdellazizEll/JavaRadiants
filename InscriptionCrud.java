/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.clutchers.services;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import com.sun.xml.internal.ws.api.message.Message;
import edu.clutchers.tools.MyConnection;
import edu.clutchers.entities.Inscription;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import sun.rmi.transport.Transport;



/**
 *
 * @author aziza
 */
public class InscriptionCrud implements Iservice<Inscription>  { 
    Connection cnx2;

    public InscriptionCrud() {
        cnx2 = MyConnection.getInstance().getCnx();
    }
    
    
    @Override
    public void add(Inscription i){
        try {  
        String requete="INSERT INTO Inscription  (nom_tournoi_id, nom_complet, nom_equipe, nombre_joueurs, nom_joueur1, nom_joueur2, nom_joueur3, nom_joueur4, nom_joueur5, email)"+"VALUES (?,?,?,?,?,?,?,?,?,?)";
          
            PreparedStatement pst= cnx2.prepareStatement(requete);
            pst.setInt(1,i.getNom_tournoi_id());
            pst.setString(2,i.getNom_complet());
            pst.setString(3,i.getNom_equipe());
            pst.setInt(4,i.getNombre_joueurs());
            pst.setString(5,i.getNom_joueur1());
            pst.setString(6,i.getNom_joueur2());
            pst.setString(7,i.getNom_joueur3());
            pst.setString(8,i.getNom_joueur4());
            pst.setString(9,i.getNom_joueur5());
             pst.setString(10,i.getEmail());
            pst.executeUpdate();
            System.out.println("Votre Inscription a été envoyé avec succés!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
    
    @Override
    public List <Inscription> findAll(){
        List <Inscription> myList = new ArrayList<>();
        try {
            
            String requete1 ="SELECT * FROM Inscription";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete1);
            while (rs.next()){
                Inscription i = new Inscription();
                i.setId(rs.getInt(1));
                i.setNombre_joueurs(rs.getInt("nombre_joueurs"));
                i.setNom_complet(rs.getString("nom_complet"));
                i.setNom_tournoi_id(rs.getInt("nom_tournoi_id"));
                i.setNom_equipe(rs.getString("nom_equipe"));
                i.setNom_joueur1(rs.getString("nom_joueur1"));
                i.setNom_joueur2(rs.getString("nom_joueur2"));
                i.setNom_joueur3(rs.getString("nom_joueur3"));
                i.setNom_joueur4(rs.getString("nom_joueur4"));
                i.setNom_joueur5(rs.getString("nom_joueur5"));
                i.setEmail(rs.getString("email"));
                myList.add(i);
                
            }
          
           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
         return myList;
    }
    
    
    
    
    @Override
    public void delete(int id) {
          try {
            String req = "DELETE FROM Inscription WHERE id = " + id;
            Statement st = cnx2.createStatement();
            st.executeUpdate(req);
            System.out.println("Inscrii supprimée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    @Override
    public void update(int id, Inscription i) {
         try {
            String req = "UPDATE Inscription SET nom_complet = '" + i.getNom_complet() + "', nom_equipe = '" + i.getNom_equipe() + "',nombre_joueurs = '" + i.getNombre_joueurs() +"', nom_joueur1 = '" + i.getNom_joueur1() +"', nom_joueur2 = '" + i.getNom_joueur2() +"', nom_joueur3 = '" + i.getNom_joueur3() +"', nom_joueur4 = '" + i.getNom_joueur4() + "', nom_joueur5 = '" + i.getNom_joueur5() +"', email = '" + i.getEmail() +"' WHERE Inscription.id = " + id;
            Statement st = cnx2.createStatement();
            st.executeUpdate(req);
            System.out.println("Commande modifiée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Inscription> getAll() {
        
    List<Inscription> list = new ArrayList<>();
try{
String reg = "Select * from Inscription";
Statement st = cnx2.createStatement();
ResultSet rs= st.executeQuery (reg) ;
while(rs.next ()){
Inscription i= new Inscription();
 i.setId(rs.getInt (1) ) ;
 i.setNombre_joueurs(rs.getInt("nombre_joueurs"));
 i.setNom_complet(rs.getString("nom_complet"));
 i.setNom_tournoi_id(rs.getInt("nom_tournoi_id"));
 i.setNom_equipe(rs.getString("nom_equipe"));
 i.setNom_joueur1(rs.getString("nom_joueur1"));
 i.setNom_joueur2(rs.getString("nom_joueur2"));
 i.setNom_joueur3(rs.getString("nom_joueur3"));
 i.setNom_joueur4(rs.getString("nom_joueur4"));
 i.setNom_joueur5(rs.getString("nom_joueur5"));
 i.setEmail(rs.getString ( "email") ) ;
list.add (i) ;

} }catch (SQLException ex)
{
System.out.println(ex.getMessage());
  }
return list;
}
    
     public boolean sendEmail(Inscription i ) throws SQLException, AddressException{
    
        
        String password = "Testtest123";
        String from,to,host,sub = null,content;
        from = "Radiants@gmail.com";
        to =i.getEmail();
        host="localhost";
        

        //setup mail server
        content = "Bonjour, /n  "+ i.getNom_complet()+" "+i.getNom_equipe()+". Votre inscription a été envoyé avec succés s' il y a un manque d'informations veuillez nous envoyer un mail.";
                    Properties props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator(){
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(from, password);
            }
        });

      try{ MimeMessage m =new MimeMessage(session);
        m.setFrom(new InternetAddress(from));
        m.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));
        m.setSubject(sub);
        m.setText(content);
        javax.mail.Transport.send(m);
        return true;
        } catch (javax.mail.MessagingException ex) {
           ex.printStackTrace();
        }
      
       return false;

        
      

    }
    
   
    }

