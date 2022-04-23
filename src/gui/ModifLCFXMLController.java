/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import entities.commande;
import entities.lignecommande;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import services.commandeService;

import services.lignecommandeService;

/**
 * FXML Controller class
 *
 * @author khouloud
 */
public class ModifLCFXMLController implements Initializable {
    private TableView<lignecommande> table_lignecommande;
       @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_lignecmd_id;

    @FXML
    private TextField txt_produit_id;

    @FXML
    private TextField txt_quantite;
      @FXML
    private Button modifierlc;

    @FXML
    private Button Afficherlc;

    lignecommandeService ll = new lignecommandeService();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
    
    }

 @FXML
    private void modifierlc(ActionEvent event) {
        final lignecommande selectedItem = table_lignecommande.getSelectionModel().getSelectedItem();
        lignecommande lc = ll.GetById(selectedItem.getId());
        lc.setLignecmd_id(txt_lignecmd_id.getText());
        lc.setProduit_id(String.valueOf(txt_produit_id.getText()));

        ll.modifierlc(lc);
        table_lignecommande.setItems(FXCollections.observableArrayList(ll.recupererlc()));
        table_lignecommande.refresh();
    }
 


    @FXML
    private void Afficherlc(ActionEvent event) {
    
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AfficherLCFXML.fxml"));
            Afficherlc.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
   
}