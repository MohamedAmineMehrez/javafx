/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import animatefx.animation.BounceInDown;
import animatefx.animation.FadeOutUp;
import entites.Produit;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.ProduitService;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Mehdi
 */
public class Afficher_pFXMLController implements Initializable {
   
    @FXML
    private TableView<Produit> tableview;  
    @FXML
    private TableColumn<Produit, String> nomC;
    @FXML
    private TableColumn<Produit, Integer> qteC;
    @FXML
    private TableColumn<Produit, Double> prixC;
    @FXML
    private TableColumn<Produit, String> descC;
    @FXML
    private TableColumn<Produit, String> catC;
    
    ObservableList list ;
    @FXML
    private Pane pane_ajout;
    @FXML
    private TextField descrp;
    @FXML
    private TextField qte;
    @FXML
    private TextField nom;
    @FXML
    private TextField prix;
        int idp =0;

    @FXML
    private Button retour;
    @FXML
    private Pane blacks;
    @FXML
    private Button ajouter2;
    @FXML
    private TextField recherche;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private TextField catego;
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        affcateg();
    }    

    private void affcateg() {
         ObservableList<Produit> observableList = FXCollections.observableArrayList();
         ProduitService us = new ProduitService();
        nomC.setCellValueFactory(new PropertyValueFactory<>("nom"));
        qteC.setCellValueFactory(new PropertyValueFactory<>("qte"));
        prixC.setCellValueFactory(new PropertyValueFactory<>("prix"));
        descC.setCellValueFactory(new PropertyValueFactory<>("descrp"));
        catC.setCellValueFactory(new PropertyValueFactory<>("catego"));

        List<Produit> lu = null;

        try {
            lu = us.recuperer();

        } catch (SQLException ex) {
            Logger.getLogger(Afficher_pFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

        lu.forEach(e -> {
            System.out.println(e);
            observableList.add(e);
        });
        tableview.setItems(observableList);

        FilteredList<Produit> filteredData = new FilteredList<>(observableList, b -> true);

        recherche.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(produits -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (produits.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                } else if (produits.getDescrp().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }else if (String.valueOf(produits.getQte()).indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } else if (String.valueOf(produits.getPrix()).indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } 
                 else {
                    return false; // Does not match.
                }
            });
        });
        SortedList<Produit> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tableview.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tableview.setItems(sortedData);
    }
       
    private void handleMouseButton(MouseEvent event) {
        
        Produit p = tableview.getSelectionModel().getSelectedItem();
        nom.setText(p.getNom());
        qte.setText(String.valueOf(p.getQte()));
        prix.setText(String.valueOf(p.getQte()));
        descrp.setText(p.getDescrp());
        catego.setText(p.getCatego());
    } 
    @FXML
    private void Modifier(ActionEvent event) {
         new BounceInDown(pane_ajout).play();
        pane_ajout.setVisible(true);
         Produit p = tableview.getSelectionModel().getSelectedItem();
        nom.setText(p.getNom());
        qte.setText(String.valueOf(p.getQte()));
        prix.setText(String.valueOf(p.getQte()));
        descrp.setText(p.getDescrp());
        catego.setText(p.getCatego());
        idp = p.getId();
        // nom.setText(pl.getNom());
//        int id = p.getId();
//        String noms = nom.getText();
//        int quantite = Integer.parseInt(qte.getText());
//        Double prix1 = Double.parseDouble(prix.getText());
//        String description = descrp.getText();
//        String categorie = catego.getText();
//        ProduitService sc = new ProduitService();
//        Produit p = new Produit(id,noms,quantite,prix1,description);
//        sc.modifier(p);
        affcateg();
    }

    @FXML
    private void Ajouter(ActionEvent event) {
        blacks.setVisible(true);
        new BounceInDown(pane_ajout).play();
        idp = 0;
        pane_ajout.setVisible(true);
    }

    @FXML
    private void Supprimer(ActionEvent event) {
          Produit p = tableview.getSelectionModel().getSelectedItem();
        ProduitService sc = new ProduitService();
        sc.supprimer(p);
        affcateg();
    }

    @FXML
    private void Ajouter2(ActionEvent event) {
        
        
        
                System.out.println("aaaaaaaaaaaaaaaaaa");
         ProduitService ps = new ProduitService();
         if (idp == 0) {
                    if(nom.getText().isEmpty()||qte.getText().isEmpty()||prix.getText().isEmpty()||descrp.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "verifer les champs");  
        }
        else
        {
        
        Produit p = new Produit();
        p.setNom(nom.getText());
        p.setQte(Integer.parseInt(qte.getText()));
        p.setPrix(Double.parseDouble(prix.getText()));
        p.setDescrp(descrp.getText());
        p.setCatego(catego.getText());
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
        descrp.clear();    
         
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Produit ajouté");
        a.show();
               blacks.setVisible(false);
        new FadeOutUp(pane_ajout).play();
    } 
         } else {
                     System.out.println("edit");
        String noms = nom.getText();
        int quantite = Integer.parseInt(qte.getText());
        Double prix1 = Double.parseDouble(prix.getText());
        String description = descrp.getText();
        String categorie = catego.getText();
        ProduitService sc = new ProduitService();
//        int id, String nom, int qte, double prix, String descrp, String cat
        Produit p = new Produit(idp, noms, quantite, prix1, description, categorie);
        sc.modifier(p);
        affcateg();
               blacks.setVisible(false);
        new FadeOutUp(pane_ajout).play();
         }
         
    }

    @FXML
    private void retour(ActionEvent event) {
        blacks.setVisible(false);
        new FadeOutUp(pane_ajout).play();
    }

   
}    
    
