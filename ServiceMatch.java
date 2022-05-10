/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;

/**
 *
 * @author MSI I7
 */
public interface ServiceMatch <M> {
     public void ajouterMatch(M e);
    public void supprimerMatch(int id);
    public void modifierMatch(int id,M e);
    public List<M> getAll();
    
}
