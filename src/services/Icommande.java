/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author khouloud
 */
 

import java.util.List;

public interface Icommande<T> {

    public void ajouter(T c);

    public void modifier(T c);

    public void supprimer(int id);

    public List<T> recuperer();

}

