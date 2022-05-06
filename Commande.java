/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.clutchers.entities;

import java.sql.Date;

/**
 *
 * @author Zied
 */
public class Commande {
    
    private int id;
    private String produit;
    private float totale;
    private Date   date;
    private String adresse;
    private String mail;
    
    
    public Commande(){
        
    }

    public Commande(String produit, float totale, Date date, String adresse, String mail) {
        this.produit = produit;
        this.totale = totale;
        this.date = date;
        this.adresse = adresse;
        this.mail = mail;
    }
    
    

    public Commande(int id, String produit, float totale, Date date, String adresse, String mail) {
        this.id = id;
        this.produit = produit;
        this.totale = totale;
        this.date = date;
        this.adresse = adresse;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public String getProduit() {
        return produit;
    }

    public float getTotale() {
        return totale;
    }

    public Date getDate() {
        return date;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getMail() {
        return mail;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public void setTotale(float totale) {
        this.totale = totale;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

  
    

   

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", totale=" + totale + ", produit=" + produit + ", date=" + date + ", adresse=" + adresse + ", mail=" + mail + '}';
    }
    
    
}
