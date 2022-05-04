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
public class Actualite {
    private int id ;
    private String titre,image,content;

    public Actualite(String titre, String image, String content) {
        this.titre = titre;
        this.image = image;
        this.content = content;
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
        final Actualite other = (Actualite) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.content, other.content)) {
            return false;
        }
        return true;
    }

    public Actualite() {
    }
    
    public Actualite(int id, String titre, String image, String content) {
        this.id = id;
        this.titre = titre;
        this.image = image;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Actualite{" + "id=" + id + ", titre=" + titre + ", image=" + image + ", content=" + content + '}';
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getImage() {
        return image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
    
}
