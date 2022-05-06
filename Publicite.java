/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.clutchers.entities;

/**
 *
 * @author Zied
 */
public class Publicite {
    
    private int id;
    private String titre;
    private String teaser;
    private String image;
    
    public Publicite(){
        
    }

    public Publicite( String titre, String teaser, String image) {
        
        this.titre = titre;
        this.teaser = teaser;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getTeaser() {
        return teaser;
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

    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Publicite{" + "id=" + id + ", titre=" + titre + ", teaser=" + teaser + ", image=" + image + '}';
    }
    
    
    
}
