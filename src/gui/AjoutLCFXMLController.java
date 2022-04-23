/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import entities.lignecommande;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.commandeService;
import services.lignecommandeService;

/**
 * FXML Controller class
 *
 * @author khouloud
 */
public class AjoutLCFXMLController implements Initializable {

     @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_lignecmd_id;

    @FXML
    private TextField txt_produit_id;

    @FXML
    private TextField txt_quantite;
      @FXML
    private Button ajouterlc;

    @FXML
    private Button Afficherlc;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    private void ajouterlc(ActionEvent event) {
        lignecommande lc = new lignecommande();
        lc.setId(Integer.parseInt(txt_id.getText()));
        lc.setLignecmd_id(txt_lignecmd_id.getText());
        lc.setProduit_id(txt_produit_id.getText());
        lc.setQuantite(Integer.parseInt(txt_quantite.getText()));
        
        lignecommandeService pr = new lignecommandeService();
        pr.ajouterlc(lc);
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("lignecommande ajoutée");
        a.show();
    }

    @FXML
    private void Afficherlc(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AfficherLCFXML.fxml"));
            txt_quantite.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}


