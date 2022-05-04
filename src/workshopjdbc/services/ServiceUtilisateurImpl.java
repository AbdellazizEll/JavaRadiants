/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.services;

import static java.awt.Event.INSERT;
import workshopjdbc.entities.Utilisateur;
import workshopjdbc.utils.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.InputStream;
import java.sql.*;
import static java.sql.JDBCType.NULL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import workshopjdbc.utils.BCrypt;

/**
 *
 * @author Lenovo
 */


public class ServiceUtilisateurImpl<s> implements IService<Utilisateur> {

    PreparedStatement store;
    
    Statement ste;
    Utilisateur user = new Utilisateur();
    Connection cnx = MyConnection.getInstance().getCnx();
    boolean existe = false;
    
     public int existe(Utilisateur u) throws SQLException {
        Statement s = cnx.createStatement();
        ResultSet rs = s.executeQuery("SELECT COUNT(*) from user WHERE email = '" + u.getEmail() + "'");
        int size = 0;
        rs.next();
        size = rs.getInt(1);
        return size;
    }

    public int existeMail(Utilisateur u)  {
       try{
        Statement s = cnx.createStatement();
        ResultSet rs = s.executeQuery("SELECT COUNT(*) from user WHERE email ='" + u.getEmail() + "'");
        int size = 0;

        rs.next();

        size = rs.getInt(1);

        return size;}
       catch(Exception ex){
           System.out.println("error");
       }
       return 0;
    }

    
       public int existeMailById(Utilisateur u)  {
       try{
           String req="SELECT COUNT(*) from user WHERE id <> "+ u.getId()+" and email ='" + u.getEmail() + "'";
        Statement s = cnx.createStatement();
        ResultSet rs = s.executeQuery(req);
        int size = 0;

        rs.next();

        size = rs.getInt(1);

        return size;}
       catch(Exception ex){
           System.out.println("error");
       }
       return 0;
    }

    
    
