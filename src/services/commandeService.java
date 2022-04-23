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
import entities.commande;
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
public class commandeService implements Icommande<commande>{

    Connection connection;
    public commandeService() {
        connection = MyDB.getInstance().getConnection();
    }

    @Override
    public void ajouter(commande c) {
        try {
//            String req = "insert into commandes(nom,prenom,age) "
//                    + "values('"+ t.getNom()+"','"+ t.getPrenom()+"',"+ t.getAge()+")";
//            Statement st = connection.createStatement();
//            st.executeUpdate(req);
            
            
            String req1 = "insert into commande(id,id_user_id,date_cmd,image,statut) values (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req1);
            ps.setInt(1, c.getId());
            ps.setString(2, c.getId_user_id());
            ps.setString(3, c.getDate_cmd());
            ps.setString(4, c.getImage());
            ps.setString(5, c.getStatut());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(commande c) {
       try {
            String req = "UPDATE commande SET id_user_id = ? ,date_cmd = ?, image = ?, statut = ? WHERE id = ?";
            PreparedStatement pst = connection.prepareStatement(req);
            
            pst.setString(1, c.getId_user_id());
            pst.setString(3, c.getDate_cmd());
            pst.setString(4, c.getImage());
            pst.setString(5, c.getStatut());
            pst.executeUpdate();
            System.err.println("MISE A JOUR FAITE AVEC SUCCEE !! ");
        } catch (SQLException ex) {
            System.err.println("UN ERREUR S'EST PRODUIT LORS DE LA MODIFICATION !! ");
            System.err.println(ex.getMessage());
        }
    }
   
   @Override
    public void supprimer(int id) {
        try {
            String requete = "DELETE FROM commande WHERE id = ? ";
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
    public List<commande> recuperer() {
        List<commande> list =new ArrayList<>();
        try {
            String req = "select * from commande";
            Statement st = connection.createStatement();
            ResultSet rs =st.executeQuery(req);
            
            while(rs.next()){
                commande c = new commande();
                c.setId(rs.getInt("id"));
                c.setId_user_id(rs.getString("id_user_id"));
                c.setDate_cmd(rs.getString("date_cmd"));
                c.setImage(rs.getString("Image"));  
                c.setStatut(rs.getString("statut"));
                  
                list.add(c);
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

 public commande GetById(int id) {
        return recuperer().stream().filter(e -> e.getId()== id).findFirst().get();
    }


}
