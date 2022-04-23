/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author Mehdi
 */
public class Fournisseur {
    int id,numTel;
    String nom,email;
    
    public Fournisseur() {
    }

    public Fournisseur(int id,  String nom,int numTel, String email) {
        this.id = id;
        this.numTel = numTel;
        this.nom = nom;
        this.email = email;
    }
    
    public Fournisseur(int numTel, String nom, String email) {
        this.numTel = numTel;
        this.nom = nom;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Fournisseur{" + "id=" + id + ", numTel=" + numTel + ", nom=" + nom + ", email=" + email + '}';
    }
 
}
