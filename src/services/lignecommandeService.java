/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import services.lignecommandeService;
import entities.lignecommande;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.MyDB;

/**
 *
 * @author khouloud
 */
public class lignecommandeService implements Ilignecommande<lignecommande>{
  
    Connection connection;
    public lignecommandeService() {
        connection = MyDB.getInstance().getConnection();
    }

    @Override
    public void ajouterlc(lignecommande lc) {
        try {
//            String req = "insert into lignecommande(nom,prenom,age) "
//                    + "values('"+ t.getNom()+"','"+ t.getPrenom()+"',"+ t.getAge()+")";
//            Statement st = connection.createStatement();
//            st.executeUpdate(req);
            
            
            String req1 = "insert into lignecommande(id,lignecmd_id,produit_id,quantite) values (?,?,?,?)";
            PreparedStatement pr = connection.prepareStatement(req1);
            pr.setInt(1, lc.getId());
            pr.setString(2, lc.getLignecmd_id());
            pr.setString(3, lc.getProduit_id());
            pr.setInt(4, lc.getQuantite());
            
            pr.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifierlc(lignecommande lc) {
       try {
            String req = "UPDATE lignecommande SET lignecmd_id = ?, produit_id = ?, quantite = ? WHERE id = ?";
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setString(1, lc.getLignecmd_id());
            pst.setString(2, lc.getProduit_id());
            pst.setInt(3, lc.getQuantite());
            pst.executeUpdate();
            System.err.println("MISE A JOUR FAITE AVEC SUCCEE !! ");
        } catch (SQLException ex) {
            System.err.println("UN ERREUR S'EST PRODUIT LORS DE LA MODIFICATION !! ");
            System.err.println(ex.getMessage());
        }
    }
   
   @Override
    public void supprimerlc(int id) {
        try {
            String requete = "DELETE FROM lignecommande WHERE id = ? ";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setInt(1, id);
            int rsltUpdate = pst.executeUpdate();
            if (rsltUpdate == 0) {
                System.err.println("EXITE AUCUN ELEMENT CORRESPOND AU DONNEE SAISIE !! \n AUCUNE SUPPRESSION N'EST EFFECTUEE !!");
            } else {
                System.out.println("EVENT DELETED SUCCESFULLY !!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
 
   
  
    @Override
    public List<lignecommande> recupererlc() {
        List<lignecommande> list =new ArrayList<>();
        try {
            String req = "select * from lignecommande";
            Statement st = connection.createStatement();
            ResultSet rs =st.executeQuery(req);
            
            while(rs.next()){
                lignecommande lc = new lignecommande();
                lc.setId(rs.getInt("id"));
                lc.setLignecmd_id(rs.getString("lignecmd_id"));
                lc.setProduit_id(rs.getString("produit_id"));
                lc.setQuantite(rs.getInt("quantite"));
                
                list.add(lc);
       //         list.add(new commandes((rs.getInt("id")),
//                (rs.getInt("guide_id")),
//                (rs.getString("date_res")),
//                (rs.getString("heure_debut")),
//               (rs.getString("idjoueur_id")),
//                (rs.getString("id_coach_id"))));
                        }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
     public lignecommande GetById(int id) {
        return recupererlc().stream().filter(e -> e.getId()== id).findFirst().get();
    }
}

