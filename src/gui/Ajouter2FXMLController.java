/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entites.Fournisseur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.FournisseurService;

/**
 * FXML Controller class
 *
 * @author Mehdi
 */
public class Ajouter2FXMLController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField num_tel;
    @FXML
    private TextField email;
    @FXML
    private Button ajouter;
    @FXML
    private Button annuler;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(MouseEvent event) throws IOException {
     Fournisseur p = new Fournisseur();
        p.setNom(nom.getText());
        p.setNumTel(Integer.parseInt(num_tel.getText()));
        p.setEmail(email.getText());
        
        FournisseurService fs = new FournisseurService();
        fs.ajouter(p);
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Fournisseur ajouté");
        a.show();
         Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Afficher_fFXML.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void afficher(MouseEvent event) {
    try {
            Parent root = FXMLLoader.load(getClass().getResource("Afficher2FXML.fxml"));
            //age.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    private void annuler(ActionEvent event) {
      try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Afficher_fFXML.fxml"));
            Parent root = loader.load();
            AjouterFXMLController controller = loader.getController();
            nom.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
