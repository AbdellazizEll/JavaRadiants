/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Clutchers.GUI;

import java.io.IOException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author sinda
 */
public class SendMailController implements Initializable {

    @FXML
    private Button btnRetourM;
    @FXML
    private Button btnSend;
    @FXML
    private TextField emailToField;
    @FXML
    private TextField emailFromField;
    @FXML
    private TextField emailPasswordField;
    @FXML
    private TextField emailSubject;
    @FXML
    private TextArea emailMessageField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Retour(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("GestionProduit.fxml"));
         Parent root = loader.load();
         GestionProduitController ap = loader.getController();
         btnRetourM.getScene().setRoot(root);
    }

    @FXML
    private void SendMail(ActionEvent event) {
      /*  // Reclamation r =.getSelectionModel().getSelectedItem();
     //int i =r.getId_rdv();
       //  System.out.println(i);
      // ServicePresta sm =new ServicePresta();
      // sm.confirmStatus(i);
       Properties props=new Properties() ;
       props.put("mail.smtp.host","smtp.gmail.com") ;
       
       props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory") ;//validite mail 
       props.put("mail.smtp.socketFactory.port", "465") ;
       props.put("mail.smtp.socketFactory.fallback", "false") ;
       props.put("mail.smtp.auth","true") ;
       props.put("mail.smtp.password","ntxwlmsoqczjbrrq");
       props.put("mail.smtp.port","465") ;
       
       
       Session session=Session.getDefaultInstance(props,new javax.mail.Authenticator()
       {
           public PasswordAuthentication getPasswordAuthetntication()
           {
               return new PasswordAuthentication("amyral.contact@gmail.com","qfieafzfjgonoggz".toCharArray());
              
           }
           
           
}
       );
       
       try
            {
                
                Message message=new MimeMessage(session) ; //type
                message.setFrom(new InternetAddress("amir.bennasr@esprit.tn"));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress("farouk.noomene@esprit.tn"));
                message.setSubject("Sahtek Confirmation code");
                message.setText(r.toString()) ;
                Transport transport = session.getTransport("smtp");//prend les config valid
                transport.connect("smtp.gmail.com","amyral.contact@gmail.com","qfieafzfjgonoggz");
                transport.sendMessage(message, message.getAllRecipients());
                JOptionPane.showMessageDialog(null,"Message sent !");
                
                
            } catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
    }*/
      
      String to= emailToField.getText();
      
      String host ="smtp.gmail.com";
      final String username =emailFromField.getText();
      final String password = emailPasswordField.getText();
      String from= emailFromField.getText();
      
       Properties props= System.getProperties();
       props.put("mail.smtp.auth","true") ;
       props.put("mail.smtp.starttls.enable","true") ;
       props.put("mail.smtp.host", host) ;
       props.put("mail.smtp.port","587") ;
       
      Session session=Session.getDefaultInstance(props,new javax.mail.Authenticator()
       {
           
           protected PasswordAuthentication getPasswordAuthetntication()
           {
               return new PasswordAuthentication("chamakhferiel@gmail.com","Chjalel21".toCharArray());
              
           }});
      
      try 
      {
          MimeMessage m = new MimeMessage (session);
          m.setFrom(new InternetAddress(from));
          m.addRecipient(MimeMessage.RecipientType.TO , new InternetAddress());
          m.setSubject(emailSubject.getText());
          m.setText(emailMessageField.getText());
          
          Transport transport = session.getTransport("smtp");//prend les config valid
          transport.connect("smtp.gmail.com",587, "chamakhferiel@gmail.com","Chjalel21");
             //   transport.connect("smtp.gmail.com","sindachamakh27t@gmail.com","191JFT1672");
                transport.sendMessage(m, m.getAllRecipients());
                JOptionPane.showMessageDialog(null,"Message sent !");
          
               // Transport.send(m);
          System.out.println("sent");
      }   
      catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
      
    }
    
}
