/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.clutchers.services;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author aziza
 */
public interface Iservice<T> {

   void add(T t) throws SQLException;

   void delete(int id) throws SQLException;

   void update(int id, T t) throws SQLException;

   List<T> findAll() throws SQLException;
   List<T> getAll() throws SQLException;

    
    
    
    
}
