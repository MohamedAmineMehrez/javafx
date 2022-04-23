/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entites.Produit;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.ProduitService;
import gui.SendEmail;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
/**
 * FXML Controller class
 *
 * @author Mehdi
 */
public class AjouterFXMLController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField qte;
    @FXML
    private TextField prix;

    @FXML
    private ChoiceBox<String> catego;
    private String[] choix = {"T-Shirt","Accessoire","Pull"};
    @FXML
    private TextField descptipn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        catego.getItems().addAll(choix);
    }    

    @FXML
    private void ajouter(MouseEvent event) throws IOException {
       
         if(nom.getText().isEmpty()||qte.getText().isEmpty()||prix.getText().isEmpty()||descptipn.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "verifer les champs");  
        }
        else
        {
        
        Produit p = new Produit();
        p.setNom(nom.getText());
        p.setQte(Integer.parseInt(qte.getText()));
        p.setPrix(Double.parseDouble(prix.getText()));
        p.setDescrp(descptipn.getText());
        p.setCatego("mehdi"); 
        ProduitService ps = new ProduitService();
        ps.ajouter(p);
               String title = "succes ";
        String message = "Votre alert est bien reçu,"
                + "Verifier votre boite mail svp!";
         try {
             SendEmail.sendMail();
                } catch (Exception ex) {
                }
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndWait();             
        nom.clear();
        qte.clear();
        prix.clear();
        descptipn.clear();    
         
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Produit ajouté");
        a.show();
         Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Afficher_pFXML.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    }
    @FXML
    private void afficher(MouseEvent event) throws IOException {

      Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Afficher_pFXML.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
       

//        try {
//            Parent root = FXMLLoader.load(getClass().getResource("Afficher_pFXML.fxml"));
//            //age.getScene().setRoot(root);
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//        
    }

    private void annuler(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Afficher_pFXML.fxml"));
            Parent root = loader.load();
            AjouterFXMLController controller = loader.getController();
            nom.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
