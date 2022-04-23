/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;

/**
 *
 * @author Mehdi
 */
public interface IFournisseur<F> {
    public void ajouter(F t);
    public void modifier(int id,String nom);
    public void supprimer(int id);
    public List<F> recuperer();  
}
