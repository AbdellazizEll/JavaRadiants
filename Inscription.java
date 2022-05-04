/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.clutchers.entities;

/**
 *
 * @author aziza
 */
public class Inscription {
    
    private int id;
    private int nom_tournoi_id ;
    private String nom_complet;
    private String nom_equipe;
    private int nombre_joueurs;
    private String nom_joueur1;
    private String nom_joueur2;
    private String nom_joueur3;
    private String nom_joueur4;
    private String nom_joueur5;
    private String email;
    
    
    public Inscription(){
        
    }

    public Inscription(int nom_tournoi_id, String nom_complet, String nom_equipe, int nombre_joueurs, String nom_joueur1, String nom_joueur2, String nom_joueur3, String nom_joueur4, String nom_joueur5, String email) {
        this.nom_tournoi_id = nom_tournoi_id;
        this.nom_complet = nom_complet;
        this.nom_equipe = nom_equipe;
        this.nombre_joueurs = nombre_joueurs;
        this.nom_joueur1 = nom_joueur1;
        this.nom_joueur2 = nom_joueur2;
        this.nom_joueur3 = nom_joueur3;
        this.nom_joueur4 = nom_joueur4;
        this.nom_joueur5 = nom_joueur5;
        this.email = email;
    }

    public Inscription(int id, int nom_tournoi_id, String nom_complet, String nom_equipe, int nombre_joueurs, String nom_joueur1, String nom_joueur2, String nom_joueur3, String nom_joueur4, String nom_joueur5, String email) {
        this.id = id;
        this.nom_tournoi_id = nom_tournoi_id;
        this.nom_complet = nom_complet;
        this.nom_equipe = nom_equipe;
        this.nombre_joueurs = nombre_joueurs;
        this.nom_joueur1 = nom_joueur1;
        this.nom_joueur2 = nom_joueur2;
        this.nom_joueur3 = nom_joueur3;
        this.nom_joueur4 = nom_joueur4;
        this.nom_joueur5 = nom_joueur5;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public int getNom_tournoi_id() {
        return nom_tournoi_id;
    }

    public String getNom_complet() {
        return nom_complet;
    }

    public String getNom_equipe() {
        return nom_equipe;
    }

    public int getNombre_joueurs() {
        return nombre_joueurs;
    }

    public String getNom_joueur1() {
        return nom_joueur1;
    }

    public String getNom_joueur2() {
        return nom_joueur2;
    }

    public String getNom_joueur3() {
        return nom_joueur3;
    }

    public String getNom_joueur4() {
        return nom_joueur4;
    }

    public String getNom_joueur5() {
        return nom_joueur5;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom_tournoi_id(int nom_tournoi_id) {
        this.nom_tournoi_id = nom_tournoi_id;
    }

    public void setNom_complet(String nom_complet) {
        this.nom_complet = nom_complet;
    }

    public void setNom_equipe(String nom_equipe) {
        this.nom_equipe = nom_equipe;
    }

    public void setNombre_joueurs(int nombre_joueurs) {
        this.nombre_joueurs = nombre_joueurs;
    }

    public void setNom_joueur1(String nom_joueur1) {
        this.nom_joueur1 = nom_joueur1;
    }

    public void setNom_joueur2(String nom_joueur2) {
        this.nom_joueur2 = nom_joueur2;
    }

    public void setNom_joueur3(String nom_joueur3) {
        this.nom_joueur3 = nom_joueur3;
    }

    public void setNom_joueur4(String nom_joueur4) {
        this.nom_joueur4 = nom_joueur4;
    }

    public void setNom_joueur5(String nom_joueur5) {
        this.nom_joueur5 = nom_joueur5;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Inscription{" + "id=" + id + ", nom_tournoi_id=" + nom_tournoi_id + ", nom_complet=" + nom_complet + ", nom_equipe=" + nom_equipe + ", nombre_joueurs=" + nombre_joueurs + ", nom_joueur1=" + nom_joueur1 + ", nom_joueur2=" + nom_joueur2 + ", nom_joueur3=" + nom_joueur3 + ", nom_joueur4=" + nom_joueur4 + ", nom_joueur5=" + nom_joueur5 + ", email=" + email + '}';
    }

    
    
    
    
    

  
    
}
