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
public class Equipe {
    
    private int id;
    private String NomEquipe;
    private Date dateCreation; 
    private String league;
    private String pays;
    private String logo;
    private String siteweb;
    private String description;
    private String palmares;

    public Equipe(String NomEquipe, Date dateCreation, String pays, String league, String logo, String siteweb, String description, String palmares) {
        this.NomEquipe = NomEquipe;
        this.dateCreation = dateCreation;
        this.pays = pays;
        this.league= league;
        this.logo = logo;
        this.siteweb = siteweb;
        this.description = description;
        this.palmares = palmares;
    }

    public Equipe(String NomEquipe) {
        this.NomEquipe = NomEquipe;
    }

   
    public Equipe() {
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getLeague() {
        return league;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomEquipe() {
        return NomEquipe;
    }

    public void setNomEquipe(String NomEquipe) {
        this.NomEquipe = NomEquipe;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSiteweb() {
        return siteweb;
    }

    public void setSiteweb(String siteweb) {
        this.siteweb = siteweb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPalmares() {
        return palmares;
    }

    public void setPalmares(String palmares) {
        this.palmares = palmares;
    }

    @Override
    public String toString() {
        return "Equipe{" + "id=" + id + ", NomEquipe=" + NomEquipe + ", dateCreation=" + dateCreation + ", league=" + league + ", pays=" + pays + ", logo=" + logo + ", siteweb=" + siteweb + ", description=" + description + ", palmares=" + palmares + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.NomEquipe);
        hash = 53 * hash + Objects.hashCode(this.dateCreation);
        hash = 53 * hash + Objects.hashCode(this.league);
        hash = 53 * hash + Objects.hashCode(this.pays);
        hash = 53 * hash + Objects.hashCode(this.logo);
        hash = 53 * hash + Objects.hashCode(this.siteweb);
        hash = 53 * hash + Objects.hashCode(this.description);
        hash = 53 * hash + Objects.hashCode(this.palmares);
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
        final Equipe other = (Equipe) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    

   
}
