/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Util.MyDB;
import entites.Produit;
import java.net.URL;
//import static gui.Afficher_pFXMLController.p;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import services.ProduitService;

/**
 * FXML Controller class
 *
 * @author Mehdi
 */
public class ModifierFXMLController implements Initializable {

    ProduitService ps = new ProduitService();
    @FXML
    private TextField nomC;
    @FXML
    private TextField qteC;
    @FXML
    private TextField prixC;
    @FXML
    private TextField descC;
    @FXML
    private ChoiceBox<?> catC;
    @FXML
    private Button modifier;
    @FXML
    private ComboBox<String> cbprod;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifier(ActionEvent event) {
        String nom = nomC.getText();
        Integer qte = Integer.parseInt(qteC.getText());
        Double prix = Double.parseDouble(prixC.getText());
        String descrp = descC.getText();
        String catego = "mehdi";
        //combo box handling
        String nomp =  cbprod.getValue();
         String sql1="select id from role where nom='"+nomp+"'";
                int id=0;
                  try {
                Statement ste;
                Connection cnx;
                cnx = MyDB.getInstance().getConnection();
                ste = cnx.prepareStatement(sql1);
                ResultSet rs = ste.executeQuery(sql1);
                if(rs.next())
                {
                  id =rs.getInt("id");
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(AjouterFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
                  System.out.println(id);
             Produit p = new Produit(id,nom,qte,prix,descrp,catego);
          
           // ps.modifier(u,cmd);
           
        
    }

    
}
