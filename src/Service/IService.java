/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;

/**
 *
 * @author EXTRA
 */
public interface IService<T>{
    public void ajouter(T t);
    public void modifier(T t,int id);
    public void supprimer(int id);
    public List<T> recuperer();
}