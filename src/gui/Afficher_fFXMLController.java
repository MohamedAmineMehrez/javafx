/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entites.Fournisseur;
import entites.Produit;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.FournisseurService;


/**
 * FXML Controller class
 *
 * @author Mehdi
 */
public class Afficher_fFXMLController implements Initializable {

    @FXML
    private TableView<Fournisseur> tableview1;
    @FXML
    private TableColumn<Fournisseur, Integer> idC1;
    @FXML
    private TableColumn<Fournisseur, String> nomC1;
    @FXML
    private TableColumn<Fournisseur, Integer> num_telC1;
    @FXML
    private TableColumn<Fournisseur, String> emailC1;
    @FXML
    private TableColumn<Fournisseur, String> bC;
    
    ObservableList list ;
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        FournisseurService fs = new FournisseurService();
        List<Fournisseur> Fournisseur = fs.recuperer();
        list = FXCollections.observableList(Fournisseur);
        tableview1.setItems(list);
        
        idC1.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomC1.setCellValueFactory(new PropertyValueFactory<>("nom"));
        num_telC1.setCellValueFactory(new PropertyValueFactory<>("numTel"));
        emailC1.setCellValueFactory(new PropertyValueFactory<>("email"));
    }    

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
         Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Ajouter2FXML.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void modifier(ActionEvent event) {
        
    }

    @FXML
    private void supprimer(ActionEvent event) {
         Fournisseur selectedItem = tableview1.getSelectionModel().getSelectedItem();
        if(selectedItem!=null){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setContentText("Etes vous sure de supprimer cette element ?");   
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        FournisseurService ps = new FournisseurService() ; 
        tableview1.getItems().remove(selectedItem);
        ps.supprimer(selectedItem.getId());
        }
        
        }
        else {
        
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez sélectionner un element à supprimer.");

        alert.showAndWait();
        }
    }
    
}
