/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author MSI I7
 */
public class Tournoi {
    private int id;
    private String nomTournoi;
    private String jeux;
    private Date dateDebut;
    private Date dateFin;
    private String couleur;

    public Tournoi( String nomTournoi, String jeux, Date dateDebut, Date dateFin, String couleur) {
        
        this.nomTournoi = nomTournoi;
        this.jeux = jeux;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.couleur = couleur;
    }

    public Tournoi(){
        
    }

    

    

    public int getId() {
        return id;
    }

    public String getNomTournoi() {
        return nomTournoi;
    }

    public String getJeux() {
        return jeux;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomTournoi(String nomTournoi) {
        this.nomTournoi = nomTournoi;
    }

    public void setJeux(String jeux) {
        this.jeux = jeux;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Tournoi{" + "id=" + id + ", nomTournoi=" + nomTournoi + ", jeux=" + jeux + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", couleur=" + couleur + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.nomTournoi);
        hash = 17 * hash + Objects.hashCode(this.jeux);
        hash = 17 * hash + Objects.hashCode(this.dateDebut);
        hash = 17 * hash + Objects.hashCode(this.dateFin);
        hash = 17 * hash + Objects.hashCode(this.couleur);
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
        final Tournoi other = (Tournoi) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
