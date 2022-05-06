/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.clutchers.services;

import java.util.List;

/**
 *
 * @author Zied
 */
public interface Iservice <P>{
    public void add(P p);
     public void update(int id,P p);
    public void delete(int id);
   
    public List<P> getAll();

    
}
