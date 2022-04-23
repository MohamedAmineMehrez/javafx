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

public interface Ilignecommande <T> {
    
     public void ajouterlc(T lc);

    public void modifierlc(T lc);

    public void supprimerlc(int id);

    public List<T> recupererlc();



}
