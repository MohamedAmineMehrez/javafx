/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.commande;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import services.commandeService;

/**
 * FXML Controller class
 *
 * @author khouloud
 */
public class AjoutCFXMLController implements Initializable {

    @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_id_user_id;

    @FXML
    private DatePicker txt_date_cmd;

    @FXML
    private TextField txt_image;

    @FXML
    private TextField txt_statut;
   
         @FXML
    private Button afficher;
    @FXML
    private Button ajouter;
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   

    @FXML
    private void ajouter(MouseEvent event) {
        
     commande c = new commande();
        c.setId(Integer.parseInt(txt_id.getText()));
        c.setId_user_id(txt_id_user_id.getText());
        c.setDate_cmd(String.valueOf(txt_date_cmd.getValue()));
        c.setImage(txt_image.getText());
        c.setStatut(txt_statut.getText());
        commandeService ps = new commandeService();
        ps.ajouter(c);
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("commande ajoutée");
        a.show();
    }


    @FXML
    private void Afficher(MouseEvent event) {
       try {
            Parent root = FXMLLoader.load(getClass().getResource("AfficherCFXML.fxml"));
            afficher.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ajouter(ActionEvent event) {
    }

    @FXML
    private void afficher(ActionEvent event) {
    }
   

   

  


}
