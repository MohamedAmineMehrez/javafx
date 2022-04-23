/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import services.IFournisseur;
import entites.Fournisseur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Util.MyDB;
/**
 *
 * @author Mehdi
 */
public class FournisseurService implements IFournisseur<Fournisseur>{
Connection connection; 

    public FournisseurService() {
        connection=Util.MyDB.getInstance().getConnection();
    }

    @Override
    public void ajouter(Fournisseur f) {
    try {
      /*  String req = "insert into personne(nom,prenom,age) "
                + "values('"+t.getNom()+"','"+t.getPrenom()+"',"+t.getAge()+")";
        Statement st = connection.createStatement();
       st.executeUpdate(req);*/
        String req1="insert into Fournisseur (nom,numTel,email) values(?,?,?)";
        PreparedStatement ps=connection.prepareStatement(req1);
        ps.setString(1, f.getNom());
        ps.setInt(2, f.getNumTel());
        ps.setString(3, f.getEmail());
        
        ps.executeUpdate();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    
    }

    @Override
    public void modifier(int id,String nom) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
       try {
            String req = "UPDATE Fournisseur SET nom = ? WHERE id = ?";
            PreparedStatement pst = connection.prepareStatement(req); 
            pst.setString(1, nom);
            pst.setInt(2, id);
            pst.executeUpdate();
            System.err.println("MISE A JOUR FAITE AVEC SUCCEE !! ");
        } catch (SQLException ex) {
            System.err.println("UN ERREUR S'EST PRODUIT LORS DE LA MODIFICATION !! ");
            System.err.println(ex.getMessage());
        }
    
    }

    @Override
    public void supprimer(int id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
     try {
            String requete = "DELETE FROM Fournisseur WHERE id = ? ";
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
    public List<Fournisseur> recuperer() {
        List<Fournisseur> list = new ArrayList<>();
        try{
            String req = "select * from fournisseur";
            Statement st = connection.createStatement();
    
        ResultSet rs=st.executeQuery(req);
        while(rs.next())
        {
            Fournisseur f = new Fournisseur();
            f.setId(rs.getInt("id"));
            f.setNom(rs.getString("nom"));
            f.setNumTel(rs.getInt("num_tel"));
            f.setEmail(rs.getString("email"));
            list.add(f);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
        return list;
    }
    
}
