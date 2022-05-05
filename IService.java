/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import java.util.List;

/**
 *
 * @author MSI I7
 * @param <E>
 */
public interface IService <E>{
    public void ajouter(E e);
    public void supprimer(int id);
    public void modifier(int id,E e);
    public List<E> getAll();
    
}

