/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mehdi
 */
public interface IProduit<T> {
    public int ajouter(T t);
    public void modifier(T t);
    public void supprimer(T t);
    public List<T> recuperer()throws SQLException;   
}
