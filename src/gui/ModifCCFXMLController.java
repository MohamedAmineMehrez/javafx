/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.commande;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import services.commandeService;

/**
 * FXML Controller class
 *
 * @author khouloud
 */
public class ModifCCFXMLController implements Initializable {
    
    private TableView<commande> table_commande;

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
    private Button modifier;

    @FXML
    private Button afficher;
       
    commandeService ss = new commandeService();
    
 
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
    }

 @FXML
    private void modifier(ActionEvent event) {
        final commande selectedItem = table_commande.getSelectionModel().getSelectedItem();
        commande c = ss.GetById(selectedItem.getId());
        c.setId_user_id(txt_id_user_id.getText());
        c.setDate_cmd(String.valueOf(txt_date_cmd.getValue()));
        c.setImage(txt_image.getText());
        c.setStatut(txt_statut.getText());
        ss.modifier(c);
        table_commande.setItems(FXCollections.observableArrayList(ss.recuperer()));
        table_commande.refresh();
    }
 

   
    @FXML
    private void afficher(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AfficherCFXML.fxml"));
            afficher.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

   
}
  


