/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.entities;

import java.util.Objects;

/**
 *
 * @author sof
 */
public class Jeu {
    private int id;
    private String nom,image,description;

    public Jeu(String nom, String image, String description) {
        this.nom = nom;
        this.image = image;
        this.description = description;
    }

  
  

    @Override
    public int hashCode() {
        int hash = 7;
       
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jeu other = (Jeu) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        return Objects.equals(this.description, other.description);
    }

    public Jeu() {
    }
    
    public Jeu(int id, String nom, String image, String description) {
        this.id = id;
        this.nom = nom;
        this.image = image;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Jeu{" + "id=" + id + ", nom=" + nom + ", image=" + image + ", description=" + description + '}';
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getImage() {
        return image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
}
