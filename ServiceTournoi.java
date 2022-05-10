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
public interface ServiceTournoi <T> {
    public void ajouterTournoi(T t);
    public void supprimerTournoi(int id);
    public void modifierTournoi(int id,T t);
    public List<T> getAll();
}
