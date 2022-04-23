/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import services.IProduit;
import entites.Produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Util.MyDB;

/**
 *
 * @author Mehdi
 */
public class ProduitService implements IProduit<Produit>{
Connection connection; 
 
public ProduitService() {
        connection=Util.MyDB.getInstance().getConnection();
    }
 
    @Override
    public int ajouter(Produit pr) {    
        int status =0;
        try { 
            Statement stm = connection.createStatement();
            String query = "INSERT INTO `produit`(`nom`,`qte`,`prix`,`descrp`,`catego`) VALUES ('"+pr.getNom()+"','"+pr.getQte()+"','"+pr.getPrix()+"','"+pr.getDescrp()+"','"+pr.getCatego()+"')";
      System.out.println(query);
            status =    stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status; 
    }

    @Override
    public void modifier(Produit pr) {
        System.out.println();        System.out.println();        System.out.println();
        System.out.println(pr.toString());
                System.out.println();        System.out.println();        System.out.println();
      String req ="UPDATE produit SET nom='"+pr.getNom()+"',qte="+pr.getQte()+",prix="+pr.getPrix()+", descrp='"+pr.getDescrp()+"', catego='"+pr.getCatego()+"' WHERE id="+pr.getId() ;
    try {
             PreparedStatement st1 = connection.prepareStatement(req);
             //String value1 = tf_instru.getText();
             st1.executeUpdate();
            System.out.println("produits modifié");     
        } 
    catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }     
    }

    @Override
    public void supprimer(Produit pr) {
           
            String req = "delete from produit where id=" + pr.getId();
        
            try {
            PreparedStatement st1 = connection.prepareStatement(req);
             st1.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    

    @Override
    public List<Produit> recuperer() throws SQLException
    
    {
       List<Produit> list = new ArrayList<>();
        try{
            String req = "select * from produit";
            Statement st = connection.createStatement();
    
        ResultSet rs=st.executeQuery(req);
        while(rs.next())
        {
            Produit pr = new Produit();
            pr.setId(rs.getInt("id"));
            pr.setNom(rs.getString("nom"));
            pr.setQte(rs.getInt("qte"));
            pr.setPrix(rs.getDouble("prix"));
            pr.setDescrp(rs.getString("descrp"));
            pr.setCatego(rs.getString("catego"));
            list.add(pr);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
        return list;  
    }

  

}
