/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;



import entities.lignecommande;
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

import services.lignecommandeService;

/**
 * FXML Controller class
 *
 * @author khouloud
 */

    
public class AfficherLCFXMLController implements Initializable {
    @FXML
    private TableView<lignecommande> table_lignecommande;
    @FXML
    private TableColumn<lignecommande, Integer> col_id;

    @FXML
    private TableColumn<lignecommande, String> col_lignecmd_id;

    @FXML
    private TableColumn<lignecommande, String> col_produit_id;

    @FXML
    private TableColumn<lignecommande, Integer> col_quantite;

    @FXML
    private Button ajouterlc;

    

        
    @FXML
    private Button modifierlc;
    @FXML
    private Button supprimerlc;
    ObservableList list ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        lignecommandeService pr = new lignecommandeService();
        List<lignecommande> lignecommandes = pr.recupererlc();
        list = FXCollections.observableList(lignecommandes);
        table_lignecommande.setItems(list);
        
        col_id.setCellValueFactory(new PropertyValueFactory<lignecommande,Integer>("id"));
        col_lignecmd_id.setCellValueFactory(new PropertyValueFactory<lignecommande,String>("lignecmd_id"));
        col_produit_id.setCellValueFactory(new PropertyValueFactory<lignecommande,String>("produit_id"));
        col_quantite.setCellValueFactory(new PropertyValueFactory<lignecommande,Integer>("quantite"));
        
        


    }    

    @FXML
    private void ajouterlc(ActionEvent event) throws IOException {
    Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/gui/AjoutLCFXML.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    

    
}
       @FXML
    private void supprimerlc(ActionEvent event) {
         lignecommande selectedItem = table_lignecommande.getSelectionModel().getSelectedItem();
        if(selectedItem!=null){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setContentText("Etes vous sure de supprimer cette element ?");   
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        lignecommandeService pr = new lignecommandeService() ; 
        table_lignecommande.getItems().remove(selectedItem);
        pr.supprimerlc(selectedItem.getId());
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

   


    @FXML
    private void modifierlc(ActionEvent event) {
              try {
            Parent root = FXMLLoader.load(getClass().getResource("ModifLCFXML.fxml"));
            modifierlc.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    

    }
    
   
}