package edu.Clutchers.GUI;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.twilio.Twilio;
   import com.twilio.rest.api.v2010.account.Message;
  import com.twilio.type.PhoneNumber;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sinda
 */
public class Sms {
    

   
   
    
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "ACfa610edd03c91d1855ce20d6217f7517";
  public static final String AUTH_TOKEN = "5b7e8fbe705bbb7772d3017b59bbcba6";

  public static void nabil(String text) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    Message message = Message.creator(new PhoneNumber("+21627260871"),
        new PhoneNumber("+19402919958"), 
        text).create();

    System.out.println(message.getSid());
  }

  
 
 }

