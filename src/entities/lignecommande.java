/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author khouloud
 */
public class lignecommande {
      private int id;
    private String lignecmd_id;
    private String produit_id;
    private int quantite;

    public lignecommande() {
    }

    public lignecommande(int id, String lignecmd_id, String produit_id, int quantite) {
        this.id = id;
        this.lignecmd_id = lignecmd_id;
        this.produit_id = produit_id;
        this.quantite = quantite;
    }

    public lignecommande(String lignecmd_id, String produit_id, int quantite) {
        this.lignecmd_id = lignecmd_id;
        this.produit_id = produit_id;
        this.quantite = quantite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLignecmd_id() {
        return lignecmd_id;
    }

    public void setLignecmd_id(String lignecmd_id) {
        this.lignecmd_id = lignecmd_id;
    }

    public String getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(String produit_id) {
        this.produit_id = produit_id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "lignecommande{" + "id=" + id + ", lignecmd_id=" + lignecmd_id + ", produit_id=" + produit_id + ", quantite=" + quantite + '}';
    }

    
}
