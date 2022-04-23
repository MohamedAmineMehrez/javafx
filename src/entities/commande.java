/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author khouloud
 */
public class commande {
     private int id;
     private String id_user_id;
      private String date_cmd;
     private String image;
     private String statut;

    public commande() {
    }

    public commande(int id, String id_user_id, String date_cmd, String image, String statut) {
        this.id = id;
        this.id_user_id = id_user_id;
        this.date_cmd = date_cmd;
        this.image = image;
        this.statut = statut;
    }

    public commande(String id_user_id, String date_cmd, String image, String statut) {
        this.id_user_id = id_user_id;
        this.date_cmd = date_cmd;
        this.image = image;
        this.statut = statut;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_user_id() {
        return id_user_id;
    }

    public void setId_user_id(String id_user_id) {
        this.id_user_id = id_user_id;
    }

    public String getDate_cmd() {
        return date_cmd;
    }

    public void setDate_cmd(String date_cmd) {
        this.date_cmd = date_cmd;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "commande{" + "id=" + id + ", id_user_id=" + id_user_id + ", date_cmd=" + date_cmd + ", image=" + image + ", statut=" + statut + '}';
    }

    
}

