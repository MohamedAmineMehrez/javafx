/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author USER
 */
public class Reservation {
    private int id , guideId , idJoueur , idCoach;
    private String dateRes ;
    private String HeureDebut , Joueur , Coach , Guide ;
    private Guide guide ; 
    private UserM coach , player ;

    public Reservation(int id, String dateRes, String HeureDebut) {
        this.id = id;
        this.dateRes = dateRes;
        this.HeureDebut = HeureDebut;
    }

    public Reservation( String dateRes, String HeureDebut) {
       
        this.dateRes = dateRes;
        this.HeureDebut = HeureDebut;
    }

    public Reservation(int id, Guide guide, String dateRes, String HeureDebut, UserM coach, UserM player) {
        this.id = id;
        this.dateRes = dateRes;
        this.HeureDebut = HeureDebut;
        this.guide = guide;
        this.coach = coach;
        this.player = player;
    }
 public Reservation( Guide guide, String dateRes, String HeureDebut, UserM coach, UserM player) {
       
        this.dateRes = dateRes;
        this.HeureDebut = HeureDebut;
        this.guide = guide;
        this.coach = coach;
        this.player = player;
    }

    public Reservation(int id,String Guide,String dateRes,String HeureDebut,String Coach, String Joueur) {
        this.id = id;
        this.Guide = Guide;
        this.dateRes = dateRes;
        this.HeureDebut = HeureDebut;
        this.Joueur = Joueur;
        this.Coach = Coach;

    }
     public Reservation(int id,int Guide,String dateRes,String HeureDebut,String Coach, String Joueur) {
        this.id = id;
        this.guideId = Guide;
        this.dateRes = dateRes;
        this.HeureDebut = HeureDebut;
        this.Joueur = Joueur;
        this.Coach = Coach;

    }
 public Reservation(int id,int Guide,String dateRes,String HeureDebut,int Coach, int Joueur) {
        this.id = id;
        this.guideId = Guide;
        this.dateRes = dateRes;
        this.HeureDebut = HeureDebut;
        this.idJoueur = Joueur;
        this.idCoach = Coach;

    }
    public Reservation(String Guide, String dateRes, String HeureDebut) {
        this.dateRes = dateRes;
        this.HeureDebut = HeureDebut;
        this.Guide = Guide;
    }

    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    public int getIdCoach() {
        return idCoach;
    }

    public void setIdCoach(int idCoach) {
        this.idCoach = idCoach;
    }

    public Reservation() {
    }

  

  
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateRes() {
        return dateRes;
    }

    public void setDateRes(String dateRes) {
        this.dateRes = dateRes;
    }

    public String getHeureDebut() {
        return HeureDebut;
    }

    public void setHeureDebut(String HeureDebut) {
        this.HeureDebut = HeureDebut;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public UserM getCoach() {
        return coach;
    }

    public void setCoach(UserM coach) {
        this.coach = coach;
    }

    public UserM getPlayer() {
        return player;
    }

    public void setPlayer(UserM player) {
        this.player = player;
    }


    

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", guideId=" + guideId + ", idJoueur=" + idJoueur + ", idCoach=" + idCoach + ", dateRes=" + dateRes + ", HeureDebut=" + HeureDebut + ", Joueur=" + Joueur + ", Coach=" + Coach + ", Guide=" + Guide + '}';
    }
    

    
}
