/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Util.MyDB;
import entities.Articles;
import entities.Comment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MOUEFEK
 */
public class comment_service implements Ipifx<Comment> {
    Connection connection;
    private Statement stm;
    
    public comment_service(){
    connection=MyDB.getInstance().getConnection();
    }
    
    
    @Override
    public void ajouter(Comment t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(Comment t, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimer(int id) {
        try{
        String req = "delete from comment where `id`='"+id+"' ";
        stm = connection.createStatement();
        stm.executeUpdate(req);
        }catch(SQLException ex ){
            System.out.println(ex.getMessage());
        }
    }
 
    @Override
    public List<Comment>recuperer() {
    List<Comment> list = new ArrayList<Comment>();
    try{
        String req = "select * from comment";
        Statement st = connection.createStatement();
        ResultSet rs=st.executeQuery(req);
    while(rs.next()){
        Comment c = new Comment();
        c.setId(rs.getInt("id"));
        c.setCommentaire(rs.getString("commentaire"));
        c.setId_article_id(rs.getInt("id_article_id"));
        list.add(c);
        }
    }catch(SQLException ex) {
        System.out.println(ex.getMessage());
    }
        return list;
    }
    
        public List<Comment> search(String text) {

        List<Comment> list = new ArrayList<>();
        try {

            String req = "select * from comment WHERE commentaire LIKE '" + text +"';";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Comment r = new Comment();
                r.setId(rs.getInt("id"));
                r.setCommentaire(rs.getString("commentaire"));
               
                String req2 = "select * from articles where id = " + rs.getInt("id") + "";
                PreparedStatement st2 = connection.prepareStatement(req2);
                //st2.setInt(1, rs.getInt("idClient"));
                ResultSet rs2 = st2.executeQuery(req2);

                Articles c = new Articles();
                while (rs2.next()) {
                    c.setId(rs2.getInt("id"));
                    c.setDescription(rs2.getString("description"));
                    c.setTitre(rs2.getString("titre"));
                    c.setImage(rs2.getString("image"));
                    c.setNom_jeux_id(rs2.getInt("nom_jeux_id "));
                }
                r.setId_article_id(c.getId());

                list.add(r);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
