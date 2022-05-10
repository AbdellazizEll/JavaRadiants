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
 * @param <E>
 */
public interface ServiceEquipe <E>{
    public void ajouterEquipe(E e);
    public void supprimerEquipe(int id);
    public void modifierEquipe(int id,E e);
    public List<E> getAll();
    
}

