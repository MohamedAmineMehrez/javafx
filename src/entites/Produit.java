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
public class Produit {
    int id,qte;
    String nom,descrp,catego;
    double prix;

    public Produit() {
    }

    public Produit(int id, String nom, int qte, double prix, String descrp, String catego) {
        this.id = id;
        this.qte = qte;
        this.nom = nom;
        this.descrp = descrp;
        this.catego = catego;
        this.prix = prix;
    }

    public Produit(int id, String noms, int quantite, Double prix1, String description) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescrp() {
        return descrp;
    }

    public void setDescrp(String descrp) {
        this.descrp = descrp;
    }

    public String getCatego() {
        return catego;
    }

    public void setCatego(String catego) {
        this.catego = catego;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", qte=" + qte + ", nom=" + nom + ", descrp=" + descrp + ", catego=" + catego + ", prix=" + prix + '}';
    }
    
    
}
