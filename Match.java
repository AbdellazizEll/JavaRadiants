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
public class Match {
    private int id;
    private int idNomTournoi;
    private String heure;
    private Date dateDebMatch;
    private String score;

    public Match(int idNomTournoi, String heure, Date dateDebMatch, String score) {
        this.idNomTournoi = idNomTournoi;
        this.heure = heure;
        this.dateDebMatch = dateDebMatch;
        this.score = score;
    }

    public Match() {
        
    }

    public int getId() {
        return id;
    }

    public int getIdNomTournoi() {
        return idNomTournoi;
    }

    public String getHeure() {
        return heure;
    }

    public Date getDateDebMatch() {
        return dateDebMatch;
    }

    public String getScore() {
        return score;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdNomTournoi(int idNomTournoi) {
        this.idNomTournoi = idNomTournoi;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public void setDateDebMatch(Date dateDebMatch) {
        this.dateDebMatch = dateDebMatch;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Match{" + "id=" + id + ", idNomTournoi=" + idNomTournoi + ", heure=" + heure + ", dateDebMatch=" + dateDebMatch + ", score=" + score + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + this.idNomTournoi;
        hash = 97 * hash + Objects.hashCode(this.heure);
        hash = 97 * hash + Objects.hashCode(this.dateDebMatch);
        hash = 97 * hash + Objects.hashCode(this.score);
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
        final Match other = (Match) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