    @Override
    public void ajouter(Utilisateur utilisateur)  {
       
        String query = "INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `password`,  `roles`, `picture`) VALUES (?, ?, ?, ?, ?, ?, ?);";
        int x;
            x = existeMail(utilisateur);
            
        
        if (x == 0) {
            try {
                String password= BCrypt.hashpw(utilisateur.getPassword(), BCrypt.gensalt());
                PreparedStatement ste = cnx.prepareStatement(query);
                ste.setInt(1, utilisateur.getId());
                ste.setString(2, utilisateur.getFirstName());
                ste.setString(3, utilisateur.getLastName());
                ste.setString(4, utilisateur.getEmail());
                ste.setString(5, password);
                ste.setString(6,"[\"ROLE_USER\"]");

                ste.setString(7, utilisateur.getPicture());
                ste.executeUpdate();
                System.out.println("User Added Successfully");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("user already exists");
        }
        
    }

    public List<Utilisateur> afficher() {
        List<Utilisateur> users = new ArrayList<>();
        String query = "SELECT * FROM user";
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ste.executeQuery();
            ResultSet rs = ste.executeQuery(query);
            while (rs.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(rs.getInt("id"));
                utilisateur.setFirstName(rs.getString("first_name"));
                utilisateur.setLastName(rs.getString("last_name"));
                utilisateur.setEmail(rs.getString("email"));
                utilisateur.setPassword(rs.getString("password"));
                if(rs.getString("roles").toLowerCase().contains("user"))
                utilisateur.setRoles("user");
                else
                utilisateur.setRoles("admin");
                utilisateur.setPicture(rs.getString("picture"));
                users.add(utilisateur);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }
    
     public Utilisateur afficherById(int id)   {
      Utilisateur u;
        try {
         ste=cnx.createStatement();
     
    ResultSet rs=store.executeQuery("select * from users where id="+id);
     while (rs.next()) {                
               int idd=rs.getInt(1);
               String libelle=rs.getString("libelle");
               
               
               u=new Utilisateur(idd);
               return u;
     }
     } catch (SQLException ex) {
         System.out.println("probleme d'affichage");
         return null;
     }
     return null;
    }
    
    

    public int modifier(Utilisateur t) {
        
        if(existeMailById(t)<1){
            
        
        
                        String password= BCrypt.hashpw(t.getPassword(), BCrypt.gensalt());
         String query = "UPDATE user SET " +
                "first_name = '" + t.getFirstName()+
                "', last_name = '" + t.getLastName()+
                "', email= '" + t.getEmail()+
                "', password = '" + password+
                "', roles = '" + t.getRoles()+
                "', picture = '" + t.getPicture()+ 
                "' where id="+t.getId();
         
         System.out.println(query);
        try {
            Statement ste = cnx.createStatement();
            ste.executeUpdate(query);
            System.out.println("User Updated Successfully ");
        } catch (SQLException e) {
               return 0;
        }
        return 1;
        }else{
            return 0;
        }

    }
    

       @Override
    public void supprimer(Utilisateur utilisateur) {
        String query = "DELETE FROM user WHERE id = '" +utilisateur.getId()+ "'";
        try {
            Statement ste = cnx.createStatement();
            int deleted = ste.executeUpdate(query);
            System.out.println(deleted);
            if (deleted > 0)
                System.out.println("Deleted successfully");
            else
                System.out.println("Nothing deleted");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Utilisateur getPassworCrypted_id(String email) throws SQLException{
         Statement ste = cnx.createStatement();
            
            ResultSet rs = ste.executeQuery("select e.* from user e where email='" + email +"'");
            while(rs.next()){
                Utilisateur u=new Utilisateur();
                u.setId(rs.getInt("id"));
                 u.setPassword(rs.getString("password"));
                 return u;
            }
            return null;
    }
    
    public Utilisateur verifPassword(String username, String password) {
        try {
            Statement ste = cnx.createStatement();
            
            ResultSet rs = ste.executeQuery("select e.* from user e where email='" + username +"' and is_verified=1");
          
            while(rs.next()){
                String passBase=rs.getString("password");
                if(BCrypt.checkpw(password, passBase)){
                                    Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(rs.getInt("id"));
                utilisateur.setFirstName(rs.getString("first_name"));
                utilisateur.setLastName(rs.getString("last_name"));
                utilisateur.setEmail(rs.getString("email"));
                utilisateur.setPassword(rs.getString("password"));
                if(rs.getString("roles").toLowerCase().contains("user"))
                utilisateur.setRoles("user");
                else
                utilisateur.setRoles("admin");
                    
                utilisateur.setPicture(rs.getString("picture"));
                MyConnection.userconnected=utilisateur;
                return utilisateur;
                }else
                    return null;
             
            }
            
        } catch (SQLException sq) {
            return null;
        }
        return null;
    }
    
    public int signup(Utilisateur utilisateur) throws SQLException  {
       
        String query = "INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `password`,  `roles`, `picture`) VALUES (?, ?, ?, ?, ?, ?, ?);";
        
        ServiceUtilisateurImpl us = new ServiceUtilisateurImpl();
        
        int x;
            x = us.existe(utilisateur);
            
         int y = us.existeMail(utilisateur);
        
        if (x == 0) {
            if(y==0) {
                String password= BCrypt.hashpw(utilisateur.getPassword(), BCrypt.gensalt());
                PreparedStatement ste = cnx.prepareStatement(query);
                ste.setInt(1, utilisateur.getId());
                ste.setString(2, utilisateur.getFirstName());
                ste.setString(3, utilisateur.getLastName());
                ste.setString(4, utilisateur.getEmail());
                ste.setString(5, password);
                ste.setString(6,"[\"ROLE_USER\"]");

                ste.setString(7, utilisateur.getPicture());
                ste.executeUpdate();
                System.out.println("User Added Successfully");
            return 0 ; 
            } else 
            {
                    return 1 ; 
                    
                    }
        }
            else {
                    return 2 ;
                    }
            
        
    }
    
    public String Login_Dispo(Utilisateur u) throws SQLException {
        Random rand = new Random(); //instance of random class
        int upperbound = 1000;
        int int_random = rand.nextInt(upperbound);
        String Newlogin=u.getEmail()+""+int_random;
        u.setEmail(Newlogin);
        while (existe(u)!=0)
        {
            int_random = rand.nextInt(upperbound);
            Newlogin=u.getEmail+""+int_random;
        }
          return Newlogin;
    }
    
    
       public boolean SendMail(Utilisateur user,String code ) throws SQLException
    {
        String password = "Testtest123";
        String from,to,host,sub,content;
        from = "wala.alimi@esprit.tn";
        to =user.getEmail();
        host="localhost";
        if (code == "null")
        {
            sub="Bienvenue sur notre Plateforme";
            content="Bonjour Mr/Mme "+user.getFirstName()+" "+user.getLastName()+". Au nom de tous les membres du plateforme, je vous souhaite la bienvenue.";
            content+="\n Pour valider votre compte copier ce texte:" +getPassworCrypted_id(user.getEmail()).getId()+"-"+getPassworCrypted_id(user.getEmail()).getPassword();
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            Session session=Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication()
                        {
                            return new PasswordAuthentication(from,password);
                        }
                    }
            );
            try {
                MimeMessage m =new MimeMessage(session);
                m.setFrom(new InternetAddress(from));
                m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                m.setSubject(sub);
                m.setText(content);
                Transport.send(m);
                return true;

            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }else
        {
            sub="Réinitialisation du mot de passe de votre compte ";
            content="Bonjour"+user.getFirstName()+".\n \n Avez-vous oublié votre mot de passe \n \n Taper ce code dans l'application =  " +code+" \n \n" +
                    "Si vous ne souhaitez pas changer votre mot de passe ou si vous ne l’avez pas demandé, veuillez ignorer et supprimer ce message. \n \n" +
                    "Cordialement,\n \n " +
                    "L’équipe PiDevers ";
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            Session session=Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication()
                        {
                            return new PasswordAuthentication(from,password);
                        }
                    }
            );
            try {
                MimeMessage m =new MimeMessage(session);
                m.setFrom(new InternetAddress(from));
                m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                m.setSubject(sub);
                m.setText(content);
                Transport.send(m);
                return true;

            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
       
       public String ForgetPWD(String email) throws SQLException
    {
        String Code="";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        Utilisateur u =new Utilisateur();
        int length = 7;
        for(int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        Code=randomString;
        u.setEmail(email);
        if (SendMail(u,Code))
        {
            System.out.println("Service"+Code);
            return Code;
        }
        return "null";
    }

    
     
     public int getUserByIdPw(int id , String pw) throws SQLException
     {
          Statement s = cnx.createStatement();
        ResultSet rs = s.executeQuery("SELECT COUNT(*) from user WHERE id = '" + id + "' AND password = '"+ pw+"' ");
        int size = 0;
        rs.next();
        size = rs.getInt(1);
        if(size>0)
        {
            String query = "UPDATE user set is_verified = 1 WHERE id="+id ;
              PreparedStatement ste = cnx.prepareStatement(query);
              ste.executeUpdate();
            
            
        }
        return size;
     }
    
    
    

}
